package com.qtech.eqn.controller;

import com.qtech.eqn.domain.EqNetworking;
import com.qtech.eqn.domain.EqRemoteStatus;
import com.qtech.eqn.service.IEqNetworkingService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.R;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.poi.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/01/19 08:43:28
 * desc   :
 */

@RestController
@RequestMapping("/eqn/status")
public class EqNetworkingController extends BaseController {

    @Autowired
    private IEqNetworkingService eqNetworkingService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public TableDataInfo list(EqRemoteStatus eqRemoteStatus) {
        startPage();
        List<EqRemoteStatus> list = eqNetworkingService.selectEqNetworkingList(eqRemoteStatus);
        return getDataTable(list);
    }

    @RequestMapping(value = "factoryNames")
    public R getFactoryNames() {
        List<EqNetworking> list = eqNetworkingService.getFactoryNames();
        return R.ok(list);
    }

    @RequestMapping(value = "workShopNames")
    public R getWorkshopNames(EqNetworking eqNetworking) {
        List<EqNetworking> list = eqNetworkingService.getWorkshopNames(eqNetworking);
        return R.ok(list);
    }

    @RequestMapping(value = "offlineEqs", method = RequestMethod.GET)
    public TableDataInfo offlineEqs(EqNetworking eqNetworking) {
        startPage();
        List<EqNetworking> list = eqNetworkingService.selectEqNetworkingOfflineList(eqNetworking);
        return getDataTable(list);
    }

    @Log(title = "设备联网明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EqRemoteStatus eqRemoteStatus)
    {
        if (Optional.ofNullable(eqRemoteStatus.getLabel()).isPresent() && eqRemoteStatus.getLabel() == 1) {
            EqNetworking eqNetworking = new EqNetworking();
            BeanUtils.copyProperties(eqRemoteStatus, eqNetworking);
            List<EqNetworking> list = eqNetworkingService.selectEqNetworkingOfflineList(eqNetworking);
            ExcelUtil<EqNetworking> util = new ExcelUtil<EqNetworking>(EqNetworking.class);
            util.exportExcel(response, list, "设备未联网明细");
        } else {
            List<EqRemoteStatus> list = eqNetworkingService.selectEqNetworkingList(eqRemoteStatus);
            ExcelUtil<EqRemoteStatus> util = new ExcelUtil<EqRemoteStatus>(EqRemoteStatus.class);
            util.exportExcel(response, list, "设备联网明细");
        }
    }

    @RequestMapping(value = "/agg", method = RequestMethod.GET)
    public TableDataInfo selectEqNetworkingAgg(EqNetworking eqNetworking) {
        List<EqNetworking> list = eqNetworkingService.selectEqNetworkingAgg(eqNetworking);
        return getDataTable(list);
    }
}
