package com.qtech.quartz.mapper;

import com.qtech.quartz.domain.BomSensorWireUsage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-biz-management-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 10:23:39
 * @description : TODO
 */

@Repository
public interface BomSensorWireUsageTaskMapper {

    public List<BomSensorWireUsage> doBomSensorWireUsageTask();
}
