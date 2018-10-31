package nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author weigs
 * @date 2018/10/28 0028
 */
public class ConnectAsync {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8090;
        if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        InetSocketAddress socketAddress = new InetSocketAddress(host, port);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        System.out.println("init connection");
        socketChannel.connect(socketAddress);
        while (!socketChannel.finishConnect()) {
            System.out.println("waiting for connection");
        }
        System.out.println("connection established");
        socketChannel.close();
    }

}
