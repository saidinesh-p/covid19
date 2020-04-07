package com.easyway.covid19.config;

import com.easyway.covid19.filter.MDCInsertingServletFilter;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;


public class ApplicationServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(MDCInsertingServletFilter.class).in(Scopes.SINGLETON);
        filter("/*").through(MDCInsertingServletFilter.class);
    }
}