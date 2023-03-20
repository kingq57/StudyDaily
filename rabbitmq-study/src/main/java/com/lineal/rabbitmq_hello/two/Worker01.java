package com.lineal.rabbitmq_hello.two;

import com.lineal.rabbitmq_hello.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * @description: 一个工作线程，相当于之前消费者
 * @author: lineal
 * @date: 2023/3/20
 * @version: 1.0
 **/
public class Worker01 {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();

        // 消息的接收
        /*
         * 消费者消息消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true则自动应答
         * 3.消费者未成功消费的回调
         * 4.消费者取消消费的回调
         *
         * */
        System.out.println("C1等待接收消息......");
        channel.basicConsume(QUEUE_NAME, true, (a, b)-> System.out.println("接收到的消息："+ new String(b.getBody())), a-> System.out.println("消费者取消消费接口逻辑回调"));
    }


}
