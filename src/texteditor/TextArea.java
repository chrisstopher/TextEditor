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
    final private DocumentEventOperation documentEventOperation;
    
    public TextArea(){
    	this(new DocumentEventOperation());
    }
    
    public TextArea(DocumentEventOperation docEventOp) {
        textPane = new JTextPane();
        scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        textPane.getDocument().addDocumentListener(this);
        documentEventOperation = docEventOp;
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
    
    public void renameTo(String name) {
    	//file = new File(file.getParent() + '\\'+ name);
    	file.renameTo(new File(file.getParent() + '\\'+ name));
    }

    @Override
    public void changedUpdate(DocumentEvent arg0) {
    	documentEventOperation.changedUpdate(arg0);
    }

    @Override
    public void insertUpdate(DocumentEvent arg0) {
    	documentEventOperation.insertUpdate(arg0);
    }

    @Override
    public void removeUpdate(DocumentEvent arg0) {
    	documentEventOperation.removeUpdate(arg0);
    }
}