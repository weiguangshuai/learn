package howtomcatwork.ex01;

import java.io.IOException;
import java.io.InputStream;

public class Request {
    private String uri;
    private InputStream inputStream;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() throws IOException {
        StringBuilder request = new StringBuilder();
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }
        byte[] buffer = new byte[count];
        inputStream.read(buffer);
        for (byte b : buffer) {
            request.append((char) b);
        }
        System.out.println(request.toString());
        uri = parseUri(request.toString());
    }

    private String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1) {
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1)
                return requestString.substring(index1 + 1, index2);
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
