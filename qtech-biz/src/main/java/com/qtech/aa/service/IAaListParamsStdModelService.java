package com.qtech.aa.service;

import com.qtech.aa.domain.AaListParamsStdModel;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:38:52
 * desc   :
 */


public interface IAaListParamsStdModelService {

    public List<AaListParamsStdModel> selectAaListParamsStdModelList(AaListParamsStdModel aaListParamsStdModel);

    public AaListParamsStdModel selectOneAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel);

    public int insertAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel);

    public int updateAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel);

    public int deleteAaListParamsStdModelByIds(List<Long> list);
}
