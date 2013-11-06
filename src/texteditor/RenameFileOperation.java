package texteditor;

import java.awt.event.ActionEvent;

public class RenameFileOperation implements ActionEventOperation {
	final private Tabs tabs;
	public RenameFileOperation(final Tabs newTabs) {
		tabs = newTabs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//create dialog box with text field
		//tabs.renameCurrentFileTo(newName);
	}
}
