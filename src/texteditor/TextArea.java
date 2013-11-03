package texteditor;

import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextArea implements DocumentListener {
    private JTextPane textPane;
    private JScrollPane scrollPane;
    private File file;
    private Tabs tabs;
    
    public TextArea(Tabs newTabs) {
        textPane = new JTextPane();
        scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        textPane.getDocument().addDocumentListener(this);
        tabs = newTabs;
    }
    
    public JTextPane getTextPane() {
        return textPane;
    }
    
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
    
    public void setFile(File newFile) {
        file = newFile;
    }
    public File getFile() {
        return file;
    }

    @Override
    public void changedUpdate(DocumentEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertUpdate(DocumentEvent arg0) {
        tabs.addSymbolOnCurrentTab();
    }

    @Override
    public void removeUpdate(DocumentEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}