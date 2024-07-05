package com.qtech.aa.mapper;

import com.qtech.aa.domain.AaListParamsStdModelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/02 13:43:36
 * desc   :
 */

@Mapper
public interface AaListParamsStdModelInfoMapper {

    public List<AaListParamsStdModelInfo> selectAaListParamsStdModelInfoList(AaListParamsStdModelInfo aaListParamsStdModelInfo);
    public int insertAaListParamsStdModelInfo(AaListParamsStdModelInfo aaListParamsStdModelInfo);
    public int updateAaListParamsStdModelInfo(AaListParamsStdModelInfo aaListParamsStdModelInfo);

    public int deleteAaListParamsStdModelInfoByIds(Long[] list);
}
