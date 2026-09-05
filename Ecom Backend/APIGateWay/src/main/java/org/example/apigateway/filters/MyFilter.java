package org.example.apigateway.filters;

import org.example.apigateway.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class MyFilter implements GlobalFilter {

    @Autowired
    JwtService jwtService;

    private static final List<String> PUBLIC_ROUTES = List.of(
            "/customer/register",
            "/customer/login"
    );

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        if (PUBLIC_ROUTES.stream().anyMatch(path::startsWith)) {
            return chain.filter(exchange);
        }

        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String authorization = headers.getFirst("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return sendUnauthorized(exchange, "Unauthorized User");
        }

        String token = authorization.substring(7);

        try {
            if (jwtService.isTokenExpired(token)) {
                return sendUnauthorized(exchange, "Token Expired");
            }

            String userEmail = jwtService.extractUsername(token);

            ServerHttpRequest mutatedRequest = exchange.getRequest().mutate()
                    .header("Current_User", userEmail)
                    .build();

            return chain.filter(exchange.mutate().request(mutatedRequest).build());

        } catch (Exception e) {
            e.printStackTrace();
            return sendUnauthorized(exchange, "Invalid Token");
        }
    }

    public Mono<Void> sendUnauthorized(ServerWebExchange exchange, String message) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        byte[] bytes = message.getBytes();
        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(wrap));
    }
}