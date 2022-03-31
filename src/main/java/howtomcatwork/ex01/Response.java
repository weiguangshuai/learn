package howtomcatwork.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

public class Response implements Runnable {
    private static final int BUFFER_SIZE = 1024;
    private Request request;
    private Socket socket;
    OutputStream outputStream = null;

    public Response(Socket socket) {
        this.socket = socket;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void run() {
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int count = fis.available();
                byte[] bytes = new byte[count];
                fis.read(bytes);
                String message = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n";
                outputStream.write(message.getBytes(Charset.defaultCharset()));
                outputStream.write(bytes);

            } else {
                // file not found
                String errorMessage = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>\r\n" +
                        "\r\n";
                outputStream.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
