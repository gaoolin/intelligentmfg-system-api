package com.qtech.wire.controller;

import com.qtech.wire.domain.FactoryNameList;
import com.qtech.wire.domain.EqLevelWireUsage;
import com.qtech.wire.domain.WorkshopNameList;
import com.qtech.wire.service.IFactoryNameService;
import com.qtech.wire.service.IWorkshopNameService;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech
 * @email : gaoolin@gmail.com
 * @date : 2023/03/27 14:11:53
 * @description :
 */

@RestController
@RequestMapping("/biz")
public class FactoryNameListController extends BaseController {

    @Autowired
    private IFactoryNameService factoryNameService;

    @Autowired
    private IWorkshopNameService workshopNameService;

    @GetMapping("/factoryName")
    public R factoryList() {
        List<FactoryNameList> list = factoryNameService.SelectFactoryNameList();
        return R.ok(list);
    }

    @GetMapping("/workshopName")
    public R workshopList(EqLevelWireUsage eqLevelWireUsage) {
        List<WorkshopNameList> list = workshopNameService.selectWorkshopNameList(eqLevelWireUsage);
        return R.ok(list);
    }
}
