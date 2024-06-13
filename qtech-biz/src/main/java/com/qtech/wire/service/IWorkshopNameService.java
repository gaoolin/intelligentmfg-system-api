package com.qtech.wire.service;

import com.qtech.wire.domain.EqLevelWireUsage;
import com.qtech.wire.domain.WorkshopNameList;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech
 * @email : gaoolin@gmail.com
 * @date : 2023/03/27 16:07:35
 * @description : TODO
 */


public interface IWorkshopNameService {

    public List<WorkshopNameList> selectWorkshopNameList(EqLevelWireUsage eqLevelWireUsage);
}
