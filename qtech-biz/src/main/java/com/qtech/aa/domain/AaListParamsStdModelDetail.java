package com.qtech.aa.domain;

import com.qtech.common.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:32:04
 * desc   :
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class AaListParamsStdModelDetail extends AaListParams {
    private Long id;

    @Excel(name = "机型", prompt = "标准模版", sort = 1)
    private String prodType;

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
