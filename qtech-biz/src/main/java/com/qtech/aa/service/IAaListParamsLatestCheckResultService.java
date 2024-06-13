package com.qtech.aa.service;

import com.qtech.aa.domain.AaListParamsCheckResult;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 09:37:30
 * desc   :
 */


public interface IAaListParamsLatestCheckResultService {
    public List<AaListParamsCheckResult> selectAaListParamsLatestCheckResultList(AaListParamsCheckResult aaListParamsCheckResult);

    public List<AaListParamsCheckResult> selectGroupNameList(AaListParamsCheckResult aaListParamsCheckResult);

    public List<AaListParamsCheckResult> selectFactoryNameList();
}
