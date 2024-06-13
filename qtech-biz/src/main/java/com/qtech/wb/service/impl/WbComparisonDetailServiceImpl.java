package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbComparisonParticularsVo;
import com.qtech.wb.mapper.WbComparisonDetailMapper;
import com.qtech.wb.service.IWbComparisonDetailService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 14:27:05
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class WbComparisonDetailServiceImpl implements IWbComparisonDetailService {

    @Autowired
    private WbComparisonDetailMapper wbComparisonDetailMapper;
    @Override
    public List<WbComparisonParticularsVo> getDetail(WbComparisonParticularsVo wbComparisonParticularsVo) {
        try {
            return wbComparisonDetailMapper.getDetail(wbComparisonParticularsVo);
        } catch (Exception e) {
            log.error("查询wbComparisonParticularsVo异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人！");
        }
    }
}
