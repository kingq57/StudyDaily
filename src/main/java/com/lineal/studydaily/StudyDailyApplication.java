package com.lineal.studydaily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lineal.study.twentytwo.september.mybatisplus.mapper")
public class StudyDailyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyDailyApplication.class, args);
    }
}
