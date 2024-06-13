package com.qtech.fixture.service.impl;

import com.qtech.fixture.domain.FixtureMaterialCategoryProdType;
import com.qtech.fixture.domain.FixtureProdTypeInfo;
import com.qtech.fixture.mapper.FixtureMaterialCategoryProdTypeMapper;
import com.qtech.fixture.mapper.FixtureProdTypeInfoMapper;
import com.qtech.fixture.service.IFixtureProdTypeInfoService;
import com.qtech.common.annotation.DataScope;
import com.qtech.common.exception.biz.TooManyResultsException;
import com.qtech.common.utils.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/21 09:34:36
 * desc   :
 */

@Service
public class FixtureProdTypeInfoServiceImpl implements IFixtureProdTypeInfoService {

    @Autowired
    FixtureProdTypeInfoMapper fixtureProdTypeInfoMapper;

    @Autowired
    FixtureMaterialCategoryProdTypeMapper fixtureMaterialCategoryProdTypeMapper;


    @DataScope(deptAlias = "ta")
    @Override
    public FixtureProdTypeInfo selectOneFixtureProdTypeInfo(FixtureProdTypeInfo fixtureProdTypeInfo) {
        List<FixtureProdTypeInfo> list = fixtureProdTypeInfoMapper.selectFixtureProdTypeInfoList(fixtureProdTypeInfo);

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
    public List<FixtureProdTypeInfo> selectFixtureProdTypeInfoList(FixtureProdTypeInfo fixtureProdTypeInfo) {
        return fixtureProdTypeInfoMapper.selectFixtureProdTypeInfoList(fixtureProdTypeInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Boolean isFixtureProdTypeInfoExist(FixtureProdTypeInfo fixtureProdTypeInfo) {
        List<FixtureProdTypeInfo> fixtureProdTypeInfos = fixtureProdTypeInfoMapper.selectFixtureProdTypeInfoList(fixtureProdTypeInfo);
        return fixtureProdTypeInfos.size() > 0;
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer addFixtureProdTypeInfo(FixtureProdTypeInfo fixtureProdTypeInfo) {
        return fixtureProdTypeInfoMapper.addFixtureProdTypeInfo(fixtureProdTypeInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer editFixtureProdTypeInfo(FixtureProdTypeInfo fixtureProdTypeInfo) {
        return fixtureProdTypeInfoMapper.editFixtureProdTypeInfo(fixtureProdTypeInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer removeFixtureProdTypeInfo(FixtureProdTypeInfo fixtureProdTypeInfo) {
        return fixtureProdTypeInfoMapper.removeFixtureProdTypeInfo(fixtureProdTypeInfo);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Boolean isSecureDeletion(FixtureProdTypeInfo fixtureProdTypeInfo) {
        FixtureProdTypeInfo fixtureProdTypeInfoDb = selectOneFixtureProdTypeInfo(fixtureProdTypeInfo);
        if (Optional.ofNullable(fixtureProdTypeInfoDb.getpId()).isPresent()) {
            FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType = new FixtureMaterialCategoryProdType();
            fixtureMaterialCategoryProdType.setpId(fixtureProdTypeInfoDb.getpId());
            List<FixtureMaterialCategoryProdType> fixtureMaterialCategoryProdTypes = fixtureMaterialCategoryProdTypeMapper.selectFixtureMaterialCategoryProdTypeList(fixtureMaterialCategoryProdType);

            return StringUtils.isEmpty(fixtureMaterialCategoryProdTypes);
        } else {
            return true;
        }
    }
}
