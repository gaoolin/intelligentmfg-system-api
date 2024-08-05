package com.qtech.aa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtech.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/02 15:08:52
 * desc   :
 */

public class AaSoftwareManagement extends BaseEntity {

    private Long id;

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    private String prodType;
    private String fileName;
    private String newFileName;
    private String version;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uploadDate;
    private String path;
    private String size;
    private Integer status;
    private String author;
    private String factoryName;
    private String remark;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AaSoftwareManagement{" +
                "id=" + id +
                ", prodType='" + prodType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", newFileName='" + newFileName + '\'' +
                ", version='" + version + '\'' +
                ", uploadDate=" + uploadDate +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", status=" + status +
                ", author='" + author + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
