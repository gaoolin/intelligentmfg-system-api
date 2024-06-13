package com.qtech.fixture.controller;

import com.qtech.fixture.domain.FixtureSharedInfo;
import com.qtech.fixture.service.IFixtureSharedInfoHistoryService;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/06/28 08:20:42
 * desc   :  pogopin治具历史Controller
 */

@RestController
@RequestMapping("/fixture/history")
public class FixtrueSharedInfoHistoryController extends BaseController {

    @Autowired
    private IFixtureSharedInfoHistoryService fixtureSharedInfoHistoryService;

    @GetMapping("/list")
    public TableDataInfo list(FixtureSharedInfo fixtureSharedInfo) {
        startPage();
        List<FixtureSharedInfo> list = fixtureSharedInfoHistoryService.selectFixtureSharedInfoHistoryList(fixtureSharedInfo);
        return getDataTable(list);
    }
}
