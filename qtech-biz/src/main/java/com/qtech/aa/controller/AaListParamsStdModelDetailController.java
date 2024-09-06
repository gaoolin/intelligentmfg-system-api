package com.qtech.aa.controller;

import com.qtech.aa.domain.AaListParamsStdModelDetail;
import com.qtech.aa.service.IAaListParamsStdModelDetailService;
import com.qtech.common.annotation.Log;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.enums.BusinessType;
import com.qtech.common.utils.DateUtils;
import com.qtech.common.utils.SecurityUtils;
import com.qtech.common.utils.poi.ExcelUtil;
import com.qtech.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/06/04 14:25:30
 * desc   :
 */

@RestController
@RequestMapping("/aa/params/model/detail")
public class AaListParamsStdModelDetailController extends BaseController {

    @Autowired
    private IAaListParamsStdModelDetailService aaListParamsStdModelDetailService;
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public TableDataInfo list(AaListParamsStdModelDetail aaListParamsStdModelDetail) {
        startPage();
        List<AaListParamsStdModelDetail> list = aaListParamsStdModelDetailService.selectAaListParamsStdModelList(aaListParamsStdModelDetail);
        return getDataTable(list);
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
    public TableDataInfo getInfoById(@PathVariable Long id) {
        AaListParamsStdModelDetail param = new AaListParamsStdModelDetail();
        param.setId(id);
        AaListParamsStdModelDetail one = aaListParamsStdModelDetailService.selectOneAaListParamsStdModel(param);
        return getDataTable(Collections.singletonList(one));
    }

    @RequestMapping(value = "/add", produces = "application/json", method = RequestMethod.POST)
    public AjaxResult add(@RequestBody AaListParamsStdModelDetail aaListParamsStdModelDetail) {
        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
        aaListParamsStdModelDetail.setCreateBy(nickName);
        aaListParamsStdModelDetail.setCreateTime(DateUtils.getNowDate());
        return toAjax(aaListParamsStdModelDetailService.insertAaListParamsStdModel(aaListParamsStdModelDetail));
    }

    @RequestMapping(value = "/edit", produces = "application/json", method = RequestMethod.POST)
    public AjaxResult edit(@RequestBody AaListParamsStdModelDetail aaListParamsStdModelDetail) {
        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
        aaListParamsStdModelDetail.setUpdateBy(nickName);
        aaListParamsStdModelDetail.setUpdateTime(DateUtils.getNowDate());
        return toAjax(aaListParamsStdModelDetailService.updateAaListParamsStdModel(aaListParamsStdModelDetail));
    }

    @RequestMapping(value = "/remove/{ids}", produces = "application/json", method = RequestMethod.DELETE)
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(aaListParamsStdModelDetailService.deleteAaListParamsStdModelByIds(Arrays.asList(ids)));
    }

    @Log(title = "AA-List参数标准模版明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AaListParamsStdModelDetail aaListParamsStdModelDetail) {
        List<AaListParamsStdModelDetail> list = aaListParamsStdModelDetailService.selectAaListParamsStdModelList(aaListParamsStdModelDetail);
        ExcelUtil<AaListParamsStdModelDetail> util = new ExcelUtil<AaListParamsStdModelDetail>(AaListParamsStdModelDetail.class);
        util.exportExcel(response, list, "AA-List参数标准模版明细");
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<AaListParamsStdModelDetail> util = new ExcelUtil<>(AaListParamsStdModelDetail.class);
        util.importTemplateExcel(response, "AA-List参数导入模版");
    }

    @PreAuthorize("@ss.hasPermi('aa:params:model:upload')")
    @Log(title = "AA参数模版导入", businessType = BusinessType.IMPORT)
    @PostMapping("/upload/manual")
    public AjaxResult uploadManual(MultipartFile file) throws Exception {
        ExcelUtil<AaListParamsStdModelDetail> util = new ExcelUtil<>(AaListParamsStdModelDetail.class);
        List<AaListParamsStdModelDetail> paramsModelList = util.importExcel(file.getInputStream());

        String nickName = sysUserService.selectUserByUserName(SecurityUtils.getUsername()).getNickName();
        Date date = DateUtils.getNowDate();
        for (AaListParamsStdModelDetail aaListParamsStdModelDetail : paramsModelList) {
            aaListParamsStdModelDetail.setCreateBy(nickName);
            aaListParamsStdModelDetail.setCreateTime(date);
        }
        Map<String, Object> resultMap = aaListParamsStdModelDetailService.uploadManual(paramsModelList);
        return resultMap.get("flag").equals(true) ? AjaxResult.success(resultMap.get("msg").toString()) : AjaxResult.warn(resultMap.get("msg").toString());
    }

    @PreAuthorize("@ss.hasPermi('aa:params:model:upload')")
    @Log(title = "AA参数模版导入", businessType = BusinessType.IMPORT)
    @PostMapping("/upload/online")
    public AjaxResult uploadOnline(@RequestBody AaListParamsStdModelDetail aaListParamsStdModelDetail) throws Exception {
        Map<String, Object> resultMap = aaListParamsStdModelDetailService.uploadOnline(aaListParamsStdModelDetail);
        return resultMap.get("flag").equals(true) ? AjaxResult.success(resultMap.get("msg").toString()) : AjaxResult.warn(resultMap.get("msg").toString());
    }
}
