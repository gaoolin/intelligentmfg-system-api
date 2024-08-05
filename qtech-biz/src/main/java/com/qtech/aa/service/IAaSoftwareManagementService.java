package com.qtech.aa.service;

import com.qtech.aa.domain.AaSoftwareManagement;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/02 16:14:57
 * desc   :
 */


public interface IAaSoftwareManagementService {
    public List<AaSoftwareManagement> selectAaSoftwareManagementList(AaSoftwareManagement aaSoftwareManagement);
}
