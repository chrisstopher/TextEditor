package texteditor;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.StyleConstants;

public class GUI {
    private Frame mainframe;
    private JMenuBar menuBar;
    private JPanel mainPanel, topPanel, centerPanel;
    private Tabs tabs;
    private ArrayList<Button> buttons;
    
    private OpenedFiles openedFiles;
    
    private ClosedFiles closedFiles;
    
    public GUI() {
        mainPanel = new JPanel(new BorderLayout());
        menuBar = new JMenuBar();
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPanel = new JPanel(new BorderLayout());
        closedFiles = new ClosedFiles();
        tabs = new Tabs(closedFiles);
        centerPanel.add(tabs.getTabbedPane(), BorderLayout.CENTER);
        openedFiles = new OpenedFiles(tabs);
        buttons = new ArrayList<>();
        
        mainframe = new Frame("Text Processor", 1280, 600, false, mainPanel, openedFiles, tabs);
        
        
        String fileChooserStartDirectory = ".";
        ArrayList<MenuItem> operationHolder = new ArrayList<>();
        operationHolder.add(new MenuItem("Open", KeyEvent.VK_O, true, new OpenFileOperation(tabs, fileChooserStartDirectory, mainframe)));
        operationHolder.add(new MenuItem("Save", KeyEvent.VK_S, false, new SaveOperation(tabs, fileChooserStartDirectory, mainframe)));
        operationHolder.add(new MenuItem("Save As", KeyEvent.VK_A, true, new SaveAsOperation(tabs, fileChooserStartDirectory, mainframe)));
        operationHolder.add(new MenuItem("New Tab", KeyEvent.VK_T, false, new AddNewTabOperation(tabs)));
        operationHolder.add(new MenuItem("Close Tab", KeyEvent.VK_C, false, new CloseCurrentTabOperation(tabs)));
        operationHolder.add(new MenuItem("Close All Tabs", KeyEvent.VK_A, true, new CloseAllTabsOperation(tabs)));
        operationHolder.add(new MenuItem("Open Last File", KeyEvent.VK_L, true, new OpenLastFileClosed(tabs, closedFiles)));
        
        operationHolder.add(new MenuItem("Exit", KeyEvent.VK_E, false, new ExitOperation(mainframe)));
        
        operationHolder.add(new MenuItem("Align Left", KeyEvent.VK_L, false, new ChangeTextAlignmentOperation(tabs, StyleConstants.ALIGN_LEFT)));
        operationHolder.add(new MenuItem("Align Center", KeyEvent.VK_C, false, new ChangeTextAlignmentOperation(tabs, StyleConstants.ALIGN_CENTER)));
        operationHolder.add(new MenuItem("Align Right", KeyEvent.VK_R, true, new ChangeTextAlignmentOperation(tabs, StyleConstants.ALIGN_RIGHT)));
        //operationHolders.add(new MenuItem("Foreground Color", false, new ChangeTextColorOperation(new ColoredButton(topPanel, Color.BLACK, tabs, new ChangeForegroundColor()))));
        //operationHolders.add(new MenuItem("Background Color", false, new ChangeTextColorOperation(new ColoredButton(topPanel, Color.WHITE, tabs, new ChangeForegroundColor()))));

        addMenuItems(operationHolder);
        
        mainframe.setJMenuBar(menuBar);

        addButtons(operationHolder);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    }
    
    private void addButtons(ArrayList<MenuItem> operationHolder) {
    	for (MenuItem item : operationHolder) {
    		buttons.add(new Button(item.getName(), topPanel, item.getActionEventOperation()));
    	}
    	buttons.add(new Button("FG Color", topPanel, new ChangeTextColorOperation(new ColoredButton(topPanel, Color.BLACK, tabs, new ChangeForegroundColor()))));
        buttons.add(new Button("BG Color", topPanel, new ChangeTextColorOperation(new ColoredButton(topPanel, Color.WHITE, tabs, new ChangeBackgroundColor()))));
    }
    
    private void addMenuItems(ArrayList<MenuItem> operationHolder) {
    	//going to need cut, copy, paste, rename... etc.
    	
    	ArrayList<MenuItem> menuItems = new ArrayList<>();
    	int i;
    	for (i = 0; i < operationHolder.size() - 3; i++) {
    		menuItems.add(operationHolder.get(i));
    	}
        new Menu("File", KeyEvent.VK_F, menuItems, menuBar);
        menuItems.clear();
        
        for ( ; i < operationHolder.size(); i++) {
        	menuItems.add(operationHolder.get(i));
    	}
        
        new Menu("Edit", KeyEvent.VK_E, menuItems, menuBar);
        menuItems.clear();
    }
}














//public class GUI {
//    
//    private JPanel gui;
//    private JTextArea textArea;
//    private JButton open, save;
//    
//    public static void main(String[] args) {
//        new GUI();
//    }
//
//    public GUI() {
//        JFrame guiFrame = new JFrame();
//        init(guiFrame, "Text Editor", new Dimension(400, 300));
//        addComponentsTo(guiFrame);
//        
//    }
//    
//    public void init(JFrame frame, String title, Dimension dim) {
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle(title);
//        frame.setSize(dim);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//    
//    public void addComponentsTo(JFrame frame) {
//        textArea = new JTextArea();
//        open = createButton("Load");
//        open.addActionListener(new OpenFile());
//        save = createButton("Save");
//        save.addActionListener(new SaveFile());
//        gui = new JPanel(new BorderLayout());
//        frame.add(gui);
//        
//        
////        JTabbedPane tabs = new JTabbedPane();
////        tabs.addTab("Tab1", null);
////        tabs.addTab("Tab2", null);
////        gui.add(tabs, BorderLayout.SOUTH);
//        
//        
//        JPanel topPanel = new JPanel();
//        gui.add(topPanel, BorderLayout.NORTH);
//        topPanel.add(open);
//        topPanel.add(save);
//        
//        JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//                                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        gui.add(scrollBar, BorderLayout.CENTER);
//        
//        
//    }
//
//    public JLabel createLabel(String name) {
//        return new JLabel(name);
//    }
//    
//    private JButton createButton(String name) {
//        return new JButton(name);
//    }
//    
//    private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch){
//        
//        GridBagConstraints gridConstraints = new GridBagConstraints();
//        
//        gridConstraints.gridx = xPos;
//        gridConstraints.gridy = yPos;
//        gridConstraints.gridwidth = compWidth;
//        gridConstraints.gridheight = compHeight;
//        gridConstraints.weightx = 100;
//        gridConstraints.weighty = 100;
//        gridConstraints.insets = new Insets(5,5,5,5);
//        gridConstraints.anchor = place;
//        gridConstraints.fill = stretch;
//        
//        thePanel.add(comp, gridConstraints);
//        
//    }
//}
//
//class OpenFile implements ActionListener {
//    private final JFileChooser fc = new JFileChooser();
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        int returnVal = fc.showOpenDialog();
//        //if (e.getSource() == openButton) {
//            int returnVal = fc.showOpenDialog(FileChooserDemo.this);
//
//            if (returnVal == JFileChooser.APPROVE_OPTION) {
//                File file = fc.getSelectedFile();
//                //This is where a real application would open the file.
//                //log.append("Opening: " + file.getName() + "." + newline);
//            } else {
//                //log.append("Open command cancelled by user." + newline);
//            }
//       //}
//    }
//    
//}
//
//class SaveFile implements ActionListener {
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        
//    }
//    
//}

//JPanel gui = new JPanel(new GridBagLayout());
//frame.add(gui);
//
//addComp(gui, new JLabel("File: "), 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
//
//JComboBox files = new JComboBox();
//files.setEditable(true);
//files.setPreferredSize(new Dimension(300, files.getPreferredSize().height));
//addComp(gui, files, 1, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

//JPanel GUI = new JPanel();
//JPanel mainPanel = new JPanel(new GridBagLayout());
//GridBagConstraints constraints = new GridBagConstraints();
//GUI.add(mainPanel);
//frame.setContentPane(GUI);
//
//constraints.gridx = 0;
//constraints.gridy = 0;
//constraints.fill = GridBagConstraints.NONE;
//mainPanel.add(createLabel("File: "), constraints);
//constraints.gridx = 1;
////constraints.gridwidth = 3;
//JComboBox input = new JComboBox();
//input.setEditable(true);
//mainPanel.add(input);


//JPanel panel = new JPanel(new BorderLayout());
//frame.add(panel);
//JPanel topPanel = new JPanel();
//JLabel labels[] = new JLabel[1];
//for (JLabel label : labels) {
//    label = new JLabel("File: ");
//    topPanel.add(label, BorderLayout.WEST);
//}
//
//JComboBox usedFiles = new JComboBox();
//usedFiles.setEditable(true);
////usedFiles.setSize(d);
//topPanel.add(usedFiles, BorderLayout.EAST);
//panel.add(topPanel, BorderLayout.WEST);
//
//JPanel bottomPanel = new JPanel();
//JButton convertButton = new JButton("Convert");
//convertButton.addActionListener(new ActionListener() {
//
//  @Override
//  public void actionPerformed(ActionEvent e) {
//      System.out.println(e);
//      //get the string in usedFiles...
//      //convert the file 
//  }
//    
//});
//bottomPanel.add(convertButton);
//panel.add(bottomPanel, BorderLayout.SOUTH);



//JPanel panel = new JPanel(new GridBagLayout());
//GridBagConstraints gbc = new GridBagConstraints();
//frame.add(panel);
//gbc.anchor = gbc.NORTHEAST;
//JPanel topPanel = new JPanel();
//JLabel labels[] = new JLabel[1];
//for (JLabel label : labels) {
//    label = new JLabel("File: ");
//    topPanel.add(label);
//}
////gbc.fill = gbc.HORIZONTAL;
//JComboBox usedFiles = new JComboBox();
//usedFiles.setEditable(true);
//topPanel.add(usedFiles);
//panel.add(topPanel, gbc);
//
//
////JPanel bottomPanel = new JPanel();
////JButton convertButton = new JButton("Convert");
////bottomPanel.add(convertButton);
////panel.add(bottomPanel, gbc);