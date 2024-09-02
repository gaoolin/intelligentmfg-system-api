package com.qtech.wb.controller;

import com.qtech.wb.domain.WbOlpOverview;
import com.qtech.wb.service.IWbOlpOverviewService;
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
@RequestMapping(value = "/wb/olp/statistics")
public class WbOlpOverviewController extends BaseController {

    @Autowired
    IWbOlpOverviewService wbOlpOverviewService;

    @RequestMapping(value = "/overView", method = RequestMethod.GET)
    public TableDataInfo listOverview(WbOlpOverview wbOlpOverview) {
        List<WbOlpOverview> wbOlpOverviews = wbOlpOverviewService.selectWbOlpOverviewList(wbOlpOverview);
        return getDataTable(wbOlpOverviews);
    }

    @RequestMapping(value = "updateTime", method = RequestMethod.GET)
    public R getUpdateTime() {
        String updateTime = wbOlpOverviewService.getUpdateTime();
        return R.ok(updateTime);
    }

    @Log(title = "打线图概览", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbOlpOverview wbOlpOverview)
    {
        List<WbOlpOverview> list = wbOlpOverviewService.selectWbOlpOverviewList(wbOlpOverview);
        ExcelUtil<WbOlpOverview> util = new ExcelUtil<WbOlpOverview>(WbOlpOverview.class);
        util.exportExcel(response, list, "打线图概览");
    }
}
