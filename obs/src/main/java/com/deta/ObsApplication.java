package com.deta;

import cn.xuyanwu.spring.file.storage.EnableFileStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author by diaozhiwei on 2023/05/01.
 * @email diaozhiwei2k@163.com
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
@EnableFileStorage
public class ObsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObsApplication.class, args);
        System.out.println("obs start success!");
    }
}
