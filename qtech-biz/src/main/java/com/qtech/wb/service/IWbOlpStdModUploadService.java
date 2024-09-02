package com.qtech.wb.service;

import com.qtech.wb.domain.WbOlpStdModDetail;
import com.qtech.wb.domain.WbOlpStdModUpload;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/08 16:17:45
 * desc   :
 */


public interface IWbOlpStdModUploadService {

    List<WbOlpStdModUpload> selectWbOlpStdModUploadList(WbOlpStdModUpload wbOlpStdModUpload);

    List<WbOlpStdModDetail> selectWbOlpStdModUploadMockList(String simId, String mcId, String pId, String beginTime, String endTime, String delLineNo);

    Integer addWbOlpStdModUploadMock(List<WbOlpStdModDetail> wbOlpStdModDetails, String leadThreshold, String padThreshold);
}
