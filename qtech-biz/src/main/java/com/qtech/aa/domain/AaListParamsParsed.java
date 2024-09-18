package com.qtech.aa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtech.common.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/05 16:30:04
 * desc   :
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class AaListParamsParsed extends AaListParams {
    @Excel(name = "盒子号")
    private String simId;

    @Excel(name = "机型")
    private String prodType;

    @Excel(name = "接收时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date receivedTime;

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}