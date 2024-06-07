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
        gp.playMusic(1);
    }

    @Override
    public void update() {
        super.update();

        if (userInput.equals("/fight")) {
            Pokemon enemy = PokemonFactory.createPokemon("Bulbasaur");

            gp.currentScreen = new BattleScreen(gp, keyH, enemy, this);
        }

        if (userInput.equals("/gym")) {

            // TEST ONLY
            GymLeader brock = GymLeaderFactory.leaderBrock();
            Pokemon ally = PokemonFactory.createPokemon("Charizard");
            ally.setLevel(1000);
            gp.player.addPokemon(ally);
            gp.currentScreen = new BattleScreen(gp, keyH, brock, this);
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
