package com.qtech.fixture.controller;

import com.qtech.fixture.domain.FixtureMaterialInfo;
import com.qtech.fixture.service.IFixtureMaterialInfoService;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.R;
import com.qtech.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/12/03 10:26:29
 * desc   :
 */

@RestController
@RequestMapping("/fixture/materialInfo")
public class FixtureMaterialInfoController extends BaseController {

    @Autowired
    IFixtureMaterialInfoService fixtureMaterialInfoService;

    @GetMapping("/exist")
    public R isMaterialExist(FixtureMaterialInfo fixtureMaterialInfo) {
        Boolean fixtureMaterialInfoExist = fixtureMaterialInfoService.isFixtureMaterialInfoExist(fixtureMaterialInfo);
        return fixtureMaterialInfoExist ? R.ok("error"): R.ok("ok");
    }

    @GetMapping("/{deptId}")
    public TableDataInfo getMaterialIds(@PathVariable Long deptId) {
        FixtureMaterialInfo fixtureMaterialInfo = new FixtureMaterialInfo();
        fixtureMaterialInfo.setDeptId(deptId);
        List<FixtureMaterialInfo> fixtureMaterialInfos = fixtureMaterialInfoService.selectFixtureMaterialInfoList(fixtureMaterialInfo);
        return getDataTable(fixtureMaterialInfos);
    }
}
