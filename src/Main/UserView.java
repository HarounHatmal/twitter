
package Main;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class UserView extends JFrame {
    private JList followingList;
    private JList tweetList;
    private DefaultListModel followingListModel;
    private DefaultListModel tweetListModel;
    private JTextField userIDTextBox;
    private JTextField tweetTextBox;
    private JButton followUserButton;
    private JButton tweetButton;
    private JLabel creationTimeLabel;
    private JLabel lastUpdateTimeLabel;
    
    public UserView() {
        super("User View");
        this.setSize(800, 500);
        this.setLayout(new GridLayout(6, 1));
        JPanel topPanel = new JPanel();
        JPanel followingPanel = new JPanel();  //list
        JPanel newsFeedPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel creationTimePanel = new JPanel();
        JPanel lastUpdateTimePanel = new JPanel();
        followingListModel = new DefaultListModel();
        followingList = new JList();
        followingList.setFixedCellHeight(50);
        followingList.setFixedCellWidth(70);
        followingList.setLayoutOrientation(JList.VERTICAL_WRAP);
        tweetListModel = new DefaultListModel();
        tweetList = new JList();
        tweetList.setFixedCellHeight(50);
        tweetList.setFixedCellWidth(70);
        tweetList.setLayoutOrientation(JList.VERTICAL_WRAP);
        topPanel.setLayout(new GridLayout(0, 2));
        bottomPanel.setLayout(new GridLayout(0, 2));
        userIDTextBox = new JTextField();
        followUserButton = new JButton("Follow User");
        tweetTextBox = new JTextField();
        tweetButton = new JButton("Tweet Message");
        creationTimeLabel = new JLabel();
        lastUpdateTimeLabel = new JLabel();
        topPanel.add(userIDTextBox);
        topPanel.add(followUserButton);
        followingPanel.add(followingList);
        bottomPanel.add(tweetTextBox);
        bottomPanel.add(tweetButton);
        newsFeedPanel.add(tweetList);
        creationTimePanel.add(creationTimeLabel);
        lastUpdateTimePanel.add(lastUpdateTimeLabel);
        this.add(topPanel);
        this.add(followingList);
        this.add(bottomPanel);
        this.add(tweetList);
        this.add(creationTimePanel);
        this.add(lastUpdateTimePanel);
        this.setVisible(true);
    }
    public void setCreationTimeLabel(long time) {
        creationTimeLabel.setText("Time Created: " + time);
    }
    public void setLastUpdateTimeLabel(long time) {
        lastUpdateTimeLabel.setText("Last Updated Time: " + time);
    }
    public void clearTweetList() {
        tweetListModel.removeAllElements();
    }
    public void setTweetList(List<String> tweets ) {
        if(tweetListModel == null)
            tweetListModel = new DefaultListModel();
        for(String s : tweets)
            tweetListModel.addElement(s);
        tweetList.setModel(tweetListModel);
    }
    public String getUserID() {
        return userIDTextBox.getText();
    }
    public String getTweet() {
        return tweetTextBox.getText();
    }
    public void addFollowListener(ActionListener addFollow) {
        followUserButton.addActionListener(addFollow);
    }
    public void addTweetListener(ActionListener addTweet) {
        tweetButton.addActionListener(addTweet);
    }
    public JList getFollowingList() {
        return followingList;
    }
    public void addFollowingListItem(String s) {
        if(followingListModel == null)
            followingListModel = new DefaultListModel();
        
        followingListModel.addElement(s);
        followingList.setModel(followingListModel);
    }
}
