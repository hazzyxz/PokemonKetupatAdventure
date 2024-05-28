package main;

import javax.swing.*;
import java.awt.event.KeyListener;

public class BattlePanel extends JPanel {

    GamePanel gamePanel;
    KeyHandler keyH;

    public BattlePanel(GamePanel gamePanel, KeyHandler keyH) {
        this.gamePanel = gamePanel;
        this.keyH = keyH;
    }
}
