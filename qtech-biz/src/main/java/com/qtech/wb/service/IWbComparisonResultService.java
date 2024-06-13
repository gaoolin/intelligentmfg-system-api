package com.qtech.wb.service;

import com.qtech.wb.domain.WbComparisonResultVo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:31:50
 * desc   :
 */


public interface IWbComparisonResultService {

    public List<WbComparisonResultVo> selectWbComparisonResultList(WbComparisonResultVo wbComparisonResultVo);
}
