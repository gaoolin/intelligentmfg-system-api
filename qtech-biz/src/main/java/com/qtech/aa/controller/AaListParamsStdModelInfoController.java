package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsStdModelDetail;
import com.qtech.aa.domain.AaListParamsStdModelInfo;
import com.qtech.aa.service.IAaListParamsStdModelInfoService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/02 13:35:31
 * desc   :
 */

@RestController
@RequestMapping("/aa/params/model/info")
public class AaListParamsStdModelInfoController extends BaseController {

    @Autowired
    private IAaListParamsStdModelInfoService aaListParamsStdModelInfoService;

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public TableDataInfo list(AaListParamsStdModelInfo aaListParamsStdModelInfo) {
        startPage();
        List<AaListParamsStdModelInfo> list = aaListParamsStdModelInfoService.selectAaListParamsStdModelInfoList(aaListParamsStdModelInfo);
        return getDataTable(list);
    }

    @RequestMapping(value = "/add", produces = "application/json", method = RequestMethod.POST)
    public AjaxResult add(@RequestBody AaListParamsStdModelInfo aaListParamsStdModelInfo) {
        return toAjax(aaListParamsStdModelInfoService.insertAaListParamsStdModelInfo(aaListParamsStdModelInfo));
    }

    @RequestMapping(value = "/edit", produces = "application/json", method = RequestMethod.POST)
    public AjaxResult edit(@RequestBody AaListParamsStdModelInfo aaListParamsStdModelInfo) {
        System.out.println(aaListParamsStdModelInfo);
        return toAjax(aaListParamsStdModelInfoService.updateAaListParamsStdModelInfo(aaListParamsStdModelInfo));
    }

    @RequestMapping(value = "/remove/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public AjaxResult remove(@PathVariable Long id) {
        return toAjax(aaListParamsStdModelInfoService.deleteAaListParamsStdModelInfoByIds(Collections.singletonList(id).toArray(new Long[0])));
    }

    @Log(title = "AA-List参数标准模版信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AaListParamsStdModelInfo aaListParamsStdModelInfo) {
        List<AaListParamsStdModelInfo> list = aaListParamsStdModelInfoService.selectAaListParamsStdModelInfoList(aaListParamsStdModelInfo);
        ExcelUtil<AaListParamsStdModelInfo> util = new ExcelUtil<AaListParamsStdModelInfo>(AaListParamsStdModelInfo.class);
        util.exportExcel(response, list, "AA-List参数标准模版信息");
    }
}
