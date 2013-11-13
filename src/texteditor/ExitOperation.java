package texteditor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ExitOperation implements ActionEventOperation {

	final private Frame frame;
	final private Tabs tabs;
	final private OpenedFilesFromLastSession openedFilesFromLastSession;
	
	public ExitOperation(final Frame newFrame, final Tabs newTabs, final OpenedFilesFromLastSession newOpenedFilesFromLastSession) {
		frame = newFrame;
		tabs = newTabs;
		openedFilesFromLastSession = newOpenedFilesFromLastSession;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//does not call window closing on mainframe... hmm...
		if (tabs.anyOpenFileNotSaved()) {
    		final JPanel panel = new JPanel(new BorderLayout());
    		
    		panel.add(new JLabel("Unsaved files"), BorderLayout.NORTH);
    		
    		TextArea unsavedFiles = new TextArea();
    		unsavedFiles.getTextPane().setEditable(false);
    		unsavedFiles.getTextPane().setText(tabs.getFilesNotSaved());
    		
    		panel.add(unsavedFiles.getScrollPane(), BorderLayout.CENTER);
    		
    		int saveFiles = JOptionPane.showConfirmDialog(frame,
    													  panel,
    													  "Text Editor",
    													  JOptionPane.YES_NO_CANCEL_OPTION,
    													  JOptionPane.WARNING_MESSAGE);
    		if (saveFiles == JOptionPane.YES_OPTION || saveFiles == JOptionPane.NO_OPTION) {
    			if (saveFiles == JOptionPane.YES_OPTION) {
    				tabs.saveAllFiles();
    			}
    			openedFilesFromLastSession.saveFilesToBeOpened();
    			frame.setVisible(false);
    			frame.dispose();
    		}
    		return;
    	}
    	openedFilesFromLastSession.saveFilesToBeOpened();
    	frame.setVisible(false);
    	frame.dispose();
	}

}
