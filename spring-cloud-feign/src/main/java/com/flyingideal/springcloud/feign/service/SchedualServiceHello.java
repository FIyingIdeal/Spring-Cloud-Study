package com.flyingideal.springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yanchao
 * @date 2019/3/12 23:30
 */
@FeignClient(value = "eureka-client", fallback = SchedualServiceHelloHystrix.class)
public interface SchedualServiceHello {

    @GetMapping(value = "/hello")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
