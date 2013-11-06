package texteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

class Menu extends JMenu implements ActionListener {
	private ArrayList<MenuItem> menuItems;
	private ActionEventOperation actionEventOperation;
	
	public Menu(String name, int mnemonic, ArrayList<MenuItem> newMenuItems, JMenuBar menuBar) {
		this(name, mnemonic, newMenuItems,  menuBar, new DefaultActionEventOperation());
	}
	
	public Menu(String name, int mnemonic, ArrayList<MenuItem> newMenuItems, JMenuBar menuBar, ActionEventOperation newActionEventOp) {
	    this(name, mnemonic, menuBar, newActionEventOp);
	    menuItems = newMenuItems;
	    addItemsToMenu();
	}
	
	private Menu(String name, int mnemonic, JMenuBar menuBar, ActionEventOperation newActionEventOp) {
	    this(name, menuBar, newActionEventOp);
	    setMnemonic(mnemonic);
	}
	
	private Menu(String name, JMenuBar menuBar, ActionEventOperation newActionEventOp) {
	    super(name);
	    menuBar.add(this);
	    addActionListener(this);
	    actionEventOperation = newActionEventOp;
	}
	
	private void addItemsToMenu() {
	    for (MenuItem menuItem : menuItems) {
	        add(menuItem);
	        if (menuItem.hasSeperatorAfter()) {
	          	addSeparator();
	        }
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		actionEventOperation.actionPerformed(e);
	}
}
