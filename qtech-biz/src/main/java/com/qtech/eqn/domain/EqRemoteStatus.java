package com.qtech.eqn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/03/13 11:13:38
 * desc   :
 */


public class EqRemoteStatus extends BaseEntity {

    @Excel(name = "厂区")
    private String companyName;

    @Excel(name = "车间")
    private String groupName;

    @Excel(name = "站位")
    private String deptName;

    @Excel(name = "设备类型")
    private String deviceType;

    @Excel(name = "设备编号")
    private String eqId;

    @Excel(name = "机台号")
    private String mcId;

    @Excel(name = "盒子号")
    private String simId;

    @JsonFormat(pattern="yyyy-mm-dd HH:mm:ss")
    private Date dt;

    private String interval;

    private int ttlEqs;

    private int onlineEqs;

    private int offlineEqs;

    private Integer label;

    /** 默认值 0 */
    @Excel(name = "远程状态码")
    private int remoteControlCode;

    /** 默认值 null */
    @Excel(name = "远程开关状态", dictType = "remote_control_status")
    private Integer status;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
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

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public int getRemoteControlCode() {
        return remoteControlCode;
    }

    public void setRemoteControlCode(int remoteControlCode) {
        this.remoteControlCode = remoteControlCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EqRemoteStatus{" +
                "companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", eqId='" + eqId + '\'' +
                ", mcId='" + mcId + '\'' +
                ", simId='" + simId + '\'' +
                ", dt=" + dt +
                ", interval='" + interval + '\'' +
                ", ttlEqs=" + ttlEqs +
                ", onlineEqs=" + onlineEqs +
                ", offlineEqs=" + offlineEqs +
                ", label=" + label +
                ", remoteControlCode=" + remoteControlCode +
                ", status=" + status +
                '}';
    }
}
