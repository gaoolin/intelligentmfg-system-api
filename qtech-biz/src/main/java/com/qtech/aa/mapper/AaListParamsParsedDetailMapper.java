package com.qtech.aa.mapper;

import com.qtech.aa.domain.AaListParamsParsed;
import com.qtech.aa.domain.AaListParamsStdModelDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/05 15:50:46
 * desc   :
 */

@Mapper
public interface AaListParamsParsedDetailMapper {

    public List<AaListParamsParsed> selectAaListParamsParsedDetailList(AaListParamsParsed aaListParamsParsed);
}
