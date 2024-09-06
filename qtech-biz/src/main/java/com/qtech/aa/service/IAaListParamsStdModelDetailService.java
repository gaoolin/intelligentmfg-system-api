package com.qtech.aa.service;

import com.qtech.aa.domain.AaListParamsStdModelDetail;
import com.qtech.aa.domain.AaListParamsStdModelInfo;

import java.util.List;
import java.util.Map;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:38:52
 * desc   :
 */


public interface IAaListParamsStdModelDetailService {

    public List<AaListParamsStdModelDetail> selectAaListParamsStdModelList(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public AaListParamsStdModelDetail selectOneAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int insertAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int batchInsert(List<AaListParamsStdModelDetail> paramsModelList);

    public int updateAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int deleteAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail);

    public int deleteAaListParamsStdModelByIds(List<Long> list);

    public Map<String, Object> uploadManual(List<AaListParamsStdModelDetail> paramsModelList);

    public Map<String, Object> uploadOnline(AaListParamsStdModelDetail aaListParamsStdModelDetail);
}
