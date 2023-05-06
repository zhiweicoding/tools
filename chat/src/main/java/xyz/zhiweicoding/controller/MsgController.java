package xyz.zhiweicoding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接受和发送消息的 api接口类
 *
 * @author by diaozhiwei on 2023/05/03.
 * @email diaozhiwei2k@163.com
 */
@RestController
@RequestMapping(value = "/v1/msg/")
public class MsgController {

    @RequestMapping(value = "/get", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    String get(String msg) {
        return msg;
    }
}
