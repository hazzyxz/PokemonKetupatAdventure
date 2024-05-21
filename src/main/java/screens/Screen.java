package screens;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static main.ApplicationMain.userInput;

public abstract class Screen {
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage background;
    Font pokemon_classic;

    public Screen(GamePanel gp, KeyHandler keyH, String backgroundPath) {
        this.gp = gp;
        this.keyH = keyH;

        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(backgroundPath)));
        }
        catch (IOException e) {
            System.out.println("Image input error");
        }
    }

    public void update() {
        if (userInput.equals("/exit")) {
            System.exit(0);
        }
        if (userInput.equals("/home")) {
            gp.stopMusic();
            gp.currentScreen = new StartScreen(gp, keyH);
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(background, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }

    public void setBackground(String path) {
        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        }
        catch (IOException e) {
            System.out.println("Image input error");
        }
    }
}
