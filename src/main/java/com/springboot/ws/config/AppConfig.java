package com.springboot.ws.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.springboot.ws.service.WebServices;
/**
 * 
 * @author BL-Y
 *
 */
@Configuration
public class AppConfig {
	
	@Bean(name = "helloWorld")
	@Lazy
	public WebServices getWeb() throws MalformedURLException{
		JaxWsPortProxyFactoryBean factoryBean = new JaxWsPortProxyFactoryBean();
		factoryBean.setWsdlDocumentUrl(new URL("http://localhost:8088/getwebservice?wsdl"));
		factoryBean.setNamespaceUri("http://service.webservice.com/");
		factoryBean.setPortName("WebServiceImplPort");
		factoryBean.setServiceName("WebServiceImplService");
		factoryBean.setServiceInterface(WebServices.class);
		factoryBean.afterPropertiesSet();
		return (WebServices) factoryBean.getObject();
	}
}
