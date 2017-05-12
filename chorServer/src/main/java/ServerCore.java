import com.sun.net.httpserver.HttpServer;
import controller.Core;
import model.DatabaseHolder;
import model.User;

import java.net.InetSocketAddress;
import java.security.MessageDigest;
import java.util.concurrent.Executors;


/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class ServerCore {
    Core core;
    HttpServer server;
    InetSocketAddress address;

    public ServerCore() {
        core = new Core();
        MessageDigest md;
        //TEMP
        DatabaseHolder holder;
        try {
            md = MessageDigest.getInstance("SHA");
            holder = new DatabaseHolder();
            String password = "hi";
            byte arr[] = password.getBytes();
            arr = password.getBytes();
            User temp = new User("Bob", arr);
            holder.addUser(temp);


            //TEMP END
            address = new InetSocketAddress(17546);

            server = HttpServer.create(address, 0);
            server.createContext("/login", new LoginManager(holder));
            server.createContext("/settings", new UserManager(holder));
            server.createContext("/group", new GroupManager(holder));
            server.createContext("/task", new TaskManager(holder));
            server.setExecutor(Executors.newSingleThreadExecutor());
            server.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
