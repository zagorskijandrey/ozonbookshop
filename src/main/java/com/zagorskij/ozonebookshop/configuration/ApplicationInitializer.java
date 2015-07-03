//Created by andrey on 09.06.2015.
package com.zagorskij.ozonebookshop.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/** Code in the 'onStartup()' method is invoked when the Servlet container initializes the
 * application. This method creates Spring Dispatcher Servlet dynamically to handle all
 * requests coming through the application (denoted by the mapping “/”).
 * The Spring Dispatcher Servlet takes an AnnotationConfigWebApplicationContext which is
 * responsible for Spring-related initializations using annotations.
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        ctx.register(ApplicationConfiguration.class);

        ctx.setServletContext(container);


        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));


        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

}