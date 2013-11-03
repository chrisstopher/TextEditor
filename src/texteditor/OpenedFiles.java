package texteditor;

import java.io.File;
import java.util.ArrayList;

public class OpenedFiles {
    private Tabs tabs;
    static final String FILE_WRITTEN_TO = "./resources/lastFilesOpened.txt";
    
    public OpenedFiles(Tabs newTabs) {
        tabs = newTabs;
    }
    
    public void saveFilesToBeOpened() {
        Util.writeTo(FILE_WRITTEN_TO, savedFilesOpen(tabs.getOpenedTextFiles()), true);
    }
    
    private ArrayList<String> savedFilesOpen(ArrayList<TextArea> openedTextFiles) {
        ArrayList<String> filesToSave = new ArrayList<>();
        for (TextArea currentText : openedTextFiles) {
            if (currentText.getFile().toString() == Tabs.DEFAULT_TITLE) {
                continue;
            }
            filesToSave.add(currentText.getFile().toString());
        }
        return filesToSave;
    }
    
    public void loadSavedFiles() {
        ArrayList<String> filesToBeOpened = new ArrayList<>();
        filesToBeOpened = Util.readFrom(FILE_WRITTEN_TO);
        for (String s : filesToBeOpened) {
            tabs.addNewTab((new File(s)).getName(), new File(s));
            tabs.setTextPaneOfCurrentTab(Util.readFrom(s));
            tabs.removeSymbolOnCurrentTab();
        }
        if (filesToBeOpened.isEmpty()) {
            tabs.addNewTab();
        }
    }
}
