package texteditor;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;

public class SaveAsOperation implements ActionEventOperation {
    private JFileChooser fileChooser;
    private Tabs tabs;
    private Frame mainFrame;
    
    public SaveAsOperation(Tabs newTabs, String fileChooserDirectory, Frame newMainFrame) {
        fileChooser = new JFileChooser(fileChooserDirectory);
        fileChooser.setDialogTitle("Save as...");
        tabs = newTabs;
        mainFrame = newMainFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(mainFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            assignTab(fileChooser.getSelectedFile());
        }
    }
    
    private void assignTab(File file) {
        tabs.setTitleOfCurrentTab(file.getName());
        tabs.setFileOfCurrentTab(file);
        Util.writeTo(file, tabs.getCurrentTextPane().getText());
    }
}