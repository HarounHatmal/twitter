
package Main;

import java.util.ArrayList;
import java.util.List;

public class UserModel implements Subject {
    private String uniqueID;
    private List<Observer> followerList;   // follower list
    private List<String> newsFeed;
    private Follower follower;
    
    public UserModel(String id) {
        uniqueID = id;
    }
    public String getID() {
        return uniqueID;
    }
    public List<Observer> getFollowerList() {
        return followerList;
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
        for(Observer s : followerList)
            s.update(tweet);
    }
}
