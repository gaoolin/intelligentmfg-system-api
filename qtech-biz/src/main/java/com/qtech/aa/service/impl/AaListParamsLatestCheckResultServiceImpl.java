package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsCheckResult;
import com.qtech.aa.mapper.AaListParamsLatestCheckResultMapper;
import com.qtech.aa.service.IAaListParamsLatestCheckResultService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 09:38:15
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class AaListParamsLatestCheckResultServiceImpl implements IAaListParamsLatestCheckResultService {

    @Autowired
    private AaListParamsLatestCheckResultMapper aaListParamsLatestCheckResultMapper;

    @Override
    public List<AaListParamsCheckResult> selectAaListParamsLatestCheckResultList(AaListParamsCheckResult aaListParamsCheckResult) {
        List<AaListParamsCheckResult> list = null;
        try {
            list = aaListParamsLatestCheckResultMapper.selectAaListParamsLatestCheckResultList(aaListParamsCheckResult);
        } catch (Exception e) {
            log.error("查询数据库发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("查询数据库发生异常，请联系管理员！");
        }
        return list;
    }

    @Override
    public List<AaListParamsCheckResult> selectGroupNameList(AaListParamsCheckResult aaListParamsCheckResult) {
        List<AaListParamsCheckResult> list = null;
        try {
            list = aaListParamsLatestCheckResultMapper.selectGroupNameList(aaListParamsCheckResult);
        } catch (Exception e) {
            log.error("查询数据库发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("查询数据库发生异常，请联系管理员！");
        }
        return list;
    }

    @Override
    public List<AaListParamsCheckResult> selectFactoryNameList() {
        List<AaListParamsCheckResult> list = null;
        try {
            list = aaListParamsLatestCheckResultMapper.selectFactoryNames();
        } catch (Exception e) {
            log.error("查询数据库发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("查询数据库发生异常，请联系管理员！");
        }
        return list;
    }
}
