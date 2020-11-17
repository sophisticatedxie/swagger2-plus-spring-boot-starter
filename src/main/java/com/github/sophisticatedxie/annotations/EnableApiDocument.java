package com.github.sophisticatedxie.annotations;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.github.sophisticatedxie.autoconfig.AnnotationDriverManager;
import com.github.sophisticatedxie.swagger.Swagger2Config;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;


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

    String description() default "swagger";

    String basePackages() default "";

    String groupName() default "";

    String version() default  "1.0";

    String concat() default  "swagger";

    String termsOfServiceUrl() default "http://www.test.com";

    String[] profiles() default {"default"};
}
