package rabbitmqdemo.queue;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author weigs
 * @date 2018/8/11 0011
 */
public class Worker {
    private final static String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception {
        //建立连接和通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
        System.out.println("[*] Waiting for messages, To exit press CTRL+C");
        channel.basicQos(1);

        //回调消费信息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("[x] Received " + message);

                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //手动进行消息确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                    System.out.println("[x] done");
                }
            }
        };

        //false表示需要手动消息确认，true表示消费者自动确认信息
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}

