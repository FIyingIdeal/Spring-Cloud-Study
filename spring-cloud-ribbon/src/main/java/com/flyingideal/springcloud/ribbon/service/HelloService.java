package com.flyingideal.springcloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanchao
 * @date 2019/3/12 22:17
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloServiceError")
    public String helloService(String name) {
        String url = "http://eureka-client/hello?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 注意：作为 {@link this#helloService(String)} 指定的 fallbackMethod
     * 这个方法的返回值必须是 {@code helloService()} 方法返回值相同类型或其子类型
     * 即，这个方法返回值类型必须是 String 或其子类型
     * @param name
     * @return
     */
    public String helloServiceError(String name) {
        return "Sorry, helloService error! The parameter value of this method is "
                + name + "! This message is returned by the hystrix fallback method";
    }
}
