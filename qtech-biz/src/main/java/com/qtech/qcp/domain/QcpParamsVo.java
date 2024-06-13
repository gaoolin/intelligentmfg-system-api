package com.qtech.qcp.domain;

import com.qtech.common.annotation.Excel;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/12/05 16:04:02
 * desc   :
 */


public class QcpParamsVo {

    @Excel(name = "厂区")
    private String companyName;

    @Excel(name = "车间")
    private String groupName;

    @Excel(name = "设备类型")
    private String deviceType;

    @Excel(name = "总设备数")
    private int ttlEqs;

    @Excel(name = "联网设备数")
    private int onlineEqs;

    @Excel(name = "离线设备数")
    private int offlineEqs;

    @Excel(name = "qcp参数为空")
    private int qcpParamsIsNull;

    @Excel(name = "远程未开启")
    private int remoteControlOff;

    private String dt;

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

    public int getQcpParamsIsNull() {
        return qcpParamsIsNull;
    }

    public void setQcpParamsIsNull(int qcpParamsIsNull) {
        this.qcpParamsIsNull = qcpParamsIsNull;
    }

    public int getRemoteControlOff() {
        return remoteControlOff;
    }

    public void setRemoteControlOff(int remoteControlOff) {
        this.remoteControlOff = remoteControlOff;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "QcpParamsVo{" +
                "companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", ttlEqs=" + ttlEqs +
                ", onlineEqs=" + onlineEqs +
                ", offlineEqs=" + offlineEqs +
                ", qcpParamsIsNull=" + qcpParamsIsNull +
                ", remoteControlOff=" + remoteControlOff +
                ", dt='" + dt + '\'' +
                '}';
    }
}
