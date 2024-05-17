package ui;

import screens.Screen;
import screens.ScreenFactory;

import javax.swing.*;
import java.awt.*;

import static ui.ApplicationMain.userInput;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int tileSize = 16;
    final int tileCount = 44;

    public final int screenHeight = tileSize * tileCount;
    public final int screenWidth = tileSize * tileCount;

    int FPS = 60;

    Thread gameThread;

    KeyHandler keyH = new KeyHandler();

    // Factories
    ScreenFactory screenFactory = new ScreenFactory(this, keyH);

    // First screen of the game
    public Screen currentScreen = screenFactory.newStartScreen();

    public GamePanel() {
        // SETS THE GAME PANEL SETTINGS
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        // this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        currentScreen.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        currentScreen.draw(g2);

        g2.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                if (!userInput.isEmpty()) {
                    userInput = "";
                }
                delta--;
            }
        }
    }
}
