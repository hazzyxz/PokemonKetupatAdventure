import java.util.ArrayList;

public class GymLeader {
		
	private String Name;
	private ArrayList<Pokemon> pokemonList;
	
	
	//constructor
	public GymLeader(String name, Pokemon[] pokemon) {
		this.Name = name;
		
		for (int i = 0; i < pokemon.length; i++) {
			pokemonList.add(pokemon[i]);
		}
		
	}
	
	//getter
	public String getName() {
		return Name;
	}
	public ArrayList<Pokemon> getPokemonList() {
		return pokemonList;
	}

	
	
}
