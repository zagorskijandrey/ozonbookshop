//Created by andrey on 09.06.2015.
package com.zagorskij.ozonbookshop.configuration;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zagorskij.ozonbookshop.unmarshal.ProcessUnmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.js.ajax.AjaxUrlBasedViewResolver;

import org.springframework.js.ajax.tiles3.AjaxTilesView;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.view.FlowAjaxTiles3View;

import java.util.Arrays;
import java.util.List;

/**
 * Created by andrey on 09.06.2015.
 */
//@Configuration marks this class as configuration class
@Configuration
//@EnableWebMVC and @ComponentScan are somewhat self explanatory and required for Spring to
// find and configure all annotated classes.
@EnableWebMvc
@ComponentScan(basePackages="com.zagorskij.ozonbookshop")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    //Method viewResolver configures a view resolver to identify the real view.
    //InternalResourceViewResolver parses the String returned by the controller
    // method and look for the jsp file with the same name in the /WEB-INF/views/ directory.
    /*@Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(2);
        return viewResolver;
    }

    //UrlBasedViewResolver parses the String returned by the controller method and look for the
    // Tiles definition with the same name in the /WEB-INF/lib/ directory, in the xml format.
    /*@Bean
    public ViewResolver resolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }*/

    /*@Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator() {
        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(Arrays.<ViewResolver>asList(ajaxResolver()));
        //factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }*/

    @Bean
     public AjaxUrlBasedViewResolver ajaxResolver() {
        AjaxUrlBasedViewResolver ajaxResolver = new AjaxUrlBasedViewResolver();
        ajaxResolver.setViewClass(FlowAjaxTiles3View.class);
        ajaxResolver.setOrder(0);
        return ajaxResolver;
    }
    @Bean
    public UrlBasedViewResolver resolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(1);
        return resolver;
    }

    //TilesConfigurer, with the location where Tiles framework based definiton in the form
    // of xml can be found.
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/lib/tiles.xml" });
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    //This is the class that will do all of the work for unmarshal
    @Bean
    public ProcessUnmarshaller getPage(){
        ProcessUnmarshaller page= new ProcessUnmarshaller();
        page.setUnmarshaller(jaxb2Marshaller());
        return page;
    }

    //This is an instance of the org.springframework.oxm.jaxb.Jaxb2Marshaller class that will
    // be injected into our ProcessUnmarshaller bean
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller jaxb2Marshaller= new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan(new String[]{"com.zagorskij.ozonbookshop.model"});
        return jaxb2Marshaller;
    }

    //In ‘addResourceHandlers()’ an instruction to Spring is given that when it sees a URL
    // beginning with “resources/**”  (images,JS, CSS etc.)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
                .setCachePeriod(31556926);
    }
}

