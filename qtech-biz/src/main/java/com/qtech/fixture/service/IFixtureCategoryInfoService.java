package com.qtech.fixture.service;

import com.qtech.fixture.domain.FixtureCategoryInfo;
import com.qtech.fixture.domain.FixtureProdTypeInfo;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/21 09:16:11
 * desc   :
 */


public interface IFixtureCategoryInfoService {

    public FixtureCategoryInfo selectOneFixtureCategoryInfo(FixtureCategoryInfo fixtureCategoryInfo);

    public List<FixtureCategoryInfo> selectFixtureCategoryInfoList(FixtureCategoryInfo fixtureCategoryInfo);

    public Boolean isFixtureCategoryInfoExist(FixtureCategoryInfo fixtureCategoryInfo);

    public List<FixtureCategoryInfo> selectFixtureCategoryList(FixtureCategoryInfo fixtureCategoryInfo);

    public Integer addFixtureCategoryInfo(FixtureCategoryInfo fixtureCategoryInfo);

    public Integer editFixtureCategoryInfo(FixtureCategoryInfo fixtureCategoryInfo);

    public Integer removeFixtureCategoryInfo(Long cId);

    public List<FixtureCategoryInfo> selectFixtureCategoryAll(FixtureCategoryInfo fixtureCategoryInfo);
}
