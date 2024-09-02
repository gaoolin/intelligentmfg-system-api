package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbOlpStdModInfo;
import com.qtech.wb.domain.WbOlpTrendingVo;
import com.qtech.wb.mapper.WbOlpStdModInfoMapper;
import com.qtech.wb.service.IWbOlpStdModInfoService;
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
public class WbOlpStdModInfoServiceImpl implements IWbOlpStdModInfoService
{
    @Autowired
    private WbOlpStdModInfoMapper wbOlpStdModInfoMapper;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询智慧打线图
     *
     * @param sid 智慧打线图主键
     * @return 智慧打线图
     */
    @Override
    public WbOlpStdModInfo selectWbOlpStdModInfoBySid(Long sid)
    {
        try {
            return wbOlpStdModInfoMapper.selectWbOlpStdModInfoBySid(sid);
        } catch (Exception e) {
            log.error("查询智慧打线图失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 查询智慧打线图列表
     *
     * @param wbOlpStdModInfo 智慧打线图
     * @return 智慧打线图
     */
    @Override
    public List<WbOlpStdModInfo> selectWbOlpStdModInfoList(WbOlpStdModInfo wbOlpStdModInfo)
    {
        try {
            return wbOlpStdModInfoMapper.selectWbOlpStdModInfoList(wbOlpStdModInfo);
        } catch (Exception e) {
            log.error("查询智慧打线图列表失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 新增智慧打线图
     *
     * @param wbOlpStdModInfo 智慧打线图
     * @return 结果
     */
    @Override
    public int insertWbOlpStdModInfo(WbOlpStdModInfo wbOlpStdModInfo)
    {
        try {
            String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SIXTH.name());
            wbOlpStdModInfo.setCreateBy(nickName);
            wbOlpStdModInfo.setCreateTime(DateUtils.getNowDate());
            return wbOlpStdModInfoMapper.insertWbOlpStdModInfo(wbOlpStdModInfo);
        } catch (Exception e) {
            log.error("新增智慧打线图失败", e);
            throw new RuntimeException("新增智慧打线图失败，请联系系统负责人!");
        }
    }

    /**
     * 修改智慧打线图
     *
     * @param wbOlpStdModInfo 智慧打线图
     * @return 结果
     */
    @Override
    public int updateWbOlpStdModInfo(WbOlpStdModInfo wbOlpStdModInfo)
    {
        try {
            String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
            DynamicDataSourceContextHolder.setDataSourceType(DataSourceType.SIXTH.name());
            wbOlpStdModInfo.setUpdateBy(nickName);
            wbOlpStdModInfo.setUpdateTime(DateUtils.getNowDate());
            return wbOlpStdModInfoMapper.updateWbOlpStdModInfo(wbOlpStdModInfo);
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
    public int deleteWbOlpStdModInfoBySids(Long[] sids)
    {
        try {
            return wbOlpStdModInfoMapper.deleteWbOlpStdModInfoBySids(sids);
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
    public int deleteWbOlpStdModInfoBySid(Long sid)
    {
        try {
            return wbOlpStdModInfoMapper.deleteWbOlpStdModInfoBySid(sid);
        } catch (Exception e) {
            log.error("删除智慧打线图信息失败", e);
            throw new RuntimeException("删除智慧打线图信息失败，请联系系统负责人!");
        }
    }

    @Override
    public Integer getModelsTtlCnt() {
        try {
            return wbOlpStdModInfoMapper.getModelsTtlCnt();
        } catch (Exception e) {
            log.error("查询智慧打线图比对总数", e);
            throw new RuntimeException("查询智慧打线图比对总数，请联系系统负责人!");
        }
    }

    @Override
    public Integer getModelAvgCnt() {
        try {
            return wbOlpStdModInfoMapper.getModelAvgCnt();
        } catch (Exception e) {
            log.error("查询智慧打线图平均线数", e);
            throw new RuntimeException("查询智慧打线图平均线数，请联系系统负责人!");
        }
    }

    @DataSource(DataSourceType.SLAVE)
    @Override
    public List<WbOlpTrendingVo> getWbOlpTrending() {
        try {
            return wbOlpStdModInfoMapper.getWbOlpTrending();
        } catch (Exception e) {
            log.error("查询智慧打线图趋势图", e);
            throw new RuntimeException("查询智慧打线图趋势图，请联系系统负责人!");
        }
    }
}
