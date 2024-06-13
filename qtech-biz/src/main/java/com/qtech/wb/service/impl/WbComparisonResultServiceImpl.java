package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbComparisonResultVo;
import com.qtech.wb.mapper.WbComparisonResultMapper;
import com.qtech.wb.service.IWbComparisonResultService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:33:06
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SIXTH)
@Service
public class WbComparisonResultServiceImpl implements IWbComparisonResultService {

    @Autowired
    WbComparisonResultMapper wbComparisonResultMapper;

    @Override
    public List<WbComparisonResultVo> selectWbComparisonResultList(WbComparisonResultVo wbComparisonResultVo) {
        try {
            return wbComparisonResultMapper.selectWbComparisonResultList(wbComparisonResultVo);
        } catch (Exception e) {
            log.error("selectWbComparisonResultList error", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }
}
