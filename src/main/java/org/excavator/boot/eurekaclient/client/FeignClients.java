package org.excavator.boot.eurekaclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
import reactivefeign.spring.config.ReactiveFeignClient;
public class FeignClients {
    @ReactiveFeignClient(name = "eureka-client-service")
    public interface GreetingClient{
        @GetMapping(value = "/greeting/greeting",produces = MediaType.APPLICATION_JSON_VALUE)
        Mono<String> greeting();
    }
}
