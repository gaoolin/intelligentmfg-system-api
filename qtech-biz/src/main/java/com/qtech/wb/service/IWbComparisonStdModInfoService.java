package com.qtech.wb.service;

import com.qtech.wb.domain.WbComparisonStdModInfo;
import com.qtech.wb.domain.WbComparisonTrendingVo;

import java.util.List;

/**
 * 智慧打线图Service接口
 *
 * @author gaozhilin
 * @date 2023-09-05
 */
public interface IWbComparisonStdModInfoService {
    /**
     * 查询智慧打线图
     *
     * @param sid 智慧打线图主键
     * @return 智慧打线图
     */
    public WbComparisonStdModInfo selectWbComparisonStdModInfoBySid(Long sid);

    /**
     * 查询智慧打线图列表
     *
     * @param wbComparisonStdModInfo 智慧打线图
     * @return 智慧打线图集合
     */
    public List<WbComparisonStdModInfo> selectWbComparisonStdModInfoList(WbComparisonStdModInfo wbComparisonStdModInfo);

    /**
     * 新增智慧打线图
     *
     * @param wbComparisonStdModInfo 智慧打线图
     * @return 结果
     */
    public int insertWbComparisonStdModInfo(WbComparisonStdModInfo wbComparisonStdModInfo);

    /**
     * 修改智慧打线图
     *
     * @param wbComparisonStdModInfo 智慧打线图
     * @return 结果
     */
    public int updateWbComparisonStdModInfo(WbComparisonStdModInfo wbComparisonStdModInfo);

    /**
     * 批量删除智慧打线图
     *
     * @param sids 需要删除的智慧打线图主键集合
     * @return 结果
     */
    public int deleteWbComparisonStdModInfoBySids(Long[] sids);

    /**
     * 删除智慧打线图信息
     *
     * @param sid 智慧打线图主键
     * @return 结果
     */
    public int deleteWbComparisonStdModInfoBySid(Long sid);

    Integer getModelsTtlCnt();

    Integer getModelAvgCnt();

    List<WbComparisonTrendingVo> getWbComparisonTrending();
}
