package com.qtech.wb.mapper;

import com.qtech.wb.domain.WbComparisonResultVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:12:55
 * desc   :
 */

@Repository
public interface WbComparisonResultMapper {

    public List<WbComparisonResultVo> selectWbComparisonResultList(WbComparisonResultVo wbComparisonResultVo);
}
