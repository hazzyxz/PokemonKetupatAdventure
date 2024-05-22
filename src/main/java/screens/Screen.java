package screens;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static main.ApplicationMain.userInput;

public abstract class Screen {
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage background;
    Font pokemon_classic20;
    Font pokemon_solid40;
    String[] dialogues = new String[20];
    String currentDialogue;
    long startTime;

    public Screen(GamePanel gp, KeyHandler keyH, String backgroundPath) {
        this.gp = gp;
        this.keyH = keyH;
        startTime = System.currentTimeMillis();

        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(backgroundPath)));
            InputStream is = getClass().getResourceAsStream("/Font/Pokemon Classic.ttf");
            pokemon_classic20 = Font.createFont(Font.TRUETYPE_FONT, is);
            pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
            is = getClass().getResourceAsStream("/Font/Pokemon Solid.ttf");
            pokemon_solid40 = Font.createFont(Font.TRUETYPE_FONT, is);
            pokemon_solid40 = pokemon_solid40.deriveFont(Font.PLAIN, 40);
        }
        catch (IOException e) {
            System.out.println("Image input error");
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
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

    public void drawDialogueScreen(Graphics2D g2) {
        // WINDOW
        int x = gp.tileSize*3;
        int y = gp.tileSize;

        int width = gp.screenWidth - (gp.tileSize*6);
        int height = gp.tileSize*12;

        drawSubWindow(x, y, width, height, g2);

        x +=gp.tileSize*2;
        y +=gp.tileSize*3;
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);
        g2.drawString("/next", width-66, height-20);
        for (String dialogue: currentDialogue.split("\n")) {
            g2.drawString(dialogue, x, y);
            y += 30;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height , Graphics2D g2) {
        Color c = new Color(0,0,0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height,35,35);

        c = new Color(255,255,255,255);
        g2.setStroke(new BasicStroke(7));
        g2.setColor(c);
        g2.drawRoundRect(x+7, y+7, width-14, height-14,25,25);
    }
}
