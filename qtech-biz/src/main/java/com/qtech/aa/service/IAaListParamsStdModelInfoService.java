package com.qtech.aa.service;

import com.qtech.aa.domain.AaListParamsStdModelInfo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/02 14:00:09
 * desc   :
 */


public interface IAaListParamsStdModelInfoService {
    public List<AaListParamsStdModelInfo> selectAaListParamsStdModelInfoList(AaListParamsStdModelInfo aaListParamsStdModelInfo);

    public AaListParamsStdModelInfo selectOneAaListParamsStdModelInfo(AaListParamsStdModelInfo aaListParamsStdModelInfo);

    public int insertAaListParamsStdModelInfo(Object entity);

    public int updateAaListParamsStdModelInfo(AaListParamsStdModelInfo aaListParamsStdModelInfo);

    public int deleteAaListParamsStdModelInfoByIds(Long[] list);
}
