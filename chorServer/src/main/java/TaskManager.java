import com.sun.net.httpserver.HttpExchange;
import model.DatabaseHolder;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class TaskManager extends Manager {
    public TaskManager(DatabaseHolder core) {
        super(core);
    }

    @Override
    protected void readPacket(Scanner in) {

    }

    @Override
    protected void replyPacket(PrintStream out) {

    }
}
