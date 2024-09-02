package com.qtech.aa.utils;

import java.util.Arrays;
import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/04 09:25:15
 * desc   :
 */


public class Constants {

    public static final String REDIS_COMPARISON_MODEL_KEY_PREFIX = "qtech:aa:list:params:";
    public static final String REDIS_COMPARISON_MODEL_INFO_KEY_SUFFIX = "qtech:aa:list:params:info:";
    public static final String EQ_REVERSE_IGNORE_SIM_PREFIX = "qtech:im:chk:ignored:";

    // 需和比对程序同步
    public static final List<String> PROPERTIES_TO_COMPARE = Arrays.asList(
            "clampOnOff",
            "destroyStart",
            "init",
            "grab",
            "reInit",
            "senserReset",
            "sid",
            "vcmHall",
            "vcmInit",
            "vcmHall2",
            "vcmPowerOff",
            "vcmPowerOn",
            "vcmTop",
            "vcmTopHall",
            "vcmZ",
            "vcmZHall",
            "vcmOisInit",
            "chartAlignment1",
            "AA1",
            "AA2",
            "mtfCheck",
            "AA3",
            "mtfCheck2",
            "lpOn",
            "lpOcCheck",
            "lpOc",
            "lpOnBlemish",
            "blemish",
            "lpOff",
            "chartAlignment",
            "vcmMoveToZ",
            "delay",
            "vcmPowerOffCheck",
            "recordPosition",
            "dispense",
            "epoxyInspectionAuto",
            "epoxyInspection",
            "backToPosition",
            "uvon",
            "yLevel",
            "uvoff",
            "gripperOpen",
            "saveOc",
            "saveMtf",
            "destroy",
            "moveToBlemishPos",
            "mtfCheck3",
            "mtfOffAxisCheck1",
            "mtfOffAxisCheck2",
            "mtfOffAxisCheck3",
            "lpBlemish",
            "chartAlignment2",
            "vcmMoveToZPos",
            "openCheck",
            "zOffset"
            // ... 其他需要比较是否相等的属性名称
    );

    public static final List<String> PROPERTIES_TO_COMPUTE = Arrays.asList(
            "roiCc", "roiUl", "roiUr", "roiLl", "roiLr",
            "result1", "result2", "result3", "result4", "result5", "result6", "result7", "result8", "result9", "result10",
            "result11", "result12", "result13", "result14", "result15", "result16", "result17", "result18", "result19", "result20",
            "result21", "result22", "result23", "result24", "result25", "result26", "result27", "result28", "result29", "result30",
            "result31", "result32", "result33", "result34", "result35", "result36", "result37", "result38", "result39", "result40",
            "result41", "result42", "result43", "result44", "result45", "result46", "result47", "result48", "result49", "result50",
            "result51", "result52",
            "xResMin", "xResMax", "yResMin", "yResMax",
            "resultCheckMin", "resultCheckMax",
            "epoxyInspectionInterval"
    );
}
