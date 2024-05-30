package data;

import entity.Player;

import java.io.Serializable;

public class DataStorage implements Serializable {
    // DATA STORAGE CLASS

    // STORE SERIALIZABLE OBJECTS
    // (note: all object within another object must also implements serializable i.e. Pokemon in Player)
    Player player;
    String currentScreen;
}
