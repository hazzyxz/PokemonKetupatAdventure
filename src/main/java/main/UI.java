package main;

import screens.SaveSelectScreen;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class UI {
    GamePanel gp;
    KeyHandler keyH;
    Font pokemon_classic;

    public UI(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void draw(Graphics g2) {

    }
}
