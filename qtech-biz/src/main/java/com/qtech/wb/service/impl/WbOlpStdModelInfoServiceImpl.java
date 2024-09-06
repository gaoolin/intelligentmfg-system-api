package com.qtech.wb.service.impl;

import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.wb.domain.WbOlpStdModInfo;
import com.qtech.wb.domain.WbOlpTrendingVo;
import com.qtech.wb.mapper.WbOlpStdModelInfoMapper;
import com.qtech.wb.service.IWbOlpStdModelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/09/05 15:31:20
 * desc   :
 */

@DataSource(DataSourceType.SIXTH)
@Service
public class WbOlpStdModelInfoServiceImpl implements IWbOlpStdModelInfoService {
    @Autowired
    private WbOlpStdModelInfoMapper wbOlpStdModelInfoMapper;

    @Override
    public WbOlpStdModInfo selectWbOlpStdModInfoBySid(Long sid) {
        try {
            return wbOlpStdModelInfoMapper.selectWbOlpStdModInfoBySid(sid);
        } catch (Exception e) {
            throw new RuntimeException("查询数据库发生异常，请联系系统负责人。");
        }
    }

    @Override
    public List<WbOlpStdModInfo> selectWbOlpStdModInfoList(WbOlpStdModInfo wbOlpStdModInfo) {
        try {
            return wbOlpStdModelInfoMapper.selectWbOlpStdModInfoList(wbOlpStdModInfo);
        } catch (Exception e) {
            throw new RuntimeException("查询数据库发生异常，请联系系统负责人。");
        }
    }

    @Override
    public int insertWbOlpStdModInfo(WbOlpStdModInfo wbOlpStdModInfo) {

        try {
            return wbOlpStdModelInfoMapper.insertWbOlpStdModInfo(wbOlpStdModInfo);
        } catch (Exception e) {
            throw new RuntimeException("新增智慧打线图失败，请联系系统负责人!");
        }
    }

    @Override
    public int updateWbOlpStdModInfo(WbOlpStdModInfo wbOlpStdModInfo) {
        try {
            return wbOlpStdModelInfoMapper.updateWbOlpStdModInfo(wbOlpStdModInfo);
        } catch (Exception e) {
            throw new RuntimeException("修改智慧打线图失败，请联系系统负责人!");
        }
    }

    @Override
    public int deleteWbOlpStdModInfoBySid(Long sid) {
        try {
            return wbOlpStdModelInfoMapper.deleteWbOlpStdModInfoBySid(sid);
        } catch (Exception e) {
            throw new RuntimeException("删除智慧打线图信息失败，请联系系统负责人!");
        }
    }

    @Override
    public int deleteWbOlpStdModInfoBySids(Long[] sids) {
        try {
            return wbOlpStdModelInfoMapper.deleteWbOlpStdModInfoBySids(sids);
        } catch (Exception e) {
            throw new RuntimeException("批量删除智慧打线图失败，请联系系统负责人!");
        }
    }

    @Override
    public long getModelAvgCnt() {
        try {
            return wbOlpStdModelInfoMapper.getModelAvgCnt();
        } catch (Exception e) {
            throw new RuntimeException("查询智慧打线图平均线数，请联系系统负责人!");
        }
    }

    @Override
    public long getModelsTtlCnt() {
        try {
            return wbOlpStdModelInfoMapper.getModelsTtlCnt();
        } catch (Exception e) {
            throw new RuntimeException("查询智慧打线图比对总数，请联系系统负责人!");
        }
    }

    @DataSource(DataSourceType.SLAVE)
    @Override
    public List<WbOlpTrendingVo> getWbOlpTrending() {
        try {
            return wbOlpStdModelInfoMapper.getWbOlpTrending();
        } catch (Exception e) {
            throw new RuntimeException("查询智慧打线图趋势图，请联系系统负责人!");
        }
    }
}
