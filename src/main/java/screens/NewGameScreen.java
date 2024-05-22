package screens;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.util.Objects;

import static main.ApplicationMain.userInput;

public class NewGameScreen extends Screen {

    int dialogueIndex = 0;
    boolean oakTalking = false;

    public NewGameScreen(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
        dialogues[0] = "Hey lancau";
        dialogues[1] = "Selamat datang ke Malaysia";
        dialogues[2] = "Saya Professor Oak";
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

        if (dialogueIndex == 3) {
            setBackground("/Backgrounds/ProfOakAndPokemon.png");
        }

        if (dialogueIndex == 6) {
            gp.stopMusic();
            gp.currentScreen = new PalletTown(gp, keyH);
        }

        if (userInput.equals("/next")) {
            dialogueIndex++;
        }

    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
        currentDialogue = dialogues[dialogueIndex];
        if (!Objects.equals(currentDialogue, null) && oakTalking) {
            drawDialogueScreen(g2);
        }
    }


}
