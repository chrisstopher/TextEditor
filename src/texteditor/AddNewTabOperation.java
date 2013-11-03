package texteditor;

public class AddNewTabOperation implements Operation {
    private Tabs tabs;
    
    public AddNewTabOperation(Tabs newTabs) {
        tabs = newTabs;
    }

    @Override
    public void operate() {
        tabs.addNewTab();
    }
}