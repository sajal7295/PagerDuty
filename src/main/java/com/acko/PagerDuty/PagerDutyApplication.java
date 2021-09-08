package com.acko.PagerDuty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class PagerDutyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagerDutyApplication.class, args);
    }

    @Bean
    RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}