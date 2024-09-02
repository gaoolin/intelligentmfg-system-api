package com.qtech.aa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;

import java.io.IOException;
import java.util.Date;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/19 10:07:05
 * desc   :
 */

public class AaListParamsEq extends BaseEntity {
    private Long id;
    @Excel(name = "厂区")
    private String factoryName;
    @Excel(name = "车间")
    private String groupName;
    @Excel(name = "设备编号")
    private String eqId;
    @Excel(name = "机台号")
    private String mcId;
    @Excel(name = "盒子号")
    private String simId;
    @Excel(name = "机种")
    private String prodType;
    // @JsonSerialize(using = IntegerToStringSerializer.class)
    @Excel(name = "状态", dictType = "aa_list_params_ignore_status", defaultValue = "受控")
    private Integer status;
    private String source;
    @Excel(name = "操作次数")
    private Integer opCnt;
    @Excel(name = "操作人")
    private String updateBy;
    @Excel(name = "上次操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getOpCnt() {
        return opCnt;
    }

    public void setOpCnt(Integer opCnt) {
        this.opCnt = opCnt;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AaListParamsEq{" +
                "id=" + id +
                ", factoryName='" + factoryName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", eqId='" + eqId + '\'' +
                ", mcId='" + mcId + '\'' +
                ", simId='" + simId + '\'' +
                ", prodType='" + prodType + '\'' +
                ", status=" + status +
                ", source='" + source + '\'' +
                ", opCnt=" + opCnt +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    static class IntegerToStringSerializer extends JsonSerializer<Integer> {
        @Override
        public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            // gen.writeString("prefix_" + value + "_suffix");
            gen.writeString(value + "");
        }
    }
}
