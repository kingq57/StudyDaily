package com.lineal.rabbitmq_hello.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KingQqq57
 * @description: RabbitMQ HELLO模式下消费者第一次代码实现
 * @date: 2023/3/16 23:11
 * @version: 1.0
 */
public class Consumer {
    //队列名称
    private static final String QUEUE_NAME = "hello";
    // 接收消息
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("117.68.113.120");
        factory.setUsername("admin");
        factory.setPassword("zhang1998");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明 接受消息
        DeliverCallback deliverCallback = (consumer, message)->{
            System.out.println(new String(message.getBody()));
        };
        // 取消消息时候的回调
        CancelCallback cancelCallback = (a)->{
            System.out.println("消息消费被中断");
        };

        /*
        * 消费者消息消息
        * 1.消费哪个队列
        * 2.消费成功之后是否要自动应答 true则自动应答
        * 3.消费者未成功消费的回调
        * 4.消费者取消消费的回调
        *
        * */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}

