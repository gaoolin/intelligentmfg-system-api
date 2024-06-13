package com.qtech.quartz.mapper;

import com.qtech.quartz.domain.YieldInfo;
import org.springframework.stereotype.Repository;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 16:20:17
 * @description : TODO
 */

@Repository
public interface YieldInfo2KuduMapper {

    void save2Kudu(YieldInfo yieldInfo);
}
