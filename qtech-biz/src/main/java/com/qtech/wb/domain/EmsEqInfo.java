package com.qtech.wb.domain;

import com.qtech.common.annotation.Excel;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:36:23
 * desc   :
 */

public class EmsEqInfo {

    @Excel(name = "厂区")
    private String companyName;

    @Excel(name = "车间")
    private String groupName;

    @Excel(name = "设备号")
    private String eqId;

    @Excel(name = "机台号")
    private String mcId;

    @Excel(name = "盒子号")
    private String simId;

    @Excel(name = "机型")
    private String prodType;

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

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    @Override
    public String toString() {
        return "EmsEqInfo{" +
                "companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", eqId='" + eqId + '\'' +
                ", mcId='" + mcId + '\'' +
                ", simId='" + simId + '\'' +
                ", prodType='" + prodType + '\'' +
                '}';
    }
}
