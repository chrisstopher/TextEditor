package texteditor;

import java.awt.Color;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;

interface ChangeFontColorStrategy {
    void change(MutableAttributeSet a, Color c);
    String getTitle();
}

class ChangeForegroundColor implements ChangeFontColorStrategy {
//    private final String title;
//    
//    public ChangeForegroundColor(final String newTitle) {
//        title = newTitle;
//    }
    @Override
    public void change(MutableAttributeSet a, Color c) {
        StyleConstants.setForeground(a, c);
    }
    @Override
    public String getTitle() {
        return "Pick foreground color...";//title;
    }
}

class ChangeBackgroundColor implements ChangeFontColorStrategy {
//    private final String title;
//    
//    public ChangeBackgroundColor(final String newTitle) {
//        title = newTitle;
//    }
    
    @Override
    public void change(MutableAttributeSet a, Color c) {
        StyleConstants.setBackground(a, c);
    }

    @Override
    public String getTitle() {
        return "Pick background color...";//title;
    }
}
