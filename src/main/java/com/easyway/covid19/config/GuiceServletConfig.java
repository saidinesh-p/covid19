package com.easyway.covid19.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;

import java.util.ArrayList;
import java.util.List;


public class GuiceServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new RestModule());
    }

    private List<Module> getModules() {
        List<Module> modulesList = new ArrayList<>();
        modulesList.add(new ApplicationServletModule());
        modulesList.add(new RestModule());
        return modulesList;
    }
}