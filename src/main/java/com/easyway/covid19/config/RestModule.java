package com.easyway.covid19.config;

import com.easyway.covid19.config.ApplicationServletModule;
import com.easyway.covid19.config.Covid19ApplicationModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.HashMap;
import java.util.Map;


public class RestModule extends JerseyServletModule {
    public RestModule()   {

    }
    @Override
    protected void configureServlets() {
        install(new Covid19ApplicationModule());
        install(new ApplicationServletModule());
        Map<String, String> initParams = new HashMap<String, String>();
        initParams.put(PackagesResourceConfig.PROPERTY_PACKAGES,
                "com.easyway.covid19.rest;org.codehaus.jackson.jaxrs");
        serve("/api/*").with(GuiceContainer.class, initParams);
    }
}
