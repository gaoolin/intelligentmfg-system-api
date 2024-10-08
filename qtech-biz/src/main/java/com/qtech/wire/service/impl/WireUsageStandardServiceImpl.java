package com.qtech.wire.service.impl;

import com.qtech.wire.domain.WireUsageStandard;
import com.qtech.wire.mapper.WireUsageStandardMapper;
import com.qtech.wire.service.IWireUsageStandardService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.common.exception.biz.WireBizImportException;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.common.utils.StringUtils;
import com.qtech.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 金线标准用量信息Service业务层处理
 *
 * @author gaozhilin
 * @date 2023-03-29
 */
@DataSource(value = DataSourceType.SLAVE)
@Service
public class WireUsageStandardServiceImpl implements IWireUsageStandardService
{
    @Autowired
    private WireUsageStandardMapper wireUsageStandardMapper;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询金线标准用量信息
     *
     * @param mcId 金线标准用量信息主键
     * @return 金线标准用量信息
     */
    @Override
    public WireUsageStandard selectWireUsageStandardByMcId(String mcId)
    {
        return wireUsageStandardMapper.selectWireUsageStandardByMcId(mcId);
    }

    /**
     * 查询金线标准用量信息列表
     *
     * @param wireUsageStandard 金线标准用量信息
     * @return 金线标准用量信息
     */
    @Override
    public List<WireUsageStandard> selectWireUsageStandardList(WireUsageStandard wireUsageStandard)
    {
        return wireUsageStandardMapper.selectWireUsageStandardList(wireUsageStandard);
    }

    /**
     * 新增金线标准用量信息
     *
     * @param wireUsageStandard 金线标准用量信息
     * @return 结果
     */
    @Override
    public int insertWireUsageStandard(WireUsageStandard wireUsageStandard)
    {
        wireUsageStandard.setCreateTime(DateUtils.getNowDate());
        return wireUsageStandardMapper.insertWireUsageStandard(wireUsageStandard);
    }

    /**
     * 修改金线标准用量信息
     *
     * @param wireUsageStandard 金线标准用量信息
     * @return 结果
     */
    @Override
    public int updateWireUsageStandard(WireUsageStandard wireUsageStandard)
    {
        wireUsageStandard.setUpdateTime(DateUtils.getNowDate());
        wireUsageStandard.setFlag("1");
        return wireUsageStandardMapper.updateWireUsageStandard(wireUsageStandard);
    }

    /**
     * 删除金线标准用量信息信息
     *
     * @param mcId 金线标准用量信息主键
     * @return 结果
     */
    @Override
    public int deleteWireUsageStandardByMcId(String mcId)
    {
        return wireUsageStandardMapper.deleteWireUsageStandardByMcId(mcId);
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public String importWireUsageStandard(List<WireUsageStandard> wireUsageStandards) {
        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();

        int insert = 0;
        int exist = 0;

        if (StringUtils.isNull(wireUsageStandards) || wireUsageStandards.size() == 0) {
            throw new WireBizImportException();
        }

        for (WireUsageStandard wireUsageStandard : wireUsageStandards) {

            WireUsageStandard p = new WireUsageStandard();
            p.setMcId(wireUsageStandard.getMcId());
            List<WireUsageStandard> isExist = wireUsageStandardMapper.selectWireUsageStandardList(p);
            if (StringUtils.isNull(isExist) || isExist.size() == 0) {
                wireUsageStandard.setCreateBy(nickName);
                wireUsageStandard.setCreateTime(DateUtils.getNowDate());
                int i = wireUsageStandardMapper.insertWireUsageStandard(wireUsageStandard);
                insert = insert + 1;
            } else {
                exist = exist + 1;
            }
        }
        return String.valueOf(insert) + "-" + String.valueOf(exist);
    }
}
