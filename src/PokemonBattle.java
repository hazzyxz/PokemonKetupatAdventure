import java.util.Random;
import java.util.Scanner;

/*
 
Pokemon Battle:

fight gym leader or fight wild pokemon

1. display name pokemon[level 8] and HP,
2. display pokemon strength and weakness
3. RNG on who start first
4. display moves
5. Select moves
6. RNG on the crit attack, suggesting 6.25%
7. display effectiveness of attack
8. display HP remaining

NOTES:
- can throw pokeball any time, but percentage nak dapat scale with HP of the pokemon //must be wild Pokemon
- If own pokemon to die, move to next pokemon available
- if own pokemon to die, revive at hospital
- if menang, xp dropped can refer to level scheme, (5*enemy level) 

 */


public class PokemonBattle {

    public static void EnterBattle(GymLeader gymLeader, Player player, Weather weather) {

        Pokemon[] pokemontoBattle = gymLeader.getPokemonList().toArray(new Pokemon[gymLeader.getPokemonList().size()]);

        System.out.println("You Are about to challenge Gym Leader " + gymLeader.getName() + "!\n "
                + "Prepare yourself for an intense battle!");

        System.out.println("Your Pokemon: ");
        Pokemon[] yourPokemon = player.getPokemonList().toArray(new Pokemon[player.getPokemonList().size()]);

        for (Pokemon x : yourPokemon)
            System.out.println(" - " + x.getName() + " - level " + x.getLevel());

        System.out.println("Battle Start");

        for (int i = 0; i < pokemontoBattle.length; i++) {
            var pokemon = pokemontoBattle[i];
            System.out.println("Next pokemon in line to battle: " + pokemon.getName());
            EnterBattle(pokemon, player, false, weather);

            // Check if all player's Pokemon are defeated
            if (player.getPokemonList().stream().allMatch(Pokemon::isDown)) {
                System.out.println("All of your pokemon have been defeated. You lost the battle!");
                return;
            }
        }

        System.out.println("You have defeated all of Gym Leader " + gymLeader.getName() + "'s Pokemon!");
        player.addBadges(gymLeader.getName());
    }

    public static void EnterBattle(Pokemon pokemonEnemy, Player player, boolean isWildPokemon, Weather weather) {

        Scanner inputScanner = new Scanner(System.in);
        Random random = new Random();
        boolean win = false;
        Pokemon pokemonChoice = null;
        boolean Captured = false;

        boolean enemyPokemonAlive = true;
        boolean firstRound = true;

        while (enemyPokemonAlive) {
        	
        	 if (player.getPokemonList().size() == 0) {
             	//lose
             	break;
             }

        	 
        	 //choose the pokemon
        	 // if not first round, or the first pokemon died, will display secodn phrase
            if (firstRound) {
                System.out.println("Choose your Pokemon: ");
                firstRound = false;
            } else {
                System.out.println("Choose your next Pokemon: ");
            }
            
      
            //get the pokemon list
            for (int i = 0; i < player.getPokemonList().size(); i++) {
                Pokemon x = player.getPokemonList().get(i);
                System.out.println((i + 1) + " - " + x.getName() + " - level " + x.getLevel() + (x.isDown() ? " (down)" : ""));
            }
            
           
            //if input wrong choice, the loop will loop back
            int choice = inputScanner.nextInt() - 1;
            if (choice < 0 || choice >= player.getPokemonList().size() || player.getPokemonList().get(choice).isDown()) {
                System.out.println("Invalid choice or chosen Pokemon is down. Please select a valid Pokemon.");
                continue;
            }

            pokemonChoice = player.getPokemonList().get(choice);
            boolean pokemonChoiceAlive = true;
            int round = 1;
            
            
            //Enter the battle
            while (pokemonEnemy.getCurrentHealth() > 0 && pokemonChoiceAlive) {

                System.out.println("Round " + round);
                
                if(!isWildPokemon)
                	System.out.printf("\nChoose Moves:\n1- %s\n2- %s\n", 
                						pokemonChoice.getMove()[0].getMovesName(), 
                						pokemonChoice.getMove()[1].getMovesName());
                
                else {
                	System.out.printf("\nChoose Moves:\n1- %s\n2- %s\n3- Throw Pokeball\n", 
                						pokemonChoice.getMove()[0].getMovesName(), 
                						pokemonChoice.getMove()[1].getMovesName());
				}
                
                int movesChoice = inputScanner.nextInt();
                
                //if input incorrect choice will continue the loop
                if ((movesChoice < 0 || movesChoice > 2) && !isWildPokemon) {
                	System.out.println("Invalid moves");
                	continue;
                } else if ((movesChoice < 0 || movesChoice > 3) && isWildPokemon) {
                	System.out.println("Invalid moves");
                	continue;
                }

                System.out.println("\n");
                switch(movesChoice) {
                case 1:
                
                case 2: usesMoves(pokemonChoice.getMove()[movesChoice - 1], pokemonEnemy, pokemonChoice, weather); break;
                
                case 3: Captured = capturePokemon(pokemonEnemy, player, weather);
                	
                }
                
                System.out.println();
                
                
                //check if the enemy dies
                if (pokemonEnemy.isDown()) {
                    System.out.println(pokemonEnemy.getName() + " has been defeated!");
                    enemyPokemonAlive = false;
                    win = true;
                    break;
                } else if (Captured) {
                	System.out.println(pokemonEnemy.getName() + " has been captured!");
                    enemyPokemonAlive = false;
                    win = true;
                    break;
                } else {
                	System.out.printf("[%s HP : %.1f/%.1f ]\n", pokemonEnemy.getName(), pokemonEnemy.getCurrentHealth(), pokemonEnemy.getFullHealth());
                }
                
                System.out.println("\n");
                int randomMoves = random.nextInt(2);
                usesMoves(pokemonEnemy.getMove()[randomMoves], pokemonChoice, pokemonEnemy, weather);

                //check if own pokemon died, 
                if (pokemonChoice.isDown()) {
                    System.out.println("Your Pokemon " + pokemonChoice.getName() + " has been defeated!");
                    pokemonChoiceAlive = false;
                    
                    
                    
                } else {
                    System.out.printf("[%s HP : %.1f/%.1f ]\n", pokemonChoice.getName(), pokemonChoice.getCurrentHealth(), pokemonChoice.getFullHealth());
                }

                round++;
            }
            
            
            
        }
        
        if (win) {
        	pokemonChoice.increaseEXP(5 * pokemonEnemy.getLevel()); //based on leveling scheme
        }
        
    }

    private static int usesMoves(Moves move, Pokemon enemy, Pokemon damagedealer, Weather weather) {

        Random random = new Random();

        String[] damageDealText = { "Super Effective!", "Ouch!", "Critical Hit!", "It's not very effective...", "" };

        System.out.println(damagedealer.getName() + " used " + move.getMovesName() + "!");

        int damageDeal;
        boolean containAdvantage = false;
        boolean containDisadvantage = false;

        for (String strength : damagedealer.getStrength()) {
            if (enemy.getType().contains(strength)) {
                containAdvantage = true;
                break;
            }
        }

        for (String weakness : damagedealer.getWeakness()) {
            if (enemy.getType().contains(weakness)) {
                containDisadvantage = true;
                break;
            }
        }

        if (containAdvantage) {
            damageDeal = (int) (move.getDamage() * 1.2);
            System.out.println(damageDealText[0]);
        } else if (containDisadvantage) {
            damageDeal = (int) (move.getDamage() * 0.8);
            System.out.println(damageDealText[3]);
        } else {
            damageDeal = move.getDamage();
        }

        //weather effect ??
        switch(weather.getCurrentWeather()) {
            case SUNNY:
                if (damagedealer.getType().contains("fire")) {
                    damageDeal = (int) (damageDeal*1.5);
                } else if (damagedealer.getType().contains("water")) {
                    damageDeal = (int) (damageDeal*0.5);
                }
                break;

            case RAINY:
                if (damagedealer.getType().contains("water")) {
                    damageDeal = (int) (damageDeal*1.5);
                } else if (damagedealer.getType().contains("fire")) {
                    damageDeal = (int) (damageDeal*0.5);
                }
                break;

            case WINDY:
                if (enemy.getType().contains("flying") && (damagedealer.getType().contains("electric") || damagedealer.getType().contains("ice") || damagedealer.getType().contains("rock"))) {
                    damageDeal = (int) (damageDeal*1.5);
                }
                break;

            case NONE:
                break;
        }

        if (random.nextDouble() < 0.0625) {
            damageDeal *= 2;
            System.out.println("Critical Hit!");
        }

        enemy.setCurrentHealth(enemy.getCurrentHealth() - damageDeal);

        return damageDeal;
    }

    
    
    public static boolean capturePokemon(Pokemon wildPokemon, Player player, Weather weather) {
        double captureRate = 0.5;
        
        double healthFactor = wildPokemon.getCurrentHealth() / wildPokemon.getFullHealth(); // health percentage
        captureRate += (1 - healthFactor) * 0.2; // increase as health decerease;

        // weather effect
        switch (weather.getCurrentWeather()) {
            case SUNNY:
                if (wildPokemon.getType().equals("fire")) {
                    captureRate += 0.1; // high rate fire type
                } else if (wildPokemon.getType().equals("water")) {
                    captureRate -= 0.1; // low rate water type
                }
                break;
            case RAINY:
                if (wildPokemon.getType().equals("water")) {
                    captureRate += 0.1; // high rate water type
                } else if (wildPokemon.getType().equals("fire")) {
                    captureRate -= 0.1; // low rate fire type
                }
                break;
            case WINDY:
                if (wildPokemon.getType().equals("flying")) {
                    captureRate += 0.1; // high rate flying type
                }
                break;
            case NONE:
                break;
        }

        captureRate = Math.min(captureRate, 1.0); // incase captureRate exceed 1;
        
        Random random = new Random();
        
        boolean captureSuccessful = random.nextDouble() < captureRate;
        
        if (captureSuccessful) {
            System.out.println("You captured " + wildPokemon.getName() + "!!\n");
            player.addPokemon(wildPokemon);
            
            return true;
        } else {
            System.out.println(wildPokemon.getName() + " broke free!!!\n");
            return false;
        }
    }

}



