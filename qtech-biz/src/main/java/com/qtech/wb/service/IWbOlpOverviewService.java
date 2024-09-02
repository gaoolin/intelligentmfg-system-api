package com.qtech.wb.service;

import com.qtech.wb.domain.WbOlpOverview;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/05 08:52:19
 * desc   :
 */


public interface IWbOlpOverviewService {

    public List<WbOlpOverview> selectWbOlpOverviewList(WbOlpOverview wbOlpOverview);
    public String getUpdateTime();
}
