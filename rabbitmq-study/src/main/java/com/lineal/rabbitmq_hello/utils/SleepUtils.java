package com.lineal.rabbitmq_hello.utils;

/**
 * @author: KingQqq57
 * @description: 线程沉睡工具类
 * @date: 2023/3/23 21:14
 * @version: 1.0
 */
public class SleepUtils {

    public static void sleep(int second){
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
