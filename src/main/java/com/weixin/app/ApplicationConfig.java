package com.weixin.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jay
 * @time 2015年5月21日
 */
@Configuration
@ImportResource(value = {"classpath*:spring/*.xml"})
//@PropertySource(value = "classpath:app.properties")
@ComponentScan(basePackages = { "com.weixin" })
@EnableAutoConfiguration
public class ApplicationConfig {

	@Bean
	public RestTemplate restTemplate() {
		ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		return new RestTemplate(clientHttpRequestFactory);
	}

}