package com.qtech.quartz.service.impl;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.quartz.domain.YieldInfo;
import com.qtech.quartz.mapper.YieldInfoTaskMapper;
import com.qtech.quartz.service.IYieldInfoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/13 15:18:19
 * @description : TODO
 */

@DataSource(value = DataSourceType.THIRD)
@Service
public class YieldInfoTaskServiceImpl implements IYieldInfoTaskService {

    @Autowired
    YieldInfoTaskMapper yieldInfoTaskMapper;

    @Override
    public List<YieldInfo> doYieldInfoTask() {

        return yieldInfoTaskMapper.doYieldInfoTask();
    }
}
