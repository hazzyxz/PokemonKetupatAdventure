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
    boolean selectPokemon = false;
    boolean selectItem = false;
    boolean displayFightDialogue = false;

    String[] allyDialogue;
    String[] enemyDialogue;
    final String[] damageDealText = { "Super Effective!", "Ouch!", "Critical Hit!", "It's not very effective...", "" };

    BufferedImage playerPokemon;
    BufferedImage enemyPokemon;

    Screen currentScreen;

    public BattleScreen(GamePanel gp, KeyHandler keyH, Pokemon wildPokemon, Screen currentScreen) {
        super(gp, keyH, "/Backgrounds/BattleBG.png");
        this.ally = gp.player.getPokemonList().getFirst();
        this.enemy = wildPokemon;
        this.currentScreen = currentScreen;
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

        //---------- SELECT ACTION COMMANDS ----------------\\
        if (userInput.equals("/fight") && selectAction) {
            selectAction = false;
            selectFight = true;
        }
        if (userInput.equals("/pokemon") && selectAction) {

        }
        if (userInput.equals("/items") && selectAction) {

        }
        if (userInput.equals("/run") && selectAction) {
            tryRun();
        }


        //------------- SELECT MOVES COMMANDS (AFTER /fight)---------------\\
        if (userInput.equals("/move1") && selectFight) {
            PokemonBattle.usesMoves(ally.getMove()[0], enemy, ally, weather);
            selectFight = false;
        }
        if (userInput.equals("/move2") && selectFight) {
            PokemonBattle.usesMoves(ally.getMove()[1], enemy, ally, weather);
            selectFight = false;
        }


    }

    public void draw(Graphics2D g2) {
        super.draw(g2);

        drawPokemonInfo(g2);
        g2.drawImage(enemyPokemon,300,50, 960,480,null);
        g2.drawImage(playerPokemon,-540,224, 960,480,null);
        if (selectAction || selectFight || selectPokemon || selectItem) {
            drawActionBox(g2);
        }
        drawBox(g2);
    }

    void drawBox(Graphics2D g2) {
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

        // During select action (/fight, /pokemon, /items, /run)
        if (selectAction) {
            if (pokemonBattle) {
                // If fighting wild pokemon
                g2.drawString("A wild "+enemy.getName()+" appeared !", x, y);
            }
            else {
                //If fighting gym leader\\
                g2.drawString("A "+enemy.getName()+" appeared !", x, y);
            }
            if (weather.getCurrentWeather() != Weather.WeatherType.NONE) {
                g2.drawString("It is "+ weather.getCurrentWeather(), x, y+35);
            }
        }

        // During selecting moves
        if (selectFight) {
            g2.drawString("Select a move !",x,y);
        }
    }

    void drawActionBox(Graphics2D g2) {
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
        g2.setColor(Color.BLACK);

        if (selectAction) {
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

    void drawActionWindow(int x, int y, int width, int height , Graphics2D g2) {
        Color c = new Color(255,255,255, 255);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height,35,35);

        c = new Color(0,0,0,255);
        g2.setStroke(new BasicStroke(7));
        g2.setColor(c);
        g2.drawRoundRect(x+7, y+7, width-14, height-14,25,25);
    }

    void drawPokemonInfo(Graphics2D g2) {
        int x = 380 + (gp.tileSize*2-20);
        int y = 450;

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.BOLD, 20);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.WHITE);

        //----------------- Ally Pokemon  -------------------\\
        g2.setColor(Color.BLACK);
        g2.drawString(ally.getName(), x-3, y-3);
        g2.drawString("lvl "+ally.getLevel(),x-3,y+30);
        g2.setColor(Color.WHITE);
        g2.drawString(ally.getName(), x, y);
        g2.drawString("lvl "+ally.getLevel(),x,y+30);
        // Calculate HP percentage
        int allyHealthPercent = (int) (ally.getCurrentHealth()/ally.getFullHealth() * 280);
        g2.setColor(Color.BLACK);
        g2.fillRoundRect(x-3, y+45-3, 280+3, 15+3,15,15);
        g2.setColor(Color.GREEN);
        g2.fillRoundRect(x, y+45, allyHealthPercent, 15,15,15);



        //----------------- Enemy Pokemon ---------------------\\
        g2.setColor(Color.BLACK);
        g2.drawString(enemy.getName(), gp.tileSize*5-3, gp.tileSize*13);
        g2.drawString("lvl "+enemy.getLevel(),gp.tileSize*5-3,gp.tileSize*13+30);
        g2.setColor(Color.WHITE);
        g2.drawString(enemy.getName(), gp.tileSize*5, gp.tileSize*13);
        g2.drawString("lvl "+enemy.getLevel(),gp.tileSize*5,gp.tileSize*13+30);
        // Calculate HP percentage
        int enemyHealthPercent = (int) (enemy.getCurrentHealth()/enemy.getFullHealth() * 280.0);
        g2.setColor(Color.BLACK);
        g2.fillRoundRect(gp.tileSize*5-3, gp.tileSize*13+45-3, 280+3, 15+3,15,15);
        g2.setColor(Color.GREEN);
        g2.fillRoundRect(gp.tileSize*5, gp.tileSize*13+45, enemyHealthPercent, 15,15,15);


    }

    void tryRun() {
        Random rand = new Random();

        int chance = rand.nextInt(10);

        if (chance <= 7) {
            endBattle();
        }
        else System.out.println("Fuck you, Cibai");
    }

    void endBattle() {
        gp.stopMusic();
        gp.playMusic(1);
        gp.currentScreen = this.currentScreen;
    }
}
