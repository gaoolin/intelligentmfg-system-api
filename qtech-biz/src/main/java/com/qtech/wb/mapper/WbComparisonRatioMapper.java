package com.qtech.wb.mapper;

import com.qtech.wb.domain.WbComparisonPercentageVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/15 13:27:04
 * desc   :
 */

@Repository
public interface WbComparisonRatioMapper {

    public List<WbComparisonPercentageVo> selectWbComparisonRatioList(WbComparisonPercentageVo wbComparisonPercentageVo);
}
