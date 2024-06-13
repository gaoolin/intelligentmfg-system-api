package com.qtech.fixture.service;

import com.qtech.fixture.domain.FixtureStatisticsInfo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/12/17 15:32:14
 * desc   :
 */


public interface IFixtureStatisticsInfoService {

    public List<FixtureStatisticsInfo> getFixturePanelData();

    public List<FixtureStatisticsInfo> getFixtureTrendingData();
}
