package com.flyingideal.springcloud.provider;

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
public class SpringCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String home(
            @RequestParam(name = "name", defaultValue = "flyingideal") String name) {
        return "Hello, " + name + "! I'm from port: " + port + " >> ";
    }
}
