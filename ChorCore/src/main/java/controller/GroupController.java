package controller;

import model.Group;
import model.Task;
import model.User;

import java.util.EventListener;
import java.util.List;

/**
 * chorCore
 * <p>
 * Created by Kyle on 4/27/2017.
 */
public class GroupController {

    //TODO add/remove task
    //TODO add/remove user
    //TODO create/destroy group

    public void onTaskEvent(TaskEvent event) {
        if (event.task.getAssigned().equals(event.user)) {
            for (User user: event.task.getAbsentUser()) {
                if (user.getVacationDays() == 0) {
                    event.task.setAssigned(user);
                    event.task.getAbsentUser().remove(user);
                    return;
                }
            }
            List<User> list = event.group.getMembers();
            int i = list.indexOf(event.user);
            for (int j = i + 1; j != i; j = (j + 1) % list.size()) {
                User temp = list.get(j);
                if (event.task.getSkipUser().contains(temp)) {
                    event.task.getSkipUser().remove(temp);
                    continue;
                }
                if (temp.getVacationDays() > 0) {
                    event.task.getAbsentUser().add(temp);
                    continue;
                }
                event.task.setAssigned(temp);
                return;
            }
        } else {
            //earned a skip
            event.task.addSkip(event.user);
        }
    }


}
