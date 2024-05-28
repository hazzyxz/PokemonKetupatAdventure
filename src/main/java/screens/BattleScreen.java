package screens;

import backend.GymLeader;
import backend.Pokemon;
import entity.Player;
import main.BattlePanel;
import main.GamePanel;
import main.KeyHandler;

import javax.net.ssl.KeyManager;
import javax.swing.*;

public class BattleScreen extends Screen {

    Player player;
    Pokemon enemy;
    GymLeader gymLeader;

    public BattleScreen(GamePanel gp, KeyHandler keyH, Player player, Pokemon wildPokemon) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
        this.player = player;
        this.enemy = wildPokemon;
    }

    public BattleScreen(GamePanel gp, KeyHandler keyH, Player player, GymLeader gymLeader) {
        super(gp, keyH, "/Backgrounds/WhiteScreen.png");
    }
}
