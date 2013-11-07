package texteditor;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class RenameFileOperation implements ActionEventOperation {
	final private Tabs tabs;
	public RenameFileOperation(final Tabs newTabs) {
		tabs = newTabs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String newName = (String)JOptionPane.showInputDialog(null,
															 "Rename " + tabs.getTitleOfCurrentTab() + " to:",
															 "Rename File...",
															 JOptionPane.PLAIN_MESSAGE);
		if (newName != null && !newName.equals(tabs.getTitleOfCurrentTab())) {
			tabs.renameCurrentFileTo(newName);
		}
	}
}
