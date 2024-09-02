package com.qtech.wb.service.impl;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.wb.domain.WbOlpIndexVo;
import com.qtech.wb.domain.WbOlpOverview;
import com.qtech.wb.mapper.WbOlpIndexMapper;
import com.qtech.wb.service.IWbOlpIndexService;
import com.qtech.wb.vo.WbOlpChkVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/09/01 12:14:59
 * desc   :
 */
@DataSource(DataSourceType.SLAVE)
@Slf4j
@Service
public class WbOlpIndexServiceImpl implements IWbOlpIndexService {

    @Autowired
    private WbOlpIndexMapper wbOlpIndexMapper;
    @Override
    public List<WbOlpChkVo> selectFactoryNameList() {
        try {
            return wbOlpIndexMapper.selectFactoryNameList();
        } catch (Exception e) {
            log.error("查询wbOlpOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public List<WbOlpChkVo> selectWorkShopNameList(WbOlpChkVo wbOlpChkVo) {
        try {
            return wbOlpIndexMapper.selectWorkShopNameList(wbOlpChkVo);
        } catch (Exception e) {
            log.error("查询wbOlpOverviewList异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }
}
