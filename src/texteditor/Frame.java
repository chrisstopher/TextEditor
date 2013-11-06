package texteditor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements WindowListener {
    private OpenedFiles openedFiles;
    private Tabs tabs;
    
    public Frame(String title, int width, int height, boolean maximize, JPanel mainPanel, OpenedFiles newOpenedFiles, Tabs newTabs) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (maximize) {
            setExtendedState(Frame.MAXIMIZED_BOTH);
        }
        setVisible(true);
        addWindowListener(this);
        add(mainPanel);
        openedFiles = newOpenedFiles;
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
    		//not working for now...
//    		final JDialog dialog = new JDialog(this, "Text Editor", true);
//    		final JPanel panel = new JPanel();
//            final TextArea unsavedFiles = new TextArea();
//            panel.add(unsavedFiles.getScrollPane());
//            final Button yesButton = new Button("Yes", panel, new SaveAllOpenFilesOperation(tabs));
//            final Button noButton = new Button("No", panel);
//            final Button cancelButton = new Button("Cancel", panel);
//            final JButton[] buttons = {
//            	yesButton.getButton(), noButton.getButton(), cancelButton.getButton()
//            };
//            JOptionPane optionPane = new JOptionPane(panel,
//                                                     JOptionPane.YES_NO_CANCEL_OPTION,
//                                                     JOptionPane.WARNING_MESSAGE,
//                                                     null, buttons, buttons[0]);
//            dialog.getContentPane().add(optionPane);
//            dialog.setSize(300, 300);
//            dialog.setLocationRelativeTo(this);
//            dialog.setVisible(true);
    	}
    	openedFiles.saveFilesToBeOpened();
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
        openedFiles.loadSavedFiles();
    }
}
