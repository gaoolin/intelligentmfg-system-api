package com.qtech.aa.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/11 09:18:12
 * desc   :
 */

@Mapper
public interface AaListParamsCommonMapper {
    public List<String> getFactoryName();
    public List<String> getWorkshopName();
}
