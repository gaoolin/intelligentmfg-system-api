package com.qtech.aa.controller;

import com.alibaba.fastjson2.JSONObject;
import com.qtech.aa.domain.AaSoftwareManagement;
import com.qtech.aa.service.IAaSoftwareManagementService;
import com.qtech.common.core.controller.BaseController;
import com.qtech.common.core.domain.AjaxResult;
import com.qtech.common.core.page.TableDataInfo;
import com.qtech.common.hdfs.service.IHDFSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/02 09:02:21
 * desc   :
 */
@Slf4j
@RestController
@RequestMapping("/aa/params/hdfs")
@Api(value = "HDFS Controller", tags = "HDFS 操作服务")
public class AaStdSoftwareManagementController extends BaseController {
    @Autowired
    private IHDFSService hdfsService;

    @Autowired
    private IAaSoftwareManagementService aaSoftwareManagementService;

    @Autowired
    private FileSystem fileSystem;

    @GetMapping("/list")
    public TableDataInfo list(AaSoftwareManagement aaSoftwareManagement) {
        List<AaSoftwareManagement> list = aaSoftwareManagementService.selectAaSoftwareManagementList(aaSoftwareManagement);
        return getDataTable(list);
    }

    /**
     * 创建的文件夹权限不够，需要设置权限问题
     *
     * @param entity
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "创建文件夹")
    @RequestMapping(value = "/mkdirFolder", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult mkdirFolder(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) AaSoftwareManagement entity) {
        boolean target = hdfsService.mkdirFolder(entity.getPath());
        return AjaxResult.success(target);
    }

    @ApiOperation(httpMethod = "POST", value = "判断文件夹是否存在")
    @RequestMapping(value = "/existFile", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult existFile(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) AaSoftwareManagement entity) {
        boolean target = hdfsService.existFile(entity.getPath());
        return AjaxResult.success(target);
    }

    @ApiOperation(httpMethod = "POST", value = "读取目录")
    @RequestMapping(value = "/readCatalog", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult readCatalog(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) AaSoftwareManagement entity) {
        List<Map<String, Object>> list = hdfsService.readCatalog(entity.getPath());
        return AjaxResult.success(list);
    }

    /**
     * 新建文件到HDFS
     *
     * @param path HDFS上的目标路径
     * @param file 从前端上传的文件
     * @return 操作结果
     */
    @ApiOperation(httpMethod = "POST", value = "新建文件")
    @RequestMapping(value = "/createFile", method = RequestMethod.POST, consumes = "multipart/form-data", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult createFile(@RequestParam("path") String path, @RequestParam("file") MultipartFile file) {
        // 可以将文件名与路径结合，或作为参数传递给hdfsService
        hdfsService.createFile(path, file);
        return AjaxResult.success();
    }


    @ApiOperation(httpMethod = "POST", value = "读取文件内容")
    @RequestMapping(value = "/readFileContent", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult readFileContent(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) AaSoftwareManagement entity) {
        String content = hdfsService.readFileContent(entity.getPath());
        return AjaxResult.success(content);
    }

    @ApiOperation(httpMethod = "POST", value = "文件列表")
    @RequestMapping(value = "/listFile", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult listFile(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) AaSoftwareManagement entity) {
        List<Map<String, String>> list = hdfsService.listFile(entity.getPath());
        return AjaxResult.success(list);
    }

    @ApiOperation(httpMethod = "POST", value = "文件重命名")
    @RequestMapping(value = "/renameFile", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult renameFile(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) AaSoftwareManagement entity) {
        boolean target = hdfsService.renameFile(entity.getFileName(), entity.getNewFileName());
        return AjaxResult.success(target);
    }

    /**
     * 指定文件位删除成功，需要寻找原因
     *
     * @param entity
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "文件删除")
    @RequestMapping(value = "/deleteFile", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult deleteFile(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) AaSoftwareManagement entity) {
        boolean target = hdfsService.deleteFile(entity.getPath());
        return AjaxResult.success(target);
    }


    @ApiOperation(httpMethod = "POST", value = "文件拷贝")
    @RequestMapping(value = "/uploadFile", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult uploadFile(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) JSONObject entity) {
        hdfsService.uploadFile(entity.getString("path"), entity.getString("uploadPath"));
        return AjaxResult.success();
    }

    @ApiOperation(httpMethod = "POST", value = "文件下载")
    @RequestMapping(value = "/downloadFile", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResult downloadFile(@RequestBody @ApiParam(name = "JSON对象", value = "json格式对象", required = true) JSONObject entity) {
        hdfsService.downloadFile(entity.getString("path"), entity.getString("downloadPath"));
        return AjaxResult.success();
    }

    /**
     * 对于文件下载来说，POST 请求通常用于需要在请求体中发送复杂数据或者是需要身份验证的情况。
     * GET 请求：适用于无需传递敏感数据的文件下载场景。GET 请求的 URL 参数通常暴露在浏览器的地址栏中。
     * POST 请求：适用于需要在请求体中传递复杂数据或者需要身份验证的场景
     */
    @GetMapping("/export")
    public void downloadFile(@RequestParam String filePath, HttpServletResponse response) throws IOException {
        Path path = new Path(filePath);
        if (!fileSystem.exists(path)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + path.getName());

        try (FSDataInputStream inputStream = fileSystem.open(path);
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                response.getOutputStream().write("Error occurred while processing the file".getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
