package com.qtech.quartz.service;

import com.qtech.quartz.domain.YieldInfo;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 16:57:05
 * @description : TODO
 */


public interface IYieldInfo2KuduService {

    public void save2Kudu(List<YieldInfo> yieldInfoList);
}
