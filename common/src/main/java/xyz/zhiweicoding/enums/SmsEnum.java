package xyz.zhiweicoding.enums;

/**
 * 短信模版类型
 *
 * @author by diaozhiwei on 2023/05/03.
 * @email diaozhiwei2k@163.com
 */
public enum SmsEnum {
    MONEY_CHANGE("1083862", "金额变动"),
    TEST("1083862", "金额变动"),
    DEFAULT("-1", "没有匹配到模版");

    private final String templateId;
    private final String templateDesc;

    SmsEnum(String templateId, String templateDesc) {
        this.templateDesc = templateDesc;
        this.templateId = templateId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getTemplateDesc() {
        return templateDesc;
    }

    /**
     * 通过模版id获取枚举
     * @param templateId 传入的模版id
     * @return {@link SmsEnum}
     */
    public static SmsEnum getEnum(String templateId) {
        for (SmsEnum smsEnum : SmsEnum.values()) {
            if (smsEnum.getTemplateId().trim().equals(templateId.trim())) {
                return smsEnum;
            }
        }
        return DEFAULT;
    }
}
