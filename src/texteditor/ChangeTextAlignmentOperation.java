package texteditor;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChangeTextAlignmentOperation implements Operation {
    
    private Tabs tabs;
    private final int alignment;
    
    public ChangeTextAlignmentOperation(Tabs newTabs, final int newAligment) {
        tabs = newTabs;
        alignment = newAligment;
    }

    @Override
    public void operate() {
        SimpleAttributeSet attr = new SimpleAttributeSet(tabs.getCurrentTextPane().getParagraphAttributes());
        StyleConstants.setAlignment(attr, alignment);
        tabs.getCurrentTextPane().setParagraphAttributes(attr, true);
    }
    
}