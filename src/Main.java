
public class Main {

	public static void main(String[] args) {
		
		
		
		//----------test je ni-------------------------//
		
		
//		GymLeader bardock = new GymLeader("Bardock", new Pokemon[] {
//			PokemonFactory.createPokemon("Charizard").setLevel(5),
//			PokemonFactory.createPokemon("Jigglypuff").setLevel(60)
//
//		});
//
//
//		Player player = new Player("Syahir", PokemonFactory.createPokemon("Charizard").setLevel(15));
//
//		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(100));
//
//		PokemonBattle.EnterBattle(PokemonFactory.createPokemon("Jigglypuff").setLevel(50), player, true);
		
		//----------test je ni-------------------------//

		//----------test gak-------------------------//

//		player.RevivePokemon();
//		player.ShowMyPokemon();

		//----------test gak-------------------------//
                
                //----------test je ni boi-------------------------//
                
                Pokemon pokemon = PokemonFactory.createPokemon("Bulbasaur");
                System.out.println(pokemon.getName());
                System.out.println(pokemon.getFullHealth());
                System.out.println(pokemon.getType());
                System.out.println(pokemon.getLevel());
                System.out.println(pokemon.getStrength());
                System.out.println(pokemon.getWeakness());
                System.out.println(pokemon.getMoveNames());
                
                pokemon.setLevel(20);
                pokemon.evolve();

                System.out.println(pokemon.getName());
                System.out.println(pokemon.getFullHealth());
                System.out.println(pokemon.getType());
                System.out.println(pokemon.getLevel());
                System.out.println(pokemon.getStrength());
                System.out.println(pokemon.getWeakness());
                System.out.println(pokemon.getMoveNames());
                
                
                //----------test je ni boi-------------------------//

	}

}