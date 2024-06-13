package com.qtech.aa.mapper;

import com.qtech.aa.domain.AaListParamsStdModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:36:51
 * desc   :
 */

@Mapper
public interface AaListParamsStdModelMapper {
    public List<AaListParamsStdModel> selectAaListParamsStdModelList(AaListParamsStdModel aaListParamsStdModel);

    public int insertAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel);

    public int updateAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel);

    public int deleteAaListParamsStdModelByIds(List<Long> list);
}
