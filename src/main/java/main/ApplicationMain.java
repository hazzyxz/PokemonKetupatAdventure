package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class ApplicationMain extends JFrame {

    public static String userInput = "";

    GamePanel gamePanel;
    JTextField inputField;

    public ApplicationMain() {
        super();
        this.setTitle("Pokemon Ketupat Adventure");
        gamePanel = new GamePanel();
        inputField = new JTextField();

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput = inputField.getText();
                inputField.setText("");
            }
        };

        inputField.addActionListener(action);
        this.add(gamePanel, BorderLayout.CENTER);
        this.add(inputField, BorderLayout.SOUTH);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Backgrounds/StartScreen.png"))).getImage());
        this.pack();
    }

    public static void main(String[] args) {
        // Create main frame
        ApplicationMain app = new ApplicationMain();

        // Set frame's properties
        app.setResizable(false);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

        // Start game time
        app.gamePanel.startGameThread();
    }
}