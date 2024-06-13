package com.qtech.eqn.service.impl;

import com.qtech.eqn.domain.EqNetworking;
import com.qtech.eqn.domain.EqRemoteStatus;
import com.qtech.eqn.mapper.EqNetworkingMapper;
import com.qtech.eqn.service.IEqNetworkingService;
import com.qtech.common.annotation.DataSource;
import com.qtech.common.enums.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/19 08:44:37
 * desc   :
 */

@Slf4j
@DataSource(DataSourceType.EIGHTH)
@Service
public class EqNetworkingServiceImpl implements IEqNetworkingService {

    @Autowired
    private EqNetworkingMapper eqNetworkingMapper;

    @Override
    public List<EqRemoteStatus> selectEqNetworkingList(EqRemoteStatus eqRemoteStatus) {
        try {
            return eqNetworkingMapper.selectEqNetworkingList(eqRemoteStatus);
        } catch (Exception e) {
            log.error("查询数据库失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public List<EqNetworking> getFactoryNames() {
        try {
            return eqNetworkingMapper.getFactoryNames();
        } catch (Exception e) {
            log.error("查询数据库失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public List<EqNetworking> getWorkshopNames(EqNetworking eqNetworking) {
        try {
            return eqNetworkingMapper.getWorkshopNames(eqNetworking);
        } catch (Exception e) {
            log.error("查询数据库失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public List<EqNetworking> selectEqNetworkingOfflineList(EqNetworking eqNetworking) {
        try {
            return eqNetworkingMapper.selectEqNetworkingOfflineList(eqNetworking);
        } catch (Exception e) {
            log.error("查询数据库失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }

    @Override
    public List<EqNetworking> selectEqNetworkingAgg(EqNetworking eqNetworking) {
        try {
            return eqNetworkingMapper.selectEqNetworkingAgg(eqNetworking);
        } catch (Exception e) {
            log.error("查询数据库失败", e);
            throw new RuntimeException("查询数据库失败，请联系系统负责人!");
        }
    }
}
