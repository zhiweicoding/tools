package com.deta.controller;

import com.deta.service.SaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.zhiweicoding.factory.ResponseFactory;
import xyz.zhiweicoding.vo.BaseResponse;

/**
 * obs测试服务
 *
 * @author by diaozhiwei on 2023/05/05.
 * @email diaozhiwei2k@163.com
 */
@Api(tags = "obs测试服务")
@RequestMapping("/v1/api/")
@RestController
@AllArgsConstructor
public class SaveController {

    private final SaveService saveService;

    /**
     * 保存图片
     *
     * @param file {@link MultipartFile}
     * @return {@link BaseResponse<String>}
     */
    @ApiOperation(value = "保存图片", httpMethod = "POST", response = BaseResponse.class)
    @PostMapping(value = "/saveDefault")
    public
    @ResponseBody
    BaseResponse<Boolean> saveDefault(@RequestParam("file") MultipartFile file) {
        saveService.save(file);
        return ResponseFactory.success("请求成功", true);
    }

    /**
     * 判断文件是否存在
     *
     * @param fileName {@link String}
     * @return {@link BaseResponse<String>}
     */
    @ApiOperation(value = "判断文件是否存在", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "/exist", method = {RequestMethod.POST})
    public
    @ResponseBody
    BaseResponse<Boolean> exist(@RequestParam("fileName") String fileName) {
        boolean exist = saveService.exist(fileName);
        return ResponseFactory.success("请求成功", exist);
    }

    /**
     * 下载
     *
     * @param url  {@link String}
     * @param path {@link String}
     * @return {@link BaseResponse<String>}
     */
    @ApiOperation(value = "下载", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "/download", method = {RequestMethod.POST})
    public
    @ResponseBody
    BaseResponse<byte[]> download(@RequestParam("url") String url, @RequestParam("path") String path) {
        byte[] download = saveService.download(url, path);
        return ResponseFactory.success("下载成功", download);
    }
}
