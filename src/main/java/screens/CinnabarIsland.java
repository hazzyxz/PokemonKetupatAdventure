package screens;

import backend.GymLeader;
import backend.GymLeaderFactory;
import backend.Pokemon;
import backend.PokemonFactory;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class CinnabarIsland extends Screen {

    public CinnabarIsland(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/CinnabarIsland.png");
        cityName = "Cinnabar Island";
        cityMap = true;

        gp.stopMusic();
        gp.playMusic(1);
    }

    @Override
    public void update() {
        super.update();

        // FORWARD DIRECTION
        if (userInput.equals("/goto Pallet Town")) {
            gp.currentScreen = new PalletTown(gp, keyH);
        }

        // BACKWARD DIRECTION
        if (userInput.equals("/goto Fuchsia City")) {
            gp.currentScreen = new FuchsiaCity(gp, keyH);
        }

        if (userInput.equals("/fight")) {
            int num = rand.nextInt(3);
            Pokemon enemy = switch (num) {
                case 0 -> PokemonFactory.createPokemon("Vulpix");
                case 1 -> PokemonFactory.createPokemon("Jigglypuff");
                case 2 -> PokemonFactory.createPokemon("Zubat");
                default -> null;
            };
            enemy.setLevel(50);
            gp.currentScreen = new BattleScreen(gp, keyH, enemy, this);
        }

        if (userInput.equals("/gym")) {
            GymLeader gymLeader = GymLeaderFactory.leaderBlaine();
            gp.currentScreen = new BattleScreen(gp, keyH, gymLeader, this);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        if (!mapBoolean && !myInfo && !showShop) {
            drawSpecialCommands(g2);
        }
    }

    void drawSpecialCommands(Graphics2D g2) {
        int x = gp.getWidth() - gp.tileSize*11;
        int y = gp.tileSize*43;

        Color c = new Color(0,0,0, 180);
        g2.setColor(c);
        g2.fillRoundRect(x-gp.tileSize/2, y-90, gp.tileSize*11, 100,35,35);

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);

        g2.setColor(Color.BLACK);
        g2.drawString("# EVENTS", x-2, y-1-60);
        g2.setColor(Color.WHITE);
        g2.drawString("# EVENTS", x, y-60);

        g2.setColor(Color.BLACK);
        g2.drawString("/fight", x-2, y-1-30);
        g2.setColor(Color.WHITE);
        g2.drawString("/fight", x, y-30);

        g2.setColor(Color.BLACK);
        g2.drawString("/gym", x-2, y-1);
        g2.setColor(Color.WHITE);
        g2.drawString("/gym", x, y);
    }
}
