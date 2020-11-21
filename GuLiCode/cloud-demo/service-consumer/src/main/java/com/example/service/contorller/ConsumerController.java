package com.example.service.contorller;

import com.example.service.fegin.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/21 13:41
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private ProviderClient providerClient;

    @GetMapping("hi")
    public String hi(){
        return "Hi consumer<br>"+ this.providerClient.hello();
    }

}
