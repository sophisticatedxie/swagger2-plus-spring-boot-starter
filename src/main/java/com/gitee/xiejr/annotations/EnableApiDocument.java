package com.gitee.xiejr.annotations;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.gitee.xiejr.autoconfig.AnnotationDriverManager;
import com.gitee.xiejr.swagger.Swagger2Config;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * @program: knife4j-starter
 * @description: 启动注解
 * @author: xjr
 * @create: 2020-09-07 10:31
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({Swagger2Config.class, AnnotationDriverManager.class})
@Inherited
@Documented
@EnableSwagger2
@EnableSwaggerBootstrapUI
public @interface EnableApiDocument {
    boolean active() default true;

    String  title() default "knife4j在线api文档";

    String description() default "swagger进阶版";

    String basePackages() default "";

    String groupName() default "";

    String version() default  "1.0";

    String concat() default  "swagger";

    String termsOfServiceUrl() default "http://www.test.com";

    String[] profiles() default {"default"};
}
