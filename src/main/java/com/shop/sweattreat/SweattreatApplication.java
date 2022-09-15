package com.shop.sweattreat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SweattreatApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SweattreatApplication.class, args);
    }
}