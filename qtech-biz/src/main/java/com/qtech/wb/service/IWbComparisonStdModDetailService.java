package com.qtech.wb.service;

import java.util.List;
import java.util.Map;

import com.qtech.wb.domain.WbComparisonStdModDetail;

/**
 * 标准模版明细Service接口
 *
 * @author gaozhilin
 * @date 2023-09-06
 */
public interface IWbComparisonStdModDetailService
{
    /**
     * 查询标准模版明细
     *
     * @param id 标准模版明细主键
     * @return 标准模版明细
     */
    public WbComparisonStdModDetail selectWbComparisonStdModDetailById(Long id);

    /**
     * 查询标准模版明细列表
     *
     * @param wbComparisonStdModDetail 标准模版明细
     * @return 标准模版明细集合
     */
    public List<WbComparisonStdModDetail> selectWbComparisonStdModDetailList(WbComparisonStdModDetail wbComparisonStdModDetail);

    /**
     * 新增标准模版明细
     *
     * @param wbComparisonStdModDetail 标准模版明细
     * @return 结果
     */
    public int insertWbComparisonStdModDetail(WbComparisonStdModDetail wbComparisonStdModDetail);

    /**
     * 修改标准模版明细
     *
     * @param wbComparisonStdModDetail 标准模版明细
     * @return 结果
     */
    public int updateWbComparisonStdModDetail(WbComparisonStdModDetail wbComparisonStdModDetail);

    /**
     * 批量删除标准模版明细
     *
     * @param ids 需要删除的标准模版明细主键集合
     * @return 结果
     */
    public int deleteWbComparisonStdModDetailByIds(Long[] ids);

    /**
     * 删除标准模版明细信息
     *
     * @param id 标准模版明细主键
     * @return 结果
     */
    public int deleteWbComparisonStdModDetailById(Long id);

    Map<String, String> uploadWbComparisonStdModDetail(List<WbComparisonStdModDetail> WbComparisonStdModDetail);

    Boolean isExistMcId(String mcId);
}
