package com.gitee.xiejr.autoconfig;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: knife4j-starter
 * @description: swagger工厂bean
 * @author: xjr
 * @create: 2020-11-16 17:07
 **/
@AllArgsConstructor
public class SwaggerFactoryBean implements FactoryBean<Docket> {

    private Docket docket;

    @Override
    public Docket getObject() throws Exception {
        return docket;
    }

    @Override
    public Class<?> getObjectType() {
        return Docket.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }




}
