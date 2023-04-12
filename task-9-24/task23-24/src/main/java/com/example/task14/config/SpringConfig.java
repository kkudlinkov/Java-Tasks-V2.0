package com.example.task14.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

@Configuration
@EnableAspectJAutoProxy
@EnableAsync
@EnableAutoConfiguration
@EnableScheduling
@EnableMBeanExport
public class SpringConfig extends AsyncSupportConfigurer {
}
