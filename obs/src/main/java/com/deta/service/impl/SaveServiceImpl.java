package com.deta.service.impl;

import cn.hutool.core.lang.UUID;
import cn.xuyanwu.spring.file.storage.Downloader;
import cn.xuyanwu.spring.file.storage.FileInfo;
import cn.xuyanwu.spring.file.storage.FileStorageService;
import cn.xuyanwu.spring.file.storage.ProgressListener;
import com.alibaba.fastjson2.JSON;
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
        //示例参数
        //{"attr":{"role":"admin"},"basePath":"hy/","contentType":"image/jpeg","createTime":"2023-05-09 01:44:16.026","ext":"jpg","filename":"645934f0f59025423cf849dc.jpg","objectId":"0","objectType":"0","originalFilename":"81silver811-1597914549369606146-20221130_192451-img1.jpg","path":"upload/","platform":"tencent-cos-1","size":64196,"thContentType":"image/jpeg","thFilename":"my-love.min.jpg","thSize":5566,"thUrl":"https://booklib-1309974988.cos.ap-shanghai.myqcloud.com/hy/upload/my-love.min.jpg","url":"https://booklib-1309974988.cos.ap-shanghai.myqcloud.com/hy/upload/645934f0f59025423cf849dc.jpg"}
        FileInfo upload = fileStorageService.of(file)
                .image(img -> img.size(1000, 1000))  //将图片大小调整到 1000*1000
                .thumbnail(th -> th.size(200, 200))  //再生成一张 200*200 的缩略图
                .setPlatform("tencent-cos-1")    //使用指定的存储平台
                .setSaveThFilename("my-love") //指定缩略图的保存文件名，注意此文件名不含后缀，默认自动生成
                .setPath("upload/") //保存到相对路径下，为了方便管理，不需要可以不写
                .setObjectId(UUID.fastUUID())   //关联对象id，为了方便管理，不需要可以不写
                .setObjectType("0") //关联对象类型，为了方便管理，不需要可以不写
                .putAttr("role", "admin") //保存一些属性，可以在切面、保存上传记录、自定义存储平台等地方获取使用，不需要可以不写
                .upload();
        log.info(JSON.toJSONString(upload));
    }

    /**
     * exist
     *
     * @param key {@link String}
     */
    @Override
    public boolean exist(String key) {
        String base = "{\"attr\":{\"role\":\"admin\"},\"basePath\":\"hy/\",\"contentType\":\"image/jpeg\",\"createTime\":\"2023-05-09 01:44:16.026\",\"ext\":\"jpg\",\"filename\":\"645934f0f59025423cf849dc.jpg\",\"objectId\":\"0\",\"objectType\":\"0\",\"originalFilename\":\"81silver811-1597914549369606146-20221130_192451-img1.jpg\",\"path\":\"upload/\",\"platform\":\"tencent-cos-1\",\"size\":64196,\"thContentType\":\"image/jpeg\",\"thFilename\":\"my-love.min.jpg\",\"thSize\":5566,\"thUrl\":\"https://booklib-1309974988.cos.ap-shanghai.myqcloud.com/hy/upload/my-love.min.jpg\",\"url\":\"https://booklib-1309974988.cos.ap-shanghai.myqcloud.com/hy/upload/645934f0f59025423cf849dc.jpg\"}";
        FileInfo parse = JSON.parseObject(base, FileInfo.class);
        return fileStorageService
                .exists(parse);
    }

    /**
     * @param url  {@link String}
     * @param path {@link String}
     * @return {@link byte[]}
     */
    @Override
    public byte[] download(String url, String path) {
        String base = "{\"attr\":{\"role\":\"admin\"},\"basePath\":\"hy/\",\"contentType\":\"image/jpeg\",\"createTime\":\"2023-05-09 01:44:16.026\",\"ext\":\"jpg\",\"filename\":\"645934f0f59025423cf849dc.jpg\",\"objectId\":\"0\",\"objectType\":\"0\",\"originalFilename\":\"81silver811-1597914549369606146-20221130_192451-img1.jpg\",\"path\":\"upload/\",\"platform\":\"tencent-cos-1\",\"size\":64196,\"thContentType\":\"image/jpeg\",\"thFilename\":\"my-love.min.jpg\",\"thSize\":5566,\"thUrl\":\"https://booklib-1309974988.cos.ap-shanghai.myqcloud.com/hy/upload/my-love.min.jpg\",\"url\":\"https://booklib-1309974988.cos.ap-shanghai.myqcloud.com/hy/upload/645934f0f59025423cf849dc.jpg\"}";
        FileInfo parse = JSON.parseObject(base, FileInfo.class);
        Downloader download = fileStorageService.download(parse);
        download.setProgressMonitor(new ProgressListener() {
            @Override
            public void start() {
                log.info("下载开始");
            }

            @Override
            public void progress(long progressSize, long allSize) {
                log.info("已下载 " + progressSize + " 总大小" + allSize);
            }

            @Override
            public void finish() {
                log.info("下载结束");
            }
        }).file(path);
        return download.bytes();
    }
}
