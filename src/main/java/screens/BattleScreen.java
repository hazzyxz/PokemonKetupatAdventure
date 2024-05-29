package screens;

import backend.GymLeader;
import backend.Pokemon;
import backend.PokemonBattle;
import backend.PokemonSprite;
import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static main.ApplicationMain.userInput;

public class BattleScreen extends Screen {

    Pokemon enemy;
    GymLeader gymLeader;

    boolean pokemonBattle = false;
    boolean selectAction = false;
    boolean selectFight = false;

    BufferedImage playerPokemon;
    BufferedImage enemyPokemon;

    public BattleScreen(GamePanel gp, KeyHandler keyH, Pokemon wildPokemon) {
        super(gp, keyH, "/Backgrounds/BattleBG.png");
        this.enemy = wildPokemon;

        playerPokemon = PokemonSprite.sprites.get(gp.player.getPokemonList().getFirst().getName());
        enemyPokemon = PokemonSprite.sprites.get(enemy.getName());
        selectAction = true;
        pokemonBattle = true;

        gp.stopMusic();
        gp.playMusic(2);
    }

    public BattleScreen(GamePanel gp, KeyHandler keyH, GymLeader gymLeader) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
    }

    public void update() {
        super.update();

        if (userInput.equals("/fight")) {
            selectAction = false;
            selectFight = true;
        }
    }

    public void draw(Graphics2D g2) {
        super.draw(g2);

        g2.drawImage(enemyPokemon,320,50, 960,480,null);
        g2.drawImage(playerPokemon,-540,224, 960,480,null);
        drawActionBox(g2);
        drawBox(g2);
    }

    public void drawBox(Graphics2D g2) {
        // WINDOW
        int x = gp.tileSize*3;
        int y = gp.tileSize;

        int width = gp.screenWidth - (gp.tileSize*6);
        int height = gp.tileSize*9;

        drawSubWindow(x, y, width, height, g2);

        x +=gp.tileSize*2;
        y +=gp.tileSize*3;
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.WHITE);

        if (selectAction) {
            if (pokemonBattle) {
                // If fighting wild pokemon
                g2.drawString("A wild "+enemy.getName()+" appeared!", x, y);
            }
            else {
                //If fighting gym leader\
                g2.drawString("A "+enemy.getName()+" appeared!", x, y);
            }
        }
        if (selectFight) {

        }
    }

    public void drawActionBox(Graphics2D g2) {
        // WINDOW
        int x = 380;
        int y = 532;

        int width = 320;
        int height = gp.tileSize*10;

        drawActionWindow(x, y, width, height, g2);

        x +=gp.tileSize*2;
        y +=gp.tileSize*3;
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.BOLD, 20);
        g2.setFont(pokemon_classic20);

        if (selectAction) {
            g2.setColor(Color.BLACK);
            g2.drawString("/fight", x, y);
            g2.drawString("/pokemon", x, y+30);
            g2.drawString("/items", x, y+60);
            g2.drawString("/run", x, y+90);
        }
    }

    public void drawActionWindow(int x, int y, int width, int height , Graphics2D g2) {
        Color c = new Color(255,255,255, 255);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height,35,35);

        c = new Color(0,0,0,255);
        g2.setStroke(new BasicStroke(7));
        g2.setColor(c);
        g2.drawRoundRect(x+7, y+7, width-14, height-14,25,25);
    }

    public void enterPokemonBattle() {
        Random random = new Random();
        boolean win = false;
        Pokemon pokemonChoice = null;
        boolean Captured = false;

        boolean enemyPokemonAlive = true;
        boolean firstRound = true;

        while (enemyPokemonAlive) {
            if (gp.player.getPokemonList().isEmpty()) {
                //lose
                break;
            }


            //choose the pokemon
            // if not first round, or the first pokemon died, will display secodn phrase
            if (firstRound) {
                System.out.println("Choose your Pokemon: ");
                choosePokemon = true;
                firstRound = false;
            } else {
                System.out.println("Choose your next Pokemon: ");
                choosePokemon = true;
            }
        }













    }
}
