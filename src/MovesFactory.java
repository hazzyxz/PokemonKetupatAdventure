
import java.util.HashMap;

public class MovesFactory {
    private static final HashMap<String, Moves> movesMap = new HashMap<String, Moves>();
    
    // list of all move
    static {
        movesMap.put("Pound", new Moves("Pound", 5));
        movesMap.put("Karate Chop", new Moves("Karate Chop", 11));
        movesMap.put("Double Slap", new Moves("Double Slap", 5));
        movesMap.put("Scratch", new Moves("Scratch", 5));
        movesMap.put("Cut", new Moves("Cut", 5));
        movesMap.put("Wing Attack", new Moves("Wing Attack", 12));
        movesMap.put("Vine Whip", new Moves("Vine Whip", 11));
        movesMap.put("Double Kick", new Moves("Double Kick", 13));
        movesMap.put("Headbutt", new Moves("Headbutt", 5));
        movesMap.put("Tackle", new Moves("Tackle", 5));
        movesMap.put("Body Slam", new Moves("Body Slam", 10));
        movesMap.put("Poison Sting", new Moves("Poison Sting", 10));
        movesMap.put("Bite", new Moves("Bite", 5));
        movesMap.put("Ember", new Moves("Ember", 12));
        movesMap.put("Flamethrower", new Moves("Flamethrower", 13));
        movesMap.put("Water Gun", new Moves("Water Gun", 14));
        movesMap.put("Hydro Pump", new Moves("Hydro Pump", 11));
        movesMap.put("Peck", new Moves("Peck", 5));
        movesMap.put("Low Kick", new Moves("Low Kick", 5));
        movesMap.put("Razor Leaf", new Moves("Razor Leaf", 10));
        movesMap.put("Solar Beam", new Moves("Solar Beam", 13));
        movesMap.put("Petal Dance", new Moves("Petal Dance", 10));
        movesMap.put("Fire Spin", new Moves("Fire Spin", 11));
        movesMap.put("Thunder Shock", new Moves("Thunder Shock", 13));
        movesMap.put("Thunderbolt", new Moves("Thunderbolt", 14));
        movesMap.put("Earthquake", new Moves("Earthquake", 14));
        movesMap.put("Dig", new Moves("Dig", 5));
        movesMap.put("Quick Attack", new Moves("Quick Attack", 5));
        movesMap.put("Bubble", new Moves("Bubble", 11));
        movesMap.put("Hyper Fang", new Moves("Hyper Fang", 12));
        movesMap.put("Slash", new Moves("Slash", 12));
        movesMap.put("Bug Bite", new Moves("Bug Bite", 11));
        movesMap.put("Bug Buzz", new Moves("Bug Buzz", 10));
        movesMap.put("Hurricane", new Moves("Hurricane", 10));
        movesMap.put("Poison Jab", new Moves("Poison Jab", 10));
        movesMap.put("Earth Power", new Moves("Earth Power", 11));
        movesMap.put("Acid", new Moves("Acid", 12));
        movesMap.put("Drill Peck", new Moves("Drill Peck", 14));

    }
    
    public static Moves createMove(String moveName) {
        return movesMap.get(moveName).clone();
    }
}
