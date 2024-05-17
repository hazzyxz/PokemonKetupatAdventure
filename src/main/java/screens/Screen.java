package screens;

import ui.GamePanel;
import ui.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static ui.ApplicationMain.userInput;

public class Screen {
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage background;
    Screen[] adjacentScreen;

    public Screen(GamePanel gp, KeyHandler keyH, Screen[] adjacentScreen) {
        this.gp = gp;
        this.keyH = keyH;
        this.adjacentScreen = adjacentScreen;
    }

    public void setBackground(String path) {
        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        }
        catch (IOException e) {
            System.out.println("Image input error");
        }
    }

    public void update() {
        if (userInput.equals("start")) {
            gp.currentScreen = adjacentScreen[1];
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(background, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }
}
