package com.kostya.chatProject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

/**
 * Created by Костя on 15.07.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.kostya.chatProject.controllers")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver getThymeleafViewResolver(SpringTemplateEngine engine){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(engine);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine getSpringTemplateEngine(ServletContextTemplateResolver templateResolver){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        return engine;
    }

    @Bean
    public ServletContextTemplateResolver getThatThing(ServletContext context){
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);

        resolver.setSuffix(".html");
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setTemplateMode(TemplateMode.HTML);

        return resolver;
    }
}
