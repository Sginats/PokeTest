package PokePD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Pokedatnis extends JFrame {

    private BufferedImage frameImage;  // outer frame (red Pokedex)
    private BufferedImage screenImage; // inner blue area replacement

    public Pokedatnis() {
        setTitle("Pokemoni");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1437, 768);
        setLocationRelativeTo(null);
        setResizable(false);

        try {
            frameImage = ImageIO.read(new File(System.getProperty("user.dir") + "/bildes/PokeFrame.png"));
            screenImage = ImageIO.read(new File(System.getProperty("user.dir") + "/bildes/screen.png")); // or video frame
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not load image(s).");
        }

        // --- LayeredPane lets us draw frame + buttons + screen ---
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1437, 768));

        // BACKGROUND LAYER: Draw the Pokedex frame + blue screen image
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (frameImage != null)
                    g.drawImage(frameImage, 0, 0, getWidth(), getHeight(), null);
                if (screenImage != null)
                    // Draw the screen image inside the big blue rectangle region
                    g.drawImage(screenImage, 460, 140, 515, 430, null);
            }
        };
        background.setBounds(0, 0, 1437, 768);

        // --- BUTTONS ---
        JButton btnExit = new JButton();
        btnExit.setBounds(475, 610, 40, 40); // red circle bottom left
        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.addActionListener(e -> System.exit(0));

        JButton btnMenu = new JButton();
        btnMenu.setBounds(910, 600, 60, 40); // black bars bottom right
        btnMenu.setOpaque(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMenu.addActionListener(e -> JOptionPane.showMessageDialog(this, "Menu clicked! (Add features here)"));

        layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(btnExit, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(btnMenu, JLayeredPane.PALETTE_LAYER);

        add(layeredPane);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Pokedatnis::new);
    }
}
