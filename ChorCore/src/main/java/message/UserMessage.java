package message;

import model.User;

/**
 * (Short Description)
 *
 * @author Kyle Rosenthal
 * @version (AssignmentName)
 */
public class UserMessage  extends Message{

   public UserMessage(long userID) {
      super(userID, MessageType.USER_ACTION);
   }
}

enum UserMessageType {
   CREATE, UPDATE, ADD_GROUP, LEAVE_GROUP
}
