package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsParsed;
import com.qtech.aa.domain.AaListParamsStdModelDetail;
import com.qtech.aa.mapper.AaListParamsParsedDetailMapper;
import com.qtech.aa.service.IAaListParamsParsedDetailService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/05 15:59:10
 * desc   :
 */

@DataSource(DataSourceType.SLAVE)
@Service
public class AaListParamsParsedDetailServiceImpl implements IAaListParamsParsedDetailService {
    private static final Logger logger = LoggerFactory.getLogger(AaListParamsParsedDetailServiceImpl.class);

    @Autowired
    private AaListParamsParsedDetailMapper aaListParamsParsedDetailMapper;

    @Override
    public List<AaListParamsParsed> selectAaListParamsParsedDetailList(AaListParamsParsed aaListParamsParsed) {
        List<AaListParamsParsed> list = null;
        try {
            list = aaListParamsParsedDetailMapper.selectAaListParamsParsedDetailList(aaListParamsParsed);
            for (AaListParamsParsed listParamsParsed : list) {
                System.out.println(listParamsParsed);
            }
        } catch (Exception e) {
            logger.error("selectAaListParamsParsedDetailList error", e);
        }
        return list;
    }
}
