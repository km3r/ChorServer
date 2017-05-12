import model.DatabaseHolder;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 * (Short Description)
 *
 * @author Kyle Rosenthal
 * @version (AssignmentName)
 */
public class ServerTest {

    @Test
    public void TestServer() {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA");

            DatabaseHolder holder = new DatabaseHolder();
            String password = "hi";
            byte arr[] = password.getBytes();
            arr = md.digest(md.digest(arr));
            ServerCore core = new ServerCore();
            URL url = new URL("http://localhost:17546/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("POST");
            //connection.setRequestProperty("User-Agent", "chor_connection_test");
            //connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setDoOutput(true);
            PrintStream stream = new PrintStream(connection.getOutputStream());
            stream.println("Bob");
            stream.println("hi");
            stream.flush();
            stream.close();
            connection.getResponseCode();
            Scanner in = new Scanner(connection.getInputStream());
            assert in.nextLine().equals("0");
        } catch (Exception e) {

            e.printStackTrace();
            assert false;
        }
    }

}
