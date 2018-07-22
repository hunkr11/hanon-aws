package com.mkyong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.mkyong"})
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

    //@Bean(name = "multipartResolver")
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/css/**")
          .addResourceLocations("/css/"); 
        
        registry
        .addResourceHandler("/js/**")
        .addResourceLocations("/js/"); 
        
        registry
        .addResourceHandler("/images/**")
        .addResourceLocations("/images/");
        
        registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/"); 
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /*@Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSizePerFile(1000); //bytes
        return commonsMultipartResolver;
    }*/

}