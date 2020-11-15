package com.dml.ds.webapi.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RequestLogFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

        long startTime = System.currentTimeMillis();
        String logPrefix = serverWebExchange.getLogPrefix();

        String method = serverWebExchange.getRequest().getMethodValue();
        String url = serverWebExchange.getRequest().getPath().toString();
        MultiValueMap<String, String> params = serverWebExchange.getRequest().getQueryParams();
        log.info("request-{} {} {} {}", logPrefix, method, url);

        return webFilterChain.filter(serverWebExchange).doFinally(signalType -> {
            long total = System.currentTimeMillis() - startTime;
            log.info("[request-{}] total:{}ms", logPrefix, total);
        });
    }
}
