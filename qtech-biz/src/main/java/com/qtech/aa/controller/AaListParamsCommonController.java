package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsCommon;
import com.qtech.aa.service.IAaListParamsCommonService;
import com.qtech.common.core.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/11 09:09:37
 * desc   :
 */

@Slf4j
@RestController
@RequestMapping("/aa/params/common")
public class AaListParamsCommonController {

    @Autowired
    private IAaListParamsCommonService aaListParamsCommonService;
    @GetMapping("/factoryName")
    public R<List<String>> getFactoryName() {
        List<String> factoryName = aaListParamsCommonService.getFactoryName();
        return R.ok(factoryName);
    }

    @GetMapping("/workshopName")
    public R<List<String>> getWorkshopName(AaListParamsCommon aaListParamsCommon) {
        List<String> workshopName = aaListParamsCommonService.getWorkshopName(aaListParamsCommon);
        return R.ok(workshopName);
    }
}
