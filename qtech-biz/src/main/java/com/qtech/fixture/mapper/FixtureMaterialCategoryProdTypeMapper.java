package com.qtech.fixture.mapper;

import com.qtech.fixture.domain.FixtureMaterialCategoryProdType;
import com.qtech.fixture.domain.FixtureProdTypeInfo;
import com.qtech.fixture.domain.FixtureSharedInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/21 10:58:41
 * desc   :
 */

@Repository
public interface FixtureMaterialCategoryProdTypeMapper {

    public List<FixtureMaterialCategoryProdType> selectFixtureMaterialCategoryProdTypeList(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType);

    public Integer addFixtureMaterialCategoryProdType(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType);

    public Integer editFixtureMaterialCategoryProdType(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType);

    public Integer removeFixtureMaterialCategoryProdType(FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType);

    public Integer removeFixtureMaterialCategoryProdTypeById(Long id);
}
