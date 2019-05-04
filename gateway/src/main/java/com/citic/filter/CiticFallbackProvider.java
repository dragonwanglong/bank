package com.citic.filter;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;


public class CiticFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        //制定为哪个微服务提供回退（这里写微服务名 写*代表所有微服务）
        return "*";
    }

    //此方法需要返回一个ClientHttpResponse对象  ClientHttpResponse是一个接口，
    // 具体的回退逻辑要实现此接口
    //route：出错的微服务名     cause：出错的异常对象
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletResponse response = currentContext.getResponse();
        if(cause instanceof HystrixTimeoutException){
             response.setStatus(HttpStatus.REQUEST_TIMEOUT.value());
        }else{
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return (ClientHttpResponse) response;
    }
}
