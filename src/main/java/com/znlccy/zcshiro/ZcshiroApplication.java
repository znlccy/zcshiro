package com.znlccy.zcshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.znlccy.zcshiro.mapper")
public class ZcshiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcshiroApplication.class, args);
    }

}
