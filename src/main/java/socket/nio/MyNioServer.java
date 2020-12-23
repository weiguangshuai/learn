package socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MyNioServer {
    //创建一个选择器
    private Selector selector;

    private final static int PORT = 8081;

    private final static int BUF_SIZE = 10240;

    private void initServer() throws IOException, InterruptedException {
        this.selector = Selector.open();

        //创建一个通道对象
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(PORT));

        //将通道注册成OP_ACCEPT事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //阻塞方法
            int select = selector.select();
            System.out.println("select num: " + select);
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    doAccept(key);
                } else if (key.isReadable()) {
                    doRead(key);
                } else if (key.isWritable() && key.isValid()) {

                } else if (key.isConnectable()) {
                    System.out.println("连接成功");
                }
            }
        }
    }

    private void doRead(SelectionKey key) throws IOException, InterruptedException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        long bytes = channel.read(byteBuffer);
        while (bytes > 0) {
            byteBuffer.flip();
            byte[] data = byteBuffer.array();
            String msg = new String(data).trim();
            System.out.println("客户端发过来的信息：" + msg);
            byteBuffer.clear();
            bytes = channel.read(byteBuffer);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入：");
            String s = scanner.nextLine();
            byteBuffer.put(s.getBytes());
            channel.write(byteBuffer);
        }

        if (bytes == -1) {
            channel.close();
        }
    }

    private void doAccept(SelectionKey key) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        System.out.println("ServerSocketChannel正在循环监听");

        SocketChannel clientChannel = serverSocketChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(key.selector(), SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MyNioServer myNioServer = new MyNioServer();
        myNioServer.initServer();
    }
}
