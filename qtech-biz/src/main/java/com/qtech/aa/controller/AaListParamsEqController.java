package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsEq;
import com.qtech.aa.service.IAaListParamsEqService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/19 10:05:16
 * desc   :
 */

@RestController
@RequestMapping("/aa/params/eq")
public class AaListParamsEqController extends BaseController {

    private final IAaListParamsEqService aaListParamsEqService;

    public AaListParamsEqController(IAaListParamsEqService aaListParamsEqService) {
        this.aaListParamsEqService = aaListParamsEqService;
    }

    @RequestMapping("/list")
    public TableDataInfo list(AaListParamsEq aaListParamsEq) {
        startPage();
        List<AaListParamsEq> list = aaListParamsEqService.selectAaListParamsEqList(aaListParamsEq);
        return getDataTable(list);
    }

    @Log(title = "AA机台受控状态修改", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/ignore", method = {RequestMethod.POST, RequestMethod.PUT})
    public AjaxResult changeSwitch(@RequestBody AaListParamsEq aaListParamsEq) {
        int i = 0;
        Boolean b = aaListParamsEqService.isExist(aaListParamsEq);
        if (b) {
            i = aaListParamsEqService.editAaListParamsIgnoreEq(aaListParamsEq);
        } else {
            i = aaListParamsEqService.insertAaListParamsIgnoreEq(aaListParamsEq);
        }
        return toAjax(i);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public AjaxResult edit(@RequestBody AaListParamsEq aaListParamsEq) {
        int i = aaListParamsEqService.editAaListParamsEq(aaListParamsEq);
        return toAjax(i);
    }

    @Log(title = "AA List管控设备状态导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AaListParamsEq aaListParamsEq) {
        List<AaListParamsEq> list = aaListParamsEqService.selectAaListParamsEqList(aaListParamsEq);
        ExcelUtil<AaListParamsEq> util = new ExcelUtil<>(AaListParamsEq.class);
        util.exportExcel(response, list, "AA List管控设备状态");
    }
}
