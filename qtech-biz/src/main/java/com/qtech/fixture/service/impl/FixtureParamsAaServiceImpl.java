package com.qtech.fixture.service.impl;

import com.qtech.fixture.common.FixtureUtils;
import com.qtech.fixture.domain.FixtureParamsAa;
import com.qtech.fixture.mapper.FixtureParamsAaMapper;
import com.qtech.fixture.service.IFixtureParamsAaService;
import com.qtech.fixture.service.IFixtureSharedInfoService;
import com.qtech.common.exception.biz.EditFixtureSharedInfoException;
import com.qtech.common.exception.file.FileUploadException;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.common.utils.StringUtils;
import com.qtech.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
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
 * date   :  2024/04/02 13:43:08
 * desc   :
 */
@Slf4j
@Service
public class FixtureParamsAaServiceImpl implements IFixtureParamsAaService {

    @Autowired
    private FixtureParamsAaMapper fixtureParamsAaMapper;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private FixtureUtils fixtureUtils;

    @Autowired
    private IFixtureSharedInfoService fixtureSharedInfoService;

    @Override
    public List<FixtureParamsAa> selectFixtureParamsAaList(FixtureParamsAa fixtureParamsAa) {
        return fixtureParamsAaMapper.selectFixtureParamsAaList(fixtureParamsAa);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    public int addFixtureParamsAa(FixtureParamsAa fixtureParamsAa) {
        return fixtureUtils.addFixtureParamsGeneric(fixtureParamsAa, "aa");
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Map<String, String> uploadFixtureParamsAa(List<FixtureParamsAa> fixtureParamsAas) {
        HashMap<String, String> resultMap = new HashMap<>();

        int insert = 0;
        int exist = 0;

        if (StringUtils.isNull(fixtureParamsAas) || fixtureParamsAas.isEmpty()) {
            try {
                throw new FileUploadException("文档数据为空！");
            } catch (FileUploadException e) {
            // e.printStackTrace();
                log.error(e.getMessage());
            }
        }

        for (FixtureParamsAa fixtureParamsAa : fixtureParamsAas) {
            int i = addFixtureParamsAa(fixtureParamsAa);

            if (i > 0) {
                insert++;
            } else {
                exist++;
            }
        }
        return uploadDataResult(resultMap, insert, exist);
    }

    @Transactional(rollbackFor = {Exception.class, EditFixtureSharedInfoException.class}, propagation = Propagation.REQUIRED)
    @Override
    public int editFixtureParamsAa(FixtureParamsAa fixtureParamsAa) {
        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
        fixtureParamsAa.setUpdateBy(nickName);
        fixtureParamsAa.setUpdateTime(DateUtils.getNowDate());

        fixtureUtils.fixtureCategoryExistCheckGeneric(fixtureParamsAa, "aa");

        int n = fixtureParamsAaMapper.editFixtureParamsAa(fixtureParamsAa);
        fixtureUtils.fixtureMaterialCheckGeneric(fixtureParamsAa, "aa");
        return n;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRED)
    @Override
    public int removeFixtureParamsAa(FixtureParamsAa fixtureParamsAa) {

        int i = fixtureParamsAaMapper.removeFixtureParamsAa(fixtureParamsAa);
        int j = fixtureUtils.fixtureSharedInfoRemoveCheck(fixtureParamsAa.getFixtureSharedStatus(), fixtureParamsAa.getDeptId(), fixtureParamsAa.getMaterialId(), fixtureSharedInfoService);
        return i | j;
    }

    @Override
    public FixtureParamsAa selectOneFixtureParamsAa(FixtureParamsAa fixtureParamsAa) {
        return fixtureParamsAaMapper.selectOneFixtureParamsAa(fixtureParamsAa);
    }
}
