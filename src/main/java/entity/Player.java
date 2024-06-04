package entity;

import backend.Main;
import backend.Pokemon;
import backend.Potion;
import main.GamePanel;
import main.KeyHandler;

//import java.awt.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Player implements Entity, Serializable {
	
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
	private ArrayList<Potion> potion; // pls change appropriately
	public int Money;
	private LinkedList<Pokemon> DownedPokemonList;
	private final int FULLPOKEMONLISTSIZE = 6;
	private ArrayList<Pokemon> bagPokemonList; // for excess pokemon
	
	//----------------Attribute----------------------------//
	
	//--------------------private method-------------------------//
	
	private boolean pokemonIsFull() {
		return (pokemonList.size() >= FULLPOKEMONLISTSIZE);
	}
	
	//--------------------private method-------------------------//
	

	//----------------constructor--------------------------//
	
	public Player() {
		pokemonList = new ArrayList<Pokemon>();
		this.Money = 100;
		DownedPokemonList = new LinkedList<Pokemon>();
		this.Badges = new Stack<String>();
		this.potion = new ArrayList<>();
		potion.add(new Potion(0));
		this.bagPokemonList = new ArrayList<Pokemon>();
	}
	
	//----------------constructor--------------------------//
	
	//-------------------setter and getter-----------------------//
	
	public String getName() {
		return Name;
	}
	public Stack<String> getBadges() {
		return Badges;
	}
	public ArrayList getPotion() {
		return potion;
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
        
        public void addPotion(int x){
            switch(x){
                case 0:
                    potion.add(new Potion(0));
                    break;
                case 1:
                    potion.add(new Potion(1));
                    break;
                case 2:
                    potion.add(new Potion(2));
                    break;
                default:
                    return;
            }
        }
	
        public int numOfSPotion(){
            int count=0;
            for(Potion x:potion){
                if(x.getSmall()==true)
                    count++;
            }
            return count;
        }
        public int numOfMPotion(){
            int count=0;
            for(Potion x:potion){
                if(x.getMedium()==true)
                    count++;
            }
            return count;
        }
        public int numOfLPotion(){
            int count=0;
            for(Potion x:potion){
                if(x.getLarge()==true)
                    count++;
            }
            return count;
        }
	//-------------------setter and getter-----------------------//
	
	//--------------------public method----------------------------//

	public void reviveAndHealFull() {
		for (Pokemon x : DownedPokemonList) {
			pokemonList.add(x);
			DownedPokemonList.remove(x);
		}
		for (Pokemon x : pokemonList) {
			x.healFull();
		}
	}
	
	public void healPokemonFull() {
		for (Pokemon x: pokemonList) {
			x.healFull();
			System.out.printf("%s [HP %.0f/%.0f]\n", x.getName(),x.getCurrentHealth(),x.getFullHealth());
		}
		System.out.println();
		
	}
        
        public void potionHealSmall(Pokemon poke){
            for(Potion x:potion){
                if(x.getSmall()==true){
                    poke.heal(x.heal());
					potion.remove(x);
                    return;
                }
            }
            System.out.println("No small potion available...");
        }
        
        public void potionHealMedium(Pokemon poke){
            for(Potion x:potion){
                if(x.getMedium()==true){
                    poke.heal(x.heal());
					potion.remove(x);
                    return;
                }
            }
            System.out.println("No medium potion available...");
        }
        
        public void potionHealLarge(Pokemon poke){
            for(Potion x:potion){
                if(x.getLarge()==true){
                    poke.heal(x.heal());
					potion.remove(x);
                    return;
                }
            }
            System.out.println("No large potion available...");
        }
	
	
	public boolean addPokemon(Pokemon pokemon) { //return true if successful, false if vice versa
		if (pokemonList.size() >= 6) {
			System.out.println("Exceed Pokemon Limit");
			bagPokemonList.add(pokemon);
			return true;
		} else {
			pokemonList.add(pokemon);
			return true; }
	}

	public void showBagPokemon() {
		System.out.println("Your Pokemon in  bag: ");

		for (int i = 0; i < bagPokemonList.size(); i++) {

			Pokemon pokemon = bagPokemonList.get(i);
			System.out.println(pokemon.getName() + " - level [" + bagPokemonList.get(i).getLevel() + "]");


			System.out.println("Type: ");

			//what the hell, maybe change later,
			switch (pokemon.getType().size()) {
				case 1:
					System.out.println(pokemon.getType().get(0));
					break;
				case 2:
					System.out.println(pokemon.getType().get(0) + "/" + pokemon.getType().get(1));
			}
			System.out.println("HP: " + pokemon.getCurrentHealth() + " / " + pokemon.getFullHealth());
			System.out.println("EXP: " + pokemon.getExp() + "/" + pokemon.getMaxExp());

			System.out.println("Moves: ");
			System.out.println("- " + pokemon.getMove()[0].getMovesName() + " [" + pokemon.getMove()[0].getDamage() + "]");
			System.out.println("- " + pokemon.getMove()[1].getMovesName() + " [" + pokemon.getMove()[1].getDamage() + "]");

			System.out.println("Strong against: ");
			String[] strong = pokemon.getStrength().toArray(new String[pokemon.getStrength().size()]);
			for (String StrongAgainst : strong) {
				System.out.println("- " + StrongAgainst);
			}

			System.out.println("Weak Against: ");
			String[] weak = pokemon.getWeakness().toArray(new String[pokemon.getWeakness().size()]);
			for (String weakAgainst : weak) {
				System.out.println("- " + weakAgainst);
			}

			System.out.println();
		}
	}

	// replace pokemon from bag to active
	public boolean movePokemonToActive(int index) {
		if (index >= 0 && index < bagPokemonList.size() && pokemonList.size() < 6) {
			Pokemon pokemon = bagPokemonList.remove(index);
			pokemonList.add(pokemon);
			return true;
		}
		return false;
	}

	// replace pokemon from active to bag
	public boolean movePokemonToBag(int index) {
		if (index >= 0 && index < pokemonList.size()) {
			Pokemon pokemon = pokemonList.remove(index);
			bagPokemonList.add(pokemon);
			return true;
		}
		return false;
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

		Scanner scanner = new Scanner(System.in);

		System.out.println("Your Pokemon: ");
		
		for (int i = 0; i < pokemonList.size(); i++) {
			
			Pokemon pokemon = pokemonList.get(i);
			System.out.println(pokemon.getName() + " - level [" + pokemonList.get(i).getLevel() + "]" );
			
			
			
			System.out.println("Type: ");
			
			//what the hell, maybe change later,
			switch(pokemon.getType().size()) {
			case 1:
				System.out.println(pokemon.getType().get(0));
				break;
			case 2:
				System.out.println(pokemon.getType().get(0) + "/" + pokemon.getType().get(1));
			}
			System.out.println("HP: " + pokemon.getCurrentHealth() + " / " + pokemon.getFullHealth());
			System.out.println("EXP: " + pokemon.getExp() + "/" + pokemon.getMaxExp());
			
			System.out.println("Moves: " );
			System.out.println("- " + pokemon.getMove()[0].getMovesName() + " [" + pokemon.getMove()[0].getDamage() + "]");
			System.out.println("- " + pokemon.getMove()[1].getMovesName() + " [" + pokemon.getMove()[1].getDamage() + "]");
			
			System.out.println("Strong against: ");
			String[] strong = pokemon.getStrength().toArray(new String[pokemon.getStrength().size()]);
			for (String StrongAgainst: strong) {
				System.out.println("- " + StrongAgainst);
			}
			
			System.out.println("Weak Against: ");
			String[] weak = pokemon.getWeakness().toArray(new String[pokemon.getWeakness().size()]);
			for (String weakAgainst: weak) {
				System.out.println("- " + weakAgainst);
			}

			if (pokemon.getLvlEvolve() != 0 && pokemon.getLevel() >= pokemon.getLvlEvolve()&& pokemon.getWeather().getCurrentWeather().equals(Main.currentWeather.getCurrentWeather())) {
				System.out.println("This Pokémon is eligible for evolution!");
				System.out.println("Do you want to evolve " + pokemon.getName() + "? (yes/no)");
				String choice = scanner.nextLine();
				if (choice.equalsIgnoreCase("yes")) {
					pokemon.evolve();
					System.out.println(pokemon.getName() + " has evolved!");
				}
			}
			
			System.out.println("\n");
			
		}
		
		
		
	}
	
	public void RevivePokemon() {
		
		Scanner scanner = new Scanner(System.in);
		
		if (pokemonIsFull()) {
			System.out.println("Pokemon already reached its limit!!\n");
			return;
		}
		
		while (true) {
			System.out.println("Choose which pokemon to revive:");
			int i = 1;
			for(Pokemon X : DownedPokemonList) {
				System.out.println( i++ + "- " + X.getName() );
			}
			
			int choice = scanner.nextInt();
			
			if (choice <= 0 || choice > DownedPokemonList.size()) {
				System.out.println("Invalid Choice\n");
				continue;
			}
			
			Pokemon chosenPokemon = DownedPokemonList.remove(choice - 1);
			
			chosenPokemon.revive();
			pokemonList.add(chosenPokemon);
			System.out.println("Pokemon successfuly revived!\n");
			break;
			
			
		}
		
		
		
		
		
		
	}


	public void setName(String string) {
		this.Name = string;
	}

	public void setStarterPokemon(Pokemon pokemon) {
		addPokemon(pokemon);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics2D g2) {

	}
}
