package com.qtech.fixture.service.impl;

import com.qtech.fixture.domain.FixtureMaterialCategoryProdType;
import com.qtech.fixture.domain.FixtureProdTypeInfo;
import com.qtech.fixture.domain.FixtureSharedInfo;
import com.qtech.fixture.mapper.FixtureMaterialCategoryProdTypeMapper;
import com.qtech.fixture.service.IFixtureMaterialCategoryProdTypeService;
import com.qtech.common.annotation.DataScope;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.common.exception.biz.TooManyResultsException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/21 11:04:31
 * desc   :
 */

@Service
public class FixtureMaterialCategoryProdTypeServiceImpl implements IFixtureMaterialCategoryProdTypeService {

    @Autowired
    FixtureMaterialCategoryProdTypeMapper fixtureMaterialCategoryProdTypeMapper;

    @DataScope(deptAlias = "ta")
    @Override
    public FixtureMaterialCategoryProdType selectFixtureMaterialCategoryProdTypeOne(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType) {
        List<FixtureMaterialCategoryProdType> list = fixtureMaterialCategoryProdTypeMapper.selectFixtureMaterialCategoryProdTypeList(fixtureMaterialCategoryProdType);
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
    public List<FixtureMaterialCategoryProdType> selectFixtureMaterialCategoryProdTypeList(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType) {
        return fixtureMaterialCategoryProdTypeMapper.selectFixtureMaterialCategoryProdTypeList(fixtureMaterialCategoryProdType);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Boolean isFixtureMaterialCategoryProdTypeExist(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType) {
        List<FixtureMaterialCategoryProdType> fixtureMaterialCategoryProdTypes = fixtureMaterialCategoryProdTypeMapper.selectFixtureMaterialCategoryProdTypeList(fixtureMaterialCategoryProdType);
        return fixtureMaterialCategoryProdTypes.size() > 0;
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer addFixtureMaterialCategoryProdType(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType) {
        return fixtureMaterialCategoryProdTypeMapper.addFixtureMaterialCategoryProdType(fixtureMaterialCategoryProdType);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer editFixtureMaterialCategoryProdType(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType) {
        return fixtureMaterialCategoryProdTypeMapper.editFixtureMaterialCategoryProdType(fixtureMaterialCategoryProdType);
    }

    @DataScope(deptAlias = "ta")
    @Override
    public Integer removeFixtureMaterialCategoryProdType(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType) {
        return fixtureMaterialCategoryProdTypeMapper.removeFixtureMaterialCategoryProdType(fixtureMaterialCategoryProdType);
    }
}
