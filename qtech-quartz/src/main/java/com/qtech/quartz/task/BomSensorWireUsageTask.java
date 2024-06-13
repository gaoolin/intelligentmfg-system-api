package com.qtech.quartz.task;

import com.qtech.quartz.domain.BomSensorWireUsage;
import com.qtech.quartz.mapper.BomSensorWireUsageTaskMapper;
import com.qtech.quartz.service.IBomSensorWireUsageTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 11:03:13
 * @description : TODO
 */


@Component("bomTask")
public class BomSensorWireUsageTask {

    @Autowired
    IBomSensorWireUsageTaskService bomSensorWireUsageTaskService;

    public void doBomSensorWireUsageTaskJob() {
        List<BomSensorWireUsage> bomSensorWireUsages = bomSensorWireUsageTaskService.doBomSensorWireUsageTask();
    }

}
