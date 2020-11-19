package com.example.dubbo.service;

import com.example.dubbo.pojo.User;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/19 20:27
 */
@Service //注意要使用dubbo的Service注解
public class UserServiceImpl implements UserService {

    @Override
    public User queryUserById() {
        User user = new User( 1L,"sleeve",22);
        return user;
    }
}
