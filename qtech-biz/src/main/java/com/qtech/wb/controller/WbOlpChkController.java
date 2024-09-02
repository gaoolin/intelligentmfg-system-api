package com.qtech.wb.controller;

import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import com.qtech.wb.domain.EmsEqInfo;
import com.qtech.wb.service.IEmsEqInfoService;
import com.qtech.wb.service.IWbOlpChkService;
import com.qtech.wb.vo.WbOlpChkVo;
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
@RequestMapping("/wb/olp/chk")
public class WbOlpChkController extends BaseController {

    @Autowired
    IEmsEqInfoService emsEqInfoService;

    @Autowired
    IWbOlpChkService wbOlpChkService;

    @GetMapping("/list/eqInfo")
    public TableDataInfo listEqInfo(WbOlpChkVo wbOlpChkVo) {
        EmsEqInfo emsEqInfo = new EmsEqInfo();
        emsEqInfo.setCompanyName(wbOlpChkVo.getCompanyName());
        emsEqInfo.setGroupName(wbOlpChkVo.getGroupName());
        emsEqInfo.setEqId(wbOlpChkVo.getEqId());
        emsEqInfo.setMcId(wbOlpChkVo.getMcId());
        emsEqInfo.setProdType(wbOlpChkVo.getProdType());
        emsEqInfo.setSimId(wbOlpChkVo.getSimId());

        // 通过ThreadLocal传递参数
        startPage();
        List<EmsEqInfo> emsEqInfos = emsEqInfoService.selectEmsEqInfoList(emsEqInfo);

        return getDataTable(emsEqInfos);
    }

    @GetMapping("/list/wbOlp")
    public TableDataInfo listWbOlp(WbOlpChkVo wbOlpChkVo) {
        /*会清除PageHelper在ThreadLocal的参数，需紧跟Mybatis查询方法*/
        startPage();  /* startPage后面返回的列表就应该是getDataTable，如果中间有其他类转换会导致分页数据丢失，详细查看getDataTable源码*/
        List<WbOlpChkVo> wbOlpChkVos = wbOlpChkService.selectWbOlpChkList(wbOlpChkVo, 7);
        return getDataTable(wbOlpChkVos);
    }

    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/emsInfo/export")
    public void exportEmsInfo(HttpServletResponse response, EmsEqInfo emsEqInfo) {
        List<EmsEqInfo> list = emsEqInfoService.selectEmsEqInfoList(emsEqInfo);
        ExcelUtil<EmsEqInfo> util = new ExcelUtil<EmsEqInfo>(EmsEqInfo.class);
        util.exportExcel(response, list, "设备信息");
    }

    @Log(title = "比对结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void exportWbOlp(HttpServletResponse response, WbOlpChkVo wbOlpChkVo) {
        List<WbOlpChkVo> wbOlpChkVos = wbOlpChkService.selectWbOlpChkList(wbOlpChkVo, 7);
        ExcelUtil<WbOlpChkVo> util = new ExcelUtil<>(WbOlpChkVo.class);
        util.exportExcel(response, wbOlpChkVos, "智慧打线图比对信息");
    }
}
