package com.flyingideal.springcloud.feign.service;

import org.springframework.stereotype.Component;

/**
 * @author yanchao
 * @date 2019/3/13 21:05
 */
@Component
public class SchedualServiceHelloHystrix implements SchedualServiceHello {

    @Override
    public String sayHiFromClientOne(String name) {
        return "Sorry, sayHiFromClientOnt error!";
    }
}
