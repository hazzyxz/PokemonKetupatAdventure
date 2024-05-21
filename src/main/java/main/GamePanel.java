package main;

import entity.Player;
import screens.Screen;
import screens.StartScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static main.ApplicationMain.userInput;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int tileSize = 16;
    final int tileCount = 44;

    public final int screenHeight = tileSize * tileCount;
    public final int screenWidth = tileSize * tileCount;

    // SYSTEM TIME VARIABLES
    int FPS = 144;

    // SYSTEM
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    UI ui = new UI(this, keyH);
    Thread gameThread;

    // Entity and Objects
    public Screen currentScreen = new StartScreen(this, keyH);
    public Player player = new Player(this, keyH);

    public GamePanel() {
        // SETS THE GAME PANEL SETTINGS
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        currentScreen.update();
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        currentScreen.draw(g2);
        // player.draw(g2);

        // UI
        ui.draw(g2);

        g2.dispose();
    }

    @Override
    public void run() {

        // deltaTime variables
        double drawInterval = 1000000000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            // deltaTime calculations
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

    public BufferedImage getImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        } catch (IOException e) {
            System.out.println("Image input error");
        }

        return image;
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }
}
