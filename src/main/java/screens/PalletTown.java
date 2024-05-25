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

public class PalletTown extends Screen {

    BufferedImage commandList;

    public PalletTown(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/PalletTown.png");
        try {
            commandList = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Backgrounds/commandList.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        g2.drawImage(commandList, 0, 0, null);

        g2.setFont(pokemon_solid40);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.drawString("Pallet Town", 3, 42);
        g2.setColor(Color.WHITE);
        g2.drawString("Pallet Town", 8, 42);
    }
}
