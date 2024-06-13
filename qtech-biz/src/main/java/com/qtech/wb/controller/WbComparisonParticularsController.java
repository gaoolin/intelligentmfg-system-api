package com.qtech.wb.controller;

import com.qtech.wb.domain.WbComparisonParticularsVo;
import com.qtech.wb.service.IWbComparisonDetailService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 14:30:14
 * desc   :
 */

@RestController
@RequestMapping("/wbcomparison/particulars")
public class WbComparisonParticularsController extends BaseController {

    @Autowired
    private IWbComparisonDetailService wbComparisonDetailService;

    @RequestMapping(value = "/detail")
    public TableDataInfo getDetail(WbComparisonParticularsVo wbComparisonParticularsVo) {
        startPage();
        List<WbComparisonParticularsVo> detail = wbComparisonDetailService.getDetail(wbComparisonParticularsVo);
        return getDataTable(detail);
    }

    @Log(title = "打线图机台比对明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbComparisonParticularsVo wbComparisonParticularsVo)
    {
        List<WbComparisonParticularsVo> list = wbComparisonDetailService.getDetail(wbComparisonParticularsVo);
        ExcelUtil<WbComparisonParticularsVo> util = new ExcelUtil<WbComparisonParticularsVo>(WbComparisonParticularsVo.class);
        util.exportExcel(response, list, "打线图机台比对明细");
    }
}
