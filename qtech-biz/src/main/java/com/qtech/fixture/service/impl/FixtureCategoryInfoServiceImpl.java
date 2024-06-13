package com.qtech.fixture.service.impl;

import com.qtech.fixture.domain.FixtureCategoryInfo;
import com.qtech.fixture.mapper.FixtureCategoryInfoMapper;
import com.qtech.fixture.service.IFixtureCategoryInfoService;
import com.qtech.common.annotation.DataScope;
import com.qtech.common.exception.biz.TooManyResultsException;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.system.service.ISysUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/21 09:19:08
 * desc   :
 */

@Service
public class FixtureCategoryInfoServiceImpl implements IFixtureCategoryInfoService {

    @Autowired
    FixtureCategoryInfoMapper fixtureCategoryInfoMapper;

    @Autowired
    private ISysUserService sysUserService;

    @DataScope(deptAlias = "ta")
    @Override
    public FixtureCategoryInfo selectOneFixtureCategoryInfo(FixtureCategoryInfo fixtureCategoryInfo) {
        List<FixtureCategoryInfo> list = fixtureCategoryInfoMapper.selectFixtureCategoryInfoList(fixtureCategoryInfo);

        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                throw new TooManyResultsException(String.format("Expected one result (or null) to be returned by selectOne(), but found: %s", size));
            }
            return list.get(0);
        }
        return null;
    }

    @DataScope(deptAlias = "ta")
    @Override
    public List<FixtureCategoryInfo> selectFixtureCategoryInfoList(FixtureCategoryInfo fixtureCategoryInfo) {
        return fixtureCategoryInfoMapper.selectFixtureCategoryInfoList(fixtureCategoryInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Boolean isFixtureCategoryInfoExist(FixtureCategoryInfo fixtureCategoryInfo) {
        List<FixtureCategoryInfo> fixtureCategoryInfos = fixtureCategoryInfoMapper.selectFixtureCategoryInfoList(fixtureCategoryInfo);
        return fixtureCategoryInfos.size() > 0;
    }

    @DataScope(deptAlias = "ta")
    @Override
    public List<FixtureCategoryInfo> selectFixtureCategoryList(FixtureCategoryInfo fixtureCategoryInfo) {
        return fixtureCategoryInfoMapper.selectFixtureCategoryInfoList(fixtureCategoryInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer addFixtureCategoryInfo(FixtureCategoryInfo fixtureCategoryInfo) {
        fixtureCategoryInfo.setCreateBy(sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName());
        fixtureCategoryInfo.setCreateTime(DateUtils.getNowDate());
        Integer n;
        try {
            n = fixtureCategoryInfoMapper.addFixtureCategoryInfo(fixtureCategoryInfo);
        } catch (Exception e) {
            throw new IllegalStateException(String.format("治具类型已存在：%s！", fixtureCategoryInfo.getFixtureCategory()));
        }
        return n;
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer editFixtureCategoryInfo(FixtureCategoryInfo fixtureCategoryInfo) {
        fixtureCategoryInfo.setUpdateBy(sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName());
        fixtureCategoryInfo.setUpdateTime(DateUtils.getNowDate());
        return fixtureCategoryInfoMapper.editFixtureCategoryInfo(fixtureCategoryInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer removeFixtureCategoryInfo(Long cId) {
        return fixtureCategoryInfoMapper.removeFixtureCategoryInfo(cId);
    }

    @Override
    public List<FixtureCategoryInfo> selectFixtureCategoryAll(FixtureCategoryInfo fixtureCategoryInfo) {
        return fixtureCategoryInfoMapper.selectFixtureCategoryInfoList(fixtureCategoryInfo);
    }
}
