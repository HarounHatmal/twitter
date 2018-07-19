
package Main;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminView extends JFrame {
   private JPanel listPanel;    // contains list of groups/users
   private JPanel inputPanel;
   private JTextField userIDTextBox;
   private JTextField groupIDTextBox;
   private JButton userIDButton;
   private JButton groupIDButton;
   private JButton userViewButton;
   private JButton showUserTotalButton;
   private JButton showGroupTotalButton;
   private JButton showMessageTotalButton;
   private JButton showPositivePercentageButton;
    public AdminView() {
        super("Admin Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        JPanel inputPanel = new JPanel();
        listPanel = new JPanel();
        //listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
        inputPanel.setLayout(new GridLayout(2, 1));
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2));
        bottomPanel.setLayout(new GridLayout(2, 2));
        userIDTextBox = new JTextField(10);
        groupIDTextBox = new JTextField(10);
        userIDButton = new JButton("Add User");
        groupIDButton = new JButton("Add Group");
        userViewButton = new JButton("Open User View");
        showUserTotalButton = new JButton("Show User Total");
        showGroupTotalButton = new JButton("Show Group Total");
        showMessageTotalButton = new JButton("Show Message Total");
        showPositivePercentageButton = new JButton("Show Positive Percentage");
        topPanel.add(userIDTextBox);
        topPanel.add(userIDButton);
        topPanel.add(groupIDTextBox);
        topPanel.add(groupIDButton);
        topPanel.add(userViewButton);
        bottomPanel.add(showUserTotalButton);
        bottomPanel.add(showGroupTotalButton);
        bottomPanel.add(showMessageTotalButton);
        bottomPanel.add(showPositivePercentageButton);
        this.setLayout(new GridLayout(1,2));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        inputPanel.add(topPanel);
        inputPanel.add(bottomPanel);
        this.add(inputPanel); 
        this.add(listPanel);
    }
    public void addListPanel(JPanel p) {
        listPanel = p;
        listPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(listPanel);
        listPanel.validate();
        listPanel.repaint();
    }
    public String getUserID() {
        return userIDTextBox.getText();
    }
    public String getGroupID() {
        return groupIDTextBox.getText();
    }
    public String getUserId() {
        return userIDTextBox.getText();
    }
    public void addUserListener(ActionListener addUser) {
        userIDButton.addActionListener(addUser);
    }
    public void addGroupListener(ActionListener addGroup) {
        groupIDButton.addActionListener(addGroup);
    }
    public void addUserTotalListener(ActionListener addUserTotal) {
        showUserTotalButton.addActionListener(addUserTotal);
    }
    public void addTotalMessageListener(ActionListener addTotalMessage) {
        showMessageTotalButton.addActionListener(addTotalMessage);
    }
    public void addGroupTotalListener(ActionListener addGroupTotal) {
        showGroupTotalButton.addActionListener(addGroupTotal);
    }
    public void addOpenUserViewListener(ActionListener addOpenUserView) {
       userViewButton.addActionListener(addOpenUserView);
    }
}
