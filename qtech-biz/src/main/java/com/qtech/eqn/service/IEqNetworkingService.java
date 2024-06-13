package com.qtech.eqn.service;

import com.qtech.eqn.domain.EqNetworking;
import com.qtech.eqn.domain.EqRemoteStatus;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/19 08:44:05
 * desc   :
 */


public interface IEqNetworkingService {

    public List<EqRemoteStatus> selectEqNetworkingList(EqRemoteStatus eqRemoteStatus);

    public List<EqNetworking> getFactoryNames();

    public List<EqNetworking> getWorkshopNames(EqNetworking eqNetworking);

    public List<EqNetworking> selectEqNetworkingOfflineList(EqNetworking eqNetworking);

    public List<EqNetworking> selectEqNetworkingAgg(EqNetworking eqNetworking);
}
