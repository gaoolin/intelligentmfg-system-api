package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbComparisonStdModDetail;
import com.qtech.wb.domain.WbComparisonStdModInfo;
import com.qtech.wb.mapper.WbComparisonStdModDetailMapper;
import com.qtech.wb.mapper.WbComparisonStdModInfoMapper;
import com.qtech.wb.service.IWbComparisonStdModDetailService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.common.exception.biz.WbOlpCheckUploadException;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.common.utils.StringUtils;
import com.qtech.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标准模版明细Service业务层处理
 *
 * @author gaozhilin
 * @date 2023-09-06
 */

@Slf4j
@DataSource(value = DataSourceType.SIXTH)
@Service
public class WbComparisonStdModDetailServiceImpl implements IWbComparisonStdModDetailService {

    private final WbComparisonStdModInfo wbComparisonStdModInfo = new WbComparisonStdModInfo();

    @Autowired
    private WbComparisonStdModDetailMapper wbComparisonStdModDetailMapper;

    @Autowired
    private WbComparisonStdModInfoMapper wbComparisonStdModInfoMapper;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询标准模版明细
     *
     * @param id 标准模版明细主键
     * @return 标准模版明细
     */
    @Override
    public WbComparisonStdModDetail selectWbComparisonStdModDetailById(Long id) {
        try {
            return wbComparisonStdModDetailMapper.selectWbComparisonStdModDetailById(id);
        } catch (Exception e) {
            log.error("查询标准模版明细异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 查询标准模版明细列表
     *
     * @param wbComparisonStdModDetail 标准模版明细
     * @return 标准模版明细
     */
    @Override
    public List<WbComparisonStdModDetail> selectWbComparisonStdModDetailList(WbComparisonStdModDetail wbComparisonStdModDetail) {
        try {
            return wbComparisonStdModDetailMapper.selectWbComparisonStdModDetailList(wbComparisonStdModDetail);
        } catch (Exception e) {
            log.error("查询标准模版明细列表异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 新增标准模版明细
     *
     * @param wbComparisonStdModDetail 标准模版明细
     * @return 结果
     */
    @Override
    public int insertWbComparisonStdModDetail(WbComparisonStdModDetail wbComparisonStdModDetail) {
        wbComparisonStdModDetail.setCreateTime(DateUtils.getNowDate());
        try {
            return wbComparisonStdModDetailMapper.insertWbComparisonStdModDetail(wbComparisonStdModDetail);
        } catch (Exception e) {
            log.error("查询数据库失败，请联系系统负责人!");
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 修改标准模版明细
     *
     * @param wbComparisonStdModDetail 标准模版明细
     * @return 结果
     */
    @Override
    public int updateWbComparisonStdModDetail(WbComparisonStdModDetail wbComparisonStdModDetail) {
        wbComparisonStdModDetail.setUpdateTime(DateUtils.getNowDate());
        try {
            return wbComparisonStdModDetailMapper.updateWbComparisonStdModDetail(wbComparisonStdModDetail);
        } catch (Exception e) {
            log.error("修改标准模版明细异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 批量删除标准模版明细
     *
     * @param ids 需要删除的标准模版明细主键
     * @return 结果
     */
    @Override
    public int deleteWbComparisonStdModDetailByIds(Long[] ids) {
        try {
            return wbComparisonStdModDetailMapper.deleteWbComparisonStdModDetailByIds(ids);
        } catch (Exception e) {
            log.error("批量删除标准模版明细异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 删除标准模版明细信息
     *
     * @param id 标准模版明细主键
     * @return 结果
     */
    @Override
    public int deleteWbComparisonStdModDetailById(Long id) {
        try {
            return wbComparisonStdModDetailMapper.deleteWbComparisonStdModDetailById(id);
        } catch (Exception e) {
            log.error("删除标准模版明细信息异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Map<String, String> uploadWbComparisonStdModDetail(List<WbComparisonStdModDetail> wbComparisonStdModDetails) {

        Map<String, Integer> modStat = new HashMap<>();
        Map<String, String> resultMap = new HashMap<>();
        ArrayList<WbComparisonStdModDetail> oneMcIdList = new ArrayList<>();
        ArrayList<String> existMcIdList = new ArrayList<>();

        int insert = 0;
        int exist = 0;

        if (StringUtils.isNull(wbComparisonStdModDetails) || wbComparisonStdModDetails.size() == 0) {
            throw new WbOlpCheckUploadException();
        }

        for (WbComparisonStdModDetail wbComparisonStdModDetail : wbComparisonStdModDetails) {
            modStat.merge(wbComparisonStdModDetail.getMcId(), 1, Integer::sum);
        }

        for (String key : modStat.keySet()) {

            for (WbComparisonStdModDetail wbComparisonStdModDetail : wbComparisonStdModDetails) {
                if (key.equals(wbComparisonStdModDetail.getMcId())) {
                    oneMcIdList.add(wbComparisonStdModDetail);
                }
            }

            Boolean isExist = isExistMcId(key);
            if (isExist) {
                existMcIdList.add(key);
                oneMcIdList.clear();
                exist = exist + 1;
                break;
            } else {
                String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();

                wbComparisonStdModInfo.setMcId(key);
                wbComparisonStdModInfo.setLineCount(modStat.get(key));
                wbComparisonStdModInfo.setStatus(1);
                wbComparisonStdModInfo.setCreateTime(DateUtils.getNowDate());
                wbComparisonStdModInfo.setCreateBy(nickName);

                wbComparisonStdModInfoMapper.insertWbComparisonStdModInfo(wbComparisonStdModInfo);

                for (WbComparisonStdModDetail oneMcId : oneMcIdList) {
                    try {
                        wbComparisonStdModDetailMapper.insertWbComparisonStdModDetail(oneMcId);
                    } catch (Exception e) {
                        log.error("插入标准模版明细异常", e);
                        throw new RuntimeException("插入标准模版明细异常，请联系系统负责人!");
                    }
                }

                oneMcIdList.clear();

                wbComparisonStdModInfo.setSid(null);
                wbComparisonStdModInfo.setMcId(null);
                wbComparisonStdModInfo.setLineCount(null);
                wbComparisonStdModInfo.setStatus(null);
                wbComparisonStdModInfo.setProvider(null);
                wbComparisonStdModInfo.setFactory(null);
                wbComparisonStdModInfo.setRemark(null);
                wbComparisonStdModInfo.setCreateBy(null);
                wbComparisonStdModInfo.setCreateTime(null);
            }
            insert = insert + 1;
        }

        if (existMcIdList.size() == 0) {
            resultMap.put("flag","1");
            resultMap.put("result", "共 " + (insert + exist) + " 个机型，已导入 " + insert + " 个机型。");
        } else {
            resultMap.put("flag", "0");
            resultMap.put("result", "共 " + (insert + exist) + " 个机型，已导入 " + insert + " 个机型，未导入 " + exist +
                    " 个机型。以下机型模板已存在，请检查！\n" + existMcIdList.toString());
        }

        return  resultMap;
    }

    @Override
    public Boolean isExistMcId(String mcId) {
        int count = wbComparisonStdModDetailMapper.countWbComparisonStdModDetailByMcId(mcId);
        return count != 0;
    }
}
