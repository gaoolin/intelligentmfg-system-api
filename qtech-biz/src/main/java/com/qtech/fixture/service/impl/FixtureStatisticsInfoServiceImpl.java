package com.qtech.fixture.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.qtech.fixture.domain.FixtureStatisticsInfo;
import com.qtech.fixture.mapper.FixtureStatisticsInfoMapper;
import com.qtech.fixture.service.IFixtureStatisticsInfoService;
import com.qtech.common.constant.Constants;
import com.qtech.common.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/12/17 15:32:49
 * desc   :
 */

@Service
public class FixtureStatisticsInfoServiceImpl implements IFixtureStatisticsInfoService {

    @Autowired
    FixtureStatisticsInfoMapper fixtureStatisticsInfoMapper;

    @Override
    public List<FixtureStatisticsInfo> getFixturePanelData() {
        List<FixtureStatisticsInfo> list = fixtureStatisticsInfoMapper.selectFixturePanelData();
        return list;
    }

    @Override
    public List<FixtureStatisticsInfo> getFixtureTrendingData() {
        List<FixtureStatisticsInfo> fixtureHistoryTrendingData = fixtureStatisticsInfoMapper.getFixtureHistoryTrendingData();

        String s = HttpUtils.sendGet("http://10.170.6.40:31735/fixture/statistics/line", Constants.GBK);
//        String s = HttpUtils.sendGet("http://127.0.0.1:5000/fixture/statistics/line", Constants.GBK);
//        String s = HttpUtils.sendGet("http://fixture-statistics.fixture-statistics:5000/fixture/statistics/line", Constants.GBK);

        if ("[]".equals(s)) {
            return fixtureHistoryTrendingData;
        }
        List<FixtureStatisticsInfo> ratioAll = JSON.parseObject(s, new TypeReference<ArrayList<FixtureStatisticsInfo>>() {
        });
        String weekNum = ratioAll.get(ratioAll.size() - 1).getWeekNum();

        fixtureHistoryTrendingData.addAll(ratioAll.stream().filter(x -> weekNum.equals(x.getWeekNum())).collect(Collectors.toList()));

        return fixtureHistoryTrendingData;
    }
}
