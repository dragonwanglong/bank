package com.citic.clientb.FeignClients;


import com.citic.clientb.HystrixFallback.HystrixFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient(value = "clientc",
        fallback = HystrixFallback.class)
public interface MyFeignClients {

    @GetMapping("/testfeign.do/{a}")
    Object testFeign(@PathVariable("a") String a);


}
