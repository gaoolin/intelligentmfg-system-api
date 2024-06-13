package com.qtech.wb.service;

import com.qtech.wb.domain.WbComparisonParticularsVo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 14:24:45
 * desc   :
 */


public interface IWbComparisonDetailService {

    public List<WbComparisonParticularsVo> getDetail(WbComparisonParticularsVo wbComparisonParticularsVo);
}
