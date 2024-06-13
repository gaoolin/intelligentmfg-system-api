package com.qtech.qcp.domain;

import com.qtech.common.annotation.Excel;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/22 08:44:17
 * desc   :
 */


public class QcpParamsDetailVo {

    @Excel(name = "厂区")
    private String companyName;

    @Excel(name = "车间")
    private String groupName;

    @Excel(name = "设备类型")
    private String deviceType;

    @Excel(name = "设备编号")
    private String eqId;

    @Excel(name = "机台号")
    private String mcId;

    @Excel(name = "机型")
    private String prodType;

    @Excel(name = "描述")
    private String reason;

    private Integer label;

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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "QcpParamsDetailVo{" +
                "companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", eqId='" + eqId + '\'' +
                ", mcId='" + mcId + '\'' +
                ", prodType='" + prodType + '\'' +
                ", reason='" + reason + '\'' +
                ", label=" + label +
                '}';
    }
}
