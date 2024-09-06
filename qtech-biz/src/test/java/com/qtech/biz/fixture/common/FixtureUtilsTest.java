package com.qtech.fixture.common;


import com.qtech.fixture.domain.FixtureParamsAa;
import com.qtech.fixture.domain.FixtureMaterialCategoryProdType;
import com.qtech.fixture.service.IFixtureSharedInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/03/27 09:34:54
 * desc   :  使用SpringBootTest做单元测试，测试的类和方法都必须是public权限，否则无法测试
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class FixtureUtilsTest {

    @Autowired
    FixtureUtils fixtureUtils;

    @Autowired
    IFixtureSharedInfoService fixtureSharedInfoService;

    @Test
    public void fixtureProdTypeMultipleReferenceCheck() {
        Boolean aBoolean = fixtureUtils.fixtureProdTypeMultipleReferenceCheck(757L, 209L);
    }

    @Test
    public void TestListSize() {
        List<FixtureMaterialCategoryProdType> fixtureMaterialCategoryProdTypes = new ArrayList<>();
        int size = fixtureMaterialCategoryProdTypes.size();
    }

    @Test
    public void deleteFixtureProdTypeMaterialInfo() {
        FixtureMaterialCategoryProdType fixtureMaterialCategoryProdType = new FixtureMaterialCategoryProdType();
        fixtureMaterialCategoryProdType.setDeptId(209L);
        fixtureMaterialCategoryProdType.setmId(2L);
        String label = "" + 191 + '-' + 757 + '-' + 0 + '-' + 209;
    }

    @Test
    public void bitTest() {
        System.out.println(0 & 1);
        System.out.println(0 | 1);
    }

    @Test
    public void fixtureCategoryCheckGeneric() {
        FixtureParamsAa fixtureParamsPogopin = new FixtureParamsAa();
        fixtureParamsPogopin.setFixtureCategory("C2NA06");
        fixtureUtils.fixtureCategoryExistCheckGeneric(fixtureParamsPogopin, "pogopin");
        System.out.println(fixtureParamsPogopin);
    }
}
