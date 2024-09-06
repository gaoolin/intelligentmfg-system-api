package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaStdProgramManagement;
import com.qtech.aa.mapper.AaStdProgramManagementMapper;
import com.qtech.aa.service.IAaStdProgramManagementService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.common.exception.biz.TooManyResultsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/09/10 09:08:08
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SIXTH)
@Service
public class AaStdProgramManagementServiceImpl implements IAaStdProgramManagementService {
    private final AaStdProgramManagementMapper aaStdProgramManagementMapper;

    @Autowired
    public AaStdProgramManagementServiceImpl(AaStdProgramManagementMapper aaStdProgramManagementMapper) {
        this.aaStdProgramManagementMapper = aaStdProgramManagementMapper;
    }

    @Override
    public AaStdProgramManagement selectAaStdProgramManagementById(Long id) {
        return aaStdProgramManagementMapper.selectAaStdProgramManagementById(id);
    }

    @Override
    public List<AaStdProgramManagement> selectAaStdProgramManagementList(AaStdProgramManagement aaStdProgramManagement) {
        try {
            return aaStdProgramManagementMapper.selectAaStdProgramManagementList(aaStdProgramManagement);
        } catch (Exception e) {
            log.error("查询数据库发生异常，请联系系统负责人。", e);
            throw new RuntimeException("查询数据库发生异常，请联系系统负责人。");
        }
    }

    @Override
    public AaStdProgramManagement selectOneAaStdProgramManagement(AaStdProgramManagement aaStdProgramManagement) {
        List<AaStdProgramManagement> list = aaStdProgramManagementMapper.selectAaStdProgramManagementList(aaStdProgramManagement);
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                throw new TooManyResultsException(String.format("Expected one result (or null) to be returned by selectOne(), but found: %s", size));
            }
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insertAaStdProgramManagement(AaStdProgramManagement aaStdProgramManagement) {
        try {
            return aaStdProgramManagementMapper.insertAaStdProgramManagement(aaStdProgramManagement);
        } catch (Exception e) {
            log.error("插入数据库发生异常，请联系系统负责人。", e);
            throw new RuntimeException("插入数据库发生异常，请联系系统负责人。");
        }
    }

    @Override
    public int updateAaStdProgramManagement(AaStdProgramManagement aaStdProgramManagement) {
        return aaStdProgramManagementMapper.updateAaStdProgramManagement(aaStdProgramManagement);
    }

    @Override
    public int deleteAaStdProgramManagementById(Long id) {
        try {
            return aaStdProgramManagementMapper.deleteAaStdProgramManagementById(id);
        } catch (Exception e) {
            throw new RuntimeException("删除数据发生异常，请联系系统负责人。");
        }
    }

    @Override
    public int deleteAaStdProgramManagementByIds(Long[] ids) {
        return 0;
    }
}
