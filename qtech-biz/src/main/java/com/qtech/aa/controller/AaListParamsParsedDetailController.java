package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsParsed;
import com.qtech.aa.service.IAaListParamsParsedDetailService;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/05 15:49:03
 * desc   :
 */

@RestController
@RequestMapping("/aa/params/parsed/detail")
public class AaListParamsParsedDetailController extends BaseController {

    @Autowired
    private IAaListParamsParsedDetailService aaListParamsParsedDetailService;

    @RequestMapping("/list")
    public TableDataInfo list(AaListParamsParsed aaListParamsParsed) {
        startPage();
        List<AaListParamsParsed> list = aaListParamsParsedDetailService.selectAaListParamsParsedDetailList(aaListParamsParsed);
        return getDataTable(list);
    }
}
