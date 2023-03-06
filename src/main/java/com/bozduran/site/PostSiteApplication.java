package com.bozduran.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PostSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostSiteApplication.class, args);
    }

}
