package com.qtech.aa.domain;

import com.qtech.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/02 15:08:52
 * desc   :
 */


@Data
public class AaStdProgramManagement extends BaseEntity {
    private Long id;
    private String prodType;
    private String fileName;
    private String newFileName;
    private String version;
    private String size;
    private Integer status;
    private Long downloadCnt;
    private String factoryName;
    private Integer flag;
}
