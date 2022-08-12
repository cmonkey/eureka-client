package org.excavator.boot.eurekaclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

public class FeignClients {
    @FeignClient("eureka-client-service")
    public interface GreetingClient{
        @RequestMapping("/greeting/greeting")
        String greeting();
    }
}
