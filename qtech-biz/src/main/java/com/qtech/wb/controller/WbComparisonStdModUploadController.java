package com.qtech.wb.controller;

import com.qtech.wb.domain.WbComparisonStdModDetail;
import com.qtech.wb.domain.WbComparisonStdModUpload;
import com.qtech.wb.service.IWbComparisonStdModDetailService;
import com.qtech.wb.service.IWbComparisonStdModUploadService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/06 15:16:39
 * desc   :
 */

@RestController
@RequestMapping("/wbcomparison/upload")
public class WbComparisonStdModUploadController extends BaseController {

    @Autowired
    IWbComparisonStdModDetailService wbComparisonStdModDetailService;

    @Autowired
    IWbComparisonStdModUploadService wbComparisonStdModUploadService;

    @PreAuthorize("@ss.hasPermi('wbcomparison:model:upload')")
    @Log(title = "CAD模版导入", businessType = BusinessType.IMPORT)
    @PostMapping("/manual")
    public AjaxResult uploadStStdModManual(MultipartFile file) throws Exception {
        ExcelUtil<WbComparisonStdModDetail> util = new ExcelUtil<>(WbComparisonStdModDetail.class);
        List<WbComparisonStdModDetail> wbComparisonStdModDetails = util.importExcel(file.getInputStream());
        Map<String, String> resultMap = wbComparisonStdModDetailService.uploadWbComparisonStdModDetail(wbComparisonStdModDetails);

        return "1".equals(resultMap.get("flag")) ? AjaxResult.success(resultMap.get("result")) : AjaxResult.warn(resultMap.get("result"));
    }

    /**
     * @param response
     * @return void
     * @description 模板下载
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {

        ExcelUtil<WbComparisonStdModDetail> util = new ExcelUtil<>(WbComparisonStdModDetail.class);
        util.importTemplateExcel(response, "打线图标准模版");
    }

    /**
     * @param wbComparisonStdModUpload
     * @return
     * @description
     */
    @GetMapping("/list")
    public TableDataInfo list(WbComparisonStdModUpload wbComparisonStdModUpload) {
        startPage(); // 这里会解析前端传过来的queryParams.params
        List<WbComparisonStdModUpload> list = wbComparisonStdModUploadService.selectWbComparisonStdModUploadList(wbComparisonStdModUpload);
        return getDataTable(list);
    }

    /**
     * @param
     * @return
     * @description
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:model:upload')")
    @Log(title = "采集模版导入", businessType = BusinessType.IMPORT)
    @GetMapping("/online")
    public AjaxResult uploadStdModOnline(@RequestParam(name = "mcId", defaultValue = "") String mcId,
                                         @RequestParam(name = "simId", defaultValue = "") String simId,
                                         @RequestParam(name = "pId", defaultValue = "") String pId,
                                         @RequestParam(name = "beginTime", defaultValue = "") String beginTime,
                                         @RequestParam(name = "endTime", defaultValue = "") String endTime,
                                         @RequestParam(name = "leadThreshold", defaultValue = "50") String leadThreshold,
                                         @RequestParam(name = "padThreshold", defaultValue = "10") String padThreshold,
                                         @RequestParam(name = "delLineNoStr", defaultValue = "") String delLineNo
    ) {
        List<WbComparisonStdModDetail> wbComparisonStdModDetails = wbComparisonStdModUploadService.selectWbComparisonStdModUploadMockList(simId, mcId, pId, beginTime, endTime, delLineNo);

        if (wbComparisonStdModDetails.size() == 0) {
            return AjaxResult.warn("没有符合条件的数据，请检查输入参数！");
        } else {
            String mcIdSplit = wbComparisonStdModDetails.get(0).getMcId().split("#")[0];

            for (WbComparisonStdModDetail wbComparisonStdModDetail : wbComparisonStdModDetails) {
                wbComparisonStdModDetail.setSource("采集模版");
                wbComparisonStdModDetail.setMcId(mcIdSplit);
                wbComparisonStdModDetail.setLeadThreshold(Float.parseFloat(leadThreshold));
                wbComparisonStdModDetail.setPadThreshold(Float.parseFloat(padThreshold));
            }
            Map<String, String> resultMap = wbComparisonStdModDetailService.uploadWbComparisonStdModDetail(wbComparisonStdModDetails);

            return AjaxResult.success(resultMap);
        }
    }

    @Log(title = "采集模版导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbComparisonStdModUpload wbComparisonStdModUpload)
    {
        List<WbComparisonStdModUpload> list = wbComparisonStdModUploadService.selectWbComparisonStdModUploadList(wbComparisonStdModUpload);
        ExcelUtil<WbComparisonStdModUpload> util = new ExcelUtil<WbComparisonStdModUpload>(WbComparisonStdModUpload.class);
        util.exportExcel(response, list, "标准模版");
    }
}
