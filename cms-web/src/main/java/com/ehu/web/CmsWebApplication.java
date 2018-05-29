package com.ehu.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ehu.system.dao")
@ComponentScan(basePackages ="com.ehu.*")
public class CmsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsWebApplication.class, args);
    }
}
