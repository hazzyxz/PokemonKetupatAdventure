package screens;

import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class SaveSelectScreen extends Screen {

    public SaveSelectScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
        gp.player = new Player();
        cityMap = false;
    }

    public void update() {
        super.update();
        if (userInput.equals("/newgame")) {
            gp.currentScreen = new NewGameScreen(gp, keyH);
        }

        if (userInput.contains("/loadgame")) {
            try {
                String[] str = userInput.split("");
                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 10; i < str.length; i++) {
                    stringBuilder.append(str[i]);
                }

                String save = stringBuilder.toString();

                gp.stopMusic();
                gp.saveLoad.load(save+".ser");

            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);

        g2.setFont(pokemon_classic20);
        g2.setColor(Color.BLACK);
        g2.drawString("/newgame", 30, 502);
        g2.drawString("/loadgame <trainer_name>", 30, 532);
        g2.drawString("/exit", 30, 562);
    }


}
