import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.DatabaseHolder;
import model.User;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public abstract class Manager implements HttpHandler {
    DatabaseHolder core;

    public Manager(DatabaseHolder core) {
        this.core = core;
    }

    protected abstract void readPacket(Scanner in);
    protected abstract void replyPacket(PrintStream out);

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Scanner in = new Scanner(httpExchange.getRequestBody());

        readPacket(in);

        //System.out.println(response);

        httpExchange.sendResponseHeaders(200, 0);
        PrintStream os = new PrintStream(httpExchange.getResponseBody());

        replyPacket(os);
        os.flush();
        os.close();
    }
}
