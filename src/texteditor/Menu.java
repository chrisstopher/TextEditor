package texteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenu implements ActionListener {
    private ArrayList<JMenuItem> menuItems;
    
    public Menu(String name, int mnemonic, JMenuItem newMenuItems, boolean seperatorAfter, JMenuBar menuBar) {
        this(name, mnemonic, menuBar);
        menuItems = new ArrayList<>();
        menuItems.add(newMenuItems);
        add(menuItems.get(0));
        if (seperatorAfter) {
            addSeparator();
        }
    }
    
    public Menu(String name, int mnemonic, ArrayList<JMenuItem> newMenuItems, ArrayList<Integer> seperatorIndexes, JMenuBar menuBar) {
        this(name, mnemonic, menuBar);
        menuItems = newMenuItems;
        addItemsToMenu(seperatorIndexes);
    }
    
    public Menu(String name, int mnemonic, JMenuBar menuBar) {
        this(name, menuBar);
        setMnemonic(mnemonic);
    }
    
    public Menu(String name, JMenuBar menuBar) {
        super(name);
        menuBar.add(this);
        addActionListener(this);
    }
    
    private void addItemsToMenu(ArrayList<Integer> seperatorIndexes) {
        if (seperatorIndexes == null) {
            for (JMenuItem menuItem : menuItems) {
                add(menuItem);
            }
            return;
        }
        int j = 0;
        for (int i = 0; i < menuItems.size(); i++) {
            add(menuItems.get(i));
            if (seperatorIndexes.get(j) == i) {
                addSeparator();
                if (j < seperatorIndexes.size() - 1) {
                    j++;
                }
            }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
