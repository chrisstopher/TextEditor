package texteditor;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

public class ExitOperation implements ActionEventOperation {

	final private Frame frame;
	public ExitOperation(final Frame newFrame) {
		frame = newFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//does not call window closing on mainframe... hmm...
		frame.setVisible(false);
		frame.dispose();
	}

}
