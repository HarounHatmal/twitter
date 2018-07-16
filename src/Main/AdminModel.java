/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author harou
 */
public class AdminModel {
    private TreeMap<UserGroup, UserGroup> map;  
    private int totalUser;
    private int totalGroup;
    
    public AdminModel() {
        map = new TreeMap();
        map.put(new UserGroup("root"), new UserGroup(null)); 
        totalUser = 0;
        totalGroup = 1;
    }
    public TreeMap<UserGroup, UserGroup> getMap() {
        return map;
    }
    //  add user to a group
    public void addUser(String id, UserGroup group) {
        group.addUser(id);
    }
    public void addGroup(String k, String v) {
        if(map == null)
            map = new TreeMap();
        map.put(new UserGroup(k), new UserGroup(v));
    }
    public TreeMap<UserGroup, UserGroup> getTree() {
        return map;
    }
    public int getTotalUser() {
        return totalUser;
    }
    public void incrementTotalUser() {
        totalUser++;
    }
    public int getTotalGroup() {
        return totalGroup;
    }
    public void incrementTotalGroup() {
        totalGroup++;
    }
}
