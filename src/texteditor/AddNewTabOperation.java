package texteditor;

import java.awt.event.ActionEvent;

public class AddNewTabOperation implements ActionEventOperation {
    private Tabs tabs;
    
    public AddNewTabOperation(Tabs newTabs) {
        tabs = newTabs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tabs.addNewTab();
    }
}