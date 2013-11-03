package texteditor;

import java.awt.Color;

import javax.swing.JColorChooser;

public class ChangeTextColorOperation implements Operation {
    
    private ColoredButton coloredButton;

    public ChangeTextColorOperation(ColoredButton newColoredButton) {
        coloredButton = newColoredButton;
    }

    @Override
    public void operate() {
        Color color = JColorChooser.showDialog(null, coloredButton.getTitle(), Color.BLACK);
        if (color != null) {
            coloredButton.setBackground(color);
        }
    }
}

