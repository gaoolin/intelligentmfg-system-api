package com.qtech.wire.service.impl;

import com.qtech.wire.domain.EqLevelWireUsage;
import com.qtech.wire.domain.WorkshopNameList;
import com.qtech.wire.mapper.WorkshopNameListMapper;
import com.qtech.wire.service.IWorkshopNameService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech
 * @email : gaoolin@gmail.com
 * @date : 2023/03/27 16:08:42
 * @description : TODO
 */
@DataSource(value= DataSourceType.FIFTH)
@Service
public class WorkshopNameServiceImpl implements IWorkshopNameService {

    @Autowired
    WorkshopNameListMapper workshopNameListMapper;

    @Override
    public List<WorkshopNameList> selectWorkshopNameList(EqLevelWireUsage eqLevelWireUsage) {

        List<WorkshopNameList> workshopNameLists = workshopNameListMapper.selectWorkshopNameList(eqLevelWireUsage);
        return workshopNameLists;
    }
}
