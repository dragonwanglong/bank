package com.citic.clientb.HystrixFallback;


import com.citic.clientb.FeignClients.MyFeignClients;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HystrixFallback  implements MyFeignClients {
    @Override
    public Object testFeign(String a) {
        Map d = new HashMap<>();
        d.put("出错了","降级了");
        return d;
    }

}
