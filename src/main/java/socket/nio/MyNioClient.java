package socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class MyNioClient {
    //创建一个选择器
    private Selector selector;

    private final static int PORT = 8081;

    private final static int BUF_SIZE = 10240;

    private static ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);

    private void initClient() throws IOException {
        this.selector = Selector.open();

        //创建一个通道对象
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress(PORT));

        //将通道注册成OP_ACCEPT事件
        channel.register(selector, SelectionKey.OP_CONNECT);
        while (true) {
            //阻塞方法
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    doConnect(key);
                } else if (key.isReadable()) {

                }
            }
        }
    }

    private void doConnect(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()) {
            clientChannel.finishConnect();
        }
        clientChannel.configureBlocking(false);
        String msg = "服务端你好呀";
        byteBuffer.clear();
        byteBuffer.put(msg.getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        clientChannel.write(byteBuffer);
        clientChannel.close();

    }

    public static void main(String[] args) throws IOException {
        MyNioClient myNioClient = new MyNioClient();
        myNioClient.initClient();
    }

}
