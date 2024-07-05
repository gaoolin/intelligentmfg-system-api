package com.qtech.aa.mapper;

import com.qtech.aa.domain.AaListParamsStdModelDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:36:51
 * desc   :
 */

@Mapper
public interface AaListParamsStdModelDetailMapper {
    public List<AaListParamsStdModelDetail> selectAaListParamsStdModelList(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int insertAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int updateAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int deleteAaListParamsStdModelByIds(List<Long> list);

    public int deleteAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int batchInsert(@Param("list") List<AaListParamsStdModelDetail> list);

    public int checkIfExists(AaListParamsStdModelDetail detail);
}
