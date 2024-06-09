package screens;

import backend.*;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class FuchsiaCity extends Screen {

    public static String answerRivalsRace = "";

    public FuchsiaCity(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/fuchsia.jpg");
        cityName = "Fuchsia City";
        cityMap = true;

        gp.stopMusic();
        gp.playMusic(1);
    }

    @Override
    public void update() {
        super.update();

        // FORWARD DIRECTION


        // BACKWARD DIRECTION
        if (userInput.equals("/goto Celadon City")) {
            gp.currentScreen = new CeladonCity(gp, keyH);
        }
        if (userInput.equals("/goto Vermillion City")) {
            gp.currentScreen = new VermillionCity(gp, keyH);
        }
        if (userInput.equals("/goto Lavender Town")) {
            gp.currentScreen = new LavenderTown(gp, keyH);
        }

        if (userInput.equals("/fight")) {
            int num = rand.nextInt(3);
            Pokemon enemy = switch (num) {
                case 0 -> PokemonFactory.createPokemon("Pikachu");
                case 1 -> PokemonFactory.createPokemon("Sandshrew");
                case 2 -> PokemonFactory.createPokemon("Clefairy");
                default -> null;
            };
            enemy.setLevel(47);
            gp.currentScreen = new BattleScreen(gp, keyH, enemy, this);
        }

        if (userInput.equals("/gym")) {
            GymLeader gymLeader = GymLeaderFactory.leaderKoga();
            gp.currentScreen = new BattleScreen(gp, keyH, gymLeader, this);
        }
        if (userInput.equals("/safarizone")) {
            gp.currentScreen = new SafariZone(gp, keyH, this);
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
        int x = gp.getWidth() - gp.tileSize*15;
        int y = gp.tileSize*43;

        Color c = new Color(0,0,0, 180);
        g2.setColor(c);
        g2.fillRoundRect(x-gp.tileSize/2, y-120, gp.tileSize*15, 130,35,35);

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);

        g2.setColor(Color.BLACK);
        g2.drawString("# EVENTS", x-2, y-1-90);
        g2.setColor(Color.WHITE);
        g2.drawString("# EVENTS", x, y-90);

        g2.setColor(Color.BLACK);
        g2.drawString("/fight", x-2, y-1-60);
        g2.setColor(Color.WHITE);
        g2.drawString("/fight", x, y-60);

        g2.setColor(Color.BLACK);
        g2.drawString("/gym", x-2, y-1-30);
        g2.setColor(Color.WHITE);
        g2.setColor(Color.WHITE);
        g2.drawString("/gym", x, y-30);

        g2.setColor(Color.BLACK);
        g2.drawString("/safarizone", x-2, y-1);
        g2.setColor(Color.WHITE);
        g2.drawString("/safarizone", x, y);

    }
}
