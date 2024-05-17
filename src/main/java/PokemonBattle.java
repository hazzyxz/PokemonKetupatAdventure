import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {

    public static void EnterBattle(GymLeader gymLeader, Player player) {

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
            EnterBattle(pokemon, player);

            // Check if all player's Pokemon are defeated
            if (player.getPokemonList().stream().allMatch(Pokemon::isDown)) {
                System.out.println("All of your pokemon have been defeated. You lost the battle!");
                return;
            }
        }

        System.out.println("You have defeated all of Gym Leader " + gymLeader.getName() + "'s Pokemon!");
        player.addBadges();
    }

    public static void EnterBattle(Pokemon pokemonEnemy, Player player) {

        Scanner inputScanner = new Scanner(System.in);
        Random random = new Random();

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

            Pokemon pokemonChoice = player.getPokemonList().get(choice);
            boolean pokemonChoiceAlive = true;
            int round = 1;
            
            
            //Enter the battle
            while (pokemonEnemy.getCurrentHealth() > 0 && pokemonChoiceAlive) {

                System.out.println("Round " + round);
                System.out.printf("\nChoose Moves:\n1- %s\n2- %s\n", pokemonChoice.getMove()[0].getMovesName(), pokemonChoice.getMove()[1].getMovesName());

                int movesChoice = inputScanner.nextInt();
                
                //if input incorrect choice will continue the loop
                if (movesChoice < 0 || movesChoice > 2) {
                	System.out.println("Invalid moves");
                	continue;
                }

                System.out.println("\n");
                usesMoves(pokemonChoice.getMove()[movesChoice - 1], pokemonEnemy, pokemonChoice);

                System.out.printf("[%s HP : %.1f/%.1f ]\n", pokemonEnemy.getName(), pokemonEnemy.getCurrentHealth(), pokemonEnemy.getFullHealth());
                
                //check if the enemy dies
                if (pokemonEnemy.isDown()) {
                    System.out.println(pokemonEnemy.getName() + " has been defeated!");
                    enemyPokemonAlive = false;
                    break;
                }
                
                System.out.println("\n");
                int randomMoves = random.nextInt(2);
                usesMoves(pokemonEnemy.getMove()[randomMoves], pokemonChoice, pokemonEnemy);

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
    }

    private static int usesMoves(Moves move, Pokemon enemy, Pokemon damagedealer) {

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

        if (random.nextDouble() < 0.0625) {
            damageDeal *= 2;
            System.out.println("Critical Hit!");
        }

        enemy.setCurrentHealth(enemy.getCurrentHealth() - damageDeal);

        return damageDeal;
    }
}
