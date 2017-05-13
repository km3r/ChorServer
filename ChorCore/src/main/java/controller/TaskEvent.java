package controller;

import model.Group;
import model.Task;
import model.User;

import java.util.EventObject;

/**
 * chorCore
 * <p>
 * Created by Kyle on 4/27/2017.
 */
public class TaskEvent {
    Task task;
    Group group;
    User user;

    /**
     * Constructs a TaskEvent.
     *
     * @param task The task on which the Event initially occurred.
     * @throws IllegalArgumentException if task is null.
     */
    protected TaskEvent(Task task, Group group, User user) {
        this.task = task;
        this.group = group;
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public Group getGroup() {
        return group;
    }

    public User getUser() {
        return user;
    }
}
