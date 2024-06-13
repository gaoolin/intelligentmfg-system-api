package com.qtech.wb.utils;

import com.qtech.wb.mapper.WbComparisonStdModDetailMapper;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/06 17:17:10
 * desc   :  工具类
 */

@DataSource(value = DataSourceType.SIXTH)
@Component
public class CheckMcIdIsExistFromDb {

    @Autowired
    private static WbComparisonStdModDetailMapper wbComparisonStdModDetailMapper;

    public static Boolean isExist(String mcId) {
        int count = wbComparisonStdModDetailMapper.countWbComparisonStdModDetailByMcId(mcId);
        return count != 0;
    }
}
