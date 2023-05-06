# sms服务

**采用的是sms4j([githu地址](https://github.com/dromara/SMS4J))，延迟短信没有采用jar中提供的程序，考虑第三方实现方式存在缺陷，如果服务宕机或者重启，定时任务会消失，可能会造成漏发短信的情况**
```xml
<dependency>
    <groupId>org.dromara.sms4j</groupId>
    <artifactId>sms4j-spring-boot-starter</artifactId>
    <version>2.0.1</version>
</dependency>
```
> 🙅🏻‍🙅🏻‍🙅🏻‍ package org.dromara.sms4j.comm.delayedTime 中延迟的实现方式
```java
public class DelayedTime {
    private final Timer timer = new Timer(true);

    public DelayedTime() {
    }

    public void schedule(TimerTask task, long delay) {
        this.timer.schedule(task, delay);
    }
}
```
> 短信yaml配置，个人认为yaml是最好的方式，接入了nacos，可以动态修改配置信息
```yaml
sms:
  alibaba:
    #阿里云的accessKey
    accessKeyId: 您的accessKey
    #阿里云的accessKeySecret
    accessKeySecret: 您的accessKeySecret
    #短信签名
    signature: 测试签名
    #模板ID 用于发送固定模板短信使用
    templateId: SMS_215125134
    #模板变量 上述模板的变量
    templateName: code
    #请求地址 默认为dysmsapi.aliyuncs.com 如无特殊改变可以不用设置
    requestUrl: dysmsapi.aliyuncs.com
  huawei:
    #华为短信appKey
    appKey: 5N6fvXXXX920HaWhVXXXXXX7fYa
    #华为短信appSecret
    app-secret: Wujt7EYzZTBXXXXXXEhSP6XXXX
    #短信签名
    signature: 华为短信测试
    #通道号
    sender: 8823040504797
    #模板ID 如果使用自定义模板发送方法可不设定
    template-id: acXXXXXXXXc274b2a8263479b954c1ab5
    #华为回调地址，如不需要可不设置或为空
    statusCallBack:
    #华为分配的app请求地址
    url: https://XXXXX.cn-north-4.XXXXXXXX.com:443
  uni-sms:
    # 访问键标识
    accessKeyId: your accessKeyId
    # 访问键秘钥 简易模式不需要配置
    accessKeySecret: your accessKeySecret
    #是否为简易模式 默认为true
    is-simple: true
    # 短信签名
    signature: your signature
    # 模板Id 发送固定模板短信时使用的此配置
    templateId: your templateId
    # 模板变量名称 上述模板的变量名称
    templateName: your templateName
  tencent:
    #腾讯云的accessKey
    accessKeyId: 您的accessKey
    #腾讯云的accessKeySecret
    accessKeySecret: 您的accessKeySecret
    #短信签名
    signature: 测试签名
    #模板ID 用于发送固定模板短信使用
    templateId: SMS_215125134
    #模板变量 上述模板的变量
    templateName: code
    #请求超时时间 默认60秒
    connTimeout: 60
    #短信sdkAppId
    sdkAppId: 短信sdkAppId
    #地域信息默认为 ap-guangzhou 如无特殊改变可不用设置
    territory: ap-guangzhou
    #请求地址默认为 sms.tencentcloudapi.com 如无特殊改变可不用设置
    requestUrl: sms.tencentcloudapi.com
    #接口名称默认为 SendSms 如无特殊改变可不用设置
    action: SendSms
    #接口版本默认为 2021-01-11 如无特殊改变可不用设置
    version: 2021-01-11
  yunpian:
    # 账号唯一标识
    apikey: your apikey
    # 云片官方回调地址，无需求可以不设置
    callbackUrl: "your callbackUrl"
    # 模板 ID
    templateId: your templateId
    # 模板变量名称
    templateName: your templateName
  jdcloud:
    # 访问键标识
    accessKeyId: your accessKeyId
    # 访问键秘钥
    accessKeySecret: your accessKeySecret
    # 短信签名 ID
    signature: your signature
    # 模板 ID（发送固定模板短信时使用的此配置）
    templateId: your templateId
    # 地域信息
    region: cn-north-1
  cloopen:
    # 访问键标识
    accessKeyId: your accessKeyId
    # 访问键秘钥
    accessKeySecret: your accessKeySecret
    # 模板 ID（发送固定模板短信时使用的此配置）
    templateId: your templateId
    # 应用 ID
    appId: your appId
    # REST API Base URL
    baseUrl: https://app.cloopen.com:8883/2013-12-26
  emay:
    # 访问键标识
    appid: your appId
    # 访问键秘钥
    secretKey: your secretKey
    # 短信发送请求地址
    requestUrl: your requestUrl
```
> 目前待办
- 加入nacos后，检测nacos配置更新，配置更新后，只要调用一次方法进行配置刷新即可
```
SmsFactory.refresh(SupplierType.CLOOPEN);
```
- 加入rocketMQ后，加入延迟发送
- 国际化