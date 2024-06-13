package com.qtech.quartz.service.impl;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.quartz.domain.YieldInfo;
import com.qtech.quartz.mapper.YieldInfo2KuduMapper;
import com.qtech.quartz.service.IYieldInfo2KuduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 16:58:17
 * @description : TODO
 */

@DataSource(value = DataSourceType.SLAVE)
@Service
public class YieldInfo2KuduServiceImpl implements IYieldInfo2KuduService {

    @Autowired
    YieldInfo2KuduMapper yieldInfo2KuduMapper;

    @Override
    public void save2Kudu(List<YieldInfo> yieldInfoList) {
        yieldInfoList.forEach(item -> {
            yieldInfo2KuduMapper.save2Kudu(item);
        });
    }
}
