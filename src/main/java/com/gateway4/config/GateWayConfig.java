package com.gateway4.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
  @Bean
  public RouteLocator customRouter(RouteLocatorBuilder builder) {
    return builder.routes()
            .route("book-service", r -> r.path("/book/**")
                    .filters(f -> f.stripPrefix(1))
                    .uri("http://localhost:8082"))

            .route("carsalon-service", r ->
                    r.path("/carsalon/**")
                            .filters(f -> f.stripPrefix(1))
                            .uri("http://localhost:8081"))
            .build();
  }

}
