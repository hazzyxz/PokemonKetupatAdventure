package screens;

import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.util.Objects;

import static main.ApplicationMain.userInput;

public class NewGameScreen extends Screen {

    int dialogueIndex = 0;
    boolean oakTalking;
    boolean chosenName;

    public NewGameScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");

        oakTalking = false;
        chosenName = false;

        dialogues[0] = "Hey lancau, nama u apa?\n\n\n/myname <name>";
        dialogues[2] = "Saya Professor Shah";
        dialogues[3] = "Banyak haiwan nama pokemon\nkat sini";
        dialogues[4] = "Sila tangkap semua dan\nkalahkan semua gym Leaders";
        dialogues[5] = "Pilih starter cepat and\nkeluar, cibai";
    }

    public void update() {
        super.update();

        long elapsedTime = System.currentTimeMillis() - startTime;

        if (elapsedTime > 2000 & elapsedTime < 3000) {
            setBackground("/Backgrounds/ProfOakOnly.png");
        }
        if (elapsedTime > 3000 & elapsedTime < 4000) {
            oakTalking = true;
        }

        if (dialogueIndex == 0) {
            if (userInput.contains("/myname")) {
                String[] name = userInput.split("");
                StringBuilder nameBuilder = new StringBuilder();

                try {
                    if (!name[8].isEmpty()) {
                        for (int i = 8; i < name.length; i++) {
                            nameBuilder.append(name[i]);
                        }

                        gp.player.setName(nameBuilder.toString());
                        dialogues[1] = "Selamat datang ke Malaysia, \n"+gp.player.getName();
                        chosenName = true;
                        dialogueIndex++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Empty name");
                }
            }
        }

        if (dialogueIndex == 3) {
            setBackground("/Backgrounds/ProfOakAndPokemon.png");
        }

        if (dialogueIndex == 5) {
            gp.currentScreen = new StarterSelectScreen(gp, keyH);
        }

        if (userInput.equals("/next") && chosenName) {
            dialogueIndex++;
        }

    }

    public void draw(Graphics2D g2) {
        super.draw(g2);

        currentDialogue = dialogues[dialogueIndex];

        if (dialogueIndex == 0 && oakTalking) {
            drawDialogueBox(g2);
        }
        else if (!Objects.equals(currentDialogue, null) && oakTalking) {
            drawDialogueScreen(g2);
        }
    }


}
