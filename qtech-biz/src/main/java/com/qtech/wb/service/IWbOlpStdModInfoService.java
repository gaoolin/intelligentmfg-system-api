package com.qtech.wb.service;

import com.qtech.wb.domain.WbOlpStdModInfo;
import com.qtech.wb.domain.WbOlpTrendingVo;

import java.util.List;

/**
 * 智慧打线图Service接口
 *
 * @author gaozhilin
 * @date 2023-09-05
 */
public interface IWbOlpStdModInfoService {
    /**
     * 查询智慧打线图
     *
     * @param sid 智慧打线图主键
     * @return 智慧打线图
     */
    public WbOlpStdModInfo selectWbOlpStdModInfoBySid(Long sid);

    /**
     * 查询智慧打线图列表
     *
     * @param wbOlpStdModInfo 智慧打线图
     * @return 智慧打线图集合
     */
    public List<WbOlpStdModInfo> selectWbOlpStdModInfoList(WbOlpStdModInfo wbOlpStdModInfo);

    /**
     * 新增智慧打线图
     *
     * @param wbOlpStdModInfo 智慧打线图
     * @return 结果
     */
    public int insertWbOlpStdModInfo(WbOlpStdModInfo wbOlpStdModInfo);

    /**
     * 修改智慧打线图
     *
     * @param wbOlpStdModInfo 智慧打线图
     * @return 结果
     */
    public int updateWbOlpStdModInfo(WbOlpStdModInfo wbOlpStdModInfo);

    /**
     * 批量删除智慧打线图
     *
     * @param sids 需要删除的智慧打线图主键集合
     * @return 结果
     */
    public int deleteWbOlpStdModInfoBySids(Long[] sids);

    /**
     * 删除智慧打线图信息
     *
     * @param sid 智慧打线图主键
     * @return 结果
     */
    public int deleteWbOlpStdModInfoBySid(Long sid);

    Integer getModelsTtlCnt();

    Integer getModelAvgCnt();

    List<WbOlpTrendingVo> getWbOlpTrending();
}
