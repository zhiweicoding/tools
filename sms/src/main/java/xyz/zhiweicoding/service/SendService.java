package xyz.zhiweicoding.service;

import org.springframework.stereotype.Service;
import xyz.zhiweicoding.vo.SmsMsg;

/**
 * 发送短信
 *
 * @author by diaozhiwei on 2023/05/03.
 * @email diaozhiwei2k@163.com
 */
public interface SendService {

    /**
     * 发送短信
     *
     * @param smsMsg {@link SmsMsg}
     * @return {@link String}
     */
    String send(SmsMsg smsMsg);

}
