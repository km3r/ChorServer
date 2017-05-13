package controller;

import model.DatabaseHolder;
import model.Group;
import model.Task;
import model.User;

/**
 * chorCore
 * <p>
 * Created by Kyle on 4/27/2017.
 */
public class TaskEventFactory {

    private TaskEventFactory() {}

    public static TaskEvent getTaskEvent(DatabaseHolder holder, long taskId, long groupId, long userId)
            throws BadIDException {
        Group g = holder.getGroup(groupId);
        User u = holder.getUser(userId);
        if (g == null || u == null)
            throw new BadIDException();
        Task t = null;
        for (Task task : g.getTasks()) {
            if (task.getTaskID() == taskId) {
                t = task;
                break;
            }
        }
        if (t == null)
            throw new BadIDException();
        return new TaskEvent(t,g,u);
    }
}
