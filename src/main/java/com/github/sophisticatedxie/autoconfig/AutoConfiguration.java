package com.github.sophisticatedxie.autoconfig;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.github.sophisticatedxie.swagger.SwaggerBootstrapUiDemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;


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
