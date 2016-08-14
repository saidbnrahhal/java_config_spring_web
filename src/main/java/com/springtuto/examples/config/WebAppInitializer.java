package com.springtuto.examples.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * it does the role of the web.xml ,it initialize the application and give the
 * hand to the dispatcher Servlet.
 */
public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);

		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));

		//activating Spring security and specify the the link path to be washed .
		DelegatingFilterProxy filter =new DelegatingFilterProxy("springSecurityFilterChain");
		 
		// Create the dispatcher servlet's Spring application context
		DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
		container.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null,false, "/*");
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}
}
