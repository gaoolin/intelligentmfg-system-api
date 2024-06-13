package com.qtech.qcp.service.impl;

import com.qtech.qcp.domain.QcpParamsVo;
import com.qtech.qcp.domain.QcpParamsDetailVo;
import com.qtech.qcp.mapper.QcpParamsMapper;
import com.qtech.qcp.service.IQcpParamsService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/19 08:52:30
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.EIGHTH)
@Service
public class QcpParamsServiceImpl implements IQcpParamsService {

    @Autowired
    private QcpParamsMapper qcpParamsMapper;

    @Override
    public List<QcpParamsVo> selectQcpParamsOverviewList(QcpParamsVo qcpParamsVo) {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        qcpParamsVo.setDt(format);
        try {
            return qcpParamsMapper.selectQcpParamsOverviewList(qcpParamsVo);
        } catch (Exception e) {
            log.error("查询QCP参数概览列表失败", e);
            throw new RuntimeException("查询QCP参数概览列表失败，请联系系统负责人!");
        }
    }

    @Override
    public List<QcpParamsDetailVo> selectQcpParamsList(QcpParamsDetailVo qcpParamsDetailVo) {
        try {
            return qcpParamsMapper.selectQcpParamsList(qcpParamsDetailVo);
        } catch (Exception e) {
            log.error("查询QCP参数列表失败", e);
            throw new RuntimeException("查询QCP参数列表失败，请联系系统负责人!");
        }
    }

    @Override
    public String getMaxTime() {
        try {
            return qcpParamsMapper.getMaxTime();
        } catch (Exception e) {
            log.error("获取最大时间失败", e);
            throw new RuntimeException("获取最大时间失败，请联系系统负责人!");
        }
    }

}
