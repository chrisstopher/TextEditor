package texteditor;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
    private Menu fileMenu;
    private Menu closedFilesMenu;//holds all files that were closed and allowed to click one and open it
    public MenuBar() {
        ArrayList<JMenuItem> menuItems = new ArrayList<>();
        ArrayList<Integer> seperators = new ArrayList<>();
        
        closedFilesMenu = new Menu("Recent Files", KeyEvent.VK_C, this);
        menuItems.clear();
        seperators.clear();
        
        menuItems.add(new JMenuItem("Open...", KeyEvent.VK_O));
        menuItems.add(new JMenuItem("Close Current Tab", KeyEvent.VK_L));
        menuItems.add(new JMenuItem("Close All Tabs", KeyEvent.VK_A));
        menuItems.add(closedFilesMenu);
        
        seperators.add(0);
        seperators.add(2);
        fileMenu = new Menu("File", KeyEvent.VK_F, menuItems, seperators, this);
        menuItems.clear();
        seperators.clear();
    }
}


//public class MenuItem implements ActionListener {
//    private JMenuItem menuItem;
//    private Operation operation;
//    
//    public MenuItem(JMenuItem newMenuItem, Operation newOperation) {
//        menuItem = newMenuItem;
//        menuItem.addActionListener(this);
//        operation = newOperation;
//    }

//    public MenuItem(JMenuItem newMenuItem, int mnemonic, Operation newOperation) {
//        this(newMenuItem, newOperation);
//        menuItem.setMnemonic(mnemonic);
//    }
//    
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        operation.operate();
//    }
//}

//public class Menu extends MenuItem {
//    public Menu(JMenuItem newMenuItem, Operation newOperation) {
//        super(newMenuItem, newOperation);
//    }
//}
