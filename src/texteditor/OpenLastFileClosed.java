package texteditor;

import java.io.File;

public class OpenLastFileClosed implements Operation {
    private Tabs tabs;
    private ClosedFiles closedFiles;
    
    public OpenLastFileClosed(Tabs newTabs, ClosedFiles newClosedFiles) {
        tabs = newTabs;
        closedFiles = newClosedFiles;
    }
    
    @Override
    public void operate() {
        if (!closedFiles.isEmpty()) {
            File file = closedFiles.pop();
            tabs.addNewTab(file, Util.readFrom(file.toString()));
        }
    }
}
