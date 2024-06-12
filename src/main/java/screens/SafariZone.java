package screens;

import main.GamePanel;
import main.KeyHandler;

import javax.print.MultiDocPrintService;
import javax.swing.*;
import java.awt.*;

import static backend.SafariZone.sortedList;
import static backend.SafariZone.steps;
import static main.ApplicationMain.userInput;

public class SafariZone extends Screen {

    Screen currentScreen;

    boolean catchPokemon;
    boolean sortPokemon;

    boolean hasCharmander = false;
    boolean hasBulbasaur = false;
    boolean hasSnorlax = false;
    boolean hasMachop = false;
    boolean hasJigglypuff = false;
    boolean hasEevee = false;
    boolean hasPikachu = false;

    public SafariZone(GamePanel gp, KeyHandler keyH, Screen currentScreen) {
        super(gp, keyH, "/Backgrounds/SafariZone.png");
        cityMap = false;
        catchPokemon = true;

        this.currentScreen = currentScreen;
    }

    @Override
    public void update() {
        super.update();

        checkTextField();

        if (catchPokemon && userInput.contains("/catch")) {
            try {
                String[] str = userInput.split("");
                StringBuilder strBuilder = new StringBuilder();
                for (int i = 7; i < str.length; i++) {
                    strBuilder.append(str[i]);
                }
                backend.SafariZone.play(strBuilder.toString());

                catchPokemon = false;
                sortPokemon = true;
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

        if (sortPokemon && userInput.equals("/return")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Thank you, hope you enjoyed the Safari Zone",
                    "Goodbye",
                    JOptionPane.PLAIN_MESSAGE
            );

            gp.currentScreen = this.currentScreen;
        }

    }

    public void draw(Graphics2D g2) {
        super.draw(g2);

        Color c = new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRect(0,0,704,704);

        if (catchPokemon) {
            catchPokemon(g2);
        }
        if (sortPokemon) {
            sortPokemon(g2);
        }


    }

    void catchPokemon(Graphics2D g2) {
        int x = gp.tileSize*2;
        int y = gp.tileSize*3;

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_solid40);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLUE);
        g2.drawString("Safari Zone",x-5,y-1);
        g2.setColor(Color.YELLOW);
        g2.drawString("Safari Zone",x,y);

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 15);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.WHITE);
        g2.drawString("Catch all pokemon in any order and we'll sort them !",x, y+gp.tileSize*3);

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_classic20);
        if (!hasBulbasaur) g2.setColor(Color.WHITE); else g2.setColor(Color.RED);
        g2.drawString("Bulbasaur",x+ gp.tileSize*12, y+gp.tileSize*15);

        g2.setFont(pokemon_classic20);
        if (!hasPikachu) g2.setColor(Color.WHITE); else g2.setColor(Color.RED);
        g2.drawString("Pikachu",x+ gp.tileSize*8, y+gp.tileSize*9);

        g2.setFont(pokemon_classic20);
        if (!hasSnorlax) g2.setColor(Color.WHITE); else g2.setColor(Color.RED);
        g2.drawString("Snorlax",x+ gp.tileSize*23, y+gp.tileSize*10);

        g2.setFont(pokemon_classic20);
        if (!hasJigglypuff) g2.setColor(Color.WHITE); else g2.setColor(Color.RED);
        g2.drawString("Jigglypuff",x+ gp.tileSize*3, y+gp.tileSize*21);

        g2.setFont(pokemon_classic20);
        if (!hasEevee) g2.setColor(Color.WHITE); else g2.setColor(Color.RED);
        g2.drawString("Eevee",x+ gp.tileSize*3, y+gp.tileSize*12);

        g2.setFont(pokemon_classic20);
        if (!hasMachop) g2.setColor(Color.WHITE); else g2.setColor(Color.RED);
        g2.drawString("Machop",x+ gp.tileSize*25, y+gp.tileSize*24);

        g2.setFont(pokemon_classic20);
        if (!hasCharmander) g2.setColor(Color.WHITE); else g2.setColor(Color.RED);
        g2.drawString("Charmander",x+ gp.tileSize*9, y+gp.tileSize*29);


        // BOTTOM TEXT
        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 15);
        g2.setFont(pokemon_classic20);
        g2.setColor(Color.WHITE);
        g2.drawString("Catch format:", x- gp.tileSize, gp.screenHeight-gp.tileSize-30);
        g2.drawString("/catch pokemon1,pokemon2,pokemon3,...etc", x- gp.tileSize, gp.screenHeight-gp.tileSize);
    }

    void sortPokemon(Graphics2D g2) {
        int x = gp.tileSize*2;
        int y = gp.tileSize*3;

        pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        g2.setFont(pokemon_solid40);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLUE);
        g2.drawString("Safari Zone",x-5,y-1);
        g2.setColor(Color.YELLOW);
        g2.drawString("Safari Zone",x,y);

        g2.setFont(pokemon_classic20);
        g2.setColor(Color.WHITE);
        g2.drawString("/return",gp.screenWidth-gp.tileSize*9,y);

        x-= gp.tileSize - (gp.tileSize/2);
        y+= gp.tileSize*3;

        for (int i=0; i<steps.length;i++) {
            pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 15);
            g2.setFont(pokemon_classic20);
            g2.setColor(Color.WHITE);
            for (String step : steps[i].split("\n")) {
                g2.drawString(step,x, y);
                y+=25;
            }
            if (i==5) {
                y+=18;
                pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 11);
                g2.setFont(pokemon_classic20);
                g2.drawString("Final Sorted List:",x,y);
                g2.drawString(sortedList[i],x,y+20);
                break;
            }

            pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 11);
            g2.setFont(pokemon_classic20);
            g2.drawString(sortedList[i],x,y);
            y+=45;
        }


    }

    void checkTextField() {
        hasCharmander = gp.inputField.getText().contains("Charmander");
        hasBulbasaur = gp.inputField.getText().contains("Bulbasaur");
        hasSnorlax = gp.inputField.getText().contains("Snorlax");
        hasMachop = gp.inputField.getText().contains("Machop");
        hasJigglypuff = gp.inputField.getText().contains("Jigglypuff");
        hasEevee = gp.inputField.getText().contains("Eevee");
        hasPikachu = gp.inputField.getText().contains("Pikachu");
     }


}
