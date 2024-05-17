import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Player {
	
	/*
	  player attribute:

		-name
		-pokemon list
		-location on map
		-badges
		-player option
		-pokeball amount in pocket, // how to get pokeball meh, create money?? can use money also to revive and buy items
		-save and exit

	 */
	
	//----------------Attribute----------------------------//
	
	private String Name;
	private ArrayList<Pokemon> pokemonList;
	private String Location;
	private Stack<String> Badges;
	private int Items; // pls change appropriately
	private double Money;
	private LinkedList<Pokemon> DownedPokemonList;
	private final int FULLPOKEMONLISTSIZE = 6;
	
	//----------------Attribute----------------------------//
	
	//--------------------private method-------------------------//
	
	private boolean pokemonIsFull() {
		return (pokemonList.size() >= FULLPOKEMONLISTSIZE);
	}
	
	//--------------------private method-------------------------//
	
	
	//----------------constructor--------------------------//
	
	public Player(String name, Pokemon StartingPokemon) {
		pokemonList = new ArrayList<Pokemon>();
		this.Name = name;
		this.pokemonList.add(StartingPokemon);
		this.Money = 0;
		DownedPokemonList = new LinkedList<Pokemon>();
		this.Badges = new Stack<String>();
	}
	
	//----------------constructor--------------------------//
	
	//-------------------setter and getter-----------------------//
	
	public String getName() {
		return Name;
	}
	public Stack<String> getBadges() {
		return Badges;
	}
	public int getItems() {
		return Items;
	}
	public String getLocation() {
		return Location;
	}
	public double getMoney() {
		return Money;
	}
	public void addBadges(String GymLeaderName) {
		
		Badges.push(GymLeaderName);
		
		if(Badges.size() > 6) {
			System.out.println("You Win the game");
		}
		
	}
	
	//-------------------setter and getter-----------------------//
	
	//--------------------public method----------------------------//
	
	public void healPokemonFull() {
		for (Pokemon x: pokemonList) {
			x.healFull();
			System.out.printf("%s [HP %.0f/%.0f]\n", x.getName(),x.getCurrentHealth(),x.getFullHealth());
		}
		System.out.println();
		
	}
	
    public void revivePokemon() {
        Scanner scanner = new Scanner(System.in);

        if (pokemonIsFull()) { // Don't allow reviving a Pokémon if the player already has 6
            System.out.println("You already have the maximum number of Pokémon.");
            scanner.close();
            return;
        }

        while (true) {
            try {
                System.out.println("Choose which Pokémon to revive: ");
                int i = 1;
                for (Pokemon pokemon : DownedPokemonList) {
                    System.out.println(i + "- " + pokemon.getName());
                    i++;
                }

                // Check if the next input is an integer
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                    continue;
                }

                int choice = scanner.nextInt();
                // Ensure the chosen index is within the bounds of the list
                if (choice < 1 || choice > DownedPokemonList.size()) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + DownedPokemonList.size());
                    continue;
                }

                var pokemon = DownedPokemonList.get(choice - 1);
                if (addPokemon(pokemon)) {
                    pokemon.revive();
                    System.out.println("Revive successful");
                } else {
                    System.out.println("Failed to revive.");
                }
                break;

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                break;
            }
        }

        scanner.close();
    }
	
	public boolean addPokemon(Pokemon pokemon) { //return true if successful, false if vice versa
		if (pokemonList.size() > 6) {
			System.out.println("Exceed Pokemon Limit");
			return false;
		} else { pokemonList.add(pokemon); return true; }
	}
	
	public ArrayList<Pokemon> getPokemonList() {
		//----------check which alive---------------------
		CheckPokemonAlive(); //move to create a function
		//----------check which alive---------------------
		return pokemonList;
	}
	
	private void CheckPokemonAlive() {
		for (int i = 0; i < pokemonList.size(); i++)
		{
			if(pokemonList.get(i).isDown()) {
			DownedPokemonList.add(pokemonList.remove(i));
			}
		}
		
	}
	
	public void ShowMyPokemon() {
		
		System.out.println("Your Pokemon: ");
		
		for (int i = 0; i < pokemonList.size(); i++) {
			
			Pokemon pokemon = pokemonList.get(i);
			System.out.println(pokemon.getName() + " - level [" + pokemonList.get(i).getLevel() + "]" );
			
			
			
			System.out.println("Type: ");
			
			//what the hell, maybe change later,
			switch(pokemon.getType().size()) {
			case 1:
				System.out.print(pokemon.getType().get(0));
				break;
			case 2:
				System.out.print(pokemon.getType().get(0) + "/" + pokemon.getType().get(1));
			}
			System.out.println("HP: " + pokemon.getCurrentHealth() + " / " + pokemon.getFullHealth());
			System.out.println("EXP: " + pokemon.getExp());
			
			System.out.println("Moves: " );
			System.out.println("- " + pokemon.getMove()[0].getMovesName() + " [" + pokemon.getMove()[0].getDamage() + "]");
			System.out.println("- " + pokemon.getMove()[1].getMovesName() + " [" + pokemon.getMove()[1].getDamage() + "]");
			
			System.out.println("Strong against: ");
			String[] strong = (String[]) pokemon.getStrength().toArray();
			for (String StrongAgainst: strong) {
				System.out.println("- " + StrongAgainst);
			}
			
			System.out.println("Weak Against: ");
			String[] weak = (String[]) pokemon.getWeakness().toArray();
			for (String weakAgainst: weak) {
				System.out.println("- " + weakAgainst);
			}
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
}
