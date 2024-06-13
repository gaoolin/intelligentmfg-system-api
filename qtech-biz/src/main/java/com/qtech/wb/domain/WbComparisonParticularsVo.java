package com.qtech.wb.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 14:04:07
 * desc   :
 */


public class WbComparisonParticularsVo extends BaseEntity {

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

    @Excel(name = "时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dt;

    @Excel(name = "代码")
    private int code;

    @Excel(name = "描述")
    private String description;

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

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "WbComparisonParticularsVo{" +
                "companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", eqId='" + eqId + '\'' +
                ", mcId='" + mcId + '\'' +
                ", prodType='" + prodType + '\'' +
                ", dt=" + dt +
                ", code=" + code +
                ", description='" + description + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
