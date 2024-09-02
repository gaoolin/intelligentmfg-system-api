package com.qtech.aa.mapper;

import com.qtech.aa.domain.AaListParamsCommon;
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
    public List<AaListParamsCommon> getFactoryName();
    public List<AaListParamsCommon> getWorkshopName(AaListParamsCommon aaListParamsCommon);
}
