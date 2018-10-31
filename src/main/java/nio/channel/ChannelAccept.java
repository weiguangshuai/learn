package nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author weigs
 * @date 2018/10/27 0027
 */
public class ChannelAccept {
    public static final String GREETING = "Hello I must be going";

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8090;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            System.out.println("waiting for connections");
            //不会阻塞，不存在直接返回null
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                System.out.println("no connection");
                Thread.sleep(1000);
            } else {
                System.out.println("Incoming connection from: "
                        + socketChannel.socket().getRemoteSocketAddress());
                buffer.rewind();
                socketChannel.write(buffer);
                socketChannel.close();
            }
        }
    }
}
