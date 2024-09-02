package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbOlpOverview;
import com.qtech.wb.mapper.WbOlpOverviewMapper;
import com.qtech.wb.service.IWbOlpOverviewService;
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
public class WbOlpOverviewServiceImpl implements IWbOlpOverviewService {

    @Autowired
    WbOlpOverviewMapper wbOlpOverviewMapper;

    @Override
    public List<WbOlpOverview> selectWbOlpOverviewList(WbOlpOverview wbOlpOverview) {
        try {
            return wbOlpOverviewMapper.selectWbOlpOverviewList(wbOlpOverview);
        } catch (Exception e) {
            log.error("查询wbOlpOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public String getUpdateTime() {
        try {
            return wbOlpOverviewMapper.getUpdateTime();
        } catch (Exception e) {
            log.error("查询wbOlpOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }
}
