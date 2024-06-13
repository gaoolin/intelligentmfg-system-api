package com.qtech.wb.domain;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/09/16 10:52:52
 * desc   :
 */


public class WbComparisonIndexVo {

    private Integer wbComparisonStdModelsTtlCnt;

    private Integer wbComparisonStdModelAvgCnt;

    public Integer getWbComparisonStdModelsTtlCnt() {
        return wbComparisonStdModelsTtlCnt;
    }

    public void setWbComparisonStdModelsTtlCnt(Integer wbComparisonStdModelsTtlCnt) {
        this.wbComparisonStdModelsTtlCnt = wbComparisonStdModelsTtlCnt;
    }

    public Integer getWbComparisonStdModelAvgCnt() {
        return wbComparisonStdModelAvgCnt;
    }

    public void setWbComparisonStdModelAvgCnt(Integer wbComparisonStdModelAvgCnt) {
        this.wbComparisonStdModelAvgCnt = wbComparisonStdModelAvgCnt;
    }

    @Override
    public String toString() {
        return "WbComparisonOverviewVo{" +
                "wbComparisonStdModelsTtlCnt=" + wbComparisonStdModelsTtlCnt +
                ", wbComparisonStdModelAvgCnt=" + wbComparisonStdModelAvgCnt +
                '}';
    }
}
