import java.util.ArrayList;

public class GymLeader {
		
	//----------------Attribute----------------------------//
	
	private String Name;
	private ArrayList<Pokemon> pokemonList;
	
	//----------------Attribute----------------------------//
	
	
	//----------------constructor--------------------------//
	
	public GymLeader(String name, Pokemon[] pokemon) {
		this.Name = name;
		pokemonList = new ArrayList<Pokemon>();
		
		for (int i = 0; i < pokemon.length; i++) {
			pokemonList.add(pokemon[i]);
		}
		
	}
	//----------------constructor--------------------------//
	
	//-------------------setter and getter-----------------------//
	
	public String getName() {
		return Name;
	}
	public ArrayList<Pokemon> getPokemonList() {
		return pokemonList;
	}

	//-------------------setter and getter-----------------------//
	
}
