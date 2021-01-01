package com.dml.ds.routing.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RequestLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 90;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRequest().getRequestURI().contains("/api");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext.getCurrentContext().set("startTime", System.currentTimeMillis());
        log.info("request in {}", RequestContext.getCurrentContext().getRequest().getRequestURI());
        log.info("request in {}", RequestContext.getCurrentContext().getRequest().getRequestURL().toString());
        return null;
    }
}
