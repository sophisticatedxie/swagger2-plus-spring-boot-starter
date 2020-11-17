package com.gitee.xiejr.swagger;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

/**
 * TODO
 *
 * @author xjr
 * @version 1.0
 * @date 2020/2/4 15:59
 */
@Slf4j
@Data
@NoArgsConstructor
public class Swagger2Config {


    /**
     *是否生效
     */
    private boolean active;

    /**
     *标题
     */
    private String title;

    /**
     *描述
     */
    private String description;

    /**
     *ip地址
     */
    private String ip;

    /**
     *端口
     */
    @Value("${server.port:8080}")
    private String port;

    /**
     *联系
     */
    private String concat;

    /**
     *版本
     */
    private String version;

    /**
     *扫描包路径
     */
    private String basePackage;

    /**
     *组名
     */
    private String groupName;

    /**
     *服务地址
     */
    private String termsOfServiceUrl;

    /**
     *生效环境
     */
    private String[] profiles;




//    @Bean("swaggerDocket")
//    public Docket createRestApi() {
//        log.info("api document start init:{}",this.basePackage);
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
//                .paths(PathSelectors.any())
//                .build();
//    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(concat)
                .version(version)
                .build();
    }






}

