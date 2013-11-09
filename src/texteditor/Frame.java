package texteditor;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame extends JFrame implements WindowListener {
    private OpenedFilesFromLastSession openedFilesFromLastSession;
    private Tabs tabs;
    
    public Frame(String title, int width, int height, boolean maximize, JPanel mainPanel, OpenedFilesFromLastSession newOpenedFilesFromLastSession, Tabs newTabs) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        if (maximize) {
            setExtendedState(Frame.MAXIMIZED_BOTH);
        }
        setVisible(true);
        addWindowListener(this);
        add(mainPanel);
        openedFilesFromLastSession = newOpenedFilesFromLastSession;
        tabs = newTabs;
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
        // TODO Auto-generated method stub
    	
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
    	//if any files not saved then pop up a dialog box
    	if (tabs.anyOpenFileNotSaved()) {
    		final JPanel panel = new JPanel(new BorderLayout());
    		
    		panel.add(new JLabel("Unsaved files"), BorderLayout.NORTH);
    		
    		TextArea unsavedFiles = new TextArea();
    		unsavedFiles.getTextPane().setEditable(false);
    		unsavedFiles.getTextPane().setText(tabs.getFilesNotSaved());
    		
    		panel.add(unsavedFiles.getScrollPane(), BorderLayout.CENTER);
    		
    		int saveFiles = JOptionPane.showConfirmDialog(this,
    													  panel,
    													  "Text Editor",
    													  JOptionPane.YES_NO_CANCEL_OPTION,
    													  JOptionPane.WARNING_MESSAGE);
    		if (saveFiles == JOptionPane.YES_OPTION || saveFiles == JOptionPane.NO_OPTION) {
    			if (saveFiles == JOptionPane.YES_OPTION) {
    				tabs.saveAllFiles();
    			}
    			openedFilesFromLastSession.saveFilesToBeOpened();
    			setVisible(false);
    			dispose();
    		}
    		return;
    	}
    	openedFilesFromLastSession.saveFilesToBeOpened();
    	setVisible(false);
		dispose();
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
    	openedFilesFromLastSession.loadSavedFiles();
    }
}
