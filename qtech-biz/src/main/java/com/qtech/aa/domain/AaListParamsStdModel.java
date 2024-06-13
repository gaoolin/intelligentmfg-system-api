package com.qtech.aa.domain;

import com.qtech.common.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:32:04
 * desc   :
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class AaListParamsStdModel extends AaListParams {
    private Long id;
    @Excel(name = "机型", cellType = Excel.ColumnType.STRING, prompt = "标准模版")
    private String prodType;
}
