package com.qtech.wb.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.enums.BusinessType;
import com.qtech.wb.domain.WbComparisonStdModInfo;
import com.qtech.wb.service.IWbComparisonStdModInfoService;
import com.qtech.common.utils.poi.ExcelUtil;
import com.qtech.common.core.page.TableDataInfo;

/**
 * 智慧打线图Controller
 *
 * @author gaozhilin
 * @date 2023-09-05
 */
@RestController
@RequestMapping("/wbcomparison/info")
public class WbComparisonStdModInfoController extends BaseController
{
    @Autowired
    private IWbComparisonStdModInfoService wbComparisonStdModInfoService;

    /**
     * 查询智慧打线图列表
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(WbComparisonStdModInfo wbComparisonStdModInfo)
    {
        startPage();
        List<WbComparisonStdModInfo> list = wbComparisonStdModInfoService.selectWbComparisonStdModInfoList(wbComparisonStdModInfo);
        return getDataTable(list);
    }

    /**
     * 导出智慧打线图列表
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:info:export')")
    @Log(title = "智慧打线图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbComparisonStdModInfo wbComparisonStdModInfo)
    {
        List<WbComparisonStdModInfo> list = wbComparisonStdModInfoService.selectWbComparisonStdModInfoList(wbComparisonStdModInfo);
        ExcelUtil<WbComparisonStdModInfo> util = new ExcelUtil<WbComparisonStdModInfo>(WbComparisonStdModInfo.class);
        util.exportExcel(response, list, "智慧打线图数据");
    }

    /**
     * 获取智慧打线图详细信息
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:info:query')")
    @GetMapping(value = "/{sid}")
    public AjaxResult getInfo(@PathVariable("sid") Long sid)
    {
        return success(wbComparisonStdModInfoService.selectWbComparisonStdModInfoBySid(sid));
    }

    /**
     * 新增智慧打线图
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:info:add')")
    @Log(title = "智慧打线图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WbComparisonStdModInfo wbComparisonStdModInfo)
    {
        return toAjax(wbComparisonStdModInfoService.insertWbComparisonStdModInfo(wbComparisonStdModInfo));
    }

    /**
     * 修改智慧打线图
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:info:edit')")
    @Log(title = "智慧打线图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WbComparisonStdModInfo wbComparisonStdModInfo)
    {
        return toAjax(wbComparisonStdModInfoService.updateWbComparisonStdModInfo(wbComparisonStdModInfo));
    }

    /**
     * 删除智慧打线图
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:info:remove')")
    @Log(title = "智慧打线图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sids}")
    public AjaxResult remove(@PathVariable Long[] sids)
    {
        return toAjax(wbComparisonStdModInfoService.deleteWbComparisonStdModInfoBySids(sids));
    }
}
