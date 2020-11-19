package com.example.dubbo.controller;

import com.example.dubbo.pojo.User;
import com.example.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/19 21:32
 */
@RestController
public class HelloController {
//    @Autowired 消费者项目中没有userService的实现类，所以无法注入这个实例
    @Reference
    private UserService userService;

    @GetMapping("test")
    public User queryUser(){
        return this.userService.queryUserById();
    }
}
