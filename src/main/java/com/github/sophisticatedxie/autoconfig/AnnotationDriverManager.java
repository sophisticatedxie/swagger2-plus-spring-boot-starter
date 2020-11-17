package com.github.sophisticatedxie.autoconfig;


import com.github.sophisticatedxie.annotations.EnableApiDocument;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.net.UnknownHostException;
import java.util.Arrays;



@Slf4j
public class AnnotationDriverManager implements ImportBeanDefinitionRegistrar, EnvironmentAware {





    private Environment environment;



    @SneakyThrows
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        StandardAnnotationMetadata standardAnnotationMetadata= (StandardAnnotationMetadata) annotationMetadata;
        AnnotationAttributes annotationMap= AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(EnableApiDocument.class.getName()));
        if (!annotationMap.getBoolean("active") || !activeByEnv(annotationMap)){
            log.info("当前环境不支持swagger文档");
        }else{
            registryBean(standardAnnotationMetadata,annotationMap,beanDefinitionRegistry);
        }


    }




    private boolean activeByEnv(AnnotationAttributes annotationMap){
        String[] envs=environment.getActiveProfiles();
        return Arrays.asList(annotationMap.getStringArray("profiles")).stream()
                .anyMatch(data -> Arrays.asList(envs).contains(data));
    }



    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }



    private void registryBean(StandardAnnotationMetadata standardAnnotationMetadata , AnnotationAttributes annotationMap, BeanDefinitionRegistry beanDefinitionRegistry ) throws UnknownHostException {
        Class targetClass=standardAnnotationMetadata.getIntrospectedClass();
        Docket docket=new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(new ApiInfoBuilder()
                .title(annotationMap.getString("title"))
                .description(annotationMap.getString("description"))
                .termsOfServiceUrl(annotationMap.getString("termsOfServiceUrl"))
                .contact(annotationMap.getString("concat"))
                .version(annotationMap.getString("version"))
                .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage(StringUtils.isEmpty(annotationMap.getString("basePackages"))?targetClass.getPackage().getName():annotationMap.getString("basePackages")))
                .paths(PathSelectors.any())
                .build();
        if (!StringUtils.isEmpty(annotationMap.getString("groupName"))){
            docket.groupName(annotationMap.getString("groupName"));
        }
        GenericBeanDefinition beanDefinition= (GenericBeanDefinition) BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(SwaggerFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(docket);
        beanDefinitionRegistry.registerBeanDefinition("knife4j",beanDefinition);


    }

}
