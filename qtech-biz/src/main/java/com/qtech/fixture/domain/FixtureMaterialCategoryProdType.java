package com.qtech.fixture.domain;

import com.qtech.common.core.domain.BaseEntity;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/11/21 10:35:57
 * desc   :
 */


public class FixtureMaterialCategoryProdType extends BaseEntity {

    private Long id;

    private Long mId;

    private Long cId;

    private Long pId;

    private Long deptId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public Long getCId() {
        return cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FixtureMaterialCategoryProdType{" +
                "id=" + id +
                ", mId=" + mId +
                ", cId=" + cId +
                ", pId=" + pId +
                ", deptId=" + deptId +
                ", userId=" + userId +
                '}';
    }
}
