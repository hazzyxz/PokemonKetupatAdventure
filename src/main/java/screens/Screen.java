package screens;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Objects;

import static main.ApplicationMain.userInput;

public abstract class Screen implements Serializable {
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage background;
    BufferedImage commandList;
    BufferedImage map;
    Font pokemon_classic20;
    Font pokemon_solid40;
    String[] dialogues = new String[20];
    String currentDialogue;
    String cityName;
    long startTime;
    boolean cityMap;
    boolean mapBoolean;
    boolean raining;

    public Screen(GamePanel gp, KeyHandler keyH, String backgroundPath) {
        this.gp = gp;
        this.keyH = keyH;
        startTime = System.currentTimeMillis();
        mapBoolean = false;
        cityMap = false;

        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(backgroundPath)));
            commandList = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Backgrounds/commandList.png")));
            map = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Backgrounds/map.png")));
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

        // UNIVERSAL COMMANDS
        if (userInput.equals("/exit")) {
            System.exit(0);
        }
        if (userInput.equals("/home")) {
            gp.stopMusic();
            gp.currentScreen = new StartScreen(gp, keyH);
        }


        // CITY COMMANDS
        if (cityMap) {
            if (userInput.equals("/map")) {
                mapBoolean = !mapBoolean;
            }

            if (userInput.equals("/mypokemon")) {
                gp.player.ShowMyPokemon();
            }

            if (userInput.equals("/save 1")) {
                gp.saveLoad.save("save1.ser");
            }
            if (userInput.equals("/save 2")) {
                gp.saveLoad.save("save2.ser");
            }
            if (userInput.equals("/save 3")) {
                gp.saveLoad.save("save3.ser");
            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(background, 0, 0, gp.screenWidth, gp.screenHeight, null);
        if (cityMap) {
            g2.drawImage(commandList, 0, 0, null);
            if (mapBoolean) {
                g2.drawImage(map, 0, 0, null);
            }
        }
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
        g2.drawString("/next", width-74, height-20);
        for (String dialogue: currentDialogue.split("\n")) {
            g2.drawString(dialogue, x, y);
            y += 30;
        }
    }

    public void drawDialogueBox(Graphics2D g2) {
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

    public String getCityName() {
        if (cityMap) {
            return cityName;
        }
        else return null;
    }
}
