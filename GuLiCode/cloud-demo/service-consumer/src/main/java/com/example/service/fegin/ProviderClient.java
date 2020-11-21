package com.example.service.fegin;

import com.example.service.fegin.fallback.ProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sleeve
 * @version 1.0
 * @date 2020/11/21 13:57
 */
//fallback是降级方法，降级类可能有多个，需要在接口上指定
@FeignClient(value = "provider-service",fallback = ProviderFallback.class )
public interface ProviderClient {

    @GetMapping("provider/hello")
    public String hello();
}
