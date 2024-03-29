package com.hx.futures;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class FuturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuturesApplication.class, args);
        log.info("Futures server start success");
    }

}
