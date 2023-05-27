package com.thingk0.wauda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WaudaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaudaApplication.class, args);
    }

}
