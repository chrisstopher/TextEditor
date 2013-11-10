package texteditor;

import java.awt.event.ActionEvent;

import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class ChangeSelectedText implements ActionEventOperation {
	final private Tabs tabs;
	final private StyleChanger styleChanger;
	
	public ChangeSelectedText(final Tabs newTabs, final StyleChanger newStyleChanger) {
		tabs = newTabs;
		styleChanger = newStyleChanger;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StyledDocument doc = tabs.getCurrentTextPane().getStyledDocument();
        int start = tabs.getCurrentTextPane().getSelectionStart();
        int end = tabs.getCurrentTextPane().getSelectionEnd();
        if (start == end) { // No selection, cursor position.
            return;
        }
        if (start > end) { // Backwards selection?
            int temp = start;
            start = end;
            end = temp;
        }
        Style style = tabs.getCurrentTextPane().addStyle(null, null);
        styleChanger.change(style);
        doc.setCharacterAttributes(start, end - start, style, false);
	}
}

