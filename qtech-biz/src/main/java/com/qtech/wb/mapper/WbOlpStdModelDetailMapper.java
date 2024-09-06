package com.qtech.wb.mapper;

import com.qtech.wb.domain.WbOlpStdModDetail;
import com.qtech.wb.domain.WbOlpStdModInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/09/05 16:27:44
 * desc   :
 */

@Repository
public interface WbOlpStdModelDetailMapper {
    WbOlpStdModDetail selectWbOlpStdModDetailById(Long id);

    List<WbOlpStdModDetail> selectWbOlpStdModDetailList(WbOlpStdModDetail wbOlpStdModDetail);

    int insertWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail);

    int updateWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail);

    int deleteWbOlpStdModDetailById(Long id);

    int deleteWbOlpStdModDetailByIds(Long[] ids);

    int countWbOlpStdModDetailByMcId(String mcId);
}
