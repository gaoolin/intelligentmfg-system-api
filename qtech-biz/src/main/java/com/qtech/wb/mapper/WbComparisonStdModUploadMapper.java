package com.qtech.wb.mapper;

import com.qtech.wb.domain.WbComparisonStdModDetail;
import com.qtech.wb.domain.WbComparisonStdModUpload;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/08 16:08:48
 * desc   :
 */

@Repository
public interface WbComparisonStdModUploadMapper {
    List<WbComparisonStdModUpload> selectWbComparisonStdModUploadList(WbComparisonStdModUpload wbComparisonStdModUpload);

    List<WbComparisonStdModDetail> selectWbComparisonStdModUploadMockList(@Param("simId") String simId,
                                                                          @Param("mcId") String mcId,
                                                                          @Param("pId") String pId,
                                                                          @Param("beginTime") String beginTime,
                                                                          @Param("endTime") String endTime,
                                                                          @Param("delLineNoList") List<Integer> delLineNoList);
}
