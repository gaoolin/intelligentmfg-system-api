package com.qtech.wb.controller;

import com.qtech.wb.domain.WbComparisonStdModDetail;
import com.qtech.wb.service.IWbComparisonStdModDetailService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 标准模版明细Controller
 *
 * @author gaozhilin
 * @date 2023-09-06
 */
@RestController
@RequestMapping("/wbcomparison/detail")
public class WbComparisonStdModDetailController extends BaseController
{
    @Autowired
    private IWbComparisonStdModDetailService wbComparisonStdModDetailService;

    /**
     * 查询标准模版明细列表
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(WbComparisonStdModDetail wbComparisonStdModDetail)
    {
        startPage();
        List<WbComparisonStdModDetail> list = wbComparisonStdModDetailService.selectWbComparisonStdModDetailList(wbComparisonStdModDetail);
        return getDataTable(list);
    }

    /**
     * 导出标准模版明细列表
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:detail:export')")
    @Log(title = "标准模版明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WbComparisonStdModDetail wbComparisonStdModDetail)
    {
        List<WbComparisonStdModDetail> list = wbComparisonStdModDetailService.selectWbComparisonStdModDetailList(wbComparisonStdModDetail);
        ExcelUtil<WbComparisonStdModDetail> util = new ExcelUtil<WbComparisonStdModDetail>(WbComparisonStdModDetail.class);
        util.exportExcel(response, list, "标准模版明细数据");
    }

    /**
     * 获取标准模版明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wbComparisonStdModDetailService.selectWbComparisonStdModDetailById(id));
    }

    /**
     * 新增标准模版明细
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:detail:add')")
    @Log(title = "标准模版明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WbComparisonStdModDetail wbComparisonStdModDetail)
    {
        return toAjax(wbComparisonStdModDetailService.insertWbComparisonStdModDetail(wbComparisonStdModDetail));
    }

    /**
     * 修改标准模版明细
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:detail:edit')")
    @Log(title = "标准模版明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WbComparisonStdModDetail wbComparisonStdModDetail)
    {
        return toAjax(wbComparisonStdModDetailService.updateWbComparisonStdModDetail(wbComparisonStdModDetail));
    }

    /**
     * 删除标准模版明细
     */
    @PreAuthorize("@ss.hasPermi('wbcomparison:detail:remove')")
    @Log(title = "标准模版明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wbComparisonStdModDetailService.deleteWbComparisonStdModDetailByIds(ids));
    }
}
