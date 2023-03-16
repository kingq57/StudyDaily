package com.lineal.rabbitmq_hello.one;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KingQqq57
 * @description: RabbitMQ HELLO模式下生产者第一次代码实现
 * @date: 2023/3/16 22:43
 * @version: 1.0
 */
public class Producer {
    // 队列名称
    public static final String QUEUE_NAME = "hello";

    //发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP连接RabbitMQ的队列
        factory.setHost("117.68.113.120");
        //用户名
        factory.setUsername("admin");
        //密码
        factory.setPassword("zhang1998");
        //创建链接
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();
        /*
        * 生成一个队列
        * 1.队列名称
        * 2.队列里面的消息是否持久化（磁盘） 默认情况消息存储在内存中
        * 3.该队列是否只供一个消费者进行消费，是否进行消息共享，true可以给多个消费者消费
        * 4.是否自动删除 最后一个消费者端开连接以后 该对列是否自动删除，true自动删除
        * 5.其它参数，
        * */
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String message = "hello world";
        /*
        * 发送一个消息
        * 1.发送到哪个交换机
        * 2.路由的Key值是哪个，本次是队列的名称
        * 3.其它参数信息
        * 4.发送消息的消息体
        * */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("消息已发送");
    }
}
