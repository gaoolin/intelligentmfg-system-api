package com.qtech.wire.service.impl;

import com.qtech.wire.domain.FactoryNameList;
import com.qtech.wire.mapper.FactoryNameListMapper;
import com.qtech.wire.service.IFactoryNameService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech
 * @email : gaoolin@gmail.com
 * @date : 2023/03/27 14:05:53
 * @description :
 */
@DataSource(value = DataSourceType.SLAVE)
@Service
public class FactoryNameServiceImpl implements IFactoryNameService {

    @Autowired
    FactoryNameListMapper factoryNameListMapper;

    @Override
    public List<FactoryNameList> SelectFactoryNameList() {
        List<FactoryNameList> factoryNameLists = factoryNameListMapper.selectFactoryName();
        return factoryNameLists;
    }
}
