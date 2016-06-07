package com.weixin.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Jay
 * @time 2015年5月21日
 */
@Configuration
@ImportResource(value = {"classpath*:spring/*.xml"})
//@PropertySource(value = "classpath:app.properties")
@ComponentScan(basePackages = { "com.weixin" })
public class ApplicationConfig {

/*	@Bean
	public RestTemplate restTemplate() {
		ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		return new RestTemplate(clientHttpRequestFactory);
	}*/

}