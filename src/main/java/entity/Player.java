package entity;

import backend.Pokemon;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Player implements Entity {

    // Attributes
    GamePanel gp;
    KeyHandler keyH;
    private String Name;
    private ArrayList<Pokemon> pokemonList;
    private String Location;
    private int Badges = 0;
    private int Items; // pls change appropriately
    private double Money;
    private LinkedList<Pokemon> DownedPokemonList;
    private final int FULLPOKEMONLISTSIZE = 6;


    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        pokemonList = new ArrayList<Pokemon>();
        this.Money = 0;
        DownedPokemonList = new LinkedList<Pokemon>();
        this.Badges = 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g2) {

    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public void setStarterPokemon(Pokemon starterPokemon) {
        this.pokemonList.add(starterPokemon);
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
