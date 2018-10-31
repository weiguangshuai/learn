package rabbitmqdemo.fanoutexchange;

import com.rabbitmq.client.*;

import java.io.*;
import java.util.concurrent.TimeoutException;


/**
 * @author weigs
 * @date 2018/8/11 0011
 */
public class WriteLogs {
    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = getChannel();
//声明路由及其类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //声明一个随机名字的队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定队列到路由器上
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        //开始监听信息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                File file = new File("c:/logs/weigs.log");
                FileOutputStream outputStream = new FileOutputStream(file,true);
                outputStream.write(body);
                outputStream.write('\n');
//                PrintWriter pw = new PrintWriter(file);
//                pw.write(message);
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }

    private static Channel getChannel() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        return connection.createChannel();

    }
}
