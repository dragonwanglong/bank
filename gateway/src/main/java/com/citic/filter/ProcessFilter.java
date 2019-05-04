package com.citic.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class ProcessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "ROUTING";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("请求处理中 。。。");
        return null;
    }
}
