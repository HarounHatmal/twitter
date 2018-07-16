
package Main;

import java.util.TreeMap;

public class TreeModel {
    private TreeMap<UserGroup, UserGroup> map;
    private String selectedItem;

    public TreeModel(TreeMap<UserGroup, UserGroup> m) {
        map = m;
        selectedItem = null;
    }
    public TreeMap<UserGroup, UserGroup> getTree() {
        return map;
    }
    public void updateMap(TreeMap<UserGroup, UserGroup> newMap) {
        map = newMap;
    }
    public void addNode(UserGroup k, UserGroup v) {
        map.put(k, v);
    }
    public String getSelectedItem() {
        if(selectedItem == null)
            return null;;
        return selectedItem.replaceAll("\\s+", "");  // remove white space
    }
    void setSelectedItem(String s) {
        selectedItem = s;
    }
}
