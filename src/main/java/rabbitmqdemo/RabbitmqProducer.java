package rabbitmqdemo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class RabbitmqProducer {
    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routingkey_demo";
    private static final String QUEUE_NAME = "queuename_demo";
    private static final String IP_ADDRESS = "8.131.94.86";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(IP_ADDRESS);
        connectionFactory.setUsername("weigs");
        connectionFactory.setPassword("weigs");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        Map<String, Object> arg = new HashMap<>();
        arg.put("x-message-ttl", 5000);
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT.getType(), true, false, null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        String message = "Hello World";
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("Ack: tag no: " + deliveryTag + " multiple " + multiple);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("Nack: tag no: " + deliveryTag + " multiple " + multiple);
            }
        });
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
//        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, new AMQP.BasicProperties().builder()
//                .contentType("text/plain").priority(1).expiration("6000").build(), message.getBytes());
//        channel.basicPublish(EXCHANGE_NAME, "", true, new AMQP.BasicProperties().builder()
//                .contentType("text/plain").priority(1).expiration("6000").build(), message.getBytes());
//        channel.addReturnListener((replyCode, replyText, exchange, routingKey, properties, body) -> {
//            String msg = new String(body);
//            System.out.println("返回的结果是：" + msg);
//        });
//
        Thread.sleep(5000);
        channel.close();
        connection.close();
    }
}
