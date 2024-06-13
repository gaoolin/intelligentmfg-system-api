package com.qtech.fixture.service;

import com.qtech.fixture.domain.FixtureSharedInfo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/06/28 09:14:55
 * desc   :
 */


public interface IFixtureSharedInfoHistoryService {

    List<FixtureSharedInfo> selectFixtureSharedInfoHistoryList(FixtureSharedInfo fixtureSharedInfo);

    Integer addFixtureSharedInfoHistory(FixtureSharedInfo fixtureSharedInfo);
}
