package com.qtech.wb.domain;

import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/15 13:19:15
 * desc   :
 */


public class WbComparisonPercentageVo extends BaseEntity {

    @Excel(name = "厂区")
    private String companyName;

    @Excel(name = "车间")
    private String groupName;

    @Excel(name = "设备编号")
    private String eqId;

    @Excel(name = "机台号")
    private String mcId;

    @Excel(name = "机型")
    private String prodType;

    @Excel(name = "比对次数")
    private int computeCnt;

    @Excel(name = "正确次数")
    private int okCnt;

    @Excel(name = "错误次数")
    private int errCnt;

    @Excel(name = "错误率")
    private float errRatio;

    private String flag;

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

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId;
    }

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
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

    public float getErrRatio() {
        return errRatio;
    }

    public void setErrRatio(float errRatio) {
        this.errRatio = errRatio;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "WbComparisonRatioVo{" +
                "companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", eqId='" + eqId + '\'' +
                ", mcId='" + mcId + '\'' +
                ", prodType='" + prodType + '\'' +
                ", computeCnt=" + computeCnt +
                ", okCnt=" + okCnt +
                ", errCnt=" + errCnt +
                ", errRatio=" + errRatio +
                ", flag='" + flag + '\'' +
                '}';
    }
}
