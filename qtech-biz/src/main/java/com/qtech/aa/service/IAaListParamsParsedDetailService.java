package com.qtech.aa.service;

import com.qtech.aa.controller.AaListParamsStdModelInfoController;
import com.qtech.aa.domain.AaListParamsParsed;
import com.qtech.aa.domain.AaListParamsStdModelDetail;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/05 15:57:27
 * desc   :
 */


public interface IAaListParamsParsedDetailService {
    public List<AaListParamsParsed> selectAaListParamsParsedDetailList(AaListParamsParsed aaListParamsParsed);
}
