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
    private String userID;
    private List<String> newsFeed;
    
    
    public Follower(String ID, Subject s) {
        userID = ID;
        s.register(this);
    }
    public String getID() {
        return userID;
    }
    @Override
    public void update(String tweet) {
        if(newsFeed == null)
            newsFeed = new ArrayList();
        newsFeed.add(tweet);
        // add newsfeed
    } 
}
