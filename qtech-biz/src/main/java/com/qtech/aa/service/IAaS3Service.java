package com.qtech.aa.service;

import com.qtech.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.Map;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2024/08/02 16:14:57
 * desc   :
 */


public interface IAaS3Service {
    public String uploadFile(String bucketName, MultipartFile file) throws Exception;
    public String generatePresignedGetUrl(String bucketName, String fileName) throws Exception;
    public String generatePresignedPutUrl(String bucketName, String fileName) throws Exception;
    public String listFiles(String bucketName) throws Exception;
    public String deleteFile(String bucketName, String fileName) throws Exception;
    public Map<String, String> getFileMetadata(String bucketName, String fileName) throws Exception;
    public AjaxResult rename(String bucketName, String fileName, String newFileName) throws Exception;
}
