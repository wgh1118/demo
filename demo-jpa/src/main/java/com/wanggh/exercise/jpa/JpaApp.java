package com.wanggh.exercise.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author wanggh
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class JpaApp {
    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class, args);
    }
}
