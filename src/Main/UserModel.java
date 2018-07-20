
package Main;

import java.util.ArrayList;
import java.util.List;

public class UserModel implements Subject {
    private String uniqueID;
    private List<Observer> followerList;   // follower list
    private List<String> newsFeed;
    private static int tweetCount;
    private long creationTime;
    private long lastUpdateTime;
    
    public UserModel(String id) {
        uniqueID = id;
        creationTime = System.currentTimeMillis();
    }
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }
    public long getCreationTime() {
        return creationTime;
    }
    public List<String> getNewsFeed() {
        return newsFeed;
    }
    public String getID() {
        return uniqueID;
    }
    public int getTweetCount() {
        return tweetCount;
    }
    public void incrementTweetCount() {
        tweetCount++;
    }
    public void setFollowerList(List<Observer> list) {
        followerList = list;
    }
    public List<Observer> getFollowerList() {
        return followerList;
    }
    public void addNewsFeed(String tweet) {
        if(newsFeed == null)
            newsFeed = new ArrayList();
        newsFeed.add(tweet);
        tweetCount++;
        lastUpdateTime = System.currentTimeMillis();
    }
    private void setNewsFeed(List<String> tweets) {
        newsFeed = tweets;
    }
    @Override
    public void register(Observer follower) {
        if(followerList == null)
            followerList = new ArrayList();
        followerList.add(follower);
    }

    @Override
    public void notifyObserver(String tweet) {
        if(followerList != null)
            for(Observer s : followerList) {
                s.update(tweet);
            }
    }
}
