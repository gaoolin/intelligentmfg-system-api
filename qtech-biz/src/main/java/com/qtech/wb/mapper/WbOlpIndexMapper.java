package com.qtech.wb.mapper;

import com.qtech.wb.domain.WbOlpOverview;
import com.qtech.wb.vo.WbOlpChkVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/09/01 12:20:27
 * desc   :
 */

@Repository
public interface WbOlpIndexMapper {
    public List<WbOlpChkVo> selectFactoryNameList();

    public List<WbOlpChkVo> selectWorkShopNameList(WbOlpChkVo wbOlpChkVo);

}
