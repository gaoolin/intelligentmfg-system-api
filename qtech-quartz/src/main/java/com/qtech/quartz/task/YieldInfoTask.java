package com.qtech.quartz.task;

import com.qtech.quartz.domain.YieldInfo;
import com.qtech.quartz.service.IYieldInfo2KuduService;
import com.qtech.quartz.service.IYieldInfoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/13 10:56:03
 * @description : TODO
 */

@Component("yieldTask")
public class YieldInfoTask {

    @Autowired
    IYieldInfoTaskService yieldInfoTaskService;

    @Autowired
    IYieldInfo2KuduService iYieldInfo2KuduService;

    public void doYieldInfoTaskJob() {
        System.out.println("yieldTask执行doYieldInfoTaskJob");
        List<YieldInfo> yieldInfos = yieldInfoTaskService.doYieldInfoTask();
        System.out.println(yieldInfos);

        /**
         * kudu表的主键改为uuid
         * 插入数据用uuid作为主键插入
         */
        iYieldInfo2KuduService.save2Kudu(yieldInfos);
    }

}
