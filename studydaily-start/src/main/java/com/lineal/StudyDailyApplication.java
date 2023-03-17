package com.lineal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyDailyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyDailyApplication.class, args);
        System.out.println("启动成功");
    }
}
