package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsCheckResult;
import com.qtech.aa.service.IAaListParamsLatestCheckResultService;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.R;
import com.qtech.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 09:31:24
 * desc   :
 */

@RestController
@RequestMapping("/aa/params/latest/status")
public class AaListParamsLatestCheckResultController extends BaseController {

    @Autowired
    private IAaListParamsLatestCheckResultService aaListParamsLatestCheckResultService;

    @GetMapping("/list")
    public TableDataInfo list(AaListParamsCheckResult aaListParamsCheckResult) {
        startPage();
        return getDataTable(aaListParamsLatestCheckResultService.selectAaListParamsLatestCheckResultList(aaListParamsCheckResult));
    }

    @GetMapping("/factoryNames")
    public R<List<AaListParamsCheckResult>> getFactoryNames() {
        List<AaListParamsCheckResult> list = aaListParamsLatestCheckResultService.selectFactoryNameList();
        return R.ok(list);
    }

    @GetMapping("/groupNames")
    public R<List<AaListParamsCheckResult>> getGroupNames(AaListParamsCheckResult aaListParamsCheckResult) {
        List<AaListParamsCheckResult> list = aaListParamsLatestCheckResultService.selectGroupNameList(aaListParamsCheckResult);
        return R.ok(list);
    }
}
