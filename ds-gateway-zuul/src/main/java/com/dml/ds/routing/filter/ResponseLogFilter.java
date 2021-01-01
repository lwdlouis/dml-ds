package com.dml.ds.routing.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class ResponseLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
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
        long startTime = (Long) RequestContext.getCurrentContext().get("startTime");
        log.info("Response in {}, use {}ms",
                RequestContext.getCurrentContext().getRequest().getRequestURI(),
                System.currentTimeMillis() - startTime);
        return null;
    }
}
