package com.qtech.wb.service;

import com.qtech.wb.domain.WbComparisonPercentageVo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 08:33:50
 * desc   :
 */


public interface IWbComparisonRatioService {

    public List<WbComparisonPercentageVo> getRatio(WbComparisonPercentageVo wbComparisonPercentageVo);
}
