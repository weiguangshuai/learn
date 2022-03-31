package howtomcatwork.ex01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator + "webroot";
    // shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();

                // create Request object and parse
                Request request = new Request(input);
                request.parse();

                // create Response object
                Response response = new Response(socket);
                response.setRequest(request);
                new Thread(response).start();

                //check if the previous URI is a shutdown command
                shutdown = SHUTDOWN_COMMAND.equals(request.getUri());
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
