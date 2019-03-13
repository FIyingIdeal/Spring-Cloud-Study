package com.flyingideal.springcloud.ribbon.controller;

import com.flyingideal.springcloud.ribbon.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanchao
 * @date 2019/3/12 22:23
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        logger.info(">>>>>>> Ribbon Server handle /hello");
        return helloService.helloService(name);
    }
}
