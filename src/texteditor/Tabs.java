package texteditor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class Tabs implements MouseListener {
    private JTabbedPane tabs;
    private ArrayList<TextArea> scrollingTextAreas;
    public static final String DEFAULT_TITLE = "Untitled";
    private ClosedFiles closedFiles;
    
    private static final String NOT_SAVED_SYMBOL = "*";
    
    public Tabs(ClosedFiles newClosedFiles) {
        tabs = new JTabbedPane();
        scrollingTextAreas = new ArrayList<>();
        
        tabs.addMouseListener(this);
        
        closedFiles = newClosedFiles;
        //addNewTab();
    }
    
    public String getTitleOfCurrentTab() {
        return tabs.getTitleAt(tabs.getSelectedIndex());
    }
    
    public void setTitleOfCurrentTab(String title) {
        tabs.setTitleAt(tabs.getSelectedIndex(), title);
    }
    
    public void setFileOfCurrentTab(File newFile) {
        scrollingTextAreas.get(tabs.getSelectedIndex()).setFile(newFile);
    }
    
    public File getFileOfCurrentTab() {
        return scrollingTextAreas.get(tabs.getSelectedIndex()).getFile();
    }
    
    public void renameCurrentFileTo(String name) {
    	if (scrollingTextAreas.get(tabs.getSelectedIndex()).renameTo(name)) {
    		setTitleOfCurrentTab(name);
    	} else {
    		JOptionPane.showConfirmDialog(null,
    									  "Could not rename " + getTitleOfCurrentTab(),
    									  "Text Editor",
    									  JOptionPane.OK_CANCEL_OPTION,
    									  JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    public void setTextPaneOfCurrentTab(ArrayList<String> strings) {
        StringBuilder strBuilder = new StringBuilder();
        for (String s : strings) {
            strBuilder.append(s + Util.NEWLINE);
        }
        scrollingTextAreas.get(tabs.getSelectedIndex()).getTextPane().setText(strBuilder.toString());
    }
    
    public void addNewTab() {
        addNewTab(DEFAULT_TITLE);
    }
    
    public void addNewTab(String title) {
        addNewTab(title, new File(title));
    }
    
    public void addNewTab(File newFile) {
        addNewTab(newFile.getName(), newFile);
    }
    
    public void addNewTab(String title, File newFile) {
        scrollingTextAreas.add(new TextArea(new UpdateTabTitleDocOperation(this)));
        tabs.addTab(title, scrollingTextAreas.get(scrollingTextAreas.size() - 1).getScrollPane());
        tabs.setSelectedIndex(tabs.getTabCount() - 1);
        setFileOfCurrentTab(newFile);
    }
    
    public void addNewTab(File newFile, ArrayList<String> text) {
        addNewTab(newFile.getName(), newFile, text);
    }
    
    public void addNewTab(String title, File newFile, ArrayList<String> text) {
        addNewTab(title, newFile);
        setTextPaneOfCurrentTab(text);
    }
    
    public void removeCurrentTab() {
    	if (tabs.getTabCount() == 0) {
    		return;
    	}
        removeTab(tabs.getSelectedIndex());
    }
    
    public void removeTab(int index) {
        if (!scrollingTextAreas.get(index).getFile().toString().equals(DEFAULT_TITLE)) {
            closedFiles.push(scrollingTextAreas.get(index).getFile());
        }
        tabs.remove(index);
        scrollingTextAreas.remove(index);
    }
    
    public void removeAllTabs() {
    	while (tabs.getTabCount() != 0) {
    		removeTab(0);
    	}
    }
    
    public void addSymbolOnCurrentTab() {
        String currentTitle = tabs.getTitleAt(tabs.getSelectedIndex());
        if (!currentTitle.endsWith(NOT_SAVED_SYMBOL)) {
            tabs.setTitleAt(tabs.getSelectedIndex(), currentTitle + NOT_SAVED_SYMBOL);
        }
    }
    
    public void removeSymbolOnCurrentTab() {
        String currentTitle = tabs.getTitleAt(tabs.getSelectedIndex());
        if (currentTitle.endsWith(NOT_SAVED_SYMBOL)) {
        	tabs.setTitleAt(tabs.getSelectedIndex(), currentTitle.substring(0, currentTitle.length() - 1));
        }
    }
    
    public boolean currentTabNotSaved() {
    	return tabNotSaved(tabs.getSelectedIndex());
    }
    
    private boolean tabNotSaved(int i) {
    	return tabs.getTitleAt(i).endsWith(NOT_SAVED_SYMBOL);
    }
    
    public boolean anyOpenFileNotSaved() {
    	for (int i = 0; i < tabs.getTabCount(); i++) {
    		if (tabs.getTitleAt(i).endsWith(NOT_SAVED_SYMBOL)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void saveAllFiles() {
    	for (int i = 0; i < tabs.getTabCount(); i++) {
    		if (tabNotSaved(i)) {
    			Util.writeTo(scrollingTextAreas.get(i).getFile(), scrollingTextAreas.get(i).getTextPane().getText());
    		}
    	}
    	
    }
    
    /**
     * @param file
     * @return The index of where the file is in the tabs if it is not in the tabs it is -1
     */
    public int hasAlreadyOpen(File file) {
        for (int i = 0; i < scrollingTextAreas.size(); i++) {
            if (scrollingTextAreas.get(i).getFile().equals(file)) {
                return i;
            }
        }
        return -1;
    }
    
    public void selectTab(int i) {
        tabs.setSelectedIndex(i);
    }
    
    public ArrayList<TextArea> getOpenedTextFiles() {
        return scrollingTextAreas;
    }
    
    public JTabbedPane getTabbedPane() {
        return tabs;
    }
    
    public JTextPane getCurrentTextPane() {
        return scrollingTextAreas.get(tabs.getSelectedIndex()).getTextPane();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON2) {
        	if (currentTabNotSaved()) {
        		String[] options = {
        			"Yes", "No", "Cancel"
        		};
        		int picked = JOptionPane.showOptionDialog(null, "Save changes to " + getFileOfCurrentTab().getName(), "Text Editor",
			        									  JOptionPane.YES_NO_CANCEL_OPTION,
			        									  JOptionPane.WARNING_MESSAGE,
			        									  null, options, options[0]);
        		if (picked == JOptionPane.YES_OPTION || picked == JOptionPane.NO_OPTION) {
        			if (picked == JOptionPane.YES_OPTION) {
        				Util.writeTo(getFileOfCurrentTab(), getCurrentTextPane().getText());
        			}
        			removeCurrentTab();
        		}
        	} else {
        		removeCurrentTab();
        	}
        }
    }
}