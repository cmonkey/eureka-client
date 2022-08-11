package org.excavator.boot.eurekaclient.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class EurekaClientCommandLineRunner implements CommandLineRunner {
    public static final Logger log = LoggerFactory.getLogger(EurekaClientCommandLineRunner.class);
    private DiscoveryClient discoveryClient;

    public EurekaClientCommandLineRunner(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public void run(String... args) throws Exception {
        discoveryClient.getServices().forEach(service -> {
            log.info("service is [{}]", service);
        });

    }
}
