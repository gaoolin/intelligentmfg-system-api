package com.qtech.quartz.domain;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 10:24:37
 * @description : TODO
 */


public class BomSensorWireUsage {

    private String finishedId;
    private String partSpec;
    private String mDate;
    private String WbWirePartNo;
    private String WbWireProdName;
    private String WbWireSpec;
    private String WbBallUnit;
    private String WbBallAmount;
    private String SensorType;
    private String SensorPartNo;
    private String SensorProdName;
    private String SensorSpec;
    private String SensorTypeNew;
    private String UpdateTime;

    public String getFinishedId() {
        return finishedId;
    }

    public void setFinishedId(String finishedId) {
        this.finishedId = finishedId;
    }

    public String getPartSpec() {
        return partSpec;
    }

    public void setPartSpec(String partSpec) {
        this.partSpec = partSpec;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getWbWirePartNo() {
        return WbWirePartNo;
    }

    public void setWbWirePartNo(String wbWirePartNo) {
        this.WbWirePartNo = wbWirePartNo;
    }

    public String getWbWireProdName() {
        return WbWireProdName;
    }

    public void setWbWireProdName(String wbWireProdName) {
        this.WbWireProdName = wbWireProdName;
    }

    public String getWbWireSpec() {
        return WbWireSpec;
    }

    public void setWbWireSpec(String wbWireSpec) {
        this.WbWireSpec = wbWireSpec;
    }

    public String getWbBallUnit() {
        return WbBallUnit;
    }

    public void setWbBallUnit(String wbBallUnit) {
        this.WbBallUnit = wbBallUnit;
    }

    public String getWbBallAmount() {
        return WbBallAmount;
    }

    public void setWbBallAmount(String wbBallAmount) {
        this.WbBallAmount = wbBallAmount;
    }

    public String getSensorType() {
        return SensorType;
    }

    public void setSensorType(String sensorType) {
        this.SensorType = sensorType;
    }

    public String getSensorPartNo() {
        return SensorPartNo;
    }

    public void setSensorPartNo(String sensorPartNo) {
        this.SensorPartNo = sensorPartNo;
    }

    public String getSensorProdName() {
        return SensorProdName;
    }

    public void setSensorProdName(String sensorProdName) {
        this.SensorProdName = sensorProdName;
    }

    public String getSensorSpec() {
        return SensorSpec;
    }

    public void setSensorSpec(String sensorSpec) {
        this.SensorSpec = sensorSpec;
    }

    public String getSensorTypeNew() {
        return SensorTypeNew;
    }

    public void setSensorTypeNew(String sensorTypeNew) {
        this.SensorTypeNew = sensorTypeNew;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.UpdateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BomSensorWireUsage{" +
                "finishedId='" + finishedId + '\'' +
                ", partSpec='" + partSpec + '\'' +
                ", mDate='" + mDate + '\'' +
                ", WbWirePartNo='" + WbWirePartNo + '\'' +
                ", WbWireProdName='" + WbWireProdName + '\'' +
                ", WbWireSpec='" + WbWireSpec + '\'' +
                ", WbBallUnit='" + WbBallUnit + '\'' +
                ", WbBallAmount='" + WbBallAmount + '\'' +
                ", SensorType='" + SensorType + '\'' +
                ", SensorPartNo='" + SensorPartNo + '\'' +
                ", SensorProdName='" + SensorProdName + '\'' +
                ", SensorSpec='" + SensorSpec + '\'' +
                ", SensorTypeNew='" + SensorTypeNew + '\'' +
                ", UpdateTime='" + UpdateTime + '\'' +
                '}';
    }
}
