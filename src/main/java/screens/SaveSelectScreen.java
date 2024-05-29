package screens;

import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class SaveSelectScreen extends Screen {

    public SaveSelectScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
        gp.player = new Player(gp, keyH);
        cityMap = false;
    }

    public void update() {
        super.update();
        if (userInput.equals("/newgame")) {
            gp.currentScreen = new NewGameScreen(gp, keyH);
        }

        if (userInput.equals("/loadgame 1")) {
            gp.stopMusic();
            gp.saveLoad.load("save1.ser");
        }
        if (userInput.equals("/loadgame 2")) {
            gp.stopMusic();
            gp.saveLoad.load("save2.ser");
        }
        if (userInput.equals("/loadgame 3")) {
            gp.stopMusic();
            gp.saveLoad.load("save3.ser");
        }
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);

        g2.setFont(pokemon_classic20);
        g2.setColor(Color.BLACK);
        g2.drawString("/newgame", 30, 502);
        g2.drawString("/loadgame <1 / 2 / 3>", 30, 532);
        g2.drawString("/exit", 30, 562);
    }


}
