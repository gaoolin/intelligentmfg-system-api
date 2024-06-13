package com.qtech.wb.service;

import com.qtech.wb.domain.WbComparisonStdModDetail;
import com.qtech.wb.domain.WbComparisonStdModUpload;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/08 16:17:45
 * desc   :
 */


public interface IWbComparisonStdModUploadService {

    List<WbComparisonStdModUpload> selectWbComparisonStdModUploadList(WbComparisonStdModUpload wbComparisonStdModUpload);

    List<WbComparisonStdModDetail> selectWbComparisonStdModUploadMockList(String simId, String mcId, String pId, String beginTime, String endTime, String delLineNo);

    Integer addWbComparisonStdModUploadMock(List<WbComparisonStdModDetail> wbComparisonStdModDetails, String leadThreshold, String padThreshold);
}
