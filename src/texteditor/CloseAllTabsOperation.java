package texteditor;

import java.awt.event.ActionEvent;

public class CloseAllTabsOperation implements ActionEventOperation {
	private Tabs tabs;
	public CloseAllTabsOperation(Tabs newTabs) {
		tabs = newTabs;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		tabs.removeAllTabs();
	}
	
}
