package com.qtech.wb.service;

import com.qtech.wb.domain.EmsEqInfo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 17:00:34
 * desc   :
 */


public interface IEmsEqInfoService {

    public List<EmsEqInfo> selectEmsEqInfoList(EmsEqInfo emsEqInfo);
}
