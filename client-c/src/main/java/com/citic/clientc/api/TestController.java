package com.citic.clientc.api;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    private static  String CLIENTB_URL = "http://clientb/";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testc.do")
    @ResponseBody
    public Object callClientc(){

        Object forObject = restTemplate.getForObject(CLIENTB_URL + "testb.do",
                Object.class);
        return forObject;

    }


    @GetMapping("/testc2.do")
    @ResponseBody
    public Object tt(){
        return restTemplate.getForObject(CLIENTB_URL+"testcc.do",Object.class);
    }


    @GetMapping("/testfeign.do/{a}")
    @ResponseBody
    public Object testFeign(@PathVariable("a") String a){
        int v = 1/0;
        Map m = new HashMap();
        m.put(a,"hello");
        return m;
    }

}
