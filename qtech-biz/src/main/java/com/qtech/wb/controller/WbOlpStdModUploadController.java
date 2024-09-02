package com.qtech.wb.controller;

import com.qtech.wb.domain.WbOlpStdModDetail;
import com.qtech.wb.domain.WbOlpStdModUpload;
import com.qtech.wb.service.IWbOlpStdModDetailService;
import com.qtech.wb.service.IWbOlpStdModUploadService;
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
@RequestMapping("/wb/olp/upload")
public class WbOlpStdModUploadController extends BaseController {

    @Autowired
    IWbOlpStdModDetailService wbOlpStdModDetailService;

    @Autowired
    IWbOlpStdModUploadService wbOlpStdModUploadService;

    @PreAuthorize("@ss.hasPermi('wbOlp:model:upload')")
    @Log(title = "CAD模版导入", businessType = BusinessType.IMPORT)
    @PostMapping("/manual")
    public AjaxResult uploadStStdModManual(MultipartFile file) throws Exception {
        ExcelUtil<WbOlpStdModDetail> util = new ExcelUtil<>(WbOlpStdModDetail.class);
        List<WbOlpStdModDetail> wbOlpStdModDetails = util.importExcel(file.getInputStream());
        Map<String, String> resultMap = wbOlpStdModDetailService.uploadWbOlpStdModDetail(wbOlpStdModDetails);

        return "1".equals(resultMap.get("flag")) ? AjaxResult.success(resultMap.get("result")) : AjaxResult.warn(resultMap.get("result"));
    }

    /**
     * @param response
     * @return void
     * @description 模板下载
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {

        ExcelUtil<WbOlpStdModDetail> util = new ExcelUtil<>(WbOlpStdModDetail.class);
        util.importTemplateExcel(response, "打线图标准模版");
    }

    /**
     * @param wbOlpStdModUpload
     * @return
     * @description
     */
    @GetMapping("/list")
    public TableDataInfo list(WbOlpStdModUpload wbOlpStdModUpload) {
        startPage(); // 这里会解析前端传过来的queryParams.params
        List<WbOlpStdModUpload> list = wbOlpStdModUploadService.selectWbOlpStdModUploadList(wbOlpStdModUpload);
        return getDataTable(list);
    }

    /**
     * @param
     * @return
     * @description
     */
    @PreAuthorize("@ss.hasPermi('wbOlp:model:upload')")
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
        List<WbOlpStdModDetail> wbOlpStdModDetails = wbOlpStdModUploadService.selectWbOlpStdModUploadMockList(simId, mcId, pId, beginTime, endTime, delLineNo);

        if (wbOlpStdModDetails.size() == 0) {
            return AjaxResult.warn("没有符合条件的数据，请检查输入参数！");
        } else {
            String mcIdSplit = wbOlpStdModDetails.get(0).getMcId().split("#")[0];

            for (WbOlpStdModDetail wbOlpStdModDetail : wbOlpStdModDetails) {
                wbOlpStdModDetail.setSource("采集模版");
                wbOlpStdModDetail.setMcId(mcIdSplit);
                wbOlpStdModDetail.setLeadThreshold(Float.parseFloat(leadThreshold));
                wbOlpStdModDetail.setPadThreshold(Float.parseFloat(padThreshold));
            }
            Map<String, String> resultMap = wbOlpStdModDetailService.uploadWbOlpStdModDetail(wbOlpStdModDetails);

            return AjaxResult.success(resultMap);
        }
    }

    @Log(title = "采集模版导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbOlpStdModUpload wbOlpStdModUpload)
    {
        List<WbOlpStdModUpload> list = wbOlpStdModUploadService.selectWbOlpStdModUploadList(wbOlpStdModUpload);
        ExcelUtil<WbOlpStdModUpload> util = new ExcelUtil<WbOlpStdModUpload>(WbOlpStdModUpload.class);
        util.exportExcel(response, list, "标准模版");
    }
}
