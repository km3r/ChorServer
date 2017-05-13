import controller.BadIDException;
import controller.TaskEvent;
import controller.TaskEventFactory;
import model.DatabaseHolder;
import model.Group;
import model.Task;
import model.User;
import org.junit.Test;
import org.junit.Before;

/**
 * Created by kmrosent on 5/3/17.
 */
public class TaskTest {
    DatabaseHolder holder;
    Group group;
    User user1;
    User user2;
    Task task;


    @Before
    public void setup() {
        holder = new DatabaseHolder();
        group = new Group("Test_Group");
        user1 = new User("u1", new byte[] {0});
        user1 = new User("u2", new byte[] {0});
        task = new Task("chore", user1);

        group.getMembers().add(user1);
        group.getMembers().add(user2);
        group.getTasks().add(task);
        holder.addGroup(group);
        holder.addUser(user1);
        holder.addUser(user2);
        user1.getUserID();

    }

    @Test
    public void factoryTest() {
        TaskEvent event;
        try {
            event = TaskEventFactory.getTaskEvent(holder,task.getTaskID(),group.getGroupId(), user1.getUserID());
            assert event.getTask().getName().equals("chore");
        } catch (BadIDException e) {
            e.printStackTrace();
        }

    }



    @Test
    public void taskTest() {
        assert task.getAssigned().equals(user1);
    }
}
