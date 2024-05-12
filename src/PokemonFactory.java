
import java.util.HashMap;

public class PokemonFactory {
    private static final HashMap<String, Pokemon> pokemonMap = new HashMap<String, Pokemon>();
    
    static {
        Moves tackleMove = MovesFactory.createMove("Tackle");
        Moves scratchMove = MovesFactory.createMove("Scratch");
        
        Moves vineWimpMove = MovesFactory.createMove("Vine Wimp");
        Moves razorLeafMove = MovesFactory.createMove("Razor Leaf");
        Moves solarBeamMove = MovesFactory.createMove("Solar Beam");
        
        Moves emberMove = MovesFactory.createMove("Ember");
        Moves flamethrowerMove = MovesFactory.createMove("Flamethrower");
        Moves fireSpinMove = MovesFactory.createMove("Fire Spin");
        
        Moves bubbleMove = MovesFactory.createMove("Bubble");
        Moves waterGunMove = MovesFactory.createMove("Water Gun");
        Moves hydroPumpMove = MovesFactory.createMove("Hydro Pump");
        
        Moves stringShotMove = MovesFactory.createMove("String Shot");
        Moves hardenMove = MovesFactory.createMove("Harden");
        Moves confusionMove = MovesFactory.createMove("Confusion");
        
        // list of pokemon
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "fairy", "electric"}, new String[] {"flying", "fire", "psychic", "ice"}, tackleMove, vineWimpMove);
        Pokemon ivysaur = new Pokemon("Ivysaur", 60, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "fairy", "electric"}, new String[] {"flying", "fire", "psychic", "ice"}, tackleMove, razorLeafMove);
        Pokemon venusaur = new Pokemon("Venusaur", 80, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "fairy", "electric"}, new String[] {"flying", "fire", "psychic", "ice"}, tackleMove, solarBeamMove);
        
        Pokemon charmander = new Pokemon("Charmander", 39, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, scratchMove, emberMove);
        Pokemon charmeleon = new Pokemon("Charmeleon", 58, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, scratchMove, flamethrowerMove);
        Pokemon charizard = new Pokemon("Charizard", 78, new String[] {"fire", "flying"}, 1, new String[] {"fighting", "bug", "steel", "fire", "grass", "fairy"}, new String[] {"rock", "water", "electric"}, scratchMove, fireSpinMove);
        
        Pokemon squirtle = new Pokemon("Squirtle", 44, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, tackleMove, bubbleMove);
        Pokemon wartorle = new Pokemon("Wartortle", 59, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, tackleMove, waterGunMove);
        Pokemon blastoise = new Pokemon("Blastoise", 79, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, tackleMove, hydroPumpMove);
        
        Pokemon caterpie = new Pokemon("Caterpie", 45, new String[] {"bug"}, 1, new String[] {"fighting", "ground", "grass"}, new String[] {"flying", "rock", "fire"}, tackleMove, stringShotMove);
        Pokemon metapod = new Pokemon("Metapod", 50, new String[] {"bug"}, 1, new String[] {"fighting", "ground", "grass"}, new String[] {"flying", "rock", "fire"}, tackleMove, hardenMove);
        Pokemon butterfree = new Pokemon("Butterfree", 60, new String[] {"bug", "flying"}, 1, new String[] {"fighting", "bug", "grass"}, new String[] {"flying", "rock", "fire", "electric", "ice"}, tackleMove, confusionMove); 
        
        
        
        pokemonMap.put("Bulbasaur", bulbasaur);
        pokemonMap.put("Ivysaur", ivysaur);
        pokemonMap.put("Venusaur", venusaur);
        pokemonMap.put("Charmander", charmander);
        pokemonMap.put("Charmeleon", charmeleon);
        pokemonMap.put("Charizard", charizard);
        pokemonMap.put("Squirtle", squirtle);
        pokemonMap.put("Wartorle", wartorle);
        pokemonMap.put("Blastoise", blastoise);
        pokemonMap.put("Caterpie", caterpie);
        pokemonMap.put("Metapod", metapod);
        pokemonMap.put("Butterfree", butterfree);
        
    }
    
    public static Pokemon createPokemon(String pokemonName) {
        return pokemonMap.get(pokemonName);
    }
}
