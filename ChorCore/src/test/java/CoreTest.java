import controller.Core;
import message.LoginMessage;
import message.LoginReply;
import message.UserMessage;
import org.junit.Test;

/**
 * chorCore
 * <p>
 * Created by Kyle on 4/20/2017.
 */
public class CoreTest {

    @Test
    public void testTest(){
        Core core = new Core();
        assert core.foo();
    }

    @Test
    public void messageTest() {
        LoginMessage loginMessage = new LoginMessage("bob", null);
        LoginReply reply = new LoginReply(0);
        UserMessage userMessage = new UserMessage(0);
    }

}
