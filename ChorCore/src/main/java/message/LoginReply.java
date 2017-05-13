package message;

/**
 * chorCore
 * <p>
 * Created by Kyle on 5/11/2017.
 */
public class LoginReply extends Message {
    public LoginReply(long userID) {
        super(userID, MessageType.LOGIN);
    }
}
