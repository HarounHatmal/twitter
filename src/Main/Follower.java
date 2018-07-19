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
public class Follower implements Observer {
    private UserModel userFollower;
    private String userID;
    
    public Follower(UserModel user, String id) {
        userFollower = user;
        id = user.getID();
    }
    public Follower(UserModel user, Subject s) {
        userFollower = user;
        userID = user.getID();
        s.register(this);
    }
    public String getID() {
        return userID;
    }
    public UserModel getUserFollower() {
        return userFollower;
    }
    @Override
    public void update(String tweet) {
        userFollower.addNewsFeed(tweet);
    } 
}
