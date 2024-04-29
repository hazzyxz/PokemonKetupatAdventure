import java.util.ArrayList;


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
	
	private String Name;
	private ArrayList<Pokemon> pokemonList;
	private String Location;
	private int Badges = 0;
	private int Items; // pls change appropriately
	private double Money;
	
	public Player(String name, Pokemon StartingPokemon) {
		this.Name = name;
		this.pokemonList.add(StartingPokemon);
		this.Money = 0;
	}
	
	//setter and getter
	public String getName() {
		return Name;
	}
	public int getBadges() {
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
	public ArrayList<Pokemon> getPokemonList() {
		return pokemonList;
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
