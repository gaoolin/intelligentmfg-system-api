package com.qtech.wire.mapper;

import com.qtech.wire.domain.FactoryNameList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : gaozhilin
 * @project : qtech
 * @email : gaoolin@gmail.com
 * @date : 2023/03/27 13:35:59
 * @description : TODO
 */

@Repository
public interface FactoryNameListMapper {

    public List<FactoryNameList> selectFactoryName();

}
