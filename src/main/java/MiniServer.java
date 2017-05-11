import java.net.Socket;

/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class MiniServer extends Thread {

    private Socket socket;

    public MiniServer(Socket socket) {
        super("IndividualServer");
        this.socket = socket;
    }

    public void run() {
        //TODO login
        //TODO add
    }
}
