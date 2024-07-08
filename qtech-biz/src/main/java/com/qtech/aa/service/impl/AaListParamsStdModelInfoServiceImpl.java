package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsStdModelDetail;
import com.qtech.aa.domain.AaListParamsStdModelInfo;
import com.qtech.aa.mapper.AaListParamsStdModelDetailMapper;
import com.qtech.aa.mapper.AaListParamsStdModelInfoMapper;
import com.qtech.aa.service.IAaListParamsStdModelInfoService;
import com.qtech.aa.utils.ModelDetailConvertToModelInfo;
import com.qtech.common.exception.biz.TooManyResultsException;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/07/02 14:01:06
 * desc   :
 */

@Slf4j
@Service
public class AaListParamsStdModelInfoServiceImpl implements IAaListParamsStdModelInfoService {

    @Autowired
    private AaListParamsStdModelInfoMapper aaListParamsStdModelInfoMapper;

    @Autowired
    private AaListParamsStdModelDetailMapper aaListParamsStdModelDetailMapper;

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public List<AaListParamsStdModelInfo> selectAaListParamsStdModelInfoList(AaListParamsStdModelInfo aaListParamsStdModelInfo) {
        try {
            return aaListParamsStdModelInfoMapper.selectAaListParamsStdModelInfoList(aaListParamsStdModelInfo);
        } catch (Exception e) {
            log.error("selectAaListParamsStdModelInfoList:", e);
            throw new RuntimeException("查询数据库发生异常，请联系管理员。");
        }
    }

    @Override
    public AaListParamsStdModelInfo selectOneAaListParamsStdModelInfo(AaListParamsStdModelInfo aaListParamsStdModelInfo) {
        List<AaListParamsStdModelInfo> list = aaListParamsStdModelInfoMapper.selectAaListParamsStdModelInfoList(aaListParamsStdModelInfo);
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
    public int insertAaListParamsStdModelInfo(Object entity) {
        try {
            int result = 0;
            if (entity.getClass().equals(AaListParamsStdModelInfo.class)) {
                AaListParamsStdModelInfo modelInfo = (AaListParamsStdModelInfo) entity;
                result = aaListParamsStdModelInfoMapper.insertAaListParamsStdModelInfo(modelInfo);
            } else if (entity.getClass().equals(AaListParamsStdModelDetail.class)) {
                AaListParamsStdModelDetail modelDetail = (AaListParamsStdModelDetail) entity;
                AaListParamsStdModelInfo param = ModelDetailConvertToModelInfo.doConvert(modelDetail);
                param.setCreateBy(sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName());
                param.setCreateTime(DateUtils.getNowDate());
                try {
                    result = aaListParamsStdModelInfoMapper.insertAaListParamsStdModelInfo(param);
                } catch (Exception e) {
                    log.error("insertAaListParamsStdModelInfoByUpload:", e);
                    throw new RuntimeException("保存到数据库发生异常，请连线管理员！");
                }
            } else {
                throw new IllegalArgumentException("Unsupported entity type: " + entity.getClass().getName());
            }
            return result;
        } catch (Exception e) {
            log.error("insertAaListParamsStdModelInfo:", e);
            throw new RuntimeException("保存到数据库发生异常，请连线管理员！");
        }
    }

    @Override
    public int updateAaListParamsStdModelInfo(AaListParamsStdModelInfo aaListParamsStdModelInfo) {

        aaListParamsStdModelInfo.setUpdateBy(sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName());
        aaListParamsStdModelInfo.setUpdateTime(DateUtils.getNowDate());
        try {
            return aaListParamsStdModelInfoMapper.updateAaListParamsStdModelInfo(aaListParamsStdModelInfo);
        } catch (Exception e) {
            log.error("updateAaListParamsStdModelInfo:", e);
            throw new RuntimeException("修改数据发生异常，请联系管理员。");
        }
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public int deleteAaListParamsStdModelInfoByIds(Long[] list) {
        try {
            for (Long l : list) {
                AaListParamsStdModelInfo param = new AaListParamsStdModelInfo();
                param.setId(l);
                AaListParamsStdModelInfo result = selectOneAaListParamsStdModelInfo(param);
                if (result != null) {
                    String prodType = result.getProdType();
                    AaListParamsStdModelDetail paramDetail = new AaListParamsStdModelDetail();
                    paramDetail.setProdType(prodType);
                    aaListParamsStdModelDetailMapper.deleteAaListParamsStdModel(paramDetail);
                }
            }

            return aaListParamsStdModelInfoMapper.deleteAaListParamsStdModelInfoByIds(list);
        } catch (Exception e) {
            log.error("deleteAaListParamsStdModelInfoByIds:", e);
            throw new RuntimeException("删除数据发生异常，请联系管理员。");
        }
    }
}
