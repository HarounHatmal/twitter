
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class UserController {
    UserModel userModel;
    UserView userView;
    TreeMap<UserGroup, UserGroup> tree; // used to search through usergroups
    
    public UserController(UserModel user, TreeMap<UserGroup, UserGroup> adminModel) {
        userModel = user;
        userView = new UserView();
        tree = adminModel;
        userView.addFollowListener(new AddFollowListener());
        userView.addTweetListener(new AddTweetListener());
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
                        // cast it
                        if(((Follower)o).getID().equals(userView.getUserID()))
                            isUser = false;
                    }
                }
                
                if(isUser) {
                    Follower follower = new Follower(userView.getUserID(), userModel);
                    userView.addFollowingListItem(userView.getUserID());
                    
                }
            }
        } 
    }
    public class AddTweetListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Helper h = new Helper();
            if(!h.isNullOrWhiteSpace(userView.getTweet())) {
                userModel.notifyObserver(userView.getTweet());  // send tweet to everyone
            }
        }
    }
}

