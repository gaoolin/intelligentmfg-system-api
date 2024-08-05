package com.qtech.aa.mapper;

import com.qtech.aa.domain.AaSoftwareManagement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/02 16:10:56
 * desc   :
 */

@Mapper
public interface AaStdSoftwareManagementMapper {

    public List<AaSoftwareManagement> selectAaSoftwareManagementList(AaSoftwareManagement aaSoftwareManagement);
}
