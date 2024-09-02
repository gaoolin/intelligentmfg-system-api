package com.qtech.wb.controller;

import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.domain.R;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.wb.domain.WbOlpIndexVo;
import com.qtech.wb.domain.WbOlpTrendingVo;
import com.qtech.wb.service.IWbOlpIndexService;
import com.qtech.wb.service.IWbOlpStdModInfoService;
import com.qtech.wb.vo.WbOlpChkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/16 10:15:16
 * desc   :
 */

@RestController
@RequestMapping("/wb/olp/index")
public class WbOlpIndexController extends BaseController {

    @Autowired
    IWbOlpStdModInfoService wbOlpStdModInfoService;

    @Autowired
    IWbOlpIndexService wbOlpIndexService;


    @GetMapping(value = "/overview")
    public AjaxResult IndexWbOlpOverview() {

        WbOlpIndexVo wbOlpIndexVo = new WbOlpIndexVo();

        Integer modelsTtlCnt = wbOlpStdModInfoService.getModelsTtlCnt();
        Integer modelAvgCnt = wbOlpStdModInfoService.getModelAvgCnt();

        wbOlpIndexVo.setWbOlpStdModelsTtlCnt(modelsTtlCnt);
        wbOlpIndexVo.setWbOlpStdModelAvgCnt(modelAvgCnt);

        return AjaxResult.success(wbOlpIndexVo);
    }

    @GetMapping(value = "/trending")
    public TableDataInfo IndexWbOlpTrending() {
        List<WbOlpTrendingVo> wbOlpTrending = wbOlpStdModInfoService.getWbOlpTrending();
        return getDataTable(wbOlpTrending);
    }


    @RequestMapping(value = "/factoryNames", method = RequestMethod.GET)
    public R getFactoryNames() {
        List<WbOlpChkVo> list = wbOlpIndexService.selectFactoryNameList();
        return R.ok(list);
    }

    @RequestMapping(value = "/workShopNames", method = RequestMethod.GET)
    public R getGroupNames(WbOlpChkVo wbOlpChkVo) {
        List<WbOlpChkVo> list = wbOlpIndexService.selectWorkShopNameList(wbOlpChkVo);
        return R.ok(list);
    }
}
