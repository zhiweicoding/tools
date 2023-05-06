package xyz.zhiweicoding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author by diaozhiwei on 2023/05/04.
 * @email diaozhiwei2k@163.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     * 多人开发可以设置多个Docket
     * @return
     */
    @Bean
    public Docket createRestApi(Environment environment) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .groupName("短信")
                //false 则不能在浏览器访问，true为默认。
                .enable(true)
                .select()
                //配置扫描接口的方式，基于包去扫描
                .apis(RequestHandlerSelectors.basePackage("xyz.zhiweicoding"))
                //paths()过滤什么路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("api文档")
                .description("短信")
                .termsOfServiceUrl("https://www.zhiweicoding.xyz/")
                .version("1.0")
                .build();
    }
}
