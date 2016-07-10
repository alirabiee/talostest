package com.alirabiee.talostest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Ali Rabiee on 2016-07-10.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan( basePackages = "com.alirabiee" )
public class ApplicationConfiguration extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources( ApplicationConfiguration.class );
    }

}