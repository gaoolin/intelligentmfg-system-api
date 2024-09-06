package com.qtech.wb.service;

import com.qtech.wb.domain.WbOlpStdModDetail;
import com.qtech.wb.domain.WbOlpStdModInfo;

import java.util.List;
import java.util.Map;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/09/05 16:22:43
 * desc   :
 */


public interface IWbOlpStdModelDetailService {
    public WbOlpStdModDetail selectWbOlpStdModDetailById(Long id);
    public List<WbOlpStdModDetail> selectWbOlpStdModDetailList(WbOlpStdModDetail wbOlpStdModDetail);
    public int insertWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail);
    public int updateWbOlpStdModDetail(WbOlpStdModDetail wbOlpStdModDetail);
    public int deleteWbOlpStdModDetailById(Long id);
    public int deleteWbOlpStdModDetailByIds(Long[] ids);
    Map<String, String> uploadWbOlpStdModDetail(List<WbOlpStdModDetail> WbOlpStdModDetail, WbOlpStdModInfo wbOlpStdModInfo);
    Boolean isExistMcId(String mcId);
}
