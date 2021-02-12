package com.dml.ds.gateway.config;

import com.dml.ds.gateway.filters.LogRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {

    @Autowired
    private LogRequestFilter logRequestFilter;

    @Bean
    public RouteLocator pathRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/web-api")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://web-api")
                        .filters(logRequestFilter)
                ).build();
    }
}
