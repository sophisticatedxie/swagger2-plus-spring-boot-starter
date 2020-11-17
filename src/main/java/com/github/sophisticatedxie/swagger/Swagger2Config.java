package com.github.sophisticatedxie.swagger;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;


@Slf4j
@Data
@NoArgsConstructor
public class Swagger2Config {



    private boolean active;


    private String title;


    private String description;


    private String ip;


    @Value("${server.port:8080}")
    private String port;


    private String concat;


    private String version;


    private String basePackage;


    private String groupName;


    private String termsOfServiceUrl;


    private String[] profiles;






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

