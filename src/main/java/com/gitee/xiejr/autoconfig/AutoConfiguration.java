package com.gitee.xiejr.autoconfig;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.gitee.xiejr.swagger.SwaggerBootstrapUiDemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

/**
 * @program: springcloud-project
 * @description: 自动装配类
 * @author: xjr
 * @create: 2020-04-12 13:52
 **/
@Configuration
@Slf4j
@Import(SwaggerBootstrapUiDemoApplication.class)
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class AutoConfiguration {

    @PostConstruct
    public void init(){
        log.info("Api document start：{}"+this.getClass().getName());
    }

}
