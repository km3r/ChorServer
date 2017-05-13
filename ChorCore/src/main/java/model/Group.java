package model;

import java.util.ArrayList;
import java.util.List;

/**
 * chorCore
 * <p>
 * Created by Kyle on 4/20/2017.
 */
public class Group {
    private static long curID = 0;
    private List<User> members;
    private List<Task> tasks;
    private String name;
    private long groupId;

    public Group(String name) {
        this.name = name;
        groupId = curID;
        curID++;
        tasks = new ArrayList<>();
        members = new ArrayList<>();
    }

    public long getGroupId() {
        return groupId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<User> getMembers() {
        return members;
    }

    public static long getCurID() {
        return curID;
    }

    public String getName() {
        return name;
    }
}
