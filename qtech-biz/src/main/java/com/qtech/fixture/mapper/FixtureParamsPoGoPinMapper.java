package com.qtech.fixture.mapper;

import com.qtech.fixture.domain.FixtureParamsPoGoPin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/03/07 15:32:52
 * desc   :
 */

@Repository
public interface FixtureParamsPoGoPinMapper {

    public List<FixtureParamsPoGoPin> selectFixtureParamsPoGoPinList(FixtureParamsPoGoPin FixtureParamsPoGoPin);

    public FixtureParamsPoGoPin selectOneFixtureParamsPoGoPin(Long id);

    public int addFixtureParamsPoGoPin(FixtureParamsPoGoPin FixtureParamsPoGoPin);

    public int editFixtureParamsPoGoPin(FixtureParamsPoGoPin FixtureParamsPoGoPin);

    public int removeFixtureParamsPoGoPin(FixtureParamsPoGoPin FixtureParamsPoGoPin);
}
