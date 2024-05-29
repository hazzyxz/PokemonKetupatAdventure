package screens;

import backend.PokemonFactory;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static main.ApplicationMain.userInput;

public class PalletTown extends Screen {

    public PalletTown(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/PalletTown.png");
        cityName = "Pallet Town";
        cityMap = true;
    }

    @Override
    public void update() {
        super.update();

        if (userInput.equals("/fight")) {
            gp.currentScreen = new BattleScreen(gp, keyH, PokemonFactory.createPokemon("Charmander"));
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);

        if (!mapBoolean) {
            g2.setFont(pokemon_solid40);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLUE);
            g2.drawString("Pallet Town", 3, 42);
            g2.setColor(Color.YELLOW);
            g2.drawString("Pallet Town", 8, 42);
        }
    }
}
