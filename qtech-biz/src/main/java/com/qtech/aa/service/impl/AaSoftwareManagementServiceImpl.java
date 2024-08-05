package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaSoftwareManagement;
import com.qtech.aa.mapper.AaStdSoftwareManagementMapper;
import com.qtech.aa.service.IAaSoftwareManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/02 16:15:52
 * desc   :
 */

@Slf4j
@Service
public class AaSoftwareManagementServiceImpl implements IAaSoftwareManagementService {

    @Autowired
    private AaStdSoftwareManagementMapper aaSoftwareManagementMapper;

    @Override
    public List<AaSoftwareManagement> selectAaSoftwareManagementList(AaSoftwareManagement aaSoftwareManagement) {
        return aaSoftwareManagementMapper.selectAaSoftwareManagementList(aaSoftwareManagement);
    }
}
