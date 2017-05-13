package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * chorCore
 * <p>
 * Created by Kyle on 4/27/2017.
 */
public class Task extends Observable {
    private static long curID = 0;
    private String name;
    private User assigned;
    private List<User> skipUser;
    private List<User> absentUser;
    private long taskID;

    public Task(String name, User assigned) {
        this.name = name;
        this.assigned = assigned;
        taskID = curID;
        curID++;
        skipUser = new ArrayList<>();
        absentUser = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        notifyObservers();
        this.name = name;
    }

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        notifyObservers();
        this.assigned = assigned;
    }

    public long getTaskID() {
        return taskID;
    }

    public List<User> getSkipUser() {
        return skipUser;
    }

    public List<User> getAbsentUser() {
        return absentUser;
    }

    public void addSkip(User user){
        skipUser.add(user);
    }
}
