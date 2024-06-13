package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbComparisonPercentageVo;
import com.qtech.wb.mapper.WbComparisonRatioMapper;
import com.qtech.wb.service.IWbComparisonRatioService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 08:35:02
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class WbComparisonRatioServiceImpl implements IWbComparisonRatioService {

    @Autowired
    private WbComparisonRatioMapper wbComparisonRatioMapper;
    @Override
    public List<WbComparisonPercentageVo> getRatio(WbComparisonPercentageVo wbComparisonPercentageVo) {

        try {
            return wbComparisonRatioMapper.selectWbComparisonRatioList(wbComparisonPercentageVo);
        } catch (Exception e) {
            log.error("getRatio error", e);
            throw new RuntimeException(e);
        }
    }
}
