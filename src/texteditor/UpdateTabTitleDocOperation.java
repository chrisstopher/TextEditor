package texteditor;

import javax.swing.event.DocumentEvent;

public class UpdateTabTitleDocOperation extends DocumentEventOperation {
	private Tabs tabs;
	
	public UpdateTabTitleDocOperation(Tabs newTabs) {
		tabs = newTabs;
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		tabs.addSymbolOnCurrentTab();
	}
	
	@Override
    void removeUpdate(DocumentEvent arg0) {
    	tabs.addSymbolOnCurrentTab();
    }
}
