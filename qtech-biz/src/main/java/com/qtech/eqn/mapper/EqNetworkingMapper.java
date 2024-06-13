package com.qtech.eqn.mapper;

import com.qtech.eqn.domain.EqNetworking;
import com.qtech.eqn.domain.EqRemoteStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/19 08:45:32
 * desc   :
 */

@Repository
public interface EqNetworkingMapper {

    public List<EqRemoteStatus> selectEqNetworkingList(EqRemoteStatus eqRemoteStatus);

    public List<EqNetworking> getFactoryNames();

    public List<EqNetworking> getWorkshopNames(EqNetworking eqNetworking);

    public List<EqNetworking> selectEqNetworkingOfflineList(EqNetworking eqNetworking);

    public List<EqNetworking> selectEqNetworkingAgg(EqNetworking eqNetworking);
}
