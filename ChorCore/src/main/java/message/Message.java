package message;

import java.io.Serializable;

/**
 * The message class to be sent over the network
 *
 * @author Kyle Rosenthal
 * @version 1
 */
public class Message implements Serializable {
   private long userID;
   private MessageType supertype;


   public Message(long userID, MessageType type) {
      this.userID = userID;
      this.supertype = type;
   }

   public long getUserID() {
      return userID;
   }

   public MessageType getSuperType() {
      return supertype;
   }
}
enum MessageType {
   LOGIN, USER_ACTION, GROUP_ACTION, TASK_ACTION
}
