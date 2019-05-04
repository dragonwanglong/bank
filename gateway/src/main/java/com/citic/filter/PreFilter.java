package com.citic.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreFilter extends ZuulFilter {
    /**
     * 过滤器的类型
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * 是否执行过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String authorization = request.getHeader("Authorization");
        System.out.println("Authorization:"+authorization);
        String requestHeader = request.getHeader("Authorization");
        if(StringUtils.isNotBlank(requestHeader)) {
            context.addZuulRequestHeader("Authorization", requestHeader);
        }
        return null;
    }
}
