package nio.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author weigs
 * @date 2017/12/20 0020
 */
public class Marketing {
    public static void main(String[] args) throws IOException {
        int reps = 10;
        FileOutputStream fileOutputStream = new FileOutputStream("balabala.txt");
        GatheringByteChannel gatheringByteChannel = fileOutputStream.getChannel();
        ByteBuffer[] bs = utterBS(reps);
        while (gatheringByteChannel.write(bs) > 0) {
        }
        System.out.println("Mindshare paradigms synergized to ");

    }

    private static String[] col1 = {
            "Aggregate", "Enable", "Leverage",
            "Facilitate", "Synergize", "Repurpose",
            "Strategize", "Reinvent", "Harness"
    };
    private static String[] col2 = {
            "cross-platform", "best-of-breed", "frictionless",
            "ubiquitous", "extensible", "compelling",
            "mission-critical", "collaborative", "integrated"
    };
    private static String[] col3 = {
            "methodologies", "infomediaries", "platforms",
            "schemas", "mindshare", "paradigms",
            "functionalities", "web services", "infrastructures"
    };

    private static String newline = System.getProperty("line.separator");

    private static ByteBuffer[] utterBS(int num) throws UnsupportedEncodingException {
        List list = new LinkedList();
        for (int i = 0; i < num; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(col3, newline));
        }

        ByteBuffer[] byteBuffers = new ByteBuffer[list.size()];
        list.toArray(byteBuffers);
        return byteBuffers;
    }

    private static Random random = new Random();

    private static ByteBuffer pickRandom(String[] strings, String suffix) throws UnsupportedEncodingException {
        String string = strings[random.nextInt(strings.length)];
        int total = string.length() + suffix.length();
        ByteBuffer byteBuffer = ByteBuffer.allocate(total);
        byteBuffer.put(string.getBytes("US-ASCII"));
        byteBuffer.put(suffix.getBytes("US-ASCII"));
        byteBuffer.flip();
        return byteBuffer;
    }
}
