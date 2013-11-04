package texteditor;

import java.io.File;

public class OpenLastFileClosed implements Operation {
	final private Tabs tabs;
	final private ClosedFiles closedFiles;
    
    public OpenLastFileClosed(final Tabs newTabs, final ClosedFiles newClosedFiles) {
        tabs = newTabs;
        closedFiles = newClosedFiles;
    }
    
    @Override
    public void operate() {
        if (!closedFiles.isEmpty()) {
            File file = closedFiles.pop();
            tabs.addNewTab(file, Util.readFrom(file.toString()));
            tabs.removeSymbolOnCurrentTab();
        }
    }
}
