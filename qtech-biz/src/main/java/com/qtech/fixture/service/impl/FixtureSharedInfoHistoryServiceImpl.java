package com.qtech.fixture.service.impl;

import com.qtech.fixture.domain.FixtureSharedInfo;
import com.qtech.fixture.mapper.FixtureSharedInfoHistoryMapper;
import com.qtech.fixture.service.IFixtureSharedInfoHistoryService;
import com.qtech.common.annotation.DataScope;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/06/28 09:20:42
 * desc   :
 */

@Service
public class FixtureSharedInfoHistoryServiceImpl implements IFixtureSharedInfoHistoryService {

    @Autowired
    FixtureSharedInfoHistoryMapper fixtureSharedInfoHistoryMapper;

    @DataScope(deptAlias = "ta")
    @Override
    public List<FixtureSharedInfo> selectFixtureSharedInfoHistoryList(FixtureSharedInfo fixtureSharedInfo) {
        return fixtureSharedInfoHistoryMapper.selectFixtureSharedInfoHistoryList(fixtureSharedInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer addFixtureSharedInfoHistory(FixtureSharedInfo fixtureSharedInfo) {
        return fixtureSharedInfoHistoryMapper.addFixtureSharedInfoHistory(fixtureSharedInfo);
    }
}
