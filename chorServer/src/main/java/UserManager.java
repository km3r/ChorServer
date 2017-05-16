import com.sun.net.httpserver.HttpExchange;
import model.DatabaseHolder;
import model.User;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class UserManager extends Manager {

    User lastUser;

    public UserManager(DatabaseHolder core) {
        super(core);
    }

    @Override
    protected void readPacket(Scanner in) {
        String command = in.nextLine();
        String name = in.nextLine();
        String pass = in.nextLine();
        switch (command) {
            case "CREATE":
                lastUser = new User(name,pass.getBytes());
                core.addUser(lastUser);
        }
    }

    @Override
    protected void replyPacket(PrintStream out) {
        out.println(lastUser.getUserID());
    }

}
