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
    Random rand = new Random();

    boolean pokemonBattle = false;
    boolean selectAction = false;
    boolean selectFight = false;
    boolean selectPokemon = false;
    boolean selectItem = false;
    boolean displayFightDialogue = false;
    boolean displayEnemyFightDialogue = false;
    boolean throwPokeball = false;
    boolean captureSuccess = false;
    boolean captureFail = false;
    boolean isGymLeader = false;
    boolean youLose = false;
    boolean youWin = false;

    int allySelectedMove;
    int enemySelectedMove;
    int allyDamage;
    int enemyDamage;

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
        isGymLeader = true;
    }

    public void update() {
        super.update();

        //---------- SELECT ACTION COMMANDS ----------------\\
        if (userInput.equals("/fight") && selectAction) {
            selectAction = false;
            selectFight = true;
        }
        if (userInput.equals("/pokemon") && selectAction) {
            selectAction = false;
            selectPokemon = true;
        }
        if (userInput.equals("/items") && selectAction) {
            selectAction = false;
            selectItem = true;
        }
        if (userInput.equals("/run") && selectAction) {
            tryRun();
        }

        //------------- SELECT MOVES COMMANDS (AFTER /fight)---------------\\
        if ((userInput.equals("/move 1") && selectFight) || userInput.equals("/fight move 1")) {
            allyDamage = PokemonBattle.usesMoves(ally.getMove()[0], enemy, ally, weather);
            allySelectedMove = 1;
            // If ally pokemon unalive switch to next pokemon
            if (enemy.isDown()) {
                if (pokemonBattle) {
                    youWin();
                    youWin = true;
                    selectAction = false;
                    selectFight = false;
                }
            }
            else {
                selectAction = false;
                selectFight = false;
                displayFightDialogue = true;
            }
        }
        if ((userInput.equals("/move 2") && selectFight) || userInput.equals("/fight move 2")) {
            allyDamage = PokemonBattle.usesMoves(ally.getMove()[1], enemy, ally, weather);
            allySelectedMove = 2;
            // If ally pokemon unalive switch to next pokemon
            if (enemy.isDown()) {
                if (pokemonBattle) {
                    youWin();
                    youWin = true;
                    selectAction = false;
                    selectFight = false;
                }
            }
            else {
                selectAction = false;
                selectFight = false;
                displayFightDialogue = true;
            }
        }

        //-------------SELECT POKEMON COMMANDS--------------------------\\
        if ((userInput.contains("/choose") && selectPokemon)) {
            int i;

            try {
                String[] s = userInput.split("");
                i = Integer.parseInt(s[8]);
                swapPokemon(i-1);
            } catch (IndexOutOfBoundsException e) {
                i = 0;
            }


            enemyTurn();
            selectPokemon = false;
        }

        if ((userInput.equals("/return") && selectPokemon)) {
            selectAction = true;
            selectPokemon = false;
        }

        //---------------FIGHT DIALOGUE----------------------------------\\
        if (displayFightDialogue && userInput.equals("/")) {
            // Enemy Turn
            enemyTurn();
        }

        else if (displayEnemyFightDialogue && userInput.equals("/")) {
            displayEnemyFightDialogue = false;
            selectAction = true;
        }

        else if (youWin && userInput.equals("/")) {
            endBattle();
        }

        else if (youLose && userInput.equals("/")) {
            gp.player.healPokemonFull();
            endBattle();
        }

        // ------------ITEMS COMMANDS-------------------------\\
        if (selectItem && userInput.equals("/ketupat")) {
            selectItem = false;
            if (!isGymLeader) {
                throwPokeball = true;
            }else {
                selectAction = true;
            }
        }

        if (throwPokeball && userInput.equals("/")) {
            throwPokeball = false;
            captureSuccess = PokemonBattle.capturePokemon(enemy, gp.player, weather);
            if (!captureSuccess) {
                captureFail = true;
            }
        }

        else if (captureSuccess) {
            enemyPokemon = null;
            if (userInput.equals("/")) {
                endBattle();
            }
        }

        else if (captureFail && userInput.equals("/")) {
            enemyTurn();
            captureFail = false;
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


        // OVERLAY OR SUBMENU
        if (selectPokemon) {
            drawSelectPokemon(g2);
        }
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

        // After selected move write attack dialogue
        if (displayFightDialogue) {
            allyDialogue = new String[]{
                    ally.getName()+" used "+ally.getMove()[0].getMovesName()+" !",
                    ally.getName()+" used "+ally.getMove()[1].getMovesName()+" !",
                    "Super Effective!",
                    "It's not very effective...",
            };

            g2.drawString(allyDialogue[allySelectedMove-1], x, y);
            g2.drawString(PokemonBattle.dialogue+" "+PokemonBattle.additionalDialogue, x, y+30);
            PokemonBattle.additionalDialogue = "";

            g2.drawString("/",width-5,y+60);
        }

        if (displayEnemyFightDialogue) {
            enemyDialogue = new String[]{
                    enemy.getName()+" used "+enemy.getMove()[0].getMovesName()+" !",
                    enemy.getName()+" used "+enemy.getMove()[1].getMovesName()+" !",
                    "Super Effective!",
                    "It's not very effective..."
            };

            g2.drawString(enemyDialogue[enemySelectedMove], x, y);
            g2.drawString(PokemonBattle.dialogue+" "+PokemonBattle.additionalDialogue, x, y+30);
            PokemonBattle.additionalDialogue = "";

            g2.drawString("/",width-5,y+60);
        }

        if (youWin) {
            g2.drawString(enemy.getName()+" fainted. You win!",x,y);
            g2.drawString("You gained 50 gold",x,y+30);
            g2.drawString("/",width-5,y+60);
        }

        if (youLose) {
            g2.drawString("All your Pokemon fainted. You lose!",x,y);
            g2.drawString("You lost 100 gold",x,y+30);
            g2.drawString("/",width-5,y+60);
        }

        if (selectItem) {
            g2.drawString("Select an item !",x,y);
        }

        if (throwPokeball) {
            g2.drawString("You throw Ketupat at the enemy !",x,y);
            g2.drawString("/",width-5,y+60);
        }

        if (captureSuccess) {
            g2.drawString("You caught "+enemy.getName()+" !",x,y);
            g2.drawString("/",width-5,y+60);
        }

        if (captureFail) {
            g2.drawString("The enemy broke free !",x,y);
            g2.drawString("/",width-5,y+60);
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
            g2.drawString("/move 1",x,y);
            g2.drawString(ally.getMoveNames().get(0)+" <"+ally.getMove()[0].getDamage()+"dmg>",x,y+28);
            g2.drawString("/move 2",x,y+68);
            g2.drawString(ally.getMoveNames().get(1)+" <"+ally.getMove()[1].getDamage()+"dmg>",x,y+96);
        }
        if (selectItem) {
            pokemon_classic20 = pokemon_classic20.deriveFont(Font.BOLD, 15);
            g2.setFont(pokemon_classic20);
            g2.drawString("/ketupat",x,y);
            g2.drawString("/potion",x,y+40);
            g2.drawString("<small/medium/large>",x,y+68);
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

        // DISPLAY COLOR FOR EACH PERCENTAGE
        if (allyHealthPercent > 140) {
            g2.setColor(Color.GREEN);
        }
        else if (allyHealthPercent > 70) {
            g2.setColor(Color.YELLOW);
        }
        else {
            g2.setColor(Color.RED);
        }
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

        // DISPLAY COLOR FOR EACH PERCENTAGE
        if (enemyHealthPercent > 140) {
            g2.setColor(Color.GREEN);
        }
        else if (enemyHealthPercent > 70) {
            g2.setColor(Color.YELLOW);
        }
        else {
            g2.setColor(Color.RED);
        }
        g2.fillRoundRect(gp.tileSize*5, gp.tileSize*13+45, enemyHealthPercent, 15,15,15);


    }

    void drawSelectPokemon(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,704,704);

        int x = gp.tileSize*2;
        int y = gp.tileSize*3;
        int spacing = 0;
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.BLACK);

        for (int i = 0; i < gp.player.getPokemonList().size(); i++) {
            g2.setColor(Color.BLACK);
            if (i==0) {
                g2.drawString((i+1)+".  "+gp.player.getPokemonList().get(i).getName()+"  lvl. "+gp.player.getPokemonList().get(i).getLevel()+" <active>", x, y + spacing);
            }
            else {
                g2.drawString((i+1)+".  "+gp.player.getPokemonList().get(i).getName()+"  lvl. "+gp.player.getPokemonList().get(i).getLevel(), x, y + spacing);
            }
            int allyHealthPercent = (int) (gp.player.getPokemonList().get(i).getCurrentHealth()/gp.player.getPokemonList().get(i).getFullHealth() * 280);
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(x+30, y+spacing+18, 280, 15,15,15);

            // DISPLAY HEALTH BASED ON PERCENTAGE
            if (allyHealthPercent > 140) {
                g2.setColor(Color.GREEN);
            }
            else if (allyHealthPercent > 70) {
                g2.setColor(Color.YELLOW);
            }
            else {
                g2.setColor(Color.RED);
            }

            g2.fillRoundRect(x+32, y+spacing+20, allyHealthPercent, 15,15,15);

            spacing+=105;
        }

        g2.setColor(Color.BLACK);
        g2.drawString("/choose   <number>                          /return",x-5,y+spacing);
    }

    void enemyTurn() {
        enemySelectedMove = rand.nextInt(2);
        enemyDamage = PokemonBattle.usesMoves(enemy.getMove()[enemySelectedMove], ally, enemy, weather);

        if (ally.isDown()) {
            if (gp.player.getPokemonList().isEmpty()) {
                youLose = true;
                displayFightDialogue = false;
                youLose();
            }
            else {
                ally = gp.player.getPokemonList().getFirst();
                playerPokemon = PokemonSprite.sprites.get(ally.getName());
                displayEnemyFightDialogue = true;
                displayFightDialogue = false;
            }
        }
        else {
            displayEnemyFightDialogue = true;
            displayFightDialogue = false;
        }
    }

    void swapPokemon(int x) {
        // SWAP FIRST POKEMON WITH xth POKEMON
        Pokemon temp = gp.player.getPokemonList().get(x);
        gp.player.getPokemonList().remove(x);
        gp.player.getPokemonList().addFirst(temp);

        // SET FIRST POKEMON AS ACTIVE
        ally = gp.player.getPokemonList().getFirst();
        playerPokemon = PokemonSprite.sprites.get(ally.getName());
    }

    void youWin() {
        if (pokemonBattle) {
            gp.player.Money+=50;
        }

        ally.increaseEXP(5*enemy.getLevel());
    }

    void youLose() {
        gp.player.Money-=100;
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
