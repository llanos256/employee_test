package com.employee.soapconfig;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebserviceConfig {
   
	    @Bean
	    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
	        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	        servlet.setApplicationContext(context);
	        servlet.setTransformWsdlLocations(true);
	        return new ServletRegistrationBean<>(servlet, "/ws/*");
	    }

	    @Bean(name = "Employee")
	    public XsdSchema empleadoSchema() {
	        return new SimpleXsdSchema(new ClassPathResource("Employee.xsd"));
	    }
}
