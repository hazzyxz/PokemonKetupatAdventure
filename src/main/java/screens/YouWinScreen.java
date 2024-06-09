package screens;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class YouWinScreen extends Screen {

    int y = 0;
    long startTime;

    public YouWinScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
        gp.stopMusic();
        gp.playMusic(0);
        cityMap = false;

        startTime = System.currentTimeMillis();
    }

    @Override
    public void update() {
        super.update();

        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime > 10000 && elapsedTime < 18000) {
            y+=1;
        }

    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        long elapsedTime = System.currentTimeMillis() - startTime;

        if (elapsedTime > 1800) {
            pokemon_solid40 = pokemon_solid40.deriveFont(Font.BOLD, 102);
            g2.setColor(Color.BLACK);
            g2.setFont(pokemon_solid40);
            g2.drawString("You Win!", gp.tileSize*9, gp.tileSize*18-y);
        }
        if (elapsedTime > 1600) {
            pokemon_solid40 = pokemon_solid40.deriveFont(Font.BOLD, 95);
            g2.setColor(Color.BLUE);
            g2.setFont(pokemon_solid40);
            g2.drawString("You Win!", gp.tileSize*9, gp.tileSize*18-y);
        }
        if (elapsedTime > 1400) {
            pokemon_solid40 = pokemon_solid40.deriveFont(Font.BOLD, 90);
            g2.setColor(Color.YELLOW);
            g2.setFont(pokemon_solid40);
            g2.drawString("You Win!", gp.tileSize*9, gp.tileSize*18-y);
        }
        if (elapsedTime > 5000) {
            pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 15);
            g2.setFont(pokemon_classic20);
            g2.setColor(Color.BLACK);
            g2.drawString("      You became the very best, that no one ever was", gp.tileSize*2, gp.tileSize*23-y);
        }
    }
}
