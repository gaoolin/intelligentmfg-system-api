package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsStdModel;
import com.qtech.aa.mapper.AaListParamsStdModelMapper;
import com.qtech.aa.service.IAaListParamsStdModelService;
import com.qtech.common.exception.biz.TooManyResultsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:39:15
 * desc   :
 */
@Slf4j
@Service
public class AaListParamsStdModelServiceImpl implements IAaListParamsStdModelService {

    @Autowired
    private AaListParamsStdModelMapper aaListParamsStdModelMapper;


    @Override
    public List<AaListParamsStdModel> selectAaListParamsStdModelList(AaListParamsStdModel aaListParamsStdModel) {
        List<AaListParamsStdModel> list = null;
        try {
            list = aaListParamsStdModelMapper.selectAaListParamsStdModelList(aaListParamsStdModel);
        } catch (Exception e) {
            log.error("查询数据库发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("查询数据库发生异常，请联系管理员！");
        }
        return list;
    }

    @Override
    public AaListParamsStdModel selectOneAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel) {
        List<AaListParamsStdModel> list = aaListParamsStdModelMapper.selectAaListParamsStdModelList(aaListParamsStdModel);
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                throw new TooManyResultsException(String.format("Expected one result (or null) to be returned by selectOne(), but found: %s", size));
            }
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insertAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel) {
        try {
            return aaListParamsStdModelMapper.insertAaListParamsStdModel(aaListParamsStdModel);
        } catch (Exception e) {
            log.error("存储数据发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("存储数据发生异常，请联系管理员！");
        }
    }

    @Override
    public int updateAaListParamsStdModel(AaListParamsStdModel aaListParamsStdModel) {
        int i = 0;
        try {
            i = aaListParamsStdModelMapper.updateAaListParamsStdModel(aaListParamsStdModel);
        } catch (Exception e) {
            log.error("修改数据发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("修改数据发生异常，请联系管理员！");
        }
        return i;
    }

    @Override
    public int deleteAaListParamsStdModelByIds(List<Long> list) {
        int i = 0;
        try {
            i = aaListParamsStdModelMapper.deleteAaListParamsStdModelByIds(list);
        } catch (Exception e) {
            log.error("删除数据发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("删除数据发生异常，请联系管理员！");
        }
        return i;
    }
}
