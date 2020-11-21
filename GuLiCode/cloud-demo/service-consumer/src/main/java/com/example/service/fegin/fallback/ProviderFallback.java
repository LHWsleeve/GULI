package com.example.service.fegin.fallback;

import com.example.service.fegin.ProviderClient;
import org.springframework.stereotype.Component;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/21 15:19
 */
@Component
public class ProviderFallback implements ProviderClient {
    @Override
    public String hello() {
        return "这是降级方法，出错了，请稍后再试";
    }
}
