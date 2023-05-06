package xyz.zhiweicoding.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.zhiweicoding.factory.ResponseFactory;
import xyz.zhiweicoding.service.SendService;
import xyz.zhiweicoding.vo.BaseResponse;
import xyz.zhiweicoding.vo.SmsMsg;

/**
 * 发送短信api
 *
 * @author by diaozhiwei on 2023/05/01.
 * @email diaozhiwei2k@163.com
 */
@Api(tags = "发送短信api")
@RequestMapping("/v1/api/")
@RestController
@AllArgsConstructor
public class SendController {

    private final SendService sendService;

    /**
     * 发送默认短信测试
     *
     * @param smsMsg {@link SmsMsg}
     * @return {@link BaseResponse<String>}
     */
    @ApiOperation(value = "发送短信", httpMethod = "POST", response = BaseResponse.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public
    @ResponseBody
    BaseResponse<String> sendDefault(@RequestBody SmsMsg smsMsg) {
        String send = sendService.send(smsMsg);
        return ResponseFactory.success("请求成功", send);
    }
}
