package com.github.sophisticatedxie.autoconfig;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import springfox.documentation.spring.web.plugins.Docket;


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
