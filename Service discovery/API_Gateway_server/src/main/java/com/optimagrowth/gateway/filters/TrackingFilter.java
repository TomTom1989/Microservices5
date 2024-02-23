package com.optimagrowth.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Order(1)
@Component
public class TrackingFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    FilterUtils filterUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        logger.debug("Incoming request for path: {}", exchange.getRequest().getPath());

        if (isCorrelationIdPresent(requestHeaders)) {
            logger.debug("tmx-correlation-id found in tracking filter: {}.", filterUtils.getCorrelationId(requestHeaders));
        } else {
            String correlationID = generateCorrelationId();
            exchange = filterUtils.setCorrelationId(exchange, correlationID);
            logger.debug("tmx-correlation-id not found. Generated and set in tracking filter: {}.", correlationID);
        }

        logCurrentHeaders(exchange);
        
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
        String correlationId = filterUtils.getCorrelationId(requestHeaders);
        boolean present = correlationId != null && !correlationId.isEmpty();
        logger.debug("Checking for tmx-correlation-id: present = {}", present);
        return present;
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }

    private void logCurrentHeaders(ServerWebExchange exchange) {
        exchange.getRequest().getHeaders().forEach((key, value) -> logger.debug("Header '{}': {}", key, value));
    }
}
