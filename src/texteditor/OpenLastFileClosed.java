package texteditor;

import java.awt.event.ActionEvent;
import java.io.File;

public class OpenLastFileClosed implements ActionEventOperation {
	final private Tabs tabs;
	final private ClosedFiles closedFiles;
    
    public OpenLastFileClosed(final Tabs newTabs, final ClosedFiles newClosedFiles) {
        tabs = newTabs;
        closedFiles = newClosedFiles;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!closedFiles.isEmpty()) {
            File file = closedFiles.pop();
            tabs.addNewTab(file, Util.readFrom(file.toString()));
            tabs.removeSymbolOnCurrentTab();
        }
    }
}
