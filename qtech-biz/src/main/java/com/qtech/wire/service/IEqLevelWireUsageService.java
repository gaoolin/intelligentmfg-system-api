package com.qtech.wire.service;

import java.util.List;
import com.qtech.wire.domain.EqLevelWireUsage;

/**
 * 金线消耗量Service接口
 *
 * @author gaozhilin
 * @date 2023-03-29
 */
public interface IEqLevelWireUsageService
{
    /**
     * 查询金线消耗量列表
     *
     * @param eqLevelWireUsage 金线消耗量
     * @return 金线消耗量集合
     */
    public List<EqLevelWireUsage> selectEqLevelWireUsageList(EqLevelWireUsage eqLevelWireUsage);
}
