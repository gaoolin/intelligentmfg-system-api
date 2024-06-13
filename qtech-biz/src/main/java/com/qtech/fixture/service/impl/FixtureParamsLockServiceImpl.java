package com.qtech.fixture.service.impl;

import com.qtech.fixture.common.FixtureDelOps;
import com.qtech.fixture.common.FixtureEditOps;
import com.qtech.fixture.common.FixtureUtils;
import com.qtech.fixture.domain.FixtureParamsAa;
import com.qtech.fixture.domain.FixtureParamsLock;
import com.qtech.fixture.domain.FixtureSharedInfo;
import com.qtech.fixture.mapper.FixtureParamsLockMapper;
import com.qtech.fixture.service.IFixtureParamsLockService;
import com.qtech.fixture.service.IFixtureSharedInfoService;
import com.qtech.common.exception.biz.TooManyResultsException;
import com.qtech.common.exception.file.FileUploadException;
import com.qtech.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.qtech.fixture.service.impl.FixtureSharedInfoServiceImpl.uploadDataResult;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/04/16 14:31:50
 * desc   :
 */

@Slf4j
@Service
public class FixtureParamsLockServiceImpl implements IFixtureParamsLockService {

    @Autowired
    private FixtureUtils fixtureUtils;

    @Autowired
    private FixtureParamsLockMapper fixtureParamsLockMapper;

    @Autowired
    private FixtureEditOps fixtureEditOps;

    @Autowired
    private FixtureDelOps fixtureDelOps;

    @Autowired
    private IFixtureSharedInfoService fixtureSharedInfoService;

    @Override
    public List<FixtureParamsLock> selectFixtureParamsLockList(FixtureParamsLock fixtureParamsLock) {
        return fixtureParamsLockMapper.selectFixtureParamsLockList(fixtureParamsLock);
    }

    @Override
    public int addFixtureParamsLock(FixtureParamsLock fixtureParamsLock) {
        return fixtureUtils.addFixtureParamsGeneric(fixtureParamsLock, "lock");
    }

    @Override
    public int editFixtureParamsLock(FixtureParamsLock fixtureParamsLock) {
        System.out.println(fixtureParamsLock);

        return fixtureEditOps.fixtureParamsEditOps(fixtureParamsLock, "lock");
    }

    @Override
    public FixtureParamsLock selectOneFixtureParamsLock(FixtureParamsLock fixtureParamsLock) {
        List<FixtureParamsLock> list = fixtureParamsLockMapper.selectFixtureParamsLockList(fixtureParamsLock);
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                throw new TooManyResultsException(String.format("Expected one result (or null) to be returned by selectOne(), but found: %s", size));
            }
            return list.get(0);
        }
        return null;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public int removeFixtureParamsLock(FixtureParamsLock fixtureParamsLock) {
        int i = fixtureDelOps.processOps(fixtureParamsLock, "lock");
        int j = fixtureUtils.fixtureSharedInfoRemoveCheck(fixtureParamsLock.getFixtureSharedStatus(), fixtureParamsLock.getDeptId(), fixtureParamsLock.getMaterialId(), fixtureSharedInfoService);
        return i | j;
    }

    @Override
    public Map<String, String> uploadFixtureParamsLock(List<FixtureParamsLock> fixtureParamsLocks) {
        HashMap<String, String> resultMap = new HashMap<>();

        int insert = 0;
        int exist = 0;

        if (StringUtils.isNull(fixtureParamsLocks) || fixtureParamsLocks.isEmpty()) {
            try {
                throw new FileUploadException("文档数据为空！");
            } catch (FileUploadException e) {
            // e.printStackTrace();
                log.error(e.getMessage());
            }
        }

        for (FixtureParamsLock fixtureParamsLock : fixtureParamsLocks) {
            int i = addFixtureParamsLock(fixtureParamsLock);

            if (i > 0) {
                insert++;
            } else {
                exist++;
            }
        }
        return uploadDataResult(resultMap, insert, exist);
    }

}
