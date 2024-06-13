package com.qtech.wb.service.impl;

import com.qtech.wb.domain.EmsEqInfo;
import com.qtech.wb.mapper.EmsEqInfoMapper;
import com.qtech.wb.service.IEmsEqInfoService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 17:01:14
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class EmsEqInfoServiceImpl implements IEmsEqInfoService {

    @Autowired
    EmsEqInfoMapper emsEqInfoMapper;

    @Override
    public List<EmsEqInfo> selectEmsEqInfoList(EmsEqInfo emsEqInfo) {
        try {
            return emsEqInfoMapper.selectEmsEqInfoList(emsEqInfo);
        } catch (Exception e) {
            log.error("查询emsEqInfo异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人！");
        }
    }
}
