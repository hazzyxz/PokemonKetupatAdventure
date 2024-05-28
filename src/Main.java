
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
		Player player = new Player("Syahir", PokemonFactory.createPokemon("Charizard").setLevel(15));

		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(10));
		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(11));
		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(12));
		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(1));
		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(13));
		player.addPokemon(PokemonFactory.createPokemon("Meowth").setLevel(1));
		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(12));
		player.addPokemon(PokemonFactory.createPokemon("Bulbasaur").setLevel(11));

		player.ShowMyPokemon();


		player.movePokemonToBag(2);
		player.showBagPokemon();
//
//		PokemonBattle.EnterBattle(PokemonFactory.createPokemon("Jigglypuff").setLevel(50), player, true);
		
		//----------test je ni-------------------------//

		//----------test gak-------------------------//

//		player.RevivePokemon();
//		player.ShowMyPokemon();

		//----------test gak-------------------------//
                
                //----------test je ni boi-------------------------//
                
//                Pokemon pokemon = PokemonFactory.createPokemon("Bulbasaur");
//                System.out.println(pokemon.getName());
//                System.out.println(pokemon.getFullHealth());
//                System.out.println(pokemon.getType());
//                System.out.println(pokemon.getLevel());
//                System.out.println(pokemon.getStrength());
//                System.out.println(pokemon.getWeakness());
//                System.out.println(pokemon.getMoveNames());
//
//                pokemon.setLevel(20);
//                pokemon.evolve();
//
//                System.out.println(pokemon.getName());
//                System.out.println(pokemon.getFullHealth());
//                System.out.println(pokemon.getType());
//                System.out.println(pokemon.getLevel());
//                System.out.println(pokemon.getStrength());
//                System.out.println(pokemon.getWeakness());
//                System.out.println(pokemon.getMoveNames());
//

//        SafariZone.play();
                
                //----------test je ni boi-------------------------//

	}

}