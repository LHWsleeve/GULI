package com.example.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/21 13:30
 */
@RefreshScope
@RestController
@RequestMapping("provider")
public class providerController {
    @Value("${myname}")
    private String myname;


    @GetMapping("hello")
    public String hello(){
//        int i=1/0;
        return "Hello provider----"+myname;
    }
}
