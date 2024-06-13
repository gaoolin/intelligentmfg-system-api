package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsStdModel;
import com.qtech.aa.service.IAaListParamsStdModelService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:25:30
 * desc   :
 */

@RestController
@RequestMapping("/aa/params/model")
public class AaListParamsStdModelController extends BaseController {

    @Autowired
    private IAaListParamsStdModelService aaListParamsStdModelService;

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public TableDataInfo list(AaListParamsStdModel aaListParamsStdModel) {
        List<AaListParamsStdModel> list = aaListParamsStdModelService.selectAaListParamsStdModelList(aaListParamsStdModel);
        return getDataTable(list);
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
    public TableDataInfo getInfoById(@PathVariable Long id) {
        AaListParamsStdModel param = new AaListParamsStdModel();
        param.setId(id);
        AaListParamsStdModel one = aaListParamsStdModelService.selectOneAaListParamsStdModel(param);
        return getDataTable(Collections.singletonList(one));
    }

    @RequestMapping(value = "/add", produces = "application/json", method = RequestMethod.POST)
    public AjaxResult add(@RequestBody AaListParamsStdModel aaListParamsStdModel) {
        return toAjax(aaListParamsStdModelService.insertAaListParamsStdModel(aaListParamsStdModel));
    }

    @RequestMapping(value = "/edit", produces = "application/json", method = RequestMethod.POST)
    public AjaxResult edit(@RequestBody AaListParamsStdModel aaListParamsStdModel) {
        return toAjax(aaListParamsStdModelService.updateAaListParamsStdModel(aaListParamsStdModel));
    }

    @RequestMapping(value = "/remove/{ids}", produces = "application/json", method = RequestMethod.DELETE)
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(aaListParamsStdModelService.deleteAaListParamsStdModelByIds(Arrays.asList(ids)));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {

        ExcelUtil<AaListParamsStdModel> util = new ExcelUtil<>(AaListParamsStdModel.class);
        util.importTemplateExcel(response, "AA-List参数导入模版");
    }

    @Log(title = "AA-List参数标准模版", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AaListParamsStdModel aaListParamsStdModel) {
        List<AaListParamsStdModel> list = aaListParamsStdModelService.selectAaListParamsStdModelList(aaListParamsStdModel);
        ExcelUtil<AaListParamsStdModel> util = new ExcelUtil<AaListParamsStdModel>(AaListParamsStdModel.class);
        util.exportExcel(response, list, "AA-List参数标准模版");
    }
}
