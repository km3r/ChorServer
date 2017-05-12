import com.sun.net.httpserver.HttpExchange;
import model.DatabaseHolder;

import java.io.IOException;

/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class GroupManager extends Manager {
    public GroupManager(DatabaseHolder core) {
        super(core);
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

    }
}
