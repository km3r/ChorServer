package model;

import java.util.ArrayList;
import java.util.List;

/**
 * chorCore
 * <p>
 * Created by Kyle on 4/27/2017.
 */
public class DatabaseHolder {
    List<User> allUsers;
    List<Group> allGroups; //groups also have tasks

    public DatabaseHolder() {
        allGroups = new ArrayList<>();
        allUsers = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public List<Group> getAllGroups() {
        return allGroups;
    }

    public void addUser(User user) {
        allUsers.add(user);
    }

    public void addGroup(Group group) {
        allGroups.add(group);
    }

    public void removeUser(User user) {
        allUsers.remove(user);
    }

    public void removeGroup(Group group) {
        allGroups.remove(group);
    }


    public User getUser(long id) {
        for (User u: allUsers) {
            if (u.getUserID() == id) {
                return u;
            }
        }
        return null;
    }

    public Group getGroup(long id) {
        for (Group g: allGroups) {
            if (g.getGroupId() == id) {
                return g;
            }
        }
        return null;
    }
}
