package com.qtech.wb.service;

import com.qtech.aa.domain.AaListParamsCommon;
import com.qtech.wb.vo.WbOlpChkVo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:31:50
 * desc   :
 */


public interface IWbOlpChkService {

    List<WbOlpChkVo> selectWbOlpChkList(WbOlpChkVo vo, int daysFilter);
}
