package com.qtech.wb.controller;

import com.qtech.wb.domain.EmsEqInfo;
import com.qtech.wb.domain.WbComparisonResultVo;
import com.qtech.wb.service.IEmsEqInfoService;
import com.qtech.wb.service.IWbComparisonResultService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 15:35:11
 * desc   :
 */

@RestController
@RequestMapping("/wbcomparison/result")
public class WbComparisonResultVoController extends BaseController {

    @Autowired
    IEmsEqInfoService emsEqInfoService;

    @Autowired
    IWbComparisonResultService wbComparisonResultService;

    @GetMapping("/list/eqInfo")
    public TableDataInfo listEqInfo(WbComparisonResultVo wbComparisonResultVo) {
        EmsEqInfo emsEqInfo = new EmsEqInfo();
        emsEqInfo.setCompanyName(wbComparisonResultVo.getCompanyName());
        emsEqInfo.setGroupName(wbComparisonResultVo.getGroupName());
        emsEqInfo.setEqId(wbComparisonResultVo.getEqId());
        emsEqInfo.setMcId(wbComparisonResultVo.getMcId());
        emsEqInfo.setProdType(wbComparisonResultVo.getProdType());
        emsEqInfo.setSimId(wbComparisonResultVo.getSimId());

        // 通过ThreadLocal传递参数
        startPage();
        List<EmsEqInfo> emsEqInfos = emsEqInfoService.selectEmsEqInfoList(emsEqInfo);

        return getDataTable(emsEqInfos);
    }

    @GetMapping("/list/wbComparison")
    public TableDataInfo listWbComparison(WbComparisonResultVo wbComparisonResultVo) {
        EmsEqInfo emsEqInfo = new EmsEqInfo();
        emsEqInfo.setCompanyName(wbComparisonResultVo.getCompanyName());
        emsEqInfo.setGroupName(wbComparisonResultVo.getGroupName());
        emsEqInfo.setEqId(wbComparisonResultVo.getEqId());
        emsEqInfo.setMcId(wbComparisonResultVo.getMcId());
        emsEqInfo.setProdType(wbComparisonResultVo.getProdType());
        emsEqInfo.setSimId(wbComparisonResultVo.getSimId());

        List<EmsEqInfo> emsEqInfos = emsEqInfoService.selectEmsEqInfoList(emsEqInfo);

        /*会清除PageHelper在ThreadLocal的参数，需紧跟Mybatis查询方法*/
        startPage();  /* startPage后面返回的列表就应该是getDataTable，如果中间有其他类转换会导致分页数据丢失，详细查看getDataTable源码*/
        List<WbComparisonResultVo> wbComparisonResultVos = wbComparisonResultService.selectWbComparisonResultList(wbComparisonResultVo);

        /*List<WbComparisonResultVo> wbComparisonResultVos = BeanUtil.copyToList(wbComparisonResults, WbComparisonResultVo.class);*/
        for (WbComparisonResultVo comparisonResultVo : wbComparisonResultVos) {
            String simId = comparisonResultVo.getSimId();
            for (EmsEqInfo eqInfo : emsEqInfos) {
                if (simId.equals(eqInfo.getSimId())) {
                    comparisonResultVo.setCompanyName(eqInfo.getCompanyName());
                    comparisonResultVo.setGroupName(eqInfo.getGroupName());
                    comparisonResultVo.setEqId(eqInfo.getEqId());
                    comparisonResultVo.setMcId(eqInfo.getMcId());
                    comparisonResultVo.setProdType(eqInfo.getProdType());
                }
            }
        }
        return getDataTable(wbComparisonResultVos);
    }

    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/emsInfo/export")
    public void exportEmsInfo(HttpServletResponse response, EmsEqInfo emsEqInfo)
    {
        List<EmsEqInfo> list = emsEqInfoService.selectEmsEqInfoList(emsEqInfo);
        ExcelUtil<EmsEqInfo> util = new ExcelUtil<EmsEqInfo>(EmsEqInfo.class);
        util.exportExcel(response, list, "设备信息");
    }

    @Log(title = "比对结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void exportWbComparison(HttpServletResponse response, WbComparisonResultVo wbComparisonResultVo) {
        EmsEqInfo emsEqInfo = new EmsEqInfo();
        emsEqInfo.setCompanyName(wbComparisonResultVo.getCompanyName());
        emsEqInfo.setGroupName(wbComparisonResultVo.getGroupName());
        emsEqInfo.setEqId(wbComparisonResultVo.getEqId());
        emsEqInfo.setMcId(wbComparisonResultVo.getMcId());
        emsEqInfo.setProdType(wbComparisonResultVo.getProdType());
        emsEqInfo.setSimId(wbComparisonResultVo.getSimId());

        List<EmsEqInfo> emsEqInfos = emsEqInfoService.selectEmsEqInfoList(emsEqInfo);

        List<WbComparisonResultVo> wbComparisonResultVos = wbComparisonResultService.selectWbComparisonResultList(wbComparisonResultVo);

        for (WbComparisonResultVo comparisonResultVo : wbComparisonResultVos) {
            String simId = comparisonResultVo.getSimId();
            for (EmsEqInfo eqInfo : emsEqInfos) {
                if (simId.equals(eqInfo.getSimId())) {
                    comparisonResultVo.setCompanyName(eqInfo.getCompanyName());
                    comparisonResultVo.setGroupName(eqInfo.getGroupName());
                    comparisonResultVo.setEqId(eqInfo.getEqId());
                    comparisonResultVo.setMcId(eqInfo.getMcId());
                    comparisonResultVo.setProdType(eqInfo.getProdType());
                }
            }
        }
        ExcelUtil<WbComparisonResultVo> util = new ExcelUtil<>(WbComparisonResultVo.class);
        util.exportExcel(response, wbComparisonResultVos, "智慧打线图比对信息");
    }
}
