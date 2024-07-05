package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsStdModelDetail;
import com.qtech.aa.mapper.AaListParamsStdModelDetailMapper;
import com.qtech.aa.service.IAaListParamsStdModelDetailService;
import com.qtech.aa.service.IAaListParamsStdModelInfoService;
import com.qtech.aa.utils.ReflectionUtils;
import com.qtech.common.core.redis.RedisCache;
import com.qtech.common.exception.biz.TooManyResultsException;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.common.utils.StringUtils;
import com.qtech.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.qtech.aa.utils.Constants.REDIS_COMPARISON_MODEL_KEY_PREFIX;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:39:15
 * desc   :
 */
@Slf4j
@Service
public class AaListParamsStdModelDetailServiceImpl implements IAaListParamsStdModelDetailService {

    @Autowired
    private AaListParamsStdModelDetailMapper aaListParamsStdModelDetailMapper;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private IAaListParamsStdModelInfoService aaListParamsStdModelInfoService;

    @Override
    public List<AaListParamsStdModelDetail> selectAaListParamsStdModelList(AaListParamsStdModelDetail aaListParamsStdModelDetail) {
        List<AaListParamsStdModelDetail> list = null;
        try {
            list = aaListParamsStdModelDetailMapper.selectAaListParamsStdModelList(aaListParamsStdModelDetail);
        } catch (Exception e) {
            log.error("查询数据库发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("查询数据库发生异常，请联系管理员！");
        }
        return list;
    }

    @Override
    public AaListParamsStdModelDetail selectOneAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail) {
        List<AaListParamsStdModelDetail> list = aaListParamsStdModelDetailMapper.selectAaListParamsStdModelList(aaListParamsStdModelDetail);
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                throw new TooManyResultsException(String.format("Expected one result (or null) to be returned by selectOne(), but found: %s", size));
            }
            return list.get(0);
        }
        return null;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public int insertAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail) {

        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
        aaListParamsStdModelDetail.setCreateBy(nickName);
        aaListParamsStdModelDetail.setCreateTime(DateUtils.getNowDate());
        try {
            return aaListParamsStdModelDetailMapper.insertAaListParamsStdModel(aaListParamsStdModelDetail);
        } catch (Exception e) {
            log.error("存储数据发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("存储数据发生异常，请联系管理员！");
        }
    }

    @Override
    public int batchInsert(List<AaListParamsStdModelDetail> paramsModelList) {
        return 0;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public int updateAaListParamsStdModel(AaListParamsStdModelDetail aaListParamsStdModelDetail) {

        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
        aaListParamsStdModelDetail.setUpdateBy(nickName);
        aaListParamsStdModelDetail.setUpdateTime(DateUtils.getNowDate());

        List<AaListParamsStdModelDetail> list = aaListParamsStdModelDetailMapper.selectAaListParamsStdModelList(aaListParamsStdModelDetail);
        if (CollectionUtils.isNotEmpty(list)) {
            redisCache.deleteObject(REDIS_COMPARISON_MODEL_KEY_PREFIX + list.get(0).getProdType());
        }

        int i = 0;
        try {
            i = aaListParamsStdModelDetailMapper.updateAaListParamsStdModel(aaListParamsStdModelDetail);
        } catch (Exception e) {
            log.error("修改数据发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("修改数据发生异常，请联系管理员！");
        }
        return i;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public int deleteAaListParamsStdModelByIds(List<Long> list) {

        list.forEach(id -> {
            AaListParamsStdModelDetail aaListParamsStdModelDetailParams = new AaListParamsStdModelDetail();
            aaListParamsStdModelDetailParams.setId(id);
            AaListParamsStdModelDetail res = selectOneAaListParamsStdModel(aaListParamsStdModelDetailParams);
            if (res != null) {
                redisCache.deleteObject(REDIS_COMPARISON_MODEL_KEY_PREFIX + res.getProdType());
            }
        });

        int i = 0;
        try {
            i = aaListParamsStdModelDetailMapper.deleteAaListParamsStdModelByIds(list);
        } catch (Exception e) {
            log.error("删除数据发生异常，请联系管理员！\n{}", e.getMessage());
            throw new RuntimeException("删除数据发生异常，请联系管理员！");
        }
        return i;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Map<String, Object> uploadManual(List<AaListParamsStdModelDetail> paramsModelList) {
        Map<String, Object> result = new HashMap<>();
        if (paramsModelList == null || paramsModelList.isEmpty()) {
            result.put("flag", "0");
            result.put("msg", "Total: 0");
            return result;
        }

        int totalCount = paramsModelList.size();
        int successCount = 0;
        int failureCount = 0;
        int duplicateCount = 0;

        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
        for (AaListParamsStdModelDetail detail : paramsModelList) {
            detail.setCreateBy(nickName);
            detail.setCreateTime(DateUtils.getNowDate());
            try {
                int exists = aaListParamsStdModelDetailMapper.checkIfExists(detail);
                if (exists > 0) {
                    duplicateCount++;
                    continue;
                }

                ReflectionUtils.getAllDeclaredFields(AaListParamsStdModelDetail.class)
                        .forEach(field -> {
                            field.setAccessible(true);
                            if (field.getType().equals(String.class)) {
                                try {
                                    String value = (String) field.get(detail);
                                    if (StringUtils.isBlank(value)) {
                                        field.set(detail, null);
                                    } else {
                                        field.set(detail, StringUtils.trim(value));
                                    }
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });

                int insertCount = aaListParamsStdModelDetailMapper.insertAaListParamsStdModel(detail);
                aaListParamsStdModelInfoService.insertAaListParamsStdModelInfoByUpload(detail);
                if (insertCount > 0) {
                    successCount++;
                } else {
                    failureCount++;
                }
            } catch (Exception e) {
                log.error("处理数据发生异常：{}", e.getMessage());
                failureCount++;
            }
        }

        boolean isAllSuccess = (successCount == totalCount);

        result.put("flag", isAllSuccess);
        StringBuilder msg = new StringBuilder("Total: " + totalCount);
        if (successCount > 0) {
            msg.append(", Success: ").append(successCount);
        }
        if (failureCount > 0) {
            msg.append(", Failure: ").append(failureCount);
        }
        if (duplicateCount > 0) {
            msg.append(", Duplicate: ").append(duplicateCount);
        }
        result.put("msg", msg.toString());

        return result;
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}, propagation = Propagation.REQUIRES_NEW)
    @Override
    public Map<String, Object> uploadOnline(AaListParamsStdModelDetail aaListParamsStdModelDetail) {
        List<AaListParamsStdModelDetail> list = Collections.singletonList(aaListParamsStdModelDetail);
        return uploadManual(list);
    }
}
