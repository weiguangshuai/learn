package rabbitmqdemo.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author weigs
 * @date 2018/8/11 0011
 */
public class NewTask {
    private final static String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //建立连接和通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);

        String message = "9........";
        //发布信息
        channel.basicPublish("", TASK_QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println("[x] Sent " + message);

        //关闭连接
        channel.close();
        connection.close();
    }
}
