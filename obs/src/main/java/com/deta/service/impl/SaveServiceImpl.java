package com.deta.service.impl;

import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import com.deta.service.SaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 发送短信实现
 *
 * @author by diaozhiwei on 2023/05/03.
 * @email diaozhiwei2k@163.com
 */
@Slf4j
@Service
public class SaveServiceImpl implements SaveService {

    @Resource
    private FileStorageService fileStorageService;

    /**
     * save
     *
     * @param file {@link MultipartFile}
     */
    @Override
    public void save(MultipartFile file) {
        FileInfo upload = fileStorageService.of(file).upload();
    }
}
