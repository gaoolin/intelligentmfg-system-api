package com.qtech.quartz.domain;

/**
 * @author : gaozhilin
 * @project : qtech-dosage-control-system
 * @email : gaoolin@gmail.com
 * @date : 2023/04/14 08:50:46
 * @description : TODO
 */


public class YieldInfo {

    private String day;
    private String rq;
    private String factoryName;
    private String workshopCode;
    private String partSpec;
    private String lineWorkshop;
    private String testStation;
    private String output;
    private String planQty;
    private String deviceQty;
    private String updateTime;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRq() {
        return rq;
    }

    public void setRq(String rq) {
        this.rq = rq;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getWorkshopCode() {
        return workshopCode;
    }

    public void setWorkshopCode(String workshopCode) {
        this.workshopCode = workshopCode;
    }

    public String getPartSpec() {
        return partSpec;
    }

    public void setPartSpec(String partSpec) {
        this.partSpec = partSpec;
    }

    public String getLineWorkshop() {
        return lineWorkshop;
    }

    public void setLineWorkshop(String lineWorkshop) {
        this.lineWorkshop = lineWorkshop;
    }

    public String getTestStation() {
        return testStation;
    }

    public void setTestStation(String testStation) {
        this.testStation = testStation;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getPlanQty() {
        return planQty;
    }

    public void setPlanQty(String planQty) {
        this.planQty = planQty;
    }

    public String getDeviceQty() {
        return deviceQty;
    }

    public void setDeviceQty(String deviceQty) {
        this.deviceQty = deviceQty;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "YieldInfo{" +
                "day='" + day + '\'' +
                ", rq='" + rq + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", workshopCode='" + workshopCode + '\'' +
                ", partSpec='" + partSpec + '\'' +
                ", lineWorkshop='" + lineWorkshop + '\'' +
                ", testStation='" + testStation + '\'' +
                ", output='" + output + '\'' +
                ", planQty='" + planQty + '\'' +
                ", deviceQty='" + deviceQty + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
