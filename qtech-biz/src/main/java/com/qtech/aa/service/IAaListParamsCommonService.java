package com.qtech.aa.service;

import com.qtech.aa.domain.AaListParamsCommon;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/11 09:15:49
 * desc   :
 */


public interface IAaListParamsCommonService {

    public List<String> getFactoryName();

    public List<String> getWorkshopName(AaListParamsCommon aaListParamsCommon);
}
