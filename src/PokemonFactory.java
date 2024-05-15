import java.util.HashMap;

public class PokemonFactory {
    private static final HashMap<String, Pokemon> pokemonMap = new HashMap<>();

    static {
        // Initialize Moves
        Moves tackleMove = MovesFactory.createMove("Tackle");
        Moves scratchMove = MovesFactory.createMove("Scratch"); 
        Moves vineWhiMove = MovesFactory.createMove("Vine Whip");
        Moves razorLeafMove = MovesFactory.createMove("Razor Leaf");
        Moves solarBeamMove = MovesFactory.createMove("Solar Beam");
        Moves emberMove = MovesFactory.createMove("Ember");
        Moves flamethrowerMove = MovesFactory.createMove("Flamethrower");
        Moves fireSpinMove = MovesFactory.createMove("Fire Spin");
        Moves bubbleMove = MovesFactory.createMove("Bubble");
        Moves waterGunMove = MovesFactory.createMove("Water Gun");
        Moves hydroPumpMove = MovesFactory.createMove("Hydro Pump");
        Moves bugBiteMove = MovesFactory.createMove("Bug Bite");
        Moves slashMove = MovesFactory.createMove("Slash");
        Moves bugBuzzMove = MovesFactory.createMove("Bug Buzz");
        Moves poisonStingMove = MovesFactory.createMove("Poison Sting");
        Moves quickAttackMove = MovesFactory.createMove("Quick Attack");
        Moves wingAttackMove = MovesFactory.createMove("Wing Attack");
        Moves hurricaneMove = MovesFactory.createMove("Hurricane");
        Moves hyperFangMove = MovesFactory.createMove("Hyper Fang");
        Moves peckMove = MovesFactory.createMove("Peck");
        Moves drillPeckMove = MovesFactory.createMove("Drill Peck");
        Moves biteMove = MovesFactory.createMove("Bite");
        Moves acidMove = MovesFactory.createMove("Acid");
        Moves thunderShockMove = MovesFactory.createMove("Thunder Shock");
        Moves thunderBoltMove = MovesFactory.createMove("Thunderbolt");
        Moves doubleKickMove = MovesFactory.createMove("Double Kick");
        Moves bodySlamMove = MovesFactory.createMove("Body Slam");
        Moves poisonJabMove = MovesFactory.createMove("Poison Jab");
        Moves earthPowerMove = MovesFactory.createMove("Earth Power");
        Moves doubleSlapMove = MovesFactory.createMove("Double Slap");
        Moves poundMove = MovesFactory.createMove("Pound");
        Moves petalDanceMove = MovesFactory.createMove("Petal Dance");
        Moves digMove = MovesFactory.createMove("Dig");
        Moves earthquakeMove = MovesFactory.createMove("Earthquake");
        Moves lowKickMove = MovesFactory.createMove("Low Kick");
        Moves karateChopMove = MovesFactory.createMove("Karate Chop");
        Moves cutMove = MovesFactory.createMove("Cut");
        Moves headbuttMove = MovesFactory.createMove("Headbutt");

        // Create and add Pokemon to map
        addPokemonToMap(new Pokemon("Bulbasaur", 45, new String[]{"grass", "poison"}, 1, new String[]{"fighting", "water", "grass", "fairy", "electric"}, new String[]{"flying", "fire", "psychic", "ice"}, tackleMove, vineWhiMove));
        addPokemonToMap(new Pokemon("Ivysaur", 60, new String[]{"grass", "poison"}, 1, new String[]{"fighting", "water", "grass", "fairy", "electric"}, new String[]{"flying", "fire", "psychic", "ice"}, tackleMove, razorLeafMove));
        addPokemonToMap(new Pokemon("Venusaur", 80, new String[]{"grass", "poison"}, 1, new String[]{"fighting", "water", "grass", "fairy", "electric"}, new String[]{"flying", "fire", "psychic", "ice"}, tackleMove, solarBeamMove));
        addPokemonToMap(new Pokemon("Charmander", 39, new String[]{"fire"}, 1, new String[]{"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[]{"ground", "rock", "water"}, scratchMove, emberMove));
        addPokemonToMap(new Pokemon("Charmeleon", 58, new String[]{"fire"}, 1, new String[]{"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[]{"ground", "rock", "water"}, scratchMove, flamethrowerMove));
        addPokemonToMap(new Pokemon("Charizard", 78, new String[]{"fire", "flying"}, 1, new String[]{"fighting", "bug", "steel", "fire", "grass", "fairy"}, new String[]{"rock", "water", "electric"}, scratchMove, fireSpinMove));
        addPokemonToMap(new Pokemon("Squirtle", 44, new String[]{"water"}, 1, new String[]{"steel", "fire", "water", "ice"}, new String[]{"grass", "electric"}, tackleMove, bubbleMove));
        addPokemonToMap(new Pokemon("Wartortle", 59, new String[]{"water"}, 1, new String[]{"steel", "fire", "water", "ice"}, new String[]{"grass", "electric"}, tackleMove, waterGunMove));
        addPokemonToMap(new Pokemon("Blastoise", 79, new String[]{"water"}, 1, new String[]{"steel", "fire", "water", "ice"}, new String[]{"grass", "electric"}, tackleMove, hydroPumpMove));
        addPokemonToMap(new Pokemon("Caterpie", 45, new String[]{"bug"}, 1, new String[]{"fighting", "ground", "grass"}, new String[]{"flying", "rock", "fire"}, tackleMove, bugBiteMove));
        addPokemonToMap(new Pokemon("Metapod", 50, new String[]{"bug"}, 1, new String[]{"fighting", "ground", "grass"}, new String[]{"flying", "rock", "fire"}, tackleMove, slashMove));
        addPokemonToMap(new Pokemon("Butterfree", 60, new String[]{"bug", "flying"}, 1, new String[]{"fighting", "bug", "grass"}, new String[]{"flying", "rock", "fire", "electric", "ice"}, tackleMove, bugBuzzMove));
        addPokemonToMap(new Pokemon("Weedle", 40, new String[]{"bug", "poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"flying", "rock", "fire", "psychic"}, tackleMove, poisonStingMove));
        addPokemonToMap(new Pokemon("Kakuna", 45, new String[]{"bug", "poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"flying", "rock", "fire", "psychic"}, tackleMove, slashMove));
        addPokemonToMap(new Pokemon("Beedrill", 65, new String[]{"bug", "poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"flying", "rock", "fire", "psychic"}, tackleMove, bugBuzzMove));
        addPokemonToMap(new Pokemon("Pidgey", 40, new String[]{"normal", "flying"}, 1, new String[]{"bug", "grass"}, new String[]{"rock", "electric", "ice"}, tackleMove, slashMove));
        addPokemonToMap(new Pokemon("Pidgeotto", 63, new String[]{"normal", "flying"}, 1, new String[]{"bug", "grass"}, new String[]{"rock", "electric", "ice"}, tackleMove, wingAttackMove));
        addPokemonToMap(new Pokemon("Pidgeot", 83, new String[]{"normal", "flying"}, 1, new String[]{"bug", "grass"}, new String[]{"rock", "electric", "ice"}, tackleMove, hurricaneMove));
        addPokemonToMap(new Pokemon("Rattata", 30, new String[]{"normal"}, 1, new String[]{}, new String[]{"fighting"}, biteMove, slashMove));
        addPokemonToMap(new Pokemon("Raticate", 55, new String[]{"normal"}, 1, new String[]{}, new String[]{"fighting"}, hyperFangMove, slashMove));
        addPokemonToMap(new Pokemon("Spearow", 40, new String[]{"normal", "flying"}, 1, new String[]{"bug", "grass"}, new String[]{"rock", "electric", "ice"}, peckMove, slashMove));
        addPokemonToMap(new Pokemon("Fearow", 65, new String[]{"normal", "flying"}, 1, new String[]{"bug", "grass"}, new String[]{"rock", "electric", "ice"}, drillPeckMove, slashMove));
        addPokemonToMap(new Pokemon("Ekans", 35, new String[]{"poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"ground", "psychic"}, biteMove, slashMove));
        addPokemonToMap(new Pokemon("Arbok", 60, new String[]{"poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"ground", "psychic"}, acidMove, slashMove));
        addPokemonToMap(new Pokemon("Pikachu", 35, new String[]{"electric"}, 1, new String[]{"flying", "steel", "electric"}, new String[]{"ground"}, thunderShockMove, slashMove));
        addPokemonToMap(new Pokemon("Raichu", 60, new String[]{"electric"}, 1, new String[]{"flying", "steel", "electric"}, new String[]{"ground"}, thunderBoltMove, slashMove));
        addPokemonToMap(new Pokemon("Sandshrew", 50, new String[]{"ground"}, 1, new String[]{"poison", "rock", "electric"}, new String[]{"ice", "grass", "water"}, slashMove, earthPowerMove));
        addPokemonToMap(new Pokemon("Sandslash", 75, new String[]{"ground"}, 1, new String[]{"poison", "rock", "electric"}, new String[]{"ice", "grass", "water"}, slashMove, earthPowerMove));
        addPokemonToMap(new Pokemon("Nidoran♀", 55, new String[]{"poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"ground", "psychic"}, scratchMove, slashMove));
        addPokemonToMap(new Pokemon("Nidorina", 70, new String[]{"poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"ground", "psychic"}, bodySlamMove, slashMove));
        addPokemonToMap(new Pokemon("Nidoqueen", 90, new String[]{"poison", "ground"}, 1, new String[]{"poison", "rock", "electric"}, new String[]{"ice", "psychic", "ground"}, bodySlamMove, slashMove));
        addPokemonToMap(new Pokemon("Nidoran♂", 46, new String[]{"poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"ground", "psychic"}, doubleKickMove, slashMove));
        addPokemonToMap(new Pokemon("Nidorino", 61, new String[]{"poison"}, 1, new String[]{"fighting", "poison", "bug", "grass", "fairy"}, new String[]{"ground", "psychic"}, poisonJabMove, slashMove));
        addPokemonToMap(new Pokemon("Nidoking", 81, new String[]{"poison", "ground"}, 1, new String[]{"poison", "rock", "electric"}, new String[]{"ice", "psychic", "ground"}, earthPowerMove, slashMove));
        addPokemonToMap(new Pokemon("Clefairy", 70, new String[]{"fairy"}, 1, new String[]{"fighting", "bug", "dark"}, new String[]{"poison", "steel"}, doubleSlapMove, slashMove));
        addPokemonToMap(new Pokemon("Clefable", 95, new String[]{"fairy"}, 1, new String[]{"fighting", "bug", "dark"}, new String[]{"poison", "steel"}, poundMove, slashMove));
        addPokemonToMap(new Pokemon("Vulpix", 38, new String[]{"fire"}, 1, new String[]{"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[]{"ground", "rock", "water"}, emberMove, slashMove));
        addPokemonToMap(new Pokemon("Ninetales", 73, new String[]{"fire"}, 1, new String[]{"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[]{"ground", "rock", "water"}, flamethrowerMove, slashMove));
        addPokemonToMap(new Pokemon("Jigglypuff", 115, new String[]{"normal", "fairy"}, 1, new String[]{"bug", "dark", "ghost"}, new String[]{"poison", "steel"}, poundMove, slashMove));
        addPokemonToMap(new Pokemon("Wigglytuff", 140, new String[]{"normal", "fairy"}, 1, new String[]{"bug", "dark", "ghost"}, new String[]{"poison", "steel"}, poundMove, slashMove));
        addPokemonToMap(new Pokemon("Diglett", 10, new String[]{"ground"}, 1, new String[]{"poison", "rock", "electric"}, new String[]{"ice", "grass", "water"}, digMove, slashMove));
        addPokemonToMap(new Pokemon("Dugtrio", 35, new String[]{"ground"}, 1, new String[]{"poison", "rock", "electric"}, new String[]{"ice", "grass", "water"}, earthquakeMove, slashMove));
        addPokemonToMap(new Pokemon("Meowth", 40, new String[]{"normal"}, 1, new String[]{}, new String[]{"fighting"}, slashMove, headbuttMove));
        addPokemonToMap(new Pokemon("Persian", 65, new String[]{"normal"}, 1, new String[]{}, new String[]{"fighting"}, slashMove, headbuttMove));
        addPokemonToMap(new Pokemon("Mankey", 40, new String[]{"fighting"}, 1, new String[]{"bug", "rock", "dark"}, new String[]{"flying", "psychic", "fairy"}, lowKickMove, slashMove));
        addPokemonToMap(new Pokemon("Primeape", 65, new String[]{"fighting"}, 1, new String[]{"bug", "rock", "dark"}, new String[]{"flying", "psychic", "fairy"}, karateChopMove, slashMove));
    }

    private static void addPokemonToMap(Pokemon pokemon) {
        if (pokemon.getMove()[0] == null || pokemon.getMove()[1] == null) {
            System.err.println("Pokemon " + pokemon.getName() + " has null moves.");
        }
        pokemonMap.put(pokemon.getName(), pokemon);
    }

    public static Pokemon createPokemon(String name) {
        return pokemonMap.get(name);
    }
}
