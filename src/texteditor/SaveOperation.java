package texteditor;

import java.io.File;

import javax.swing.JFileChooser;

public class SaveOperation implements Operation {
    private JFileChooser fileChooser;
    private Tabs tabs;
    private Frame mainFrame;
    
    public SaveOperation(Tabs newTabs, String fileChooserDirectory, Frame newMainFrame) {
        fileChooser = new JFileChooser(fileChooserDirectory);
        fileChooser.setDialogTitle("Type in a file name to save...");
        tabs = newTabs;
        mainFrame = newMainFrame;
    }
    
    @Override
    public void operate() {
        File file = tabs.getFileOfCurrentTab();
        if (file.toString() == Tabs.DEFAULT_TITLE || !file.exists()) {
            int returnVal = fileChooser.showOpenDialog(mainFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                assignTab(fileChooser.getSelectedFile());
            }
        } else {
            Util.writeTo(tabs.getFileOfCurrentTab(), tabs.getCurrentTextPane().getText());
            tabs.removeSymbolOnCurrentTab();
        }
    }
    
    private void assignTab(File file) {
        tabs.setTitleOfCurrentTab(file.getName());
        tabs.setFileOfCurrentTab(file);
        Util.writeTo(file, tabs.getCurrentTextPane().getText());
        tabs.removeSymbolOnCurrentTab();
    }
}