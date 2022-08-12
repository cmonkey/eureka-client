package org.excavator.boot.eurekaclient.controller;

import org.excavator.boot.eurekaclient.client.FeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    public static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    private FeignClients.GreetingClient greetingClient;

    private DiscoveryClient discoveryClient;

    public GreetingController(FeignClients.GreetingClient greetingClient, DiscoveryClient discoveryClient) {
        this.greetingClient = greetingClient;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/home")
    public Mono<String> home(){
        log.info("run home method");
        return greetingClient.greeting();
    }

    @GetMapping(value = "/greeting",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Map<String,Instant>> greeting(){
        log.info("run greeting");
        var json = Map.of("greeting",Instant.now());
        return Mono.just(json);
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Map<String, Instant>> test(){
        var json = Map.of("time", Instant.now());
        return Mono.just(json);
    }

    @GetMapping("/discovery")
    public Flux<List<String>> queryDiscovery(){
        return Flux.just(discoveryClient.getServices());
    }

}
