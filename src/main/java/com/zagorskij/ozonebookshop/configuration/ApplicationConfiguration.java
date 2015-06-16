package com.zagorskij.ozonebookshop.configuration;

import com.zagorskij.ozonebookshop.unmarshal.ProcessUnmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by andrey on 09.06.2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.zagorskij.ozonebookshop")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ProcessUnmarshaller getPage(){
        ProcessUnmarshaller page= new ProcessUnmarshaller();
        page.setUnmarshaller(jaxb2Marshaller());
        return page;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller jaxb2Marshaller= new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan(new String[]{"com.zagorskij.ozonebookshop.model"});
        return jaxb2Marshaller;
    }


}
