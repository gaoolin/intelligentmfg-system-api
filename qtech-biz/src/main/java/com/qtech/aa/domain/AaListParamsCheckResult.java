package com.qtech.aa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/03 10:45:07
 * desc   :
 */


public class AaListParamsCheckResult extends BaseEntity {

    @Excel(name = "厂区名称")
    private String factoryName;
    @Excel(name = "车间名称")
    private String groupName;
    @Excel(name = "设备号")
    private String eqCode;
    @Excel(name = "机台号")
    private String mcId;
    @Excel(name = "机型")
    private String prodType;
    @Excel(name = "盒子号")
    private String simId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "点检时间")
    private Date checkDt;
    @Excel(name = "状态码")
    private Integer statusCode;
    @Excel(name = "描述")
    private String description;
    private Integer flag;

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getEqCode() {
        return eqCode;
    }

    public void setEqCode(String eqCode) {
        this.eqCode = eqCode;
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

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public Date getCheckDt() {
        return checkDt;
    }

    public void setCheckDt(Date checkDt) {
        this.checkDt = checkDt;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "AaListParamsCheckResult{" +
                "factoryName='" + factoryName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", eqCode='" + eqCode + '\'' +
                ", mcId='" + mcId + '\'' +
                ", prodType='" + prodType + '\'' +
                ", simId='" + simId + '\'' +
                ", checkDt=" + checkDt +
                ", statusCode=" + statusCode +
                ", description='" + description + '\'' +
                ", flag=" + flag +
                '}';
    }
}
