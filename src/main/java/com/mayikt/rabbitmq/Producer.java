package com.mayikt.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName Producer
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class Producer {
    private static final String QUEUE_NAME = "mayikt-queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建一个新连接
        Connection connection = RabbitMQConnection.getConnection();
        //2.设置channel
        Channel channel = connection.createChannel();
        //3.发送消息
        String msg = "java继父886";
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        System.out.println("消息投递成功");
        channel.close();
        connection.close();
    }
}
