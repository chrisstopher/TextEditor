package texteditor;

import java.awt.event.ActionEvent;

public class SaveAllOpenFilesOperation implements ActionEventOperation {
	final private Tabs tabs;
	
	public SaveAllOpenFilesOperation(final Tabs newTabs) {
		tabs = newTabs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tabs.saveAllFiles();
	}
}
