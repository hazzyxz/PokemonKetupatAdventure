import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Pokemon> pokedex;
    
    public Pokedex() {
        this.pokedex = new ArrayList();
        
        initializePokedex();
    }
    
    private void initializePokedex() {
       pokedex.add(PokemonFactory.createPokemon("Bulbasaur"));
       pokedex.add(PokemonFactory.createPokemon("Ivysaur"));
       pokedex.add(PokemonFactory.createPokemon("Venusaur"));
       pokedex.add(PokemonFactory.createPokemon("Charmander"));
       pokedex.add(PokemonFactory.createPokemon("Charmeleon"));
       pokedex.add(PokemonFactory.createPokemon("Charizard"));
       pokedex.add(PokemonFactory.createPokemon("Squirtle"));
       pokedex.add(PokemonFactory.createPokemon("Wartorle"));
       pokedex.add(PokemonFactory.createPokemon("Blastoise"));
       pokedex.add(PokemonFactory.createPokemon("Caterpie"));
       pokedex.add(PokemonFactory.createPokemon("Metapod"));
       pokedex.add(PokemonFactory.createPokemon("Butterfree"));
    }
}
