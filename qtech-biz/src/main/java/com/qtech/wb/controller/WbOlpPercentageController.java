package com.qtech.wb.controller;

import com.qtech.wb.domain.WbOlpPercentageVo;
import com.qtech.wb.service.IWbOlpRatioService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
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
 * date   :  2024/01/15 11:54:01
 * desc   :
 */

@RestController
@RequestMapping("/wb/olp/percentage")
public class WbOlpPercentageController extends BaseController {

    @Autowired
    private IWbOlpRatioService wbOlpRatioService;

    @RequestMapping(value = "/ratio", method = RequestMethod.GET)
    public TableDataInfo getRatio(WbOlpPercentageVo wbOlpPercentageVo) {
        startPage();
        List<WbOlpPercentageVo> ratio = wbOlpRatioService.getRatio(wbOlpPercentageVo);
        return getDataTable(ratio);
    }

    @Log(title = "打线图机台比对正确率", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbOlpPercentageVo wbOlpPercentageVo)
    {
        List<WbOlpPercentageVo> list = wbOlpRatioService.getRatio(wbOlpPercentageVo);
        ExcelUtil<WbOlpPercentageVo> util = new ExcelUtil<WbOlpPercentageVo>(WbOlpPercentageVo.class);
        util.exportExcel(response, list, "打线图机台比对正确率");
    }
}
