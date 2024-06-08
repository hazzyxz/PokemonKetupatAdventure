package screens;

import backend.GymLeader;
import backend.GymLeaderFactory;
import backend.Pokemon;
import backend.PokemonFactory;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class ViridianCity extends Screen {

    boolean isNotQualified;

    public ViridianCity(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/viridian.jpg");
        cityName = "Viridian City";
        cityMap = true;
        isNotQualified = false;

        currentDialogue = "You are not qualified. Earn\nall other badges to challenge\nGym Leader Giovani";

        gp.stopMusic();
        gp.playMusic(1);
    }

    @Override
    public void update() {
        super.update();

        // FORWARD DIRECTION
        if (userInput.equals("/goto Pewter City")) {
            gp.currentScreen = new PewterCity(gp, keyH);
        }

        // BACKWARD DIRECTION
        if (userInput.equals("/goto Pallet Town")) {
            gp.currentScreen = new PalletTown(gp, keyH);
        }

        if (userInput.equals("/fight")) {
            int num = rand.nextInt(3);
            Pokemon enemy = switch (num) {
                case 0 -> PokemonFactory.createPokemon("Caterpie");
                case 1 -> PokemonFactory.createPokemon("Weedle");
                case 2 -> PokemonFactory.createPokemon("Pidgey");
                default -> null;
            };
            enemy.setLevel(7);
            gp.currentScreen = new BattleScreen(gp, keyH, enemy, this);
        }

        if (userInput.equals("/gym")) {
            if (gp.player.getBadges().size() >= 7) {
                // TEST ONLY
                GymLeader gymLeader = GymLeaderFactory.leaderGiovani();
                gp.currentScreen = new BattleScreen(gp, keyH, gymLeader, this);
            }
            else {
                isNotQualified = true;
            }
        }

        if (userInput.equals("/") && isNotQualified) {
            isNotQualified = false;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);

        if (!mapBoolean && !myInfo && !showShop) {
            drawSpecialCommands(g2);
        }

        if (isNotQualified) {
            drawDialogueBox(g2);
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
