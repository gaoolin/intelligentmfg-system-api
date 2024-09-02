package com.qtech.wb.domain;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/16 10:52:52
 * desc   :
 */


public class WbOlpIndexVo {

    private Integer wbOlpStdModelsTtlCnt;

    private Integer wbOlpStdModelAvgCnt;

    public Integer getWbOlpStdModelsTtlCnt() {
        return wbOlpStdModelsTtlCnt;
    }

    public void setWbOlpStdModelsTtlCnt(Integer wbOlpStdModelsTtlCnt) {
        this.wbOlpStdModelsTtlCnt = wbOlpStdModelsTtlCnt;
    }

    public Integer getWbOlpStdModelAvgCnt() {
        return wbOlpStdModelAvgCnt;
    }

    public void setWbOlpStdModelAvgCnt(Integer wbOlpStdModelAvgCnt) {
        this.wbOlpStdModelAvgCnt = wbOlpStdModelAvgCnt;
    }

    @Override
    public String toString() {
        return "WbOlpOverviewVo{" +
                "wbOlpStdModelsTtlCnt=" + wbOlpStdModelsTtlCnt +
                ", wbOlpStdModelAvgCnt=" + wbOlpStdModelAvgCnt +
                '}';
    }
}
