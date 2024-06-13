package com.qtech.wb.mapper;

import com.qtech.wb.domain.EmsEqInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:44:19
 * desc   :
 */

@Repository
public interface EmsEqInfoMapper {

    public List<EmsEqInfo> selectEmsEqInfoList(EmsEqInfo emsEqInfo);
}
