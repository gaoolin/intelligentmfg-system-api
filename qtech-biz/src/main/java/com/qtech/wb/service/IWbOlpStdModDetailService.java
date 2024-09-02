package com.qtech.wb.service;

import java.util.List;
import java.util.Map;

import com.qtech.wb.domain.WbOlpStdModDetail;

/**
 * 标准模版明细Service接口
 *
 * @author gaozhilin
 * @date 2023-09-06
 */
public interface IWbOlpStdModDetailService
{
    /**
     * 查询标准模版明细
     *
     * @param id 标准模版明细主键
     * @return 标准模版明细
     */
    public WbOlpStdModDetail selectWbOlpStdModDetailById(Long id);

    /**
     * 查询标准模版明细列表
     *
     * @param wbOlpStdModDetail 标准模版明细
     * @return 标准模版明细集合
     */
    public List<WbOlpStdModDetail> selectWbOlpStdModDetailList(WbOlpStdModDetail wbOlpStdModDetail);

    /**
     * 新增标准模版明细
     *
     * @param wbOlpStdModDetail 标准模版明细
     * @return 结果
     */
    public int insertWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail);

    /**
     * 修改标准模版明细
     *
     * @param wbOlpStdModDetail 标准模版明细
     * @return 结果
     */
    public int updateWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail);

    /**
     * 批量删除标准模版明细
     *
     * @param ids 需要删除的标准模版明细主键集合
     * @return 结果
     */
    public int deleteWbOlpStdModDetailByIds(Long[] ids);

    /**
     * 删除标准模版明细信息
     *
     * @param id 标准模版明细主键
     * @return 结果
     */
    public int deleteWbOlpStdModDetailById(Long id);

    Map<String, String> uploadWbOlpStdModDetail(List<WbOlpStdModDetail> WbOlpStdModDetail);

    Boolean isExistMcId(String mcId);
}
