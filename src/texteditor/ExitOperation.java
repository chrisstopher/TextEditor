package texteditor;

import java.awt.event.ActionEvent;

public class ExitOperation implements ActionEventOperation {

	final private Frame frame;
	
	public ExitOperation(final Frame newFrame) {
		frame = newFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.onWindowClosing(null);
	}
}
