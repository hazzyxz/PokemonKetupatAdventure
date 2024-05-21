package screens;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class StartScreen extends Screen {

    long startTime;

    public StartScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
        startTime = System.currentTimeMillis();
        gp.playMusic(0);
    }

    @Override
    public void update() {
        super.update();

        long elapsedTime = System.currentTimeMillis() - startTime;

        if (elapsedTime >= 5000) {
            setBackground("/Backgrounds/StartScreen.png");
        }


        if (userInput.equals("/start")) {
            gp.currentScreen = new SaveSelectScreen(gp, keyH);
        }
        if (userInput.equals("/skip")) {
            setBackground("/Backgrounds/StartScreen.png");
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);

        long elapsedTime = System.currentTimeMillis() - startTime;

        if (elapsedTime >= 7500) g2.drawImage(gp.getImage("/Backgrounds/StartText.png"), 0, 0, null);
    }
}
