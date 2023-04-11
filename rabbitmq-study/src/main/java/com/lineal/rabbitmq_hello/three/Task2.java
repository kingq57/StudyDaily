package com.lineal.rabbitmq_hello.three;

import com.lineal.rabbitmq_hello.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description: 消息手动应答生产者，消息在手动应答时是不丢失、放回队列中重新消费
 * @author: lineal
 * @date: 2023/3/20
 * @version: 1.0
 **/
public class Task2 {

    //队列名称
    private static final String TASK_QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();
        //声明队列
        boolean durable = true; //是否持久化参数
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
        //从控制台中输入信息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String message = scanner.next();
            // 设置生产者发送消息为持久化消息（要求保存到磁盘上，不仅仅只保存到内存中）
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }
    }
}
