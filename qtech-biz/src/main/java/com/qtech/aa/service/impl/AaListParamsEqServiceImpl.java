package com.qtech.aa.service.impl;

import com.qtech.aa.domain.AaListParamsEq;
import com.qtech.aa.mapper.AaListParamsEqMapper;
import com.qtech.aa.service.IAaListParamsEqService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import com.qtech.common.exception.biz.TooManyResultsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static com.qtech.aa.utils.Constants.EQ_REVERSE_IGNORE_SIM_PREFIX;
import static com.qtech.common.utils.SecurityUtils.getLoginUser;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/19 10:06:06
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.SLAVE)
@Service
public class AaListParamsEqServiceImpl implements IAaListParamsEqService {

    private final AaListParamsEqMapper aaListParamsEqMapper;
    private final RedisTemplate<String, String> stringRedisTemplate;

    public AaListParamsEqServiceImpl(AaListParamsEqMapper aaListParamsEqMapper, RedisTemplate<String, String> stringRedisTemplate) {
        this.aaListParamsEqMapper = aaListParamsEqMapper;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public List<AaListParamsEq> selectAaListParamsEqList(AaListParamsEq aaListParamsEq) {
        try {
            return aaListParamsEqMapper.selectAaListParamsEqList(aaListParamsEq);
        } catch (Exception e) {
            // 更具体的异常处理
            if (e instanceof NullPointerException) {
                log.error("NullPointerException in selectAaListParamsEqList: {}", e.getMessage());
                throw new RuntimeException("查询后台数据库时出现空指针异常，请检查参数是否为空！");
            } else if (e instanceof IllegalArgumentException) {
                log.error("IllegalArgumentException in selectAaListParamsEqList: {}", e.getMessage());
                throw new RuntimeException("查询后台数据库时参数非法，请检查输入参数！");
            } else {
                log.error("selectAaListParamsEqList error", e);
                throw new RuntimeException("查询后台数据库发生异常，请联系管理员！");
            }
        }
    }

    @Override
    public AaListParamsEq selectOneAaListParamsEq(AaListParamsEq aaListParamsEq) {
        List<AaListParamsEq> list = aaListParamsEqMapper.selectAaListParamsEqList(aaListParamsEq);
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                log.error("selectOneAaListParamsEq error, size > 1");
                throw new TooManyResultsException("selectOneAaListParamsEq error, size > 1");
            }
            return list.get(0);
        }
        return null;
    }

    @Override
    public AaListParamsEq selectAaListParamsEqById(String id) {
        try {
            return aaListParamsEqMapper.selectAaListParamsEqById(id);
        } catch (Exception e) {
            log.error("selectAaListParamsEqById error", e);
            throw new RuntimeException("查询后台数据库发生异常，请联系管理员！");
        }
    }

    @Override
    public int editAaListParamsEq(AaListParamsEq aaListParamsEq) {
        try {
            Integer status = aaListParamsEq.getStatus();
            if (status == null) {
                throw new RuntimeException("status can not be updated");
            } else if (status == 1) {
                stringRedisTemplate.opsForValue().set(EQ_REVERSE_IGNORE_SIM_PREFIX + aaListParamsEq.getSimId(), "true");
            } else if (status == 0) {
                stringRedisTemplate.delete(EQ_REVERSE_IGNORE_SIM_PREFIX + aaListParamsEq.getSimId());
            } else {
                throw new RuntimeException("unknown status");
            }
            return aaListParamsEqMapper.editAaListParamsEq(aaListParamsEq);
        } catch (Exception e) {
            log.error("editAaListParamsEq error", e);
            throw new RuntimeException("查询后台数据库发生异常，请联系管理员！");
        }
    }

    /**
     * @param aaListParamsEq
     * @return int
     * @description 主要用于插入数据和更新除了状态以外的数据
     */
    @Override
    public int upsetAaListParamsEq(AaListParamsEq aaListParamsEq) {
        if (aaListParamsEq != null) {
            aaListParamsEq.setUpdateTime(Date.from(Instant.now()));
            aaListParamsEq.setOpCnt((aaListParamsEq.getOpCnt() == null ? 0 : aaListParamsEq.getOpCnt()) + 1);
            String nickName = getLoginUser().getUser().getNickName();
            aaListParamsEq.setUpdateBy(nickName);
            stringRedisTemplate.opsForValue().set(EQ_REVERSE_IGNORE_SIM_PREFIX + aaListParamsEq.getSimId(), "true");
            try {
                return aaListParamsEqMapper.upsertAaListParamsEq(aaListParamsEq);
            } catch (Exception e) {
                log.error("upsetAaListParamsEq error", e);
                throw new RuntimeException("查询后台数据库发生异常，请联系管理员！");
            }
        }
        return 0;
    }

    @Override
    @Scheduled(cron = "0 0 21 * * ?") // 每天晚上21:00执行
    public void cleanupDayShiftIgnores() {
        stringRedisTemplate.delete(EQ_REVERSE_IGNORE_SIM_PREFIX + "*");
    }

    @Override
    @Scheduled(cron = "0 0 9 * * ?") // 每天早上09:00执行
    public void cleanupNightShiftIgnores() {
        stringRedisTemplate.delete(EQ_REVERSE_IGNORE_SIM_PREFIX + "*");
    }

    @Override
    public void cleanupIgnores() {

    }

    @Override
    public Boolean isExist(AaListParamsEq aaListParamsEq) {
        AaListParamsEq res = selectAaListParamsEqById(aaListParamsEq.getSimId());
        return res != null;
    }
}
