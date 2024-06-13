package com.qtech.wire.service.impl;

import java.util.List;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qtech.wire.mapper.FactoryLevelWireUsageMapper;
import com.qtech.wire.domain.FactoryLevelWireUsage;
import com.qtech.wire.service.IFactoryLevelWireUsageService;

/**
 * 厂区级金线用量监控Service业务层处理
 *
 * @author qtech
 * @date 2023-05-17
 */
@DataSource(DataSourceType.FIFTH)
@Service
public class FactoryLevelWireUsageServiceImpl implements IFactoryLevelWireUsageService
{
    @Autowired
    private FactoryLevelWireUsageMapper factoryLevelWireUsageMapper;

    /**
     * 查询厂区级金线用量监控
     *
     * @param factoryName 厂区级金线用量监控主键
     * @return 厂区级金线用量监控
     */
    @Override
    public FactoryLevelWireUsage selectFactoryLevelWireUsageByFactoryName(String factoryName)
    {
        return factoryLevelWireUsageMapper.selectFactoryLevelWireUsageByFactoryName(factoryName);
    }

    /**
     * 查询厂区级金线用量监控列表
     *
     * @param factoryLevelWireUsage 厂区级金线用量监控
     * @return 厂区级金线用量监控
     */
    @Override
    public List<FactoryLevelWireUsage> selectFactoryLevelWireUsageList(FactoryLevelWireUsage factoryLevelWireUsage)
    {
        return factoryLevelWireUsageMapper.selectFactoryLevelWireUsageList(factoryLevelWireUsage);
    }

    /**
     * 新增厂区级金线用量监控
     *
     * @param factoryLevelWireUsage 厂区级金线用量监控
     * @return 结果
     */
    @Override
    public int insertFactoryLevelWireUsage(FactoryLevelWireUsage factoryLevelWireUsage)
    {
        return factoryLevelWireUsageMapper.insertFactoryLevelWireUsage(factoryLevelWireUsage);
    }

    /**
     * 修改厂区级金线用量监控
     *
     * @param factoryLevelWireUsage 厂区级金线用量监控
     * @return 结果
     */
    @Override
    public int updateFactoryLevelWireUsage(FactoryLevelWireUsage factoryLevelWireUsage)
    {
        return factoryLevelWireUsageMapper.updateFactoryLevelWireUsage(factoryLevelWireUsage);
    }

    /**
     * 批量删除厂区级金线用量监控
     *
     * @param factoryNames 需要删除的厂区级金线用量监控主键
     * @return 结果
     */
    @Override
    public int deleteFactoryLevelWireUsageByFactoryNames(String[] factoryNames)
    {
        return factoryLevelWireUsageMapper.deleteFactoryLevelWireUsageByFactoryNames(factoryNames);
    }

    /**
     * 删除厂区级金线用量监控信息
     *
     * @param factoryName 厂区级金线用量监控主键
     * @return 结果
     */
    @Override
    public int deleteFactoryLevelWireUsageByFactoryName(String factoryName)
    {
        return factoryLevelWireUsageMapper.deleteFactoryLevelWireUsageByFactoryName(factoryName);
    }
}
