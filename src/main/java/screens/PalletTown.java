package screens;

import backend.GymLeader;
import backend.GymLeaderFactory;
import backend.Pokemon;
import backend.PokemonFactory;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

import static main.ApplicationMain.userInput;

public class PalletTown extends Screen {

    public PalletTown(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/PalletTown.png");
        cityName = "Pallet Town";
        cityMap = true;
        gp.stopMusic();
        gp.playMusic(1);
    }

    @Override
    public void update() {
        super.update();

        if (userInput.equals("/goto Viridian City")) {
            gp.currentScreen = new ViridianCity(gp, keyH);
        }

        if (userInput.equals("/fight")) {
            int num = rand.nextInt(3);
            Pokemon enemy = switch (num) {
                case 0 -> PokemonFactory.createPokemon("Caterpie");
                case 1 -> PokemonFactory.createPokemon("Weedle");
                case 2 -> PokemonFactory.createPokemon("Pidgey");
                default -> null;
            };
            enemy.setLevel(3);
            gp.currentScreen = new BattleScreen(gp, keyH, enemy, this);
        }

        if (userInput.equals("/gym")) {

            // TEST ONLY
            GymLeader brock = GymLeaderFactory.leaderBrock();
            gp.currentScreen = new BattleScreen(gp, keyH, brock, this);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);

        if (!mapBoolean && !myInfo && !showShop) {
            g2.setFont(pokemon_solid40);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLUE);
            g2.drawString("Pallet Town", 3, 42);
            g2.setColor(Color.YELLOW);
            g2.drawString("Pallet Town", 8, 42);
        }
    }
}
