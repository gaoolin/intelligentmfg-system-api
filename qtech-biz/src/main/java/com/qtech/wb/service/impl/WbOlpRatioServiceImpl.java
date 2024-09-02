package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbOlpPercentageVo;
import com.qtech.wb.mapper.WbOlpRatioMapper;
import com.qtech.wb.service.IWbOlpRatioService;
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
public class WbOlpRatioServiceImpl implements IWbOlpRatioService {

    @Autowired
    private WbOlpRatioMapper wbOlpRatioMapper;
    @Override
    public List<WbOlpPercentageVo> getRatio(WbOlpPercentageVo wbOlpPercentageVo) {

        try {
            return wbOlpRatioMapper.selectWbOlpRatioList(wbOlpPercentageVo);
        } catch (Exception e) {
            log.error("getRatio error", e);
            throw new RuntimeException(e);
        }
    }
}
