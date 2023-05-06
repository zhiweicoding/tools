package com.deta.controller;

import com.deta.service.SaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.zhiweicoding.factory.ResponseFactory;
import xyz.zhiweicoding.service.SendService;
import xyz.zhiweicoding.vo.BaseResponse;
import xyz.zhiweicoding.vo.SmsMsg;

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
     * 发送默认短信测试
     *
     * @param file {@link MultipartFile}
     * @return {@link BaseResponse<String>}
     */
    @ApiOperation(value = "发送短信", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public
    @ResponseBody
    BaseResponse<Boolean> sendDefault(MultipartFile file) {
        saveService.save(file);
        return ResponseFactory.success("请求成功", true);
    }
}
