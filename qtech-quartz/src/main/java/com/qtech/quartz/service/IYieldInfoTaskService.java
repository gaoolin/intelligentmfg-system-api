package com.qtech.quartz.service;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.quartz.domain.YieldInfo;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/13 15:11:34
 * @description : TODO
 */


public interface IYieldInfoTaskService {

    public List<YieldInfo> doYieldInfoTask();
}
