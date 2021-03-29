package desen.panel;

import desen.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JButton buttonColor;
    Color colorSelected = null;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
        sidesField.setValue(4);
        ColorChooser ch = new ColorChooser();
        add(buttonColor);
        add(sidesLabel);
        add(sidesField);
    }

    public class ColorChooser extends JFrame implements ActionListener {

        ColorChooser() {
            buttonColor = new JButton("color");
            buttonColor.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            Color initialColor = Color.BLACK;
            colorSelected = JColorChooser.showDialog(this, "Select a color", initialColor);
        }
    }
}
