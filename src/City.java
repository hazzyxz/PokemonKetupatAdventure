import java.util.ArrayList;

public class City {
	/*
	- gym leader
	- adjacent town, sbb nak gerak
	- list wild pokemon dkt area tu
	- hospital ( heal pokemon ) //not all city

	NOTES: some town has special attribute

	such as, 

	Pallet town - doesnt have gym

	Lavender town - have pokemaze

	Saffron city - main aci ligan (Rival's Race)

	Fuchsia City - Safari Zone
	
`	*/

	private String Name;
	private boolean Hospital;
	private GymLeader gymLeader;
	private ArrayList<City> nextCity;
	private ArrayList<Pokemon> wildPokemon;
	
	public City(String name, GymLeader gymLeader, City[] adjacentCities, Pokemon[] WildPokemon, boolean isHospitalExist) {
		this.Name = name;
		this.gymLeader = gymLeader;
		
		for (City x: adjacentCities)
			this.nextCity.add(x);
		
		for (Pokemon pokemon: WildPokemon)
			this.wildPokemon.add(pokemon);
		
		this.Hospital = isHospitalExist;
		
	}
	
	
	
	//setter and getter
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public GymLeader getGymLeader() {
		return gymLeader;
	}
	public void setGymLeader(GymLeader gymLeader) {
		this.gymLeader = gymLeader;
	}
	
	public ArrayList<City> getNextCity() {
		return nextCity;
	}
	
	public ArrayList<Pokemon> getWildPokemon() {
		return wildPokemon;
	}
	
	
}
