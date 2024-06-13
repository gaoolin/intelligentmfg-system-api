package com.qtech.wb.domain;

import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/04 15:18:41
 * desc   :
 */


public class WbComparisonOverview extends BaseEntity {

    @Excel(name = "厂区")
    private String companyName;

    @Excel(name = "车间")
    private String groupName;

    private int ttlEqs;

    private int onlineEqs;

    private int offlineEqs;

    @Excel(name = "比对次数")
    private int computeCnt;

    @Excel(name = "正确次数")
    private int okCnt;

    @Excel(name = "错误次数")
    private int errCnt;

    @Excel(name = "金线偏移")
    private int offsetCnt;

    @Excel(name = "无程序")
    private int npCnt;

    @Excel(name = "少线")
    private int lackCnt;

    @Excel(name = "多线")
    private int overCnt;

    @Excel(name = "错误率")
    private float errRatio;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getTtlEqs() {
        return ttlEqs;
    }

    public void setTtlEqs(int ttlEqs) {
        this.ttlEqs = ttlEqs;
    }

    public int getOnlineEqs() {
        return onlineEqs;
    }

    public void setOnlineEqs(int onlineEqs) {
        this.onlineEqs = onlineEqs;
    }

    public int getOfflineEqs() {
        return offlineEqs;
    }

    public void setOfflineEqs(int offlineEqs) {
        this.offlineEqs = offlineEqs;
    }

    public int getComputeCnt() {
        return computeCnt;
    }

    public void setComputeCnt(int computeCnt) {
        this.computeCnt = computeCnt;
    }

    public int getOkCnt() {
        return okCnt;
    }

    public void setOkCnt(int okCnt) {
        this.okCnt = okCnt;
    }

    public int getErrCnt() {
        return errCnt;
    }

    public void setErrCnt(int errCnt) {
        this.errCnt = errCnt;
    }

    public int getOffsetCnt() {
        return offsetCnt;
    }

    public void setOffsetCnt(int offsetCnt) {
        this.offsetCnt = offsetCnt;
    }

    public int getNpCnt() {
        return npCnt;
    }

    public void setNpCnt(int npCnt) {
        this.npCnt = npCnt;
    }

    public int getLackCnt() {
        return lackCnt;
    }

    public void setLackCnt(int lackCnt) {
        this.lackCnt = lackCnt;
    }

    public int getOverCnt() {
        return overCnt;
    }

    public void setOverCnt(int overCnt) {
        this.overCnt = overCnt;
    }

    public float getErrRatio() {
        return errRatio;
    }

    public void setErrRatio(float errRatio) {
        this.errRatio = errRatio;
    }

    @Override
    public String toString() {
        return "WbComparisonOverview{" +
                "companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", ttlEqs=" + ttlEqs +
                ", onlineEqs=" + onlineEqs +
                ", offlineEqs=" + offlineEqs +
                ", computeCnt=" + computeCnt +
                ", okCnt=" + okCnt +
                ", errCnt=" + errCnt +
                ", offsetCnt=" + offsetCnt +
                ", npCnt=" + npCnt +
                ", lackCnt=" + lackCnt +
                ", overCnt=" + overCnt +
                ", errRatio=" + errRatio +
                '}';
    }
}
