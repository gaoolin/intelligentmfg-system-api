package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsCheckResult;
import com.qtech.aa.mapper.AaListParamsHistoryCheckResultMapper;
import com.qtech.aa.service.IAaListParamsHistoryCheckResultService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/03 10:58:31
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class AaListParamsHistoryCheckResultServiceImpl implements IAaListParamsHistoryCheckResultService {

    @Autowired
    private AaListParamsHistoryCheckResultMapper aaListParamsHistoryCheckResultMapper;
    @Override
    public List<AaListParamsCheckResult> selectAaListParamsCheckResultList(AaListParamsCheckResult aaListParamsCheckResult) {
        List<AaListParamsCheckResult> list = null;
        try {
            list = aaListParamsHistoryCheckResultMapper.selectAaListParamsCheckResultList(aaListParamsCheckResult);
        } catch (Exception e) {
            log.error("查询数据库发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("查询数据库发生异常，请联系管理员！");
        }
        return list;
    }
}
