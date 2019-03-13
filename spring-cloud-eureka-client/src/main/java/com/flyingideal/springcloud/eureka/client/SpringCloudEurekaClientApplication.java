package com.flyingideal.springcloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	private String port;

	// 如果要测试 spring cloud config 的话，需要先启动 spirng-cloud-config-server 项目
	/*@Value("${foo}")
	private String foo;*/

	@GetMapping("/hello")
	public String home(
			@RequestParam(name = "name", defaultValue = "flyingideal") String name) {
		// String configFoo = "This is from config server foo value : " + foo;
		return "Hello, " + name + "! I'm from port: " + port + " >> "; //+ configFoo;
	}
}
