package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsStdModelDetail;
import com.qtech.common.utils.poi.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/05 10:04:09
 * desc   :
 */


class AaListParamsStdModelDetailControllerTest {

    @Test
    public void testExportTemplate() throws IOException {
        MockHttpServletResponse response = new MockHttpServletResponse();
        ExcelUtil<AaListParamsStdModelDetail> util = new ExcelUtil<>(AaListParamsStdModelDetail.class);
        util.importTemplateExcel(response, "AA-List参数导入模版");

        // 检查响应内容
        byte[] content = response.getContentAsByteArray();
        assertThat(content).isNotEmpty();

        // 验证Excel文件内容
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            List<String> expectedHeaders = getExpectedHeaders();
            List<String> actualHeaders = new ArrayList<>();

            for (Cell cell : headerRow) {
                actualHeaders.add(cell.getStringCellValue());
            }

            // 验证所有期望的字段都在Excel中
            assertThat(actualHeaders).containsAll(expectedHeaders);
        }
    }

    private List<String> getExpectedHeaders() {
        List<String> headers = new ArrayList<>();
        headers.add("clampOnOff");
        headers.add("destroyStart");
        headers.add("init");
        headers.add("grab");
        headers.add("reInit");
        headers.add("senserReset");
        headers.add("sid");
        headers.add("vcmHall");
        headers.add("vcmInit");
        headers.add("vcmHall2");
        headers.add("vcmPowerOff");
        headers.add("vcmPowerOn");
        headers.add("vcmTop");
        headers.add("vcmTopHall");
        headers.add("vcmZ");
        headers.add("vcmZHall");
        headers.add("vcmOisInit");
        headers.add("chartAlignment1");
        headers.add("AA1");
        headers.add("AA2");
        headers.add("mtfCheck");
        headers.add("AA3");
        headers.add("mtfCheck2");
        headers.add("lpOn");
        headers.add("lpOcCheck");
        headers.add("lpOc");
        headers.add("lpOnBlemish");
        headers.add("blemish");
        headers.add("lpOff");
        headers.add("chartAlignment");
        headers.add("vcmMoveToZ");
        headers.add("delay");
        headers.add("vcmPowerOffCheck");
        headers.add("recordPosition");
        headers.add("dispense");
        headers.add("epoxyInspectionAuto");
        headers.add("epoxyInspection");
        headers.add("backToPosition");
        headers.add("uvon");
        headers.add("yLevel");
        headers.add("uvoff");
        headers.add("gripperOpen");
        headers.add("saveOc");
        headers.add("saveMtf");
        headers.add("destroy");
        headers.add("moveToBlemishPos");
        headers.add("mtfCheck3");
        headers.add("mtfOffAxisCheck1");
        headers.add("mtfOffAxisCheck2");
        headers.add("mtfOffAxisCheck3");
        headers.add("lpBlemish");
        headers.add("chartAlignment2");
        headers.add("vcmMoveToZPos");
        headers.add("zOffset");
        headers.add("openCheck");
        headers.add("roiCc");
        headers.add("roiUl");
        headers.add("roiUr");
        headers.add("roiLl");
        headers.add("roiLr");
        headers.add("result1");
        headers.add("result2");
        headers.add("result3");
        headers.add("result4");
        headers.add("result5");
        headers.add("result6");
        headers.add("result7");
        headers.add("result8");
        headers.add("result9");
        headers.add("result10");
        headers.add("result11");
        headers.add("result12");
        headers.add("result13");
        headers.add("result14");
        headers.add("result15");
        headers.add("result16");
        headers.add("result17");
        headers.add("result18");
        headers.add("result19");
        headers.add("result20");
        headers.add("result21");
        headers.add("result22");
        headers.add("result23");
        headers.add("result24");
        headers.add("result25");
        headers.add("result26");
        headers.add("result27");
        headers.add("result28");
        headers.add("result29");
        headers.add("result30");
        headers.add("result31");
        headers.add("result32");
        headers.add("result33");
        headers.add("result34");
        headers.add("result35");
        headers.add("result36");
        headers.add("result37");
        headers.add("result38");
        headers.add("result39");
        headers.add("result40");
        headers.add("result41");
        headers.add("result42");
        headers.add("result43");
        headers.add("result44");
        headers.add("result45");
        headers.add("result46");
        headers.add("result47");
        headers.add("result48");
        headers.add("result49");
        headers.add("result50");
        headers.add("result51");
        headers.add("result52");
        headers.add("xResMin");
        headers.add("xResMax");
        headers.add("yResMin");
        headers.add("yResMax");
        headers.add("epoxyInspectionInterval");
        headers.add("resultCheckMin");
        headers.add("resultCheckMax");
        headers.add("prodType");

        return headers;
    }
}