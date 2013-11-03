package texteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Button implements ActionListener {
    private JButton button;
    private Operation operation;
    
    public Button(String title, JPanel panel, Operation newOperation) {
        button = new JButton(title);
        panel.add(button);
        button.addActionListener(this);
        operation = newOperation;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        operation.operate();
    }
}