package com.qtech.wb.controller;

import com.qtech.wb.domain.WbComparisonIndexVo;
import com.qtech.wb.domain.WbComparisonTrendingVo;
import com.qtech.wb.service.IWbComparisonStdModInfoService;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/16 10:15:16
 * desc   :
 */

@RestController
@RequestMapping("/index")
public class WbComparisonIndexController extends BaseController {

    @Autowired
    IWbComparisonStdModInfoService wbComparisonStdModInfoService;


    @GetMapping(value = "/wbComparison/overview")
    public AjaxResult IndexWbComparisonOverview() {

        WbComparisonIndexVo wbComparisonIndexVo = new WbComparisonIndexVo();

        Integer modelsTtlCnt = wbComparisonStdModInfoService.getModelsTtlCnt();
        Integer modelAvgCnt = wbComparisonStdModInfoService.getModelAvgCnt();

        wbComparisonIndexVo.setWbComparisonStdModelsTtlCnt(modelsTtlCnt);
        wbComparisonIndexVo.setWbComparisonStdModelAvgCnt(modelAvgCnt);

        return AjaxResult.success(wbComparisonIndexVo);
    }

    @GetMapping(value = "/wbComparison/trending")
    public TableDataInfo IndexWbComparisonTrending() {
        List<WbComparisonTrendingVo> wbComparisonTrending = wbComparisonStdModInfoService.getWbComparisonTrending();
        return getDataTable(wbComparisonTrending);
    }
}
