package com.lineal.rabbitmq_hello.four;

import com.lineal.rabbitmq_hello.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.UUID;

/**
 * @description: 
 * 发布确认模式
 * 看使用时间 比较哪种确认方式是最好的
 * 1.单个确认
 * 2.批量确认
 * 3.异步批量确认
 * @author: lineal
 * @date: 2023/4/20
 * @version: 1.0
 **/
public class ConfirmMessage {
    //批量发消息的个数
    public static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws IOException, InterruptedException {
        // 1.单个确认
        publishMessageIndividually();
        // 2.批量确认
        // 3.异步批量确认
    }
    

    // 单个发布确认
    public static void publishMessageIndividually() throws IOException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        // 队列的声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, true, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        // 开始时间
        final long beginTime = System.currentTimeMillis();
        // 批量发消息
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 单个消息就马上进行发布确认
            boolean flag = channel.waitForConfirms();
            if (flag){
                System.out.println("消息发送成功");
            }
        }
        final long end = System.currentTimeMillis();
        System.out.println("发布"+MESSAGE_COUNT+"个单独确认消息，耗时"+(end-beginTime)+"ms");
    }

    // 批量发布确认
    public static void publishMessageBatch() throws IOException, InterruptedException {

    }
}
