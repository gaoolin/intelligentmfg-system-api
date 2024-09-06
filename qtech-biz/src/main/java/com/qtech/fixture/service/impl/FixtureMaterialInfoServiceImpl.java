package com.qtech.fixture.service.impl;

import com.qtech.fixture.domain.FixtureMaterialInfo;
import com.qtech.fixture.mapper.FixtureMaterialInfoMapper;
import com.qtech.fixture.service.IFixtureMaterialInfoService;
import com.qtech.common.annotation.DataScope;
import com.qtech.common.exception.biz.TooManyResultsException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/21 08:56:11
 * desc   :
 */

@Service
public class FixtureMaterialInfoServiceImpl implements IFixtureMaterialInfoService {

    @Autowired
    FixtureMaterialInfoMapper fixtureMaterialInfoMapper;

    @Override
    public FixtureMaterialInfo selectOneFixtureMaterialInfo(FixtureMaterialInfo fixtureMaterialInfo) {
        List<FixtureMaterialInfo> list = fixtureMaterialInfoMapper.selectFixtureMaterialInfoList(fixtureMaterialInfo);
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
    public List<FixtureMaterialInfo> selectFixtureMaterialInfoList(FixtureMaterialInfo fixtureMaterialInfo) {
        return fixtureMaterialInfoMapper.selectFixtureMaterialInfoList(fixtureMaterialInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Boolean isFixtureMaterialInfoExist(FixtureMaterialInfo fixtureMaterialInfo) {
        List<FixtureMaterialInfo> fixtureMaterialInfos = fixtureMaterialInfoMapper.selectFixtureMaterialInfoList(fixtureMaterialInfo);
        return !fixtureMaterialInfos.isEmpty();
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer addFixtureMaterialInfo(FixtureMaterialInfo fixtureMaterialInfo) {
        return fixtureMaterialInfoMapper.addFixtureMaterialInfo(fixtureMaterialInfo);
    }

    @Override
    public Integer editFixtureMaterialInfo(FixtureMaterialInfo fixtureMaterialInfo) {
        return fixtureMaterialInfoMapper.editFixtureMaterialInfo(fixtureMaterialInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer removeFixtureMaterialInfo(FixtureMaterialInfo fixtureMaterialInfo) {
        return fixtureMaterialInfoMapper.removeFixtureMaterialInfo(fixtureMaterialInfo);
    }
}
