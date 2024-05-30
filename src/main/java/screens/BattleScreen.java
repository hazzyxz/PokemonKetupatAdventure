package screens;

import backend.*;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static main.ApplicationMain.userInput;

public class BattleScreen extends Screen {

    Pokemon ally;
    Pokemon enemy;
    GymLeader gymLeader;
    Weather weather;

    boolean pokemonBattle = false;
    boolean selectAction = false;
    boolean selectFight = false;

    BufferedImage playerPokemon;
    BufferedImage enemyPokemon;

    public BattleScreen(GamePanel gp, KeyHandler keyH, Pokemon wildPokemon) {
        super(gp, keyH, "/Backgrounds/BattleBG.png");
        this.ally = gp.player.getPokemonList().getFirst();
        this.enemy = wildPokemon;
        this.weather = new Weather();
        weather.randomizeWeather();

        playerPokemon = PokemonSprite.sprites.get(ally.getName());
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

        // FIGHT MENU COMMANDS
        if (userInput.equals("/fight") && selectAction) {
            selectAction = false;
            selectFight = true;
        }
        if (userInput.equals("/move1") && selectFight) {
            PokemonBattle.usesMoves(ally.getMove()[0], enemy, ally, weather);
            selectFight = false;
            selectAction = true;
        }
        if (userInput.equals("/move2") && selectFight) {
            PokemonBattle.usesMoves(ally.getMove()[1], enemy, ally, weather);
            selectFight = false;
            selectAction = true;
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
                g2.drawString("A wild "+enemy.getName()+" appeared !", x, y);
                if (weather.getCurrentWeather() != Weather.WeatherType.NONE) {
                    g2.drawString("It is "+ weather.getCurrentWeather(), x, y+35);
                }
            }
            else {
                //If fighting gym leader\
                g2.drawString("A "+enemy.getName()+" appeared !", x, y);
            }
        }
        if (selectFight) {
            g2.drawString("Select a move !",x,y);
        }
    }

    public void drawActionBox(Graphics2D g2) {
        // WINDOW
        int x = 380;
        int y = 532;

        int width = 320;
        int height = gp.tileSize*10;

        drawActionWindow(x, y, width, height, g2);

        x +=gp.tileSize*2-10;
        y +=gp.tileSize*3-6;
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.BOLD, 20);
        g2.setFont(pokemon_classic20);

        if (selectAction) {
            g2.setColor(Color.BLACK);
            g2.drawString("/fight", x, y);
            g2.drawString("/pokemon", x, y+32);
            g2.drawString("/items", x, y+64);
            g2.drawString("/run", x, y+96);
        }
        if (selectFight) {
            pokemon_classic20 = pokemon_classic20.deriveFont(Font.BOLD, 15);
            g2.setFont(pokemon_classic20);
            g2.drawString("/move1",x,y);
            g2.drawString(ally.getMoveNames().get(0)+" <"+ally.getMove()[0].getDamage()+"dmg>",x,y+28);
            g2.drawString("/move2",x,y+68);
            g2.drawString(ally.getMoveNames().get(1)+" <"+ally.getMove()[1].getDamage()+"dmg>",x,y+96);
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
        }













    }
}
