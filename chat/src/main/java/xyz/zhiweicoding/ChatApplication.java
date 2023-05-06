package xyz.zhiweicoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 钉钉机器人api接入服务
 *
 * @author by diaozhiwei on 2023/05/03.
 * @email diaozhiwei2k@163.com
 */
@SpringBootApplication
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
        System.out.println("启动成功");
    }
}
