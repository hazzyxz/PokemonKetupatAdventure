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
	
	
}
