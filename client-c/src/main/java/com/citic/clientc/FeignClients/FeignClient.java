package com.citic.clientc.FeignClients;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient("clientb")
public interface FeignClient {

    @GetMapping("/testfeign.do/{a}")
    Object testFeign(@PathVariable("a") String a);

}
