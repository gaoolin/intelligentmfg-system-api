package com.qtech.qcp.service;

import com.qtech.qcp.domain.QcpParamsVo;
import com.qtech.qcp.domain.QcpParamsDetailVo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/19 08:51:55
 * desc   :
 */


public interface IQcpParamsService {

    public List<QcpParamsVo> selectQcpParamsOverviewList(QcpParamsVo qcpParamsVo);

    public List<QcpParamsDetailVo> selectQcpParamsList(QcpParamsDetailVo qcpParamsDetailVo);

    public String getMaxTime();
}
