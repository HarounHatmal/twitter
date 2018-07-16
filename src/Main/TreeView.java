
package Main;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TreeView extends JPanel {
    private JList list;
    private DefaultListModel defaultListModel;
    private ListSelectionModel listSelectionModel;
    
    public TreeView() {
        defaultListModel = new DefaultListModel();
        list = new JList();
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        addListItem("root");
        list.setSize(250,250);
        list.setFixedCellHeight(50);
        list.setFixedCellWidth(70);
        this.add(list);
    }
    public JList getList() {
        return list;
    }
    public void clearList() {
        defaultListModel.removeAllElements();
    }
    public void addListItem(String s) {
        if(defaultListModel == null)
            defaultListModel = new DefaultListModel();
        
        defaultListModel.addElement(s);
        list.setModel(defaultListModel);
    }
    public void addListSelectionListener(ListSelectionListener selectedItem) {
        if(list != null) {
            list.addListSelectionListener(selectedItem);
        }
    }
}
