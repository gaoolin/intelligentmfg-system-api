package com.qtech.wire.service.impl;

import java.util.List;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qtech.wire.mapper.WorkshopLevelWireUsageMapper;
import com.qtech.wire.domain.WorkshopLevelWireUsage;
import com.qtech.wire.service.IWorkshopLevelWireUsageService;

/**
 * 车间级金线用量监控Service业务层处理
 *
 * @author qtech
 * @date 2023-05-16
 */
@DataSource(value = DataSourceType.FIFTH)
@Service
public class WorkshopLevelWireUsageServiceImpl implements IWorkshopLevelWireUsageService
{
    @Autowired
    private WorkshopLevelWireUsageMapper workshopLevelWireUsageMapper;

    /**
     * 查询车间级金线用量监控
     *
     * @param factoryName 车间级金线用量监控主键
     * @return 车间级金线用量监控
     */
    @Override
    public WorkshopLevelWireUsage selectWorkshopLevelWireUsageByFactoryName(String factoryName)
    {
        return workshopLevelWireUsageMapper.selectWorkshopLevelWireUsageByFactoryName(factoryName);
    }

    /**
     * 查询车间级金线用量监控列表
     *
     * @param workshopLevelWireUsage 车间级金线用量监控
     * @return 车间级金线用量监控
     */
    @Override
    public List<WorkshopLevelWireUsage> selectWorkshopLevelWireUsageList(WorkshopLevelWireUsage workshopLevelWireUsage)
    {
        return workshopLevelWireUsageMapper.selectWorkshopLevelWireUsageList(workshopLevelWireUsage);
    }

    /**
     * 新增车间级金线用量监控
     *
     * @param workshopLevelWireUsage 车间级金线用量监控
     * @return 结果
     */
    @Override
    public int insertWorkshopLevelWireUsage(WorkshopLevelWireUsage workshopLevelWireUsage)
    {
        return workshopLevelWireUsageMapper.insertWorkshopLevelWireUsage(workshopLevelWireUsage);
    }

    /**
     * 修改车间级金线用量监控
     *
     * @param workshopLevelWireUsage 车间级金线用量监控
     * @return 结果
     */
    @Override
    public int updateWorkshopLevelWireUsage(WorkshopLevelWireUsage workshopLevelWireUsage)
    {
        return workshopLevelWireUsageMapper.updateWorkshopLevelWireUsage(workshopLevelWireUsage);
    }

    /**
     * 批量删除车间级金线用量监控
     *
     * @param factoryNames 需要删除的车间级金线用量监控主键
     * @return 结果
     */
    @Override
    public int deleteWorkshopLevelWireUsageByFactoryNames(String[] factoryNames)
    {
        return workshopLevelWireUsageMapper.deleteWorkshopLevelWireUsageByFactoryNames(factoryNames);
    }

    /**
     * 删除车间级金线用量监控信息
     *
     * @param factoryName 车间级金线用量监控主键
     * @return 结果
     */
    @Override
    public int deleteWorkshopLevelWireUsageByFactoryName(String factoryName)
    {
        return workshopLevelWireUsageMapper.deleteWorkshopLevelWireUsageByFactoryName(factoryName);
    }
}
