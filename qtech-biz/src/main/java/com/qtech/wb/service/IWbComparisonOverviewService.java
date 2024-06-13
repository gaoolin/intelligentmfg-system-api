package com.qtech.wb.service;

import com.qtech.wb.domain.WbComparisonOverview;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/05 08:52:19
 * desc   :
 */


public interface IWbComparisonOverviewService {

    public List<WbComparisonOverview> selectWbComparisonOverviewList(WbComparisonOverview wbComparisonOverview);

    public List<WbComparisonOverview> selectFactoryNameList();

    public List<WbComparisonOverview> selectWorkShopNameList(WbComparisonOverview wbComparisonOverview);

    public String getUpdateTime();
}
