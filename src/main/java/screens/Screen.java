package screens;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Random;

import static main.ApplicationMain.userInput;

public abstract class Screen {
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
    Random rand = new Random();
    long startTime;
    boolean cityMap;
    boolean mapBoolean;
    boolean myInfo;
    boolean showShop;

    public Screen(GamePanel gp, KeyHandler keyH, String backgroundPath) {
        this.gp = gp;
        this.keyH = keyH;
        startTime = System.currentTimeMillis();
        mapBoolean = false;
        cityMap = false;
        myInfo = false;
        showShop = false;

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

            if (userInput.equals("/myinfo")) {
                myInfo = !myInfo;
            }

            if (userInput.equals("/heal")) {
                gp.player.healPokemonFull();
            }

            if (userInput.equals("/shop")) {
                showShop = !showShop;
            }

            if (userInput.equals("/save")) {
                gp.saveLoad.save(gp.player.getName()+".ser");
            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(background, 0, 0, gp.screenWidth, gp.screenHeight, null);
        if (cityMap) {
            // TOGGLE MAP
            // g2.drawImage(commandList, 0, 0, null);
            drawCommandList(g2);
            if (mapBoolean) {
                g2.drawImage(map, 0, 0, null);
            }

            // TOGGLE POKEMON INFO
            if (myInfo) {
                drawMyInfo(g2);
            }

            if (showShop) {
                drawShop(g2);
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
        g2.drawString("/", width-74, height-20);
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
        g2.drawString("/", width-16, height-20);
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

    void drawMyInfo(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,704,704);

        int x = gp.tileSize*2;
        int y = gp.tileSize*3;
        int spacing = 0;
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.BLACK);
        g2.drawString("<Trainer> "+gp.player.getName(), x, y);
        g2.drawString("Total Badges: "+gp.player.getBadges().size()+" | Money: "+(int) gp.player.getMoney()+"$", x, y+30);

        y+=70;

        for (int i = 0; i < gp.player.getPokemonList().size(); i++) {
            g2.setColor(Color.BLACK);
            if (i==0) {
                g2.drawString((i+1)+".  "+gp.player.getPokemonList().get(i).getName()+"  lvl. "+gp.player.getPokemonList().get(i).getLevel()+" <active>", x, y + spacing);
            }
            else {
                g2.drawString((i+1)+".  "+gp.player.getPokemonList().get(i).getName()+"  lvl. "+gp.player.getPokemonList().get(i).getLevel(), x, y + spacing);
            }
            int allyHealthPercent = (int) (gp.player.getPokemonList().get(i).getCurrentHealth()/gp.player.getPokemonList().get(i).getFullHealth() * 280);
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(x+30, y+spacing+18, 280, 15,15,15);

            // DISPLAY HEALTH BASED ON PERCENTAGE
            if (allyHealthPercent > 140) {
                g2.setColor(Color.GREEN);
            }
            else if (allyHealthPercent > 70) {
                g2.setColor(Color.YELLOW);
            }
            else {
                g2.setColor(Color.RED);
            }

            g2.fillRoundRect(x+32, y+spacing+20, allyHealthPercent, 15,15,15);

            g2.setColor(Color.LIGHT_GRAY);
            g2.drawString("[moves: "+gp.player.getPokemonList().get(i).getMove()[0].getMovesName()+",  "+gp.player.getPokemonList().get(i).getMove()[1].getMovesName()+"]", x+32,y+spacing+60);

            spacing+=95;
        }

        g2.setColor(Color.BLACK);
        g2.drawString("/myinfo",x-15,695);
    }

    void drawCommandList(Graphics2D g2) {
        int x = gp.tileSize;
        int y = gp.tileSize*33;
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);

        // DRAW COMMAND LIST
        g2.setColor(Color.BLACK);
        g2.drawString("/map",x-2,y-1);
        g2.setColor(Color.WHITE);
        g2.drawString("/map",x,y);

        g2.setColor(Color.BLACK);
        g2.drawString("/myinfo",x-2,y-1+30);
        g2.setColor(Color.WHITE);
        g2.drawString("/myinfo",x,y+30);

        g2.setColor(Color.BLACK);
        g2.drawString("/heal",x-2,y-1+60);
        g2.setColor(Color.WHITE);
        g2.drawString("/heal",x,y+60);

        g2.setColor(Color.BLACK);
        g2.drawString("/shop",x-2,y-1+90);
        g2.setColor(Color.WHITE);
        g2.drawString("/shop",x,y+90);

        g2.setColor(Color.BLACK);
        g2.drawString("/goto <location>",x-2,y-1+120);
        g2.setColor(Color.WHITE);
        g2.drawString("/goto <location>",x,y+120);

        g2.setColor(Color.BLACK);
        g2.drawString("/save",x-2,y-1+150);
        g2.setColor(Color.WHITE);
        g2.drawString("/save",x,y+150);
    }

    void drawShop(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,704,704);

        int x = gp.tileSize*2;
        int y = gp.tileSize*3;

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.BOLD, 20);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.BLACK);
        g2.drawString("</> SHOP </>",x,y);

        // ITEM LISTs
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.BLACK);
        g2.drawString("< Potions >",x,y+60);
        g2.setColor(Color.BLACK);
        g2.drawString("1. Small Potion          <50$>",x,y+90);
        g2.drawString("2. Medium Potion   <250$>",x,y+120);
        g2.drawString("3. Large Potion    <500$>",x,y+150);

        // BOTTOM TEXT
        g2.drawString("/buy <number>        /shop",x-15,695);
    }

    public String getCityName() {
        if (cityMap) {
            return cityName;
        }
        else return null;
    }
}
