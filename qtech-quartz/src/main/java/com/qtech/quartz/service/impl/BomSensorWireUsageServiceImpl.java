package com.qtech.quartz.service.impl;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.quartz.domain.BomSensorWireUsage;
import com.qtech.quartz.mapper.BomSensorWireUsageTaskMapper;
import com.qtech.quartz.service.IBomSensorWireUsageTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 10:31:26
 * @description : TODO
 */

@DataSource(value = DataSourceType.FOURTH)
@Service
public class BomSensorWireUsageServiceImpl implements IBomSensorWireUsageTaskService {

    @Autowired
    BomSensorWireUsageTaskMapper bomSensorWireUsageTaskMapper;

    @Override
    public List<BomSensorWireUsage> doBomSensorWireUsageTask() {
        return bomSensorWireUsageTaskMapper.doBomSensorWireUsageTask();
    }
}
