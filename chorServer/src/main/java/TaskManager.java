import com.sun.net.httpserver.HttpExchange;
import model.DatabaseHolder;

import java.io.IOException;

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
    public void handle(HttpExchange httpExchange) throws IOException {

    }
}
