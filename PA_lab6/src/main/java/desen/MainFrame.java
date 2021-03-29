package desen;

import desen.panel.ConfigPanel;
import desen.panel.ControlPanel;
import desen.panel.DrawingPanel;

import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
    public ControlPanel controlPanel;
    public DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

}
