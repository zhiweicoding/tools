package xyz.zhiweicoding.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.zhiweicoding.enums.SmsEnum;

import java.util.List;
import java.util.Map;

/**
 * 短信发送基类
 *
 * @author by diaozhiwei on 2023/05/03.
 * @email diaozhiwei2k@163.com
 */
@ApiModel(value = "短信基础消息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsMsg {

    @ApiModelProperty(value = "手机号", example = "13800138000", position = 1, dataType = "String")
    private String phone;
    @ApiModelProperty(value = "模版", required = true, position = 2, dataType = "SmsEnum", allowableValues = "MONEY_CHANGE,TEST,DEFAULT")
    private SmsEnum smsEnum;
    @ApiModelProperty(value = "短信内容", required = true, example = "您的验证码是123456", position = 3, dataType = "String")
    private String content;
    @ApiModelProperty(value = "延迟发送时间", example = "0", position = 4, dataType = "long")
    private long delay;
    @ApiModelProperty(value = "手机号", position = 5, dataType = "List")
    private List<String> phoneArray;
    @ApiModelProperty(value = "模版参数", position = 6, dataType = "Map")
    private Map<String, String> templateParams;

}
