package com.jone.social.govern.reward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zouzujiang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RewordApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewordApplication.class, args);
    }
}
