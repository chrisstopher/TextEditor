package texteditor;

public class CloseCurrentTabOperation implements Operation {
    private Tabs tabs;
    
    public CloseCurrentTabOperation(Tabs newTabs) {
        tabs = newTabs;
    }
    
    @Override
    public void operate() {
        tabs.removeCurrentTab();
    }
}
