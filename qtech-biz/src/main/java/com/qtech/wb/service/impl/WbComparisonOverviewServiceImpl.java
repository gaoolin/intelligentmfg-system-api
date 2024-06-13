package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbComparisonOverview;
import com.qtech.wb.mapper.WbComparisonOverviewMapper;
import com.qtech.wb.service.IWbComparisonOverviewService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/05 08:54:17
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class WbComparisonOverviewServiceImpl implements IWbComparisonOverviewService {

    @Autowired
    WbComparisonOverviewMapper wbComparisonOverviewMapper;

    @Override
    public List<WbComparisonOverview> selectWbComparisonOverviewList(WbComparisonOverview wbComparisonOverview) {
        try {
            return wbComparisonOverviewMapper.selectWbComparisonOverviewList(wbComparisonOverview);
        } catch (Exception e) {
            log.error("查询wbComparisonOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public List<WbComparisonOverview> selectFactoryNameList() {
        try {
            return wbComparisonOverviewMapper.selectFactoryNameList();
        } catch (Exception e) {
            log.error("查询wbComparisonOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public List<WbComparisonOverview> selectWorkShopNameList(WbComparisonOverview wbComparisonOverview) {
        try {
            return wbComparisonOverviewMapper.selectWorkShopNameList(wbComparisonOverview);
        } catch (Exception e) {
            log.error("查询wbComparisonOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public String getUpdateTime() {
        try {
            return wbComparisonOverviewMapper.getUpdateTime();
        } catch (Exception e) {
            log.error("查询wbComparisonOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }
}
