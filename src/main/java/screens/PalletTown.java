package screens;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class PalletTown extends Screen {

    public PalletTown(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/PalletTown.png");
        pokemon_classic = new Font("Pokemon Solid", Font.PLAIN, 40);
        gp.playMusic(1);
    }

    @Override
    public void update() {
        super.update();

        if (userInput.equals("/return")) {
            gp.currentScreen = new StartScreen(gp, keyH);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);

        g2.setFont(pokemon_classic);
        g2.setColor(Color.BLACK);
        g2.drawString("Pallet Town", 35, 85);
        g2.setColor(Color.WHITE);
        g2.drawString("Pallet Town", 40, 85);
    }
}
