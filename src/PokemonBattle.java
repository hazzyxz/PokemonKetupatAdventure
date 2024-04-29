import java.util.Random;
import java.util.Scanner;


public class PokemonBattle {
	
	
	
	
	public void EnterBattle(GymLeader gymLeader, Player player) {
		
		Pokemon[] pokemontoBattle = (Pokemon[]) gymLeader.getPokemonList().toArray();
		
		System.out.println("You Are about to challenge Gym Leader " + gymLeader.getName() + "!\n "
						 + "Prepare yourself for an intenst battle!");
		
		System.out.println("Your Pokemon: ");
		Pokemon[] yourPokemon = (Pokemon[]) player.getPokemonList().toArray();
		
		for (Pokemon x: yourPokemon)
			System.out.println(" - " + x.getName() + " - level " + x.getLevel());
		
		System.out.println("Battle Start");
		
		for (Pokemon pokemon: pokemontoBattle) {
			EnterBattle(pokemon, player);
		}
		
	}
	
	public static void EnterBattle(Pokemon pokemonEnemy, Player player) {
		
		String[] damageTakenText = { "takes some damage.", "took heavy damage." };
		
		
		Scanner inputScanner = new Scanner(System.in);
		Random random = new Random();
		
		boolean enemyPokemonAlive = true;
		boolean FirstRound = true;
		
		while (enemyPokemonAlive) {
			
			
			if (FirstRound)
				System.out.println("Choose your Pokemon: ");
			else {
				System.out.println("Choose your next Pokemon: ");
			}
			
			for (Pokemon x: player.getPokemonList())
				System.out.println(" - " + x.getName() + " - level " + x.getLevel());
			
			int choice = inputScanner.nextInt();
			boolean pokemonChoiceAlive = true;
				
			while (pokemonChoiceAlive) {
				int round = 1;
				Pokemon pokemonChoice = player.getPokemonList().get(choice-1);
				
				//player Start first
				System.out.println("Round " + round);
				System.out.printf("\nChoose Moves:\n1- %s\n2- %s\n", pokemonChoice.getMove()[0],pokemonChoice.getMove()[1]);
				
				choice = inputScanner.nextInt();
				
				usesMoves(pokemonChoice.getMove()[choice-1], pokemonEnemy, pokemonChoice);
				
				if(pokemonEnemy.isDown()) {
					System.out.println(pokemonEnemy.getName() + " has been defeated!");
					enemyPokemonAlive = false;
					break;
				}
				
				//show health
				System.out.printf("[%s HP : %.1f/%.1f ]",pokemonEnemy.getName(), pokemonEnemy.getCurrentHealth(), pokemonEnemy.getFullHealth());
				
				
				//enemy turn
				//randomise moved
				int randomMoves = random.nextInt(2) + 1; 
				usesMoves(pokemonEnemy.getMove()[randomMoves], pokemonChoice, pokemonEnemy);
				
				
				//check health
				if (pokemonChoice.isDown()) {
					
					System.out.println("Your Pokemon defeated!");
					
					pokemonChoiceAlive = false;
					break;
				}
				
				//show health
				System.out.printf("[%s HP : %.1f/%.1f ]",pokemonChoice.getName(), pokemonChoice.getCurrentHealth(), pokemonChoice.getFullHealth());
				
				
				//next round
				round++;
				
			}	if (enemyPokemonAlive) { //if enemy is still alive, go back into the loop and choose next pokemon
				
				
			}	else {	//if enemy defeated, display congrats message and get out of loop
				
				
				
			}
				
			
			
			
			
			
			
		}
		
		inputScanner.close();
	
	}
	
	private static int usesMoves(Moves move, Pokemon enemy, Pokemon damagedealer) {
		
		Random random = new Random();
		
		String[] damageDealText = { "Super Effective!","Ouch!", "Saket cuk", "Critical Hit!", "It's is not very effective...", 
									"" };
		
		System.out.println(damagedealer.getName() + " used " + move.getMovesName() + "!");
		
		int damageDeal;
		boolean containAdvantage = false;
		boolean containDisadvantage = false;
		
		//check if have advantage
		for (String Weakness: damagedealer.getStrength()) {
			if(enemy.getType().contains(Weakness)) {
				containAdvantage = true;
				break;
			}
		}
		
		//check if have weakness
		for (String Weakness: damagedealer.getWeakness()) {
			if(enemy.getType().contains(Weakness)) {
				containDisadvantage = true;
				break;
			}
		}
		
		
		//calculate damage based on advantage or disadvantage
		//20% bonus if strong against, 20% damage reduction if weak against
		if (containAdvantage) {
			
			damageDeal = (int) ((int) move.getDamage() * (120/100.0)); //120% damage dealt
			System.out.println(damageDealText[random.nextInt(3)]);
			
		} else if (containDisadvantage) {
			
			damageDeal = (int) ((int) move.getDamage() * (80/100.0)); //80% damage dealt
			System.out.println(damageDealText[random.nextInt(2)] + 4);
		
		} else {
		
			damageDeal = move.getDamage();
		
		}
		
		//crit attack with 6.25%
		//generate number between 0 - 1, if number less than percentage
		//execute crit attack
		if (random.nextDouble() < 0.0625){
            damageDeal*=2;
            System.out.println("Crit Attack");
        }
		
		//tolak HP based on damage calculated
		enemy.setCurrentHealth(enemy.getCurrentHealth() - damageDeal);
		
		
		//return damage calculated
		return damageDeal;
	}
	
	
	
}







