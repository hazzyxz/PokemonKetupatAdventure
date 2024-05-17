package screens;

import ui.GamePanel;
import ui.KeyHandler;

public class ScreenFactory {
    GamePanel gp;
    KeyHandler keyH;

    public ScreenFactory(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public Screen newStartScreen() {
        Screen startScreen = new Screen(gp, keyH, new Screen[]{null, this.newPalletTownScreen()});
        startScreen.setBackground("/Backgrounds/StartScreen.png");
        return startScreen;
    }

    public Screen newPalletTownScreen() {
        Screen palletTownScreen = new Screen(gp, keyH, null);
        palletTownScreen.setBackground("/Backgrounds/PalletTown.png");
        return palletTownScreen;
    }
}
