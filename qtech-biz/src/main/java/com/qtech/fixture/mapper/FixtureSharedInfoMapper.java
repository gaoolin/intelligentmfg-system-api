package com.qtech.fixture.mapper;

import com.qtech.fixture.domain.FixtureMaterialInfo;
import com.qtech.fixture.domain.FixtureProdTypeInfo;
import com.qtech.fixture.domain.FixtureSharedInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * pogopin治具Mapper接口
 *
 * @author gaozhilin
 * @date 2023-06-27
 */
@Repository
public interface FixtureSharedInfoMapper {
    /**
     * 查询pogopin治具
     *
     * @param fixtureSharedInfo pogopin治具主键
     * @return pogopin治具
     */
    public FixtureSharedInfo selectFixtureSharedInfoOne(FixtureSharedInfo fixtureSharedInfo);

    public FixtureSharedInfo selectFixtureSharedInfoById(Long id);

    public List<FixtureSharedInfo> selectFixtureSharedInfoList(FixtureSharedInfo fixtureSharedInfo);

    public List<FixtureSharedInfo> selectFixtureSharedInfoDeptIds(@Value("deptId") Long userDeptId);
}
