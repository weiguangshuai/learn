package nio.channel;

import java.io.FileNotFoundException;
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
 * @date 2018/9/10 0010
 */
public class CommonMarketing {


    public static void main(String[] args) throws IOException {
        long beginTime = System.currentTimeMillis();
        int reps = 100000;
        FileOutputStream fileOutputStream = new FileOutputStream("balabala.txt", true);
        String[] strs = utterBS(reps);
        for (String string : strs) {
            fileOutputStream.write(string.getBytes("UTF-8"));

        }
        long endTime = System.currentTimeMillis();
        System.out.println("time:" + (endTime - beginTime));
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

    private static String[] utterBS(int num) throws UnsupportedEncodingException {
        List list = new LinkedList();
        for (int i = 0; i < num; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(col3, newline));
        }

        String[] strings = new String[list.size()];
        list.toArray(strings);
        return strings;
    }

    private static Random random = new Random();

    private static String pickRandom(String[] strings, String suffix) throws UnsupportedEncodingException {
        String string = strings[random.nextInt(strings.length)];
        return string;
    }

}
