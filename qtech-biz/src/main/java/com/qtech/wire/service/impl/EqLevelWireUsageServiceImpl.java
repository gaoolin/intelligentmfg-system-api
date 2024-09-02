package com.qtech.wire.service.impl;

import java.util.List;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qtech.wire.mapper.EqLevelWireUsageMapper;
import com.qtech.wire.domain.EqLevelWireUsage;
import com.qtech.wire.service.IEqLevelWireUsageService;

/**
 * 金线消耗量Service业务层处理
 *
 * @author gaozhilin
 * @date 2023-03-29
 */
@DataSource(value = DataSourceType.SLAVE)
@Service
public class EqLevelWireUsageServiceImpl implements IEqLevelWireUsageService
{
    @Autowired
    private EqLevelWireUsageMapper eqLevelWireUsageMapper;

    /**
     * 查询金线消耗量列表
     *
     * @param eqLevelWireUsage 金线消耗量
     * @return 金线消耗量
     */
    @Override
    public List<EqLevelWireUsage> selectEqLevelWireUsageList(EqLevelWireUsage eqLevelWireUsage)
    {
        return eqLevelWireUsageMapper.selectEqLevelWireUsageList(eqLevelWireUsage);
    }
}
