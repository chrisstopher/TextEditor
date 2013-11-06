package texteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class MenuItem extends JMenuItem implements ActionListener {
	private boolean addSeperatorAfter;
	private ActionEventOperation actionEventOperation;
	
	public MenuItem(String text, int mnemonic, boolean addSepAfter, ActionEventOperation newActionEventOp) {
		this(text, addSepAfter, newActionEventOp);
		setMnemonic(mnemonic);
	}
	
	public MenuItem(String text, int mnemonic, boolean addSepAfter) {
		this(text, mnemonic, addSepAfter, new DefaultActionEventOperation());
	}
	
	public MenuItem(String text, int mnemonic) {
		this(text, mnemonic, false, new DefaultActionEventOperation());
	}
	
	public MenuItem(String text, boolean addSepAfter, ActionEventOperation newActionEventOp) {
		super(text);
		addActionListener(this);
		addSeperatorAfter = addSepAfter;
		actionEventOperation = newActionEventOp;
	}
	
	public MenuItem(String text, ActionEventOperation newActionEventOp) {
		this(text, false, newActionEventOp);
	}
	
	public MenuItem(String text, boolean addSepAfter) {
		this(text, addSepAfter, new DefaultActionEventOperation());
	}
	
	public MenuItem(String text) {
		this(text, new DefaultActionEventOperation());
	}
	
	public boolean hasSeperatorAfter() {
		return addSeperatorAfter;
	}
	
	public String getName() {
		return getText();
	}
	
	public ActionEventOperation getActionEventOperation() {
		return actionEventOperation;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		actionEventOperation.actionPerformed(e);
	}
}
