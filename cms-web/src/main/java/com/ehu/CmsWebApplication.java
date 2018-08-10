package com.ehu;

import com.ehu.datasource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
@ComponentScan("com.ehu")
@MapperScan("com.ehu.dao")
public class CmsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsWebApplication.class, args);
    }
}
