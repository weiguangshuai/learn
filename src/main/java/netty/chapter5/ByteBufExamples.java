package netty.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author weigs
 * @date 2018/10/30 0030
 */
public class ByteBufExamples {
    public static void main(String[] args) {
//        byteBufWriteRead();
        byteBufSetGet();
    }

    private static void byteBufWriteRead() {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty In Action", utf8);
        System.out.println((char)byteBuf.readByte());
        int readIndex = byteBuf.readerIndex();
        int writeIndex = byteBuf.writerIndex();
        System.out.println("before write :" + writeIndex);
        byteBuf.writeByte((byte) '?');
        System.out.println(readIndex);
        System.out.println("after write :"+byteBuf.writerIndex());
        System.out.println("readableByte :"+byteBuf.readableBytes());
        System.out.println("writableByte :"+byteBuf.writableBytes());
        System.out.println("capacity :"+byteBuf.capacity());
    }

    private static void byteBufSetGet() {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf byteBuf = Unpooled.copiedBuffer("Netty In Action rocks!", utf8);
        System.out.println((char)byteBuf.getByte(0));
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        byteBuf.setByte(0, (byte) 'B');
        System.out.println((char) byteBuf.getByte(0));
        assert readerIndex == byteBuf.readerIndex();
        assert writerIndex == byteBuf.writerIndex();
    }
}
