package desen.panel;

import desen.MainFrame;
import desen.RegularPolygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    public void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(100);
        Color color;
        int sides = (int) frame.configPanel.sidesField.getValue();
        if (frame.configPanel.colorSelected == null) {
            Random random = new Random();
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            int transparent;
            transparent = random.nextInt(255);
            color = new Color(r, g, b, transparent);
        } else {
            color = frame.configPanel.colorSelected;
        }
        graphics.setColor(color);
        if (sides == 1) {
            int x0 = x - (radius / 2);
            int y0 = y - (radius / 2);
            graphics.fillOval(x0, y0, radius, radius);
        } else {
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
        frame.configPanel.colorSelected = null;
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}
