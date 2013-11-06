package texteditor;

import java.awt.event.ActionEvent;

public class CloseCurrentTabOperation implements ActionEventOperation {
    private Tabs tabs;
    
    public CloseCurrentTabOperation(Tabs newTabs) {
        tabs = newTabs;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        tabs.removeCurrentTab();
    }
}
