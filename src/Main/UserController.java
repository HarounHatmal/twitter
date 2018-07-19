
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserController {
    private UserModel userModel;
    private UserView userView;
    private TreeMap<UserGroup, UserGroup> tree; // used to search through usergroups
    private List<UserModel> userList;
    private static List<UserController> userControllerList; // to update views of other users
    
    public UserController(UserModel user, TreeMap<UserGroup, UserGroup> adminModel, List<UserModel> users) {
        userModel = user;
        userView = new UserView();
        tree = adminModel;
        userView.addFollowListener(new AddFollowListener());
        userView.addTweetListener(new AddTweetListener());
        userList = users;
        if(userControllerList == null)
            userControllerList = new ArrayList();
        userControllerList.add(this);
    }
    public class AddFollowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Helper h = new Helper();
            if(!h.isNullOrWhiteSpace(userView.getUserID())) {
                // need to check if its a user and its not the current user
                // need to check if user is already being followed
                if(userView.getUserID().equals(userModel.getID()))
                    return;
                boolean isUser = false;
                for(Map.Entry<UserGroup, UserGroup> entry : tree.entrySet()) {
                    if(entry.getKey().getID().equals("root")) {
                        if(entry.getKey().getUserList() != null)
                            for(String s : entry.getKey().getUserList()) 
                                if(s.equals(userView.getUserID()))
                                    isUser = true;
                    }
                    if(entry.getValue() != null) {
                        if(entry.getValue().getUserList() != null)
                            for(String s : entry.getValue().getUserList())
                                if(s.equals(userView.getUserID()))
                                    isUser = true;
                    }
                }
                // user non-existant
                if(!isUser)
                    return;
                // if null then no followers anyways
                if(userModel.getFollowerList() != null) {
                    for(Observer o : userModel.getFollowerList()) {
                        if(((Follower)o).getID().equals(userView.getUserID()))
                            isUser = false;
                    }
                }
                
                if(isUser) {
                    userView.addFollowingListItem(userView.getUserID());
                    // add this instance of usermodel to user being followed
                    for(UserModel u : userList) {
                        if(u.getID().equals(userView.getUserID())) {
                            Follower follower = new Follower(userModel, u);
                        }    
                    }
                }   
            }
        }
    }
    public void updateView() {
        for(Observer o : userModel.getFollowerList()) {
            for(UserController uc : userControllerList){
                if(uc.userModel == ((Follower)o).getUserFollower()) {
                    uc.userView.clearTweetList();
                    uc.userView.setTweetList(uc.userModel.getNewsFeed());
                }
            }
        }
    }
       
    public UserModel findUserClass(String id) {
        for(UserModel u : userList) {
            if(u.getID().equals(id))
                return u;
        }
        return null;
    } 
    public class AddTweetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Helper h = new Helper();
            if(!h.isNullOrWhiteSpace(userView.getTweet())) {
                userModel.notifyObserver(userView.getTweet());  // send tweet to everyone then update their views
                updateView();
                userModel.incrementTweetCount();
            }
        }
    }
}
    
    
 

