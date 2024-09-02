package com.qtech.wb.mapper;

import com.qtech.wb.domain.WbOlpParticularsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 14:08:12
 * desc   :
 */

@Repository
public interface WbOlpDetailMapper {

    public List<WbOlpParticularsVo> getDetail(WbOlpParticularsVo wbOlpParticularsVo);
}
