package com.qtech.wb.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtech.common.annotation.Excel;

import java.util.Date;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/09 16:39:58
 * desc   :
 */


public class WbComparisonResult {

    @Excel(name = "盒子号")
    private String simId;

    @Excel(name = "时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dt;

    @Excel(name = "状态码")
    private Integer code;

    @Excel(name = "描述")
    private String description;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WbComparisonResult{" +
                "simId='" + simId + '\'' +
                ", dt=" + dt +
                ", code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
