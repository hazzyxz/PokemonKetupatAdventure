import java.util.ArrayList;
import java.util.Scanner;

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

	//----------------Attribute----------------------------//
	
	private String Name;
	private boolean Hospital;
	private GymLeader gymLeader;
	private ArrayList<City> nextCity;
	private ArrayList<Pokemon> wildPokemon;
	
	//----------------Attribute----------------------------//
	
	//----------------constructor--------------------------//
	
	public City(String name, GymLeader gymLeader, City[] adjacentCities, Pokemon[] WildPokemon, boolean isHospitalExist) {
		this.Name = name;
		this.gymLeader = gymLeader;
		
		for (City x: adjacentCities)
			this.nextCity.add(x);
		
		for (Pokemon pokemon: WildPokemon)
			this.wildPokemon.add(pokemon);
		
		this.Hospital = isHospitalExist;
		
	}
	
	//----------------constructor--------------------------//
	
	//-------------------setter and getter-----------------------//
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
	
	//-------------------setter and getter-----------------------//
	
	//---------------------public method------------------------//
	
	public void pokemaze() {
		//TO-DO create a maze
	}
	
	public void RivalsRace() {
		//TO-DO create rivals race
		
	}
	
	public void SafariZone() {
		//TO-DO create Safari zone
		
	}
	
	public void PokemonCenter(Player player) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 3) {
			System.out.println("""
					You entered pokemon Center:
					1. Heal pokemon
					2. Revive pokemon
					3. Exit
					""");
			
			choice = scanner.nextInt();
			
			switch (choice){
			case 1: player.healPokemonFull(); break; 
				
			case 2: player.revivePokemon(); break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
			
			scanner.close();
			
		}
		
		
	}
	
	
}
