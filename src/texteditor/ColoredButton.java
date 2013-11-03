package texteditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class ColoredButton implements ActionListener {
    private JButton button;
    private Tabs tabs;
    private ChangeFontColorStrategy changeFontColorStrat;
    
    public ColoredButton(JPanel panel, Color bgColor, Tabs newTabs, ChangeFontColorStrategy newChangeFontColor) {
        tabs = newTabs;
        changeFontColorStrat = newChangeFontColor;
        button = new JButton();
        button.setBackground(bgColor);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(24, 24));
        button.addActionListener(this);
        panel.add(button);
    }
    
    public void setBackground(Color newColor) {
        button.setBackground(newColor);
    }
    
    public String getTitle() {
        return changeFontColorStrat.getTitle();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
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
        changeFontColorStrat.change(style, button.getBackground());
        doc.setCharacterAttributes(start, end - start, style, false);
    }
}
