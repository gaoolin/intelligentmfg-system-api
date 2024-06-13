package com.qtech.wb.service.impl;

import com.qtech.wb.domain.WbComparisonStdModDetail;
import com.qtech.wb.domain.WbComparisonStdModUpload;
import com.qtech.wb.mapper.WbComparisonStdModDetailMapper;
import com.qtech.wb.mapper.WbComparisonStdModUploadMapper;
import com.qtech.wb.service.IWbComparisonStdModUploadService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/08 16:18:20
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.FIFTH)
@Service
public class WbComparisonStdModUploadServiceImpl implements IWbComparisonStdModUploadService {

    @Autowired
    WbComparisonStdModUploadMapper wbComparisonStdModUploadMapper;

    @Autowired
    WbComparisonStdModDetailMapper wbComparisonStdModDetailMapper;

    @Override
    public List<WbComparisonStdModUpload> selectWbComparisonStdModUploadList(WbComparisonStdModUpload wbComparisonStdModUpload) {
        try {
            return wbComparisonStdModUploadMapper.selectWbComparisonStdModUploadList(wbComparisonStdModUpload);
        } catch (Exception e) {
            log.error("查询标准模组上传数据异常", e);
            throw new RuntimeException("查询标准模组上传数据异常，请联系系统负责人!");
        }
    }

    @Override
    public List<WbComparisonStdModDetail> selectWbComparisonStdModUploadMockList(String simId, String mcId, String pId, String beginTime, String endTime, String delLineNo) {
        List<Integer> delLineNoList = new ArrayList<>();
        if (!"".equals(delLineNo)) {
            String[] split = delLineNo.split(",");
            for (String s : split) {
                delLineNoList.add(Integer.parseInt(s));
            }
        }
        try {
            return wbComparisonStdModUploadMapper.selectWbComparisonStdModUploadMockList(simId, mcId, pId, beginTime, endTime, delLineNoList);
        } catch (Exception e) {
            log.error("查询标准模组上传数据异常", e);
            throw new RuntimeException("查询标准模组上传数据异常，请联系系统负责人!");
        }
    }

    @DataSource(value = DataSourceType.SIXTH)
    @Override
    public Integer addWbComparisonStdModUploadMock(List<WbComparisonStdModDetail> wbComparisonStdModDetails, String leadThreshold, String padThreshold) {
        for (WbComparisonStdModDetail wbComparisonStdModDetail : wbComparisonStdModDetails) {
            wbComparisonStdModDetail.setSource("数采模版");
            wbComparisonStdModDetail.setLeadThreshold(Float.parseFloat(leadThreshold));
            wbComparisonStdModDetail.setPadThreshold(Float.parseFloat(padThreshold));
        }

        Integer cnt = 0;
        for (WbComparisonStdModDetail wbComparisonStdModDetail : wbComparisonStdModDetails) {
            Integer i = null;
            try {
                i = wbComparisonStdModDetailMapper.insertWbComparisonStdModDetail(wbComparisonStdModDetail);
            } catch (Exception e) {
                log.error("插入标准模组上传数据异常", e);
                throw new RuntimeException("插入标准模组上传数据异常，请联系系统负责人!");
            }
            cnt = cnt + i;
        }
        return cnt;
    }
}
