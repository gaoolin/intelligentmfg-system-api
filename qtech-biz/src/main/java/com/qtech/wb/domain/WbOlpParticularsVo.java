package com.qtech.wb.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/16 14:04:07
 * desc   :
 */

@Data
public class WbOlpParticularsVo extends BaseEntity {

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
    private Integer code;

    @Excel(name = "描述")
    private String description;

    private String flag;
}
