/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JOptionPane;

public class AdminController {
    private AdminView adminView;
    private AdminModel adminModel;
    TreeController tc;
    public AdminController(AdminView av, AdminModel am) {
        adminView = av;
        adminModel = am;
        adminView.addUserListener(new AddUserListener());     
        adminView.addGroupListener(new AddGroupListener());
        adminView.addUserTotalListener(new AddUserTotalListener());
        adminView.addGroupTotalListener(new AddGroupTotalListener());
        adminView.addOpenUserViewListener(new AddOpenUserViewListener());
        // need to get selected group
        TreeView tv = new TreeView();
        TreeModel tm = new TreeModel(adminModel.getMap());
        tc = new TreeController(tv, tm);
        av.addListPanel(tv);
        adminView.setVisible(true);
    }
    
    public class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Helper h = new Helper();
            if(!h.isNullOrWhiteSpace(adminView.getUserID())) {
                String selectedItem = tc.getModel().getSelectedItem();
                if(selectedItem == null)
                    return;
                // a user group must be selected for the user to be entered in
                
                UserGroup group = null;                 
                for(Map.Entry<UserGroup, UserGroup> entry : adminModel.getTree().entrySet()) {
                    if("root".equals(selectedItem))
                        group = entry.getKey(); //root group
                    else if(entry.getKey().getID().equals(selectedItem))
                        group = entry.getKey();
                    else if(entry.getValue().getID().equals(selectedItem))
                        group = entry.getValue();
                }
                if(group == null)
                    return;
                adminModel.addUser(adminView.getUserID(), group);
                // need to update tree model
                // update tree view off tree model
                tc.getModel().updateMap(adminModel.getMap());
                tc.updateView();
                tc.getModel().setSelectedItem(null);
                adminModel.incrementTotalUser();
            }
        } 
    }
    public class AddGroupListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Helper h = new Helper();
            if(!h.isNullOrWhiteSpace(adminView.getGroupID())) {
                    // given a selected item
                    // need to check if its a group in the map
                    String selectedItem = tc.getModel().getSelectedItem();
                    boolean isGroup = false;
                for(Map.Entry<UserGroup, UserGroup> entry : adminModel.getTree().entrySet()) {
                    if("root".equals(selectedItem) || entry.getKey().getID().equals(selectedItem) || entry.getValue().getID().equals(selectedItem)) 
                        isGroup = true;
                }
                if(isGroup) {
                    adminModel.addGroup(tc.getModel().getSelectedItem(), adminView.getGroupID());
                    tc.getModel().updateMap(adminModel.getMap());
                    tc.updateView();
                    tc.getModel().setSelectedItem(null);
                    adminModel.incrementTotalGroup();
                }
            }   
        }
    }
    public class AddUserTotalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Total User Count: " + adminModel.getTotalUser());
        }
    }
    public class AddGroupTotalListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Total Group Count: " + adminModel.getTotalGroup());
        }       
    }
    public class AddOpenUserViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedItem = tc.getModel().getSelectedItem();
            if(selectedItem == null)
                return;
            // need to find User class for a given selected item
            UserModel user = null;
            for(Map.Entry<UserGroup, UserGroup> entry : adminModel.getTree().entrySet()) {
                if(entry.getKey().getID().equals("root")) {
                    if(entry.getKey().getUserList() != null)
                        for(String s : entry.getKey().getUserList()) 
                            if(s.equals(selectedItem))
                                user = new UserModel(selectedItem);
                }
                if(entry.getValue() != null) {
                    if(entry.getValue().getUserList() != null)
                        for(String s : entry.getValue().getUserList())
                            if(s.equals(selectedItem))
                                user = new UserModel(selectedItem);
                }
            }
            UserController uc;
            if(user != null) {
                uc = new UserController(user, adminModel.getTree());
                // go through all 
            }
        }  
    }
}
    
