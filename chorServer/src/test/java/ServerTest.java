import model.DatabaseHolder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

    static ServerCore core;

    @BeforeClass
    public static void setCore() {
        core = new ServerCore();
    }

    @Test
    public void TestServer() {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA");

            DatabaseHolder holder = new DatabaseHolder();
            String password = "hi";
            byte arr[] = password.getBytes();
            arr = md.digest(md.digest(arr));

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

    @Test
    public void userCreateTest() {

        URL url = null;
        try {
            url = new URL("http://localhost:17546/user");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            PrintStream stream = new PrintStream(connection.getOutputStream());
            stream.println("CREATE");
            stream.println("Fred");
            stream.println("pass");
            stream.flush();
            stream.close();
            connection.getResponseCode();
            Scanner in = new Scanner(connection.getInputStream());
            String id = in.nextLine();
            in.close();
            url = new URL("http://localhost:17546/login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            stream = new PrintStream(connection.getOutputStream());
            stream.println("Fred");
            stream.println("pass");
            stream.flush();
            stream.close();
            connection.getResponseCode();
            in = new Scanner(connection.getInputStream());
            assert in.nextLine().equals(id);
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }

    }
}
