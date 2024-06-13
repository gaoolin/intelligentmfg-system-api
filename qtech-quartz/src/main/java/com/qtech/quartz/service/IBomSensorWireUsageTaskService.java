package com.qtech.quartz.service;

import com.qtech.quartz.domain.BomSensorWireUsage;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 10:30:13
 * @description : TODO
 */


public interface IBomSensorWireUsageTaskService {

    public List<BomSensorWireUsage> doBomSensorWireUsageTask();
}
