import controller.Core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class ServerCore {
    Core core;
    ServerSocket serverSocket;


    public ServerCore() {
        try {
            serverSocket = new ServerSocket(17546);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket socket;
        while (true) {
            try {
                socket = serverSocket.accept();
                MiniServer mini = new MiniServer(socket);
                mini.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
