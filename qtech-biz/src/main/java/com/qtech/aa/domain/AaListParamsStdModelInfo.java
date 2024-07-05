package com.qtech.aa.domain;

import com.qtech.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/02 13:37:00
 * desc   :
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class AaListParamsStdModelInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String prodType;
    private Integer listParams;
    private Integer itemParams;
    private Integer status;
    private String provider;
    private String belongTo;
}
