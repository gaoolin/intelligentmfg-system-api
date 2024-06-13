package com.qtech.quartz.mapper;

import com.qtech.quartz.domain.YieldInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/13 15:19:51
 * @description : TODO
 */

@Repository
public interface YieldInfoTaskMapper {

    public List<YieldInfo> doYieldInfoTask();


}
