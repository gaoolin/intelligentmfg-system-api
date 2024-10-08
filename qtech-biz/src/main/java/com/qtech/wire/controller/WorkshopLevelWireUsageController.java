package com.qtech.wire.controller;

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
import com.qtech.wire.domain.WorkshopLevelWireUsage;
import com.qtech.wire.service.IWorkshopLevelWireUsageService;
import com.qtech.common.utils.poi.ExcelUtil;
import com.qtech.common.core.page.TableDataInfo;

/**
 * 车间级金线用量监控Controller
 *
 * @author qtech
 * @date 2023-05-16
 */
@RestController
@RequestMapping("/biz/wire/monitor/workshop")
public class WorkshopLevelWireUsageController extends BaseController
{
    @Autowired
    private IWorkshopLevelWireUsageService workshopLevelWireUsageService;

    /**
     * 查询车间级金线用量监控列表
     */
    @PreAuthorize("@ss.hasPermi('biz/wire/monitor:workshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(WorkshopLevelWireUsage workshopLevelWireUsage)
    {
        startPage();
        List<WorkshopLevelWireUsage> list = workshopLevelWireUsageService.selectWorkshopLevelWireUsageList(workshopLevelWireUsage);
        return getDataTable(list);
    }

    /**
     * 导出车间级金线用量监控列表
     */
    @PreAuthorize("@ss.hasPermi('biz/wire/monitor:workshop:export')")
    @Log(title = "车间级金线用量监控", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WorkshopLevelWireUsage workshopLevelWireUsage)
    {
        List<WorkshopLevelWireUsage> list = workshopLevelWireUsageService.selectWorkshopLevelWireUsageList(workshopLevelWireUsage);
        ExcelUtil<WorkshopLevelWireUsage> util = new ExcelUtil<WorkshopLevelWireUsage>(WorkshopLevelWireUsage.class);
        util.exportExcel(response, list, "车间级金线用量监控数据");
    }

    /**
     * 获取车间级金线用量监控详细信息
     */
    @PreAuthorize("@ss.hasPermi('biz/wire/monitor:workshop:query')")
    @GetMapping(value = "/{factoryName}")
    public AjaxResult getInfo(@PathVariable("factoryName") String factoryName)
    {
        return success(workshopLevelWireUsageService.selectWorkshopLevelWireUsageByFactoryName(factoryName));
    }

    /**
     * 新增车间级金线用量监控
     */
    @PreAuthorize("@ss.hasPermi('biz/wire/monitor:workshop:add')")
    @Log(title = "车间级金线用量监控", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WorkshopLevelWireUsage workshopLevelWireUsage)
    {
        return toAjax(workshopLevelWireUsageService.insertWorkshopLevelWireUsage(workshopLevelWireUsage));
    }

    /**
     * 修改车间级金线用量监控
     */
    @PreAuthorize("@ss.hasPermi('biz/wire/monitor:workshop:edit')")
    @Log(title = "车间级金线用量监控", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WorkshopLevelWireUsage workshopLevelWireUsage)
    {
        return toAjax(workshopLevelWireUsageService.updateWorkshopLevelWireUsage(workshopLevelWireUsage));
    }

    /**
     * 删除车间级金线用量监控
     */
    @PreAuthorize("@ss.hasPermi('biz/wire/monitor:workshop:remove')")
    @Log(title = "车间级金线用量监控", businessType = BusinessType.DELETE)
	@DeleteMapping("/{factoryNames}")
    public AjaxResult remove(@PathVariable String[] factoryNames)
    {
        return toAjax(workshopLevelWireUsageService.deleteWorkshopLevelWireUsageByFactoryNames(factoryNames));
    }
}
