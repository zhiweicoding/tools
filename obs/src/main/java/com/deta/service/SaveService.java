package com.deta.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 对象存储
 *
 * @author by diaozhiwei on 2023/05/06.
 * @email diaozhiwei2k@163.com
 */
public interface SaveService {

    /**
     * save
     *
     * @param file {@link MultipartFile}
     */
    void save(MultipartFile file);

}
