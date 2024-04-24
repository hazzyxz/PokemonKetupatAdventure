import java.util.ArrayList;

public class GymLeader {
		
	private String Name;
	private ArrayList<Pokemon> pokemonList;
	
	
	//constructor
	public GymLeader(String name, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3) {
		this.Name = name;
		this.pokemonList.add(pokemon1);
		this.pokemonList.add(pokemon2);
		this.pokemonList.add(pokemon3);
		
	}
	
	
	//getter
	public String getName() {
		return Name;
	}
	public ArrayList<Pokemon> getPokemonList() {
		return pokemonList;
	}

	
	
}
