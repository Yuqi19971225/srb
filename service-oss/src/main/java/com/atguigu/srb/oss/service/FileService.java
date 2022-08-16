package com.atguigu.srb.oss.service;

import java.io.InputStream;

public interface FileService {
    /**
     * @param inputStream:
     * @param module:
     * @param fileName:
     * @return String
     * @description 文件上传至阿里云
     * @date
     */
    String upload(InputStream inputStream, String module, String fileName);

    void removeFile(String url);
}
