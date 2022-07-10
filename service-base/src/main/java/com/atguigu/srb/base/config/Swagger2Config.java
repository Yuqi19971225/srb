package com.atguigu.srb.base.config;

import com.google.common.base.Predicates;
import com.sun.org.apache.bcel.internal.generic.DCMPG;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;

/**
 * @author ：FYQ
 * @description： Swagger2配置
 * @date ：2022/7/10 17:36
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket apiConfig(){
        return new Docket(DocumentationType.SWAGGER_2);
    }

    @Bean
    public Docket adminApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();

    }

    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("尚融宝后台管理系统-API文档")
                .description("本文档描述了尚融宝后台管理系统接口")
                .version("1.0")
                .contact(new Contact("Yuqi", "https://github.com/Yuqi19971225", "857559565@qq.com"))
                .build();
    }
}
