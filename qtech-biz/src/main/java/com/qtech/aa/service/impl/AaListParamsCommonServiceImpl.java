package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsCommon;
import com.qtech.aa.mapper.AaListParamsCommonMapper;
import com.qtech.aa.service.IAaListParamsCommonService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/11 09:16:15
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class AaListParamsCommonServiceImpl implements IAaListParamsCommonService {

    @Autowired
    private AaListParamsCommonMapper aaListParamsCommonMapper;
    @Override
    public List<AaListParamsCommon> getFactoryName() {
        try {
            return aaListParamsCommonMapper.getFactoryName();
        } catch (Exception e) {
            log.error("getFactoryName error", e);
            throw new RuntimeException("获取厂区名称出错，请联系管理员！");
        }
    }

    @Override
    public List<AaListParamsCommon> getWorkshopName(AaListParamsCommon aaListParamsCommon) {
        try {
            return aaListParamsCommonMapper.getWorkshopName(aaListParamsCommon);
        } catch (Exception e) {
            log.error("getWorkshopName error", e);
            throw new RuntimeException("获取车间名称出错，请联系管理员！");
        }
    }
}
