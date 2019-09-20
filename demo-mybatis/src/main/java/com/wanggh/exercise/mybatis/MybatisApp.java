package com.wanggh.exercise.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wanggh
 */
@Configuration
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.wanggh.exercise.mybatis")
public class MybatisApp {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApp.class, args);
    }

    /**
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
