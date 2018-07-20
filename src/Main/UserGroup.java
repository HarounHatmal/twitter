/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;

public class UserGroup implements Comparable<UserGroup> {
    private String uniqueID;
    private List<String> userList;
    private long creationTime;
    
    public UserGroup(String id) {
        uniqueID = id;
        creationTime = System.currentTimeMillis();
    }
    public long getCreationTime() {
        return creationTime;
    }
    public String getID() {
        return uniqueID;
    }
    public List<String> getUserList() {
        return userList;
    }
    public void addUser(String id) {
        if(userList == null)
            userList = new ArrayList();
        userList.add(id);
    }
    @Override
    public int compareTo(UserGroup obj) {
        return uniqueID.compareTo(obj.uniqueID);
    }
}
