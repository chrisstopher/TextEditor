package texteditor;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

public class ChangeTextColorOperation implements ActionEventOperation {
    
    private ColoredButton coloredButton;

    public ChangeTextColorOperation(ColoredButton newColoredButton) {
        coloredButton = newColoredButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(null, coloredButton.getTitle(), Color.BLACK);
        if (color != null) {
            coloredButton.setBackground(color);
        }
    }
}

