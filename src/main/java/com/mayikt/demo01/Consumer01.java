package com.mayikt.demo01;

import com.mayikt.rabbitmq.RabbitMQConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer01 {
    private static final String QUEUE_NAME = "mayikt-queue";

    public static void main(String[] args) throws IOException, TimeoutException, IOException, TimeoutException {
        // 1.创建连接
        Connection connection = RabbitMQConnection.getConnection();
        // 2.设置通道
        Channel channel = connection.createChannel();
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                String msg = new String(body, "UTF-8");
                System.out.println("消费者获取消息:" + msg);
            }
        };
        // 3.监听队列
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);

    }
}