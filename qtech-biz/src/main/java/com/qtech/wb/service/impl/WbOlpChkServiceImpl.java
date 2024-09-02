package com.qtech.wb.service.impl;

import com.qtech.wb.vo.WbOlpChkVo;
import com.qtech.wb.mapper.WbOlpChkMapper;
import com.qtech.wb.service.IWbOlpChkService;
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
@DataSource(DataSourceType.SLAVE)
@Service
public class WbOlpChkServiceImpl implements IWbOlpChkService {

    @Autowired
    private WbOlpChkMapper wbOlpChkMapper;

    @Override
    public List<WbOlpChkVo> selectWbOlpChkList(WbOlpChkVo vo, int daysFilter) {
        try {
            return wbOlpChkMapper.selectWbOlpChkList(vo, daysFilter);
        } catch (Exception e) {
            log.error("selectWbOlpChkList error", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }
}
