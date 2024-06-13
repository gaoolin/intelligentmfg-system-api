package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbComparisonStdModInfo;
import com.qtech.wb.domain.WbComparisonTrendingVo;
import com.qtech.wb.mapper.WbComparisonStdModInfoMapper;
import com.qtech.wb.service.IWbComparisonStdModInfoService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.framework.datasource.DynamicDataSourceContextHolder;
import com.qtech.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 智慧打线图Service业务层处理
 *
 * @author gaozhilin
 * @date 2023-09-05
 */

@Slf4j
@DataSource(value = DataSourceType.SIXTH)
@Service
public class WbComparisonStdModInfoServiceImpl implements IWbComparisonStdModInfoService
{
    @Autowired
    private WbComparisonStdModInfoMapper wbComparisonStdModInfoMapper;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询智慧打线图
     *
     * @param sid 智慧打线图主键
     * @return 智慧打线图
     */
    @Override
    public WbComparisonStdModInfo selectWbComparisonStdModInfoBySid(Long sid)
    {
        try {
            return wbComparisonStdModInfoMapper.selectWbComparisonStdModInfoBySid(sid);
        } catch (Exception e) {
            log.error("查询智慧打线图失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 查询智慧打线图列表
     *
     * @param wbComparisonStdModInfo 智慧打线图
     * @return 智慧打线图
     */
    @Override
    public List<WbComparisonStdModInfo> selectWbComparisonStdModInfoList(WbComparisonStdModInfo wbComparisonStdModInfo)
    {
        try {
            return wbComparisonStdModInfoMapper.selectWbComparisonStdModInfoList(wbComparisonStdModInfo);
        } catch (Exception e) {
            log.error("查询智慧打线图列表失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 新增智慧打线图
     *
     * @param wbComparisonStdModInfo 智慧打线图
     * @return 结果
     */
    @Override
    public int insertWbComparisonStdModInfo(WbComparisonStdModInfo wbComparisonStdModInfo)
    {
        try {
            String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SIXTH.name());
            wbComparisonStdModInfo.setCreateBy(nickName);
            wbComparisonStdModInfo.setCreateTime(DateUtils.getNowDate());
            return wbComparisonStdModInfoMapper.insertWbComparisonStdModInfo(wbComparisonStdModInfo);
        } catch (Exception e) {
            log.error("新增智慧打线图失败", e);
            throw new RuntimeException("新增智慧打线图失败，请联系系统负责人!");
        }
    }

    /**
     * 修改智慧打线图
     *
     * @param wbComparisonStdModInfo 智慧打线图
     * @return 结果
     */
    @Override
    public int updateWbComparisonStdModInfo(WbComparisonStdModInfo wbComparisonStdModInfo)
    {
        try {
            String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SIXTH.name());
            wbComparisonStdModInfo.setUpdateBy(nickName);
            wbComparisonStdModInfo.setUpdateTime(DateUtils.getNowDate());
            return wbComparisonStdModInfoMapper.updateWbComparisonStdModInfo(wbComparisonStdModInfo);
        } catch (Exception e) {
            log.error("修改智慧打线图失败", e);
            throw new RuntimeException("修改智慧打线图失败，请联系系统负责人!");
        }
    }

    /**
     * 批量删除智慧打线图
     *
     * @param sids 需要删除的智慧打线图主键
     * @return 结果
     */
    @Override
    public int deleteWbComparisonStdModInfoBySids(Long[] sids)
    {
        try {
            return wbComparisonStdModInfoMapper.deleteWbComparisonStdModInfoBySids(sids);
        } catch (Exception e) {
            log.error("批量删除智慧打线图失败", e);
            throw new RuntimeException("批量删除智慧打线图失败，请联系系统负责人!");
        }
    }

    /**
     * 删除智慧打线图信息
     *
     * @param sid 智慧打线图主键
     * @return 结果
     */
    @Override
    public int deleteWbComparisonStdModInfoBySid(Long sid)
    {
        try {
            return wbComparisonStdModInfoMapper.deleteWbComparisonStdModInfoBySid(sid);
        } catch (Exception e) {
            log.error("删除智慧打线图信息失败", e);
            throw new RuntimeException("删除智慧打线图信息失败，请联系系统负责人!");
        }
    }

    @Override
    public Integer getModelsTtlCnt() {
        try {
            return wbComparisonStdModInfoMapper.getModelsTtlCnt();
        } catch (Exception e) {
            log.error("查询智慧打线图比对总数", e);
            throw new RuntimeException("查询智慧打线图比对总数，请联系系统负责人!");
        }
    }

    @Override
    public Integer getModelAvgCnt() {
        try {
            return wbComparisonStdModInfoMapper.getModelAvgCnt();
        } catch (Exception e) {
            log.error("查询智慧打线图平均线数", e);
            throw new RuntimeException("查询智慧打线图平均线数，请联系系统负责人!");
        }
    }

    @DataSource(DataSourceType.FIFTH)
    @Override
    public List<WbComparisonTrendingVo> getWbComparisonTrending() {
        try {
            return wbComparisonStdModInfoMapper.getWbComparisonTrending();
        } catch (Exception e) {
            log.error("查询智慧打线图趋势图", e);
            throw new RuntimeException("查询智慧打线图趋势图，请联系系统负责人!");
        }
    }
}
