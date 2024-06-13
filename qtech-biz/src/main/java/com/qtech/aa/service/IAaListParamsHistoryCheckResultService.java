package com.qtech.aa.service;

import com.qtech.aa.domain.AaListParamsCheckResult;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/03 10:57:52
 * desc   :
 */

public interface IAaListParamsHistoryCheckResultService {

    public List<AaListParamsCheckResult> selectAaListParamsCheckResultList(AaListParamsCheckResult aaListParamsCheckResult);
}
