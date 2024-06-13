package com.qtech.wb.controller;

import com.qtech.wb.domain.WbComparisonOverview;
import com.qtech.wb.service.IWbComparisonOverviewService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.R;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/05 08:56:16
 * desc   :
 */

@RestController
@RequestMapping(value = "/wbcomparison/statistics")
public class WbComparisonOverviewController extends BaseController {

    @Autowired
    IWbComparisonOverviewService wbComparisonOverviewService;

    @RequestMapping(value = "/overView", method = RequestMethod.GET)
    public TableDataInfo listOverview(WbComparisonOverview wbComparisonOverview) {
        List<WbComparisonOverview> wbComparisonOverviews = wbComparisonOverviewService.selectWbComparisonOverviewList(wbComparisonOverview);
        return getDataTable(wbComparisonOverviews);
    }

    @RequestMapping(value = "factoryNames", method = RequestMethod.GET)
    public R getFactoryNames() {
        List<WbComparisonOverview> list = wbComparisonOverviewService.selectFactoryNameList();
        return R.ok(list);
    }

    @RequestMapping(value = "workShopNames", method = RequestMethod.GET)
    public R getGroupNames(WbComparisonOverview wbComparisonOverview) {
        List<WbComparisonOverview> list = wbComparisonOverviewService.selectWorkShopNameList(wbComparisonOverview);
        return R.ok(list);
    }

    @RequestMapping(value = "updateTime", method = RequestMethod.GET)
    public R getUpdateTime() {
        String updateTime = wbComparisonOverviewService.getUpdateTime();
        return R.ok(updateTime);
    }

    @Log(title = "打线图概览", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbComparisonOverview wbComparisonOverview)
    {
        List<WbComparisonOverview> list = wbComparisonOverviewService.selectWbComparisonOverviewList(wbComparisonOverview);
        ExcelUtil<WbComparisonOverview> util = new ExcelUtil<WbComparisonOverview>(WbComparisonOverview.class);
        util.exportExcel(response, list, "治具数据");
    }
}
