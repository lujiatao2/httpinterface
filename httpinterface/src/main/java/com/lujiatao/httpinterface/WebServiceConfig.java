package com.lujiatao.httpinterface;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/***
 * SOAP接口的服务器配置
 * 
 * @author lujiatao
 *
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/MobilePhones/*");
	}

	@Bean(name = "mobilePhones")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema mobilePhonesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("MobilePhonesPort");
		wsdl11Definition.setLocationUri("/MobilePhones");
		wsdl11Definition.setTargetNamespace("http://www.lujiatao.com/httpinterface/MobilePhones");
		wsdl11Definition.setSchema(mobilePhonesSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema mobilePhonesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("MobilePhones.xsd"));
	}

}
