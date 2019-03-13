package com.flyingideal.springcloud.feign.controller;

import com.flyingideal.springcloud.feign.service.SchedualServiceHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanchao
 * @date 2019/3/12 23:34
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private SchedualServiceHello schedualServiceHello;

    @GetMapping("hello")
    public String sayHello(@RequestParam String name) {
        logger.info(">>>>>>> Feign Server handle /hello");
        return schedualServiceHello.sayHiFromClientOne(name);
    }
}
