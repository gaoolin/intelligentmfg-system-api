package com.qtech.fixture.mapper;

import com.qtech.fixture.domain.FixtureParamsLock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/04/16 14:15:10
 * desc   :
 */

@Repository
public interface FixtureParamsLockMapper {
    List<FixtureParamsLock> selectFixtureParamsLockList(FixtureParamsLock fixtureParamsLock);

    int addFixtureParamsLock(FixtureParamsLock fixtureParamsLock);

    int editFixtureParamsLock(FixtureParamsLock fixtureParamsLock);

    int removeFixtureParamsLock(FixtureParamsLock fixtureParamsLock);
}
