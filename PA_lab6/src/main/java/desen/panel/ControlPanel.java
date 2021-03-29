package desen.panel;

import desen.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    Graphics2D graphics;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int saveDialog = fileChooser.showSaveDialog(null);
        if (saveDialog == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(fileChooser.getSelectedFile().getAbsolutePath()));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int loadDialog = fileChooser.showOpenDialog(null);
            if (loadDialog == JFileChooser.APPROVE_OPTION) {
                frame.canvas.image = ImageIO.read(new FileInputStream(fileChooser.getSelectedFile()));
                frame.canvas.repaint();
                frame.canvas.graphics = frame.canvas.image.createGraphics();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void reset(ActionEvent e) {
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, frame.canvas.getWidth(), frame.canvas.getHeight());
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }
}
