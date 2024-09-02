package com.qtech.wb.mapper;

import com.qtech.wb.vo.WbOlpChkVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:12:55
 * desc   :
 */

@Repository
public interface WbOlpChkMapper {

    public List<WbOlpChkVo> selectWbOlpChkList(@Param("vo") WbOlpChkVo vo, @Param("daysFilter") int daysFilter);
}
