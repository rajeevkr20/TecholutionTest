package com.test.techolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author Rajeev
 *
 */


@SpringBootApplication
@EnableScheduling


public class ApplicationContext extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationContext.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationContext.class, args);
    }
    
    
}
