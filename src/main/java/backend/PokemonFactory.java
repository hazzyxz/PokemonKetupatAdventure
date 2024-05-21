package backend;

import java.util.HashMap;

public class PokemonFactory {
    private static final HashMap<String, Pokemon> pokemonMap = new HashMap<String, Pokemon>();
    
    static {
    	Moves tackleMove = MovesFactory.createMove("Tackle");
        Moves scratchMove = MovesFactory.createMove("Scratch"); 
        Moves vineWhipMove = MovesFactory.createMove("Vine Whip");
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



        // list of pokemon
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "fairy", "electric"}, new String[] {"flying", "fire", "psychic", "ice"}, tackleMove, vineWhipMove);
        Pokemon ivysaur = new Pokemon("Ivysaur", 60, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "fairy", "electric"}, new String[] {"flying", "fire", "psychic", "ice"}, tackleMove, razorLeafMove);
        Pokemon venusaur = new Pokemon("Venusaur", 80, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "fairy", "electric"}, new String[] {"flying", "fire", "psychic", "ice"}, tackleMove, solarBeamMove);

        Pokemon charmander = new Pokemon("Charmander", 39, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, scratchMove, emberMove);
        Pokemon charmeleon = new Pokemon("Charmeleon", 58, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, scratchMove, flamethrowerMove);
        Pokemon charizard = new Pokemon("Charizard", 78, new String[] {"fire", "flying"}, 1, new String[] {"fighting", "bug", "steel", "fire", "grass", "fairy"}, new String[] {"rock", "water", "electric"}, scratchMove, fireSpinMove);

        Pokemon squirtle = new Pokemon("Squirtle", 44, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, tackleMove, bubbleMove);
        Pokemon wartorle = new Pokemon("Wartortle", 59, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, tackleMove, waterGunMove);
        Pokemon blastoise = new Pokemon("Blastoise", 79, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, tackleMove, hydroPumpMove);

        Pokemon caterpie = new Pokemon("Caterpie", 45, new String[] {"bug"}, 1, new String[] {"fighting", "ground", "grass"}, new String[] {"flying", "rock", "fire"}, tackleMove, bugBiteMove);
        Pokemon metapod = new Pokemon("Metapod", 50, new String[] {"bug"}, 1, new String[] {"fighting", "ground", "grass"}, new String[] {"flying", "rock", "fire"}, tackleMove, slashMove);
        Pokemon butterfree = new Pokemon("Butterfree", 60, new String[] {"bug", "flying"}, 1, new String[] {"fighting", "bug", "grass"}, new String[] {"flying", "rock", "fire", "electric", "ice"}, tackleMove, bugBuzzMove); 

        Pokemon weedle = new Pokemon("Weedle", 40, new String[] {"bug", "poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"flying", "rock", "fire", "psychic"}, tackleMove, poisonStingMove);
        Pokemon kakuna = new Pokemon("Kakuna", 45, new String[] {"bug", "poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"flying", "rock", "fire", "psychic"}, tackleMove, slashMove);
        Pokemon beedrill = new Pokemon("Beedrill", 65, new String[] {"bug", "poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"flying", "rock", "fire", "psychic"}, tackleMove, bugBuzzMove);

        Pokemon pidgey = new Pokemon("Pidgey", 40, new String[] {"normal", "flying"}, 1, new String[] {"bug", "grass"}, new String[] {"rock", "electric", "ice"}, tackleMove, slashMove);
        Pokemon pidgeotto = new Pokemon("Pidgeotto", 63, new String[] {"normal", "flying"}, 1, new String[] {"bug", "grass"}, new String[] {"rock", "electric", "ice"}, tackleMove, wingAttackMove);
        Pokemon pidgeot = new Pokemon("Pidgeot", 83, new String[] {"normal", "flying"}, 1, new String[] {"bug", "grass"}, new String[] {"rock", "electric", "ice"}, tackleMove, hurricaneMove);

        Pokemon rattata = new Pokemon("Rattata", 30, new String[] {"normal"}, 1, new String[] {}, new String[] {"fighting"}, biteMove, slashMove);
        Pokemon raticate = new Pokemon("Raticate", 55, new String[] {"normal"}, 1, new String[] {}, new String[] {"fighting"}, biteMove, hyperFangMove);

        Pokemon spearow = new Pokemon("Spearow", 40, new String[] {"normal", "flying"}, 1, new String[] {"bug", "grass"}, new String[] {"rock", "electric", "ice"}, peckMove, wingAttackMove);
        Pokemon fearow = new Pokemon("Fearow", 65, new String[] {"normal", "flying"}, 1, new String[] {"bug", "grass"}, new String[] {"rock", "electric", "ice"}, peckMove, drillPeckMove);

        Pokemon ekans = new Pokemon("Ekans", 35, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, biteMove, poisonStingMove);
        Pokemon arbok = new Pokemon("Arbok", 60, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, biteMove, poisonStingMove);

        Pokemon pikachu = new Pokemon("Pikachu", 35, new String[] {"electric"}, 1, new String[] {"flying", "steel", "electric"}, new String[] {"ground"}, quickAttackMove, thunderShockMove);
        Pokemon raichu = new Pokemon("Raichu", 60, new String[] {"electric"}, 1, new String[] {"flying", "steel", "electric"}, new String[] {"ground"}, quickAttackMove, thunderBoltMove);

        Pokemon sandshrew = new Pokemon("Sandshrew", 50, new String[] {"ground"}, 1, new String[] {"poison", "rock"}, new String[] {"water", "grass", "ice"}, scratchMove, slashMove);
        Pokemon sandslash = new Pokemon("Sandslash", 75, new String[] {"ground"}, 1, new String[] {"poison", "rock"}, new String[] {"water", "grass", "ice"}, scratchMove, earthPowerMove);

        Pokemon nidoranF = new Pokemon("NidoranF", 55, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, cutMove, poisonStingMove);
        Pokemon nidorina = new Pokemon("Nidorina", 70, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, cutMove, poisonJabMove);
        Pokemon nidoqueen = new Pokemon("Nidoqueen", 90, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, cutMove, acidMove);

        Pokemon nidoranM = new Pokemon("NidoranM", 46, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, headbuttMove, poisonStingMove);
        Pokemon nidorino = new Pokemon("Nidorino", 61, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, headbuttMove, poisonJabMove);
        Pokemon nidoking = new Pokemon("Nidoking", 81, new String[] {"poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground", "psychic"}, headbuttMove, earthquakeMove);

        Pokemon clefairy = new Pokemon("Clefairy", 70, new String[] {"fairy"}, 1, new String[] {"fighting", "bug", "dark"}, new String[] {"poison", "steel"}, doubleSlapMove, bodySlamMove);
        Pokemon clefable = new Pokemon("Clefable", 95, new String[] {"fairy"}, 1, new String[] {"fighting", "bug", "dark"}, new String[] {"poison", "steel"}, doubleSlapMove, earthquakeMove);

        Pokemon vulpix = new Pokemon("Vulpix", 38, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, biteMove, emberMove);
        Pokemon ninetales = new Pokemon("Ninetales", 73, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, biteMove, fireSpinMove);

        Pokemon jigglypuff = new Pokemon("Jigglypuff", 115, new String[] {"normal", "fairy"}, 1, new String[] {"bug", "dark"}, new String[] {"poison", "steel"}, scratchMove, slashMove);
        Pokemon wigglytuff = new Pokemon("Wigglytuff", 140, new String[] {"normal", "fairy"}, 1, new String[] {"bug", "dark"}, new String[] {"poison", "steel"}, poundMove, earthPowerMove);

        Pokemon zubat = new Pokemon("Zubat", 40, new String[] {"poison", "flying"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground"}, biteMove, acidMove);
        Pokemon golbat = new Pokemon("Golbat", 75, new String[] {"poison", "flying"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"ground"}, biteMove, poisonJabMove);

        Pokemon oddish = new Pokemon("Oddish", 45, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "electric", "fairy"}, new String[] {"flying", "fire", "psychic", "ice"}, scratchMove, vineWhipMove);
        Pokemon gloom = new Pokemon("Gloom", 60, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "electric", "fairy"}, new String[] {"flying", "fire", "psychic", "ice"}, scratchMove, petalDanceMove);
        Pokemon vileplume = new Pokemon("Vileplume", 75, new String[] {"grass", "poison"}, 1, new String[] {"fighting", "water", "grass", "electric", "fairy"}, new String[] {"flying", "fire", "psychic", "ice"}, scratchMove, solarBeamMove);

        Pokemon paras = new Pokemon("Paras", 35, new String[] {"bug", "grass"}, 1, new String[] {"fighting", "ground", "water", "grass", "electric"}, new String[] {"flying", "poison", "rock", "bug", "fire", "ice"}, scratchMove, slashMove);
        Pokemon parasect = new Pokemon("Parasect", 60, new String[] {"bug", "grass"}, 1, new String[] {"fighting", "ground", "water", "grass", "electric"}, new String[] {"flying", "poison", "rock", "bug", "fire", "ice"}, scratchMove, slashMove);

        Pokemon venonat = new Pokemon("Venonat", 60, new String[] {"bug", "poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"flying", "rock", "fire", "psychic"}, cutMove, poisonStingMove);
        Pokemon venomoth = new Pokemon("Venomoth", 70, new String[] {"bug", "poison"}, 1, new String[] {"fighting", "poison", "bug", "grass", "fairy"}, new String[] {"flying", "rock", "fire", "psychic"}, cutMove, poisonJabMove);

        Pokemon diglett = new Pokemon("Diglett", 10, new String[] {"ground"}, 1, new String[] {"poison", "rock"}, new String[] {"water", "grass", "ice"}, digMove, slashMove);
        Pokemon dugtrio = new Pokemon("Dugtrio", 10, new String[] {"ground"}, 1, new String[] {"poison", "rock"}, new String[] {"water", "grass", "ice"}, digMove, earthquakeMove);

        Pokemon meowth = new Pokemon("Meowth", 40, new String[] {"normal"}, 1, new String[] {}, new String[] {"fighting"}, scratchMove, slashMove);
        Pokemon persian = new Pokemon("Persian", 65, new String[] {"normal"}, 1, new String[] {}, new String[] {"fighting"}, headbuttMove, doubleKickMove);

        Pokemon psyduck = new Pokemon("Psyduck", 50, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, headbuttMove, bubbleMove);
        Pokemon golduck = new Pokemon("golduck", 80, new String[] {"water"}, 1, new String[] {"steel", "fire", "water", "ice"}, new String[] {"grass", "electric"}, headbuttMove, hydroPumpMove);

        Pokemon mankey = new Pokemon("Mankey", 40, new String[] {"fighting"}, 1, new String[] {"rock", "bug", "dark"}, new String[] {"flying", "psychic", "fairy"}, lowKickMove, doubleKickMove);
        Pokemon primeape = new Pokemon("Primeape", 65, new String[] {"fighting"}, 1, new String[] {"rock", "bug", "dark"}, new String[] {"flying", "psychic", "fairy"}, lowKickMove, karateChopMove);

        Pokemon growlithe = new Pokemon("Growlithe", 55, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, biteMove, emberMove);
        Pokemon arcanine = new Pokemon("Arcanine", 90, new String[] {"fire"}, 1, new String[] {"bug", "steel", "fire", "grass", "ice", "fairy"}, new String[] {"ground", "rock", "water"}, biteMove, flamethrowerMove);




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
        pokemonMap.put("Weedle", weedle);
        pokemonMap.put("Kakuna", kakuna);
        pokemonMap.put("Beedrill", beedrill);
        pokemonMap.put("Pidgey", pidgey);
        pokemonMap.put("Pidgeotto", pidgeotto);
        pokemonMap.put("Pidgeot", pidgeot);
        pokemonMap.put("Rattata", rattata);
        pokemonMap.put("Raticate", raticate);
        pokemonMap.put("Spearow", spearow);
        pokemonMap.put("Fearow", fearow);
        pokemonMap.put("Ekans", ekans);
        pokemonMap.put("Arbok", arbok);
        pokemonMap.put("Pikachu", pikachu);
        pokemonMap.put("Raichu", raichu);
        pokemonMap.put("Sandshrew", sandshrew);
        pokemonMap.put("Sandslash", sandslash);
        pokemonMap.put("NidoranF", nidoranF);
        pokemonMap.put("Nidorina", nidorina);
        pokemonMap.put("Nidoqueen", nidoqueen);
        pokemonMap.put("NidoranM", nidoranM);
        pokemonMap.put("Nidorino", nidorino);
        pokemonMap.put("Nidoking", nidoking);
        pokemonMap.put("Clefairy", clefairy);
        pokemonMap.put("Clefable", clefable);
        pokemonMap.put("Vulpix", vulpix);
        pokemonMap.put("Ninetales", ninetales);
        pokemonMap.put("Jigglypuff", jigglypuff);
        pokemonMap.put("Wigglytuff", wigglytuff);
        pokemonMap.put("Zubat", zubat);
        pokemonMap.put("Golbat", golbat);
        pokemonMap.put("Oddish", oddish);
        pokemonMap.put("Gloom", gloom);
        pokemonMap.put("Vileplume", vileplume);
        pokemonMap.put("Paras", paras);
        pokemonMap.put("Parasect", parasect);
        pokemonMap.put("Venonat", venonat);
        pokemonMap.put("Venomoth", venomoth);
        pokemonMap.put("Diglett", diglett);
        pokemonMap.put("Dugtrio", dugtrio);
        pokemonMap.put("Meowth", meowth);
        pokemonMap.put("Persian", persian);
        pokemonMap.put("Psyduck", psyduck);
        pokemonMap.put("Golduck", golduck);
        pokemonMap.put("Mankey", mankey);
        pokemonMap.put("Primeape", primeape);
        pokemonMap.put("Growlithe", growlithe);
        pokemonMap.put("Arcanine", arcanine);

    }
    
    public static Pokemon createPokemon(String pokemonName) {
        return pokemonMap.get(pokemonName);
    }
}