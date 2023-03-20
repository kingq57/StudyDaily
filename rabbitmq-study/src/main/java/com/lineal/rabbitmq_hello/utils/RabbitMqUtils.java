package com.lineal.rabbitmq_hello.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: RabbitMQ工具类
 * @author: lineal
 * @date: 2023/3/17
 * @version: 1.0
 **/
public class RabbitMqUtils {

    public static Channel getChannel(){
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP连接RabbitMQ的队列
        factory.setHost("117.68.113.120");
        //用户名
        factory.setUsername("admin");
        //密码
        factory.setPassword("zhang1998");
        try {
            //创建链接
            Connection connection = factory.newConnection();
            //获取信道
            Channel channel = connection.createChannel();
            return channel;
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }
}
