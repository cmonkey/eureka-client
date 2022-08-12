package org.excavator.boot.eurekaclient.controller;

import org.excavator.boot.eurekaclient.client.FeignClients;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private FeignClients.GreetingClient greetingClient;

    private DiscoveryClient discoveryClient;

    public GreetingController(FeignClients.GreetingClient greetingClient, DiscoveryClient discoveryClient) {
        this.greetingClient = greetingClient;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/home")
    public String home(){
        return greetingClient.greeting();
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "greeting is " + Instant.now();
    }

    @GetMapping("/discovery")
    public List<String> queryDiscovery(){
        return discoveryClient.getServices();
    }

}
