package main;

import screens.SaveSelectScreen;

import java.awt.*;
import java.util.Objects;

public class UI {
    GamePanel gp;
    KeyHandler keyH;
    Font pokemon_classic;

    public UI(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        pokemon_classic = new Font("Pokemon Classic", Font.PLAIN, 20);
    }

    public void draw(Graphics g2) {

    }
}
