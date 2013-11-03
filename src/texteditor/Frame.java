package texteditor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements WindowListener {
    private OpenedFiles openedFiles;
    
    public Frame(String title, int width, int height, boolean maximize, JPanel mainPanel, OpenedFiles newOpenedFiles) {
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
