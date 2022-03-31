package rabbitmqdemo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqConsumer {
    private static final String QUEUE_NAME = "queuename_demo2";

    private static final String IP_ADDRESS = "8.131.94.86";

    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{
                new Address(IP_ADDRESS, PORT)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("weigs");
        factory.setPassword("weigs");
        Connection connection = factory.newConnection(addresses);
        Channel channel = connection.createChannel();
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message: " + new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
        Thread.sleep(5000);
        channel.close();
        connection.close();
    }
}
