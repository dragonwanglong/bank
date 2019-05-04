package com.citic.clientb.api;

import com.citic.clientb.FeignClients.MyFeignClients;
import com.citic.clientb.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    private static String CLIENTC = "clientc";

    @Autowired
    private MyFeignClients myFeignClients;

    @GetMapping("/testb.do")
    @ResponseBody
    public Map test(){
         Map ret = new HashMap();
        ret.put("name","wanglong");
        return ret;
    }


    @GetMapping("/testcc.do")
    @ResponseBody
    public Object test02(){
        return new User("zhangsan","23");
    }


    @GetMapping("/testfeign.do/{a}")
    @ResponseBody
    public Object testFeign(@PathVariable("a") String a){
        return myFeignClients.testFeign(a);
    }
}
