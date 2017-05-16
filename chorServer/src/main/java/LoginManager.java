import com.sun.net.httpserver.HttpExchange;
import model.DatabaseHolder;
import model.User;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * chorServer
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class LoginManager extends Manager {
    MessageDigest md;

    String id;

    public LoginManager(DatabaseHolder core) {
        super(core);
        try {
            md = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void readPacket(Scanner in) {
        id = "FAIL";

        String name = in.nextLine();
        String pass = in.nextLine();

        in.close();
        for (User u2 : core.getAllUsers()) {
            if (u2.getName().equals(name)) {
                if (Arrays.equals(pass.getBytes(), u2.getHashPass())) {
                    // password correct
                    id = u2.getUserID() + "";
                }

                break;
            }
        }
    }

    @Override
    protected void replyPacket(PrintStream out) {
        out.println(id);
    }


}
