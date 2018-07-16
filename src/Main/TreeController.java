
package Main;

import java.util.Map;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TreeController {
    private TreeView treeView;
    private TreeModel treeModel;
    
    public TreeController(TreeView tv, TreeModel tm) {
        treeView = tv;
        treeModel = tm;
        //addGroup(new UserGroup("Test"), new UserGroup("Teast"));
        tv.addListSelectionListener(new SelectItemListener());
    }
    public TreeView getView() {
        return treeView;
    }
    public void addItemToView(String s) {
        treeView.addListItem(s);
    }
    public TreeModel getModel() {
        return treeModel;
    }
    public void updateView() {
        treeView.clearList();

        for(Map.Entry<UserGroup, UserGroup> entry : treeModel.getTree().entrySet()) {
            //  add group and its users
            // dealing with root case
            if(entry.getKey().getID() == "root") {
                treeView.addListItem(entry.getKey().getID());
                if(entry.getKey().getUserList() != null)
                    for(String s : entry.getKey().getUserList())
                        treeView.addListItem(s);
            }
            if(entry.getValue().getID() != null) {
                treeView.addListItem(" " + entry.getValue().getID());
                if(entry.getValue().getUserList() != null) {
                    for(String s : entry.getValue().getUserList())
                        treeView.addListItem(s);
                }
            }
        }
    }
    //  group should be added under another group(highlighted on list)
    //  adds and updates list
    //  k represents the highlighted group
    public void addGroup(UserGroup k, UserGroup v) {
        treeModel.addNode(k, v);
        treeView.addListItem("root");
        for(Map.Entry<UserGroup, UserGroup> entry : treeModel.getTree().entrySet()) {
            //  add group and its users
            treeView.addListItem(" " + entry.getValue().getID());
            if(entry.getValue().getUserList() != null) {
                for(String s : entry.getValue().getUserList())
                    treeView.addListItem(s);
            }
        }
    }
    public class SelectItemListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(!e.getValueIsAdjusting()) {
                if(treeView.getList().getSelectedValue() != null)
                    treeModel.setSelectedItem(treeView.getList().getSelectedValue().toString());
            }
        }
        
    }
}
