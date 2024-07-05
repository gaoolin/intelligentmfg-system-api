package com.qtech.aa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qtech.common.annotation.Excel;
import com.qtech.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:28:29
 * desc   :
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AaListParams extends BaseEntity {
    @Excel(name = "clampOnOff", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String clampOnOff;

    @Excel(name = "destroyStart", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String destroyStart;

    @Excel(name = "init", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String init;

    @Excel(name = "grab", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String grab;

    @Excel(name = "reInit", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String reInit;

    @Excel(name = "senserReset", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String senserReset;

    @Excel(name = "sid", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String sid;

    @Excel(name = "vcmHall", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmHall;

    @Excel(name = "vcmInit", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmInit;

    @Excel(name = "vcmHall2", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmHall2;

    @Excel(name = "vcmPowerOff", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmPowerOff;

    @Excel(name = "vcmPowerOn", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmPowerOn;

    @Excel(name = "vcmTop", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmTop;

    @Excel(name = "vcmTopHall", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmTopHall;

    @Excel(name = "vcmZ", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmZ;

    @Excel(name = "vcmZHall", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmZHall;

    @Excel(name = "vcmOisInit", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmOisInit;

    @Excel(name = "chartAlignment1", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String chartAlignment1;

    @JsonProperty("AA1")
    @Excel(name = "AA1", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String AA1;

    @JsonProperty("AA2")
    @Excel(name = "AA2", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String AA2;

    @JsonProperty("AA3")
    @Excel(name = "AA3", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String AA3;

    @Excel(name = "mtfCheck", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String mtfCheck;

    @Excel(name = "mtfCheck2", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String mtfCheck2;

    @Excel(name = "lpOn", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String lpOn;

    @Excel(name = "lpOcCheck", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String lpOcCheck;

    @Excel(name = "lpOc", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String lpOc;

    @Excel(name = "lpOnBlemish", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String lpOnBlemish;

    @Excel(name = "blemish", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String blemish;

    @Excel(name = "lpOff", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String lpOff;

    @Excel(name = "chartAlignment", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String chartAlignment;

    @Excel(name = "vcmMoveToZ", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmMoveToZ;

    @Excel(name = "delay", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String delay;

    @Excel(name = "vcmPowerOffCheck", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmPowerOffCheck;

    @Excel(name = "recordPosition", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String recordPosition;

    @Excel(name = "dispense", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String dispense;

    @Excel(name = "epoxyInspectionAuto", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String epoxyInspectionAuto;

    @Excel(name = "epoxyInspection", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String epoxyInspection;

    @Excel(name = "backToPosition", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String backToPosition;

    @Excel(name = "uvon", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String uvon;

    @JsonProperty("yLevel")
    @Excel(name = "yLevel", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String yLevel;

    @Excel(name = "uvoff", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String uvoff;

    @Excel(name = "gripperOpen", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String gripperOpen;

    @Excel(name = "saveOc", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String saveOc;

    @Excel(name = "saveMtf", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String saveMtf;

    @Excel(name = "destroy", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String destroy;

    @Excel(name = "moveToBlemishPos", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String moveToBlemishPos;

    @Excel(name = "mtfCheck3", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String mtfCheck3;

    @Excel(name = "mtfOffAxisCheck1", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String mtfOffAxisCheck1;

    @Excel(name = "mtfOffAxisCheck2", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String mtfOffAxisCheck2;

    @Excel(name = "mtfOffAxisCheck3", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String mtfOffAxisCheck3;

    @Excel(name = "lpBlemish", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String lpBlemish;

    @Excel(name = "chartAlignment2", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String chartAlignment2;

    @Excel(name = "vcmMoveToZPos", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String vcmMoveToZPos;

    @JsonProperty("zOffset")
    @Excel(name = "zOffset", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String zOffset;

    @Excel(name = "openCheck", cellType = Excel.ColumnType.STRING, prompt = "list")
    private String openCheck;

    // AA Item 指标
    @Excel(name = "roiCc", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String roiCc;

    @Excel(name = "roiUl", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String roiUl;

    @Excel(name = "roiUr", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String roiUr;

    @Excel(name = "roiLl", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String roiLl;

    @Excel(name = "roiLr", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String roiLr;

    // mtfCheck Item 指标
    @Excel(name = "result1", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result1;

    @Excel(name = "result2", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result2;

    @Excel(name = "result3", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result3;

    @Excel(name = "result4", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result4;

    @Excel(name = "result5", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result5;

    @Excel(name = "result6", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result6;

    @Excel(name = "result7", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result7;

    @Excel(name = "result8", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result8;

    @Excel(name = "result9", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result9;

    @Excel(name = "result10", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result10;

    @Excel(name = "result11", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result11;

    @Excel(name = "result12", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result12;

    @Excel(name = "result13", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result13;

    @Excel(name = "result14", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result14;

    @Excel(name = "result15", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result15;

    @Excel(name = "result16", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result16;

    @Excel(name = "result17", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result17;

    @Excel(name = "result18", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result18;

    @Excel(name = "result19", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result19;

    @Excel(name = "result20", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result20;

    @Excel(name = "result21", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result21;

    @Excel(name = "result22", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result22;

    @Excel(name = "result23", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result23;

    @Excel(name = "result24", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result24;

    @Excel(name = "result25", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result25;

    @Excel(name = "result26", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result26;

    @Excel(name = "result27", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result27;

    @Excel(name = "result28", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result28;

    @Excel(name = "result29", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result29;

    @Excel(name = "result30", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result30;

    @Excel(name = "result31", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result31;

    @Excel(name = "result32", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result32;

    @Excel(name = "result33", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result33;

    @Excel(name = "result34", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result34;

    @Excel(name = "result35", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result35;

    @Excel(name = "result36", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result36;

    @Excel(name = "result37", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result37;

    @Excel(name = "result38", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result38;

    @Excel(name = "result39", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result39;

    @Excel(name = "result40", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result40;

    @Excel(name = "result41", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result41;

    @Excel(name = "result42", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result42;

    @Excel(name = "result43", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result43;

    @Excel(name = "result44", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result44;

    @Excel(name = "result45", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result45;

    @Excel(name = "result46", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result46;

    @Excel(name = "result47", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result47;

    @Excel(name = "result48", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result48;

    @Excel(name = "result49", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result49;

    @Excel(name = "result50", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result50;

    @Excel(name = "result51", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result51;

    @Excel(name = "result52", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String result52;

    // chartAlignment Item 指标
    @JsonProperty("xResMin")
    @Excel(name = "xResMin", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String xResMin;

    @JsonProperty("xResMax")
    @Excel(name = "xResMax", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String xResMax;

    @JsonProperty("yResMin")
    @Excel(name = "yResMin", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String yResMin;

    @JsonProperty("yResMax")
    @Excel(name = "yResMax", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String yResMax;

    // EpoxyInspection Auto Item 指标
    @Excel(name = "epoxyInspectionInterval", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String epoxyInspectionInterval;

    // vcmZ Item 指标
    @Excel(name = "resultCheckMin", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String resultCheckMin;

    @Excel(name = "resultCheckMax", cellType = Excel.ColumnType.STRING, prompt = "item")
    private String resultCheckMax;
}
