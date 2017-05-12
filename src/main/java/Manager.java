import com.sun.net.httpserver.HttpHandler;
import model.DatabaseHolder;

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
}
