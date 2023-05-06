package xyz.zhiweicoding.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.api.SmsBlend;
import org.dromara.sms4j.api.callback.CallBack;
import org.dromara.sms4j.api.entity.SmsResponse;
import org.dromara.sms4j.comm.enumerate.SupplierType;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.zhiweicoding.service.SendService;
import xyz.zhiweicoding.vo.SmsMsg;

import java.util.LinkedHashMap;

/**
 * 发送短信实现
 *
 * @author by diaozhiwei on 2023/05/03.
 * @email diaozhiwei2k@163.com
 */
@Slf4j
@Service
public class SendServiceImpl implements SendService {

    private static final SmsBlend smsBlendCloopen = SmsFactory.createSmsBlend(SupplierType.CLOOPEN);

    /**
     * 发送短信
     *
     * @param smsMsg {@link SmsMsg}
     * @return {@link String}
     */
    @Override
    public String send(SmsMsg smsMsg) {
        String msg = "发送成功";
        try {
            SmsResponse smsResponse = new SmsResponse();
            if (!StringUtils.isEmpty(smsMsg.getPhone())) {
                smsResponse = smsBlendCloopen.sendMessage(smsMsg.getPhone(), smsMsg.getSmsEnum().getTemplateId(), (LinkedHashMap<String, String>) smsMsg.getTemplateParams());
            }
            if (CollUtil.isNotEmpty(smsMsg.getPhoneArray())) {
                smsResponse = smsBlendCloopen.massTexting(smsMsg.getPhoneArray(), smsMsg.getSmsEnum().getTemplateId(), (LinkedHashMap<String, String>) smsMsg.getTemplateParams());
            }
            log.debug("发送短信结果：{}", JSON.toJSONString(smsResponse));
            String errMessage = smsResponse.getErrMessage();
            if (!StringUtils.isEmpty(errMessage)) {
                msg = errMessage;
            }
        } catch (Exception e) {
            log.error("发送短信异常", e);
            msg = "发送失败";
        }
        return msg;
    }
}
