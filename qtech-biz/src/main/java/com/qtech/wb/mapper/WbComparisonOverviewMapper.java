package com.qtech.wb.mapper;

import com.qtech.wb.domain.WbComparisonOverview;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/04 15:24:56
 * desc   :
 */

@Repository
public interface WbComparisonOverviewMapper {

    public List<WbComparisonOverview> selectWbComparisonOverviewList(WbComparisonOverview wbComparisonOverview);

    public List<WbComparisonOverview> selectFactoryNameList();

    public List<WbComparisonOverview> selectWorkShopNameList(WbComparisonOverview wbComparisonOverview);

    public String getUpdateTime();
}
