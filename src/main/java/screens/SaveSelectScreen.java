package screens;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class SaveSelectScreen extends Screen {

    public SaveSelectScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
        this.pokemon_classic = new Font("Pokemon Classic", Font.PLAIN, 20);
    }

    public void update() {
        super.update();
        if (userInput.equals("/newgame")) {
            gp.stopMusic();
            gp.currentScreen = new PalletTown(gp, keyH);
        }
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);

        g2.setFont(pokemon_classic);
        g2.setColor(Color.BLACK);
        g2.drawString("/newgame", 30, 502);
        g2.drawString("/loadgame (1 / 2 / 3)", 30, 532);
        g2.drawString("/exit", 30, 562);
    }


}
