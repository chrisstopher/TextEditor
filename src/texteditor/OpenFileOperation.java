package texteditor;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;

public class OpenFileOperation implements ActionEventOperation {
    private JFileChooser fileChooser;
    private Tabs tabs;
    private Frame mainFrame;
    
    public OpenFileOperation(Tabs newTabs, String fileChooserDirectory, Frame newMainFrame) {
        fileChooser = new JFileChooser(fileChooserDirectory);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Select a file to Open...");
        tabs = newTabs;
        mainFrame = newMainFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(mainFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            openFile(file);
        }
    }
    
    private void openFile(File file) {
        int foundTab = tabs.hasAlreadyOpen(file);
        if (foundTab != -1) {
            tabs.selectTab(foundTab);
        } else {
            readFileIntoTextArea(file);
        }
    }
    
    private void readFileIntoTextArea(File file) {
    	if (tabs.getTabbedPane().getTabCount() == 0 || tabs.getTitleOfCurrentTab() != Tabs.DEFAULT_TITLE) {
            tabs.addNewTab(file.getName(), file);
        } else {
            tabs.setTitleOfCurrentTab(file.getName());
            tabs.setFileOfCurrentTab(file);
        }
        tabs.setTextPaneOfCurrentTab(Util.readFrom(file.toString()));
        tabs.removeSymbolOnCurrentTab();
    }
}



