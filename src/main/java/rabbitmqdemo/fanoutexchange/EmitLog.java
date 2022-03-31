package rabbitmqdemo.fanoutexchange;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发布同一个消息到多个消费者中
 *
 * @author weigs
 * @date 2018/8/11 0011
 */
public class EmitLog {
    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        //建立连接和通道
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();



        //声明路由以及路由的类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        String message = "2018-07-22 22:29:56 [ RMI TCP Connection(3)-127.0.0.1:0 ] - [ INFO ] Root WebApplicationContext: initialization started";

        //发布信息
        channel.basicPublish(EXCHANGE_NAME, "",
                null, message.getBytes("UTF-8"));
        System.out.println("[x] Sent " + message);

        //关闭连接和通道
        channel.close();
        connection.close();
    }
}
