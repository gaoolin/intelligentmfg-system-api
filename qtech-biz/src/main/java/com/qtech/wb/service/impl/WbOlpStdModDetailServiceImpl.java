package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbOlpStdModDetail;
import com.qtech.wb.domain.WbOlpStdModInfo;
import com.qtech.wb.mapper.WbOlpStdModDetailMapper;
import com.qtech.wb.mapper.WbOlpStdModInfoMapper;
import com.qtech.wb.service.IWbOlpStdModDetailService;
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
public class WbOlpStdModDetailServiceImpl implements IWbOlpStdModDetailService {

    private final WbOlpStdModInfo wbOlpStdModInfo = new WbOlpStdModInfo();

    @Autowired
    private WbOlpStdModDetailMapper wbOlpStdModDetailMapper;

    @Autowired
    private WbOlpStdModInfoMapper wbOlpStdModInfoMapper;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询标准模版明细
     *
     * @param id 标准模版明细主键
     * @return 标准模版明细
     */
    @Override
    public WbOlpStdModDetail selectWbOlpStdModDetailById(Long id) {
        try {
            return wbOlpStdModDetailMapper.selectWbOlpStdModDetailById(id);
        } catch (Exception e) {
            log.error("查询标准模版明细异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 查询标准模版明细列表
     *
     * @param wbOlpStdModDetail 标准模版明细
     * @return 标准模版明细
     */
    @Override
    public List<WbOlpStdModDetail> selectWbOlpStdModDetailList(WbOlpStdModDetail wbOlpStdModDetail) {
        try {
            return wbOlpStdModDetailMapper.selectWbOlpStdModDetailList(wbOlpStdModDetail);
        } catch (Exception e) {
            log.error("查询标准模版明细列表异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 新增标准模版明细
     *
     * @param wbOlpStdModDetail 标准模版明细
     * @return 结果
     */
    @Override
    public int insertWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail) {
        wbOlpStdModDetail.setCreateTime(DateUtils.getNowDate());
        try {
            return wbOlpStdModDetailMapper.insertWbOlpStdModDetail(wbOlpStdModDetail);
        } catch (Exception e) {
            log.error("查询数据库失败，请联系系统负责人!");
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    /**
     * 修改标准模版明细
     *
     * @param wbOlpStdModDetail 标准模版明细
     * @return 结果
     */
    @Override
    public int updateWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail) {
        wbOlpStdModDetail.setUpdateTime(DateUtils.getNowDate());
        try {
            return wbOlpStdModDetailMapper.updateWbOlpStdModDetail(wbOlpStdModDetail);
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
    public int deleteWbOlpStdModDetailByIds(Long[] ids) {
        try {
            return wbOlpStdModDetailMapper.deleteWbOlpStdModDetailByIds(ids);
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
    public int deleteWbOlpStdModDetailById(Long id) {
        try {
            return wbOlpStdModDetailMapper.deleteWbOlpStdModDetailById(id);
        } catch (Exception e) {
            log.error("删除标准模版明细信息异常", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Map<String, String> uploadWbOlpStdModDetail(List<WbOlpStdModDetail> wbOlpStdModDetails) {

        Map<String, Integer> modStat = new HashMap<>();
        Map<String, String> resultMap = new HashMap<>();
        ArrayList<WbOlpStdModDetail> oneMcIdList = new ArrayList<>();
        ArrayList<String> existMcIdList = new ArrayList<>();

        int insert = 0;
        int exist = 0;

        if (StringUtils.isNull(wbOlpStdModDetails) || wbOlpStdModDetails.isEmpty()) {
            throw new WbOlpCheckUploadException();
        }

        for (WbOlpStdModDetail wbOlpStdModDetail : wbOlpStdModDetails) {
            modStat.merge(wbOlpStdModDetail.getMcId(), 1, Integer::sum);
        }

        for (String key : modStat.keySet()) {

            for (WbOlpStdModDetail wbOlpStdModDetail : wbOlpStdModDetails) {
                if (key.equals(wbOlpStdModDetail.getMcId())) {
                    oneMcIdList.add(wbOlpStdModDetail);
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

                wbOlpStdModInfo.setMcId(key);
                wbOlpStdModInfo.setLineCount(modStat.get(key));
                wbOlpStdModInfo.setStatus(1);
                wbOlpStdModInfo.setCreateTime(DateUtils.getNowDate());
                wbOlpStdModInfo.setCreateBy(nickName);

                wbOlpStdModInfoMapper.insertWbOlpStdModInfo(wbOlpStdModInfo);

                for (WbOlpStdModDetail oneMcId : oneMcIdList) {
                    try {
                        wbOlpStdModDetailMapper.insertWbOlpStdModDetail(oneMcId);
                    } catch (Exception e) {
                        log.error("插入标准模版明细异常", e);
                        throw new RuntimeException("插入标准模版明细异常，请联系系统负责人!");
                    }
                }

                oneMcIdList.clear();

                wbOlpStdModInfo.setSid(null);
                wbOlpStdModInfo.setMcId(null);
                wbOlpStdModInfo.setLineCount(null);
                wbOlpStdModInfo.setStatus(null);
                wbOlpStdModInfo.setProvider(null);
                wbOlpStdModInfo.setFactory(null);
                wbOlpStdModInfo.setRemark(null);
                wbOlpStdModInfo.setCreateBy(null);
                wbOlpStdModInfo.setCreateTime(null);
            }
            insert = insert + 1;
        }

        if (existMcIdList.isEmpty()) {
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
        int count = 0;
        try {
            count = wbOlpStdModDetailMapper.countWbOlpStdModDetailByMcId(mcId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count != 0;
    }
}
