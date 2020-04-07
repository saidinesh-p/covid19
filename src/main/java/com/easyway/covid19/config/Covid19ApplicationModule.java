package com.easyway.covid19.config;


import com.easyway.covid19.ServiceHelper;
import com.easyway.covid19.service.Covid19Service;
import com.easyway.covid19.service.Covid19ServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.mybatis.guice.XMLMyBatisModule;

import javax.inject.Singleton;

public class Covid19ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ServiceHelper.class).in(Scopes.SINGLETON);
        bind(Covid19Service.class).to(Covid19ServiceImpl.class).in(Singleton.class);
        install(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                setClassPathResource("mybatis-config.xml");
            }

        });
    }

}
