package backend;

public class GymLeaderFactory {
    
    public static GymLeader createGymLeader(String name, Pokemon[] pokemon) {
        return new GymLeader(name, pokemon);
    }
    
    //pewter city
    public static GymLeader leaderBrock() {
        Pokemon venusaur = PokemonFactory.createPokemon("Venusaur");
        Pokemon beedrill = PokemonFactory.createPokemon("Beedrill");
        Pokemon raticate = PokemonFactory.createPokemon("Raticate");
        Pokemon vulpix = PokemonFactory.createPokemon("Vulpix");
        Pokemon pidgeot = PokemonFactory.createPokemon("Pidgeot");
        Pokemon arbok = PokemonFactory.createPokemon("Arbok");
        
        venusaur.setLevel(15);
        beedrill.setLevel(15);
        raticate.setLevel(15);
        vulpix.setLevel(15);
        pidgeot.setLevel(15);
        arbok.setLevel(15);
        
        Pokemon[] brockPokemon = {venusaur, beedrill, raticate, vulpix, pidgeot, arbok};
        
        return new GymLeader("Brock", brockPokemon);
    }
    
    //cerulean city
    public static GymLeader leaderMisty() {
        Pokemon ninetales = PokemonFactory.createPokemon("Ninetales");
        Pokemon golbat = PokemonFactory.createPokemon("Golbat");
        Pokemon psyduck = PokemonFactory.createPokemon("Psyduck");
        Pokemon blastoise = PokemonFactory.createPokemon("Blastoise");
        Pokemon venonat = PokemonFactory.createPokemon("Venonat");
        Pokemon charmeleon = PokemonFactory.createPokemon("Charmeleon");
        
        ninetales.setLevel(25);
        golbat.setLevel(25);
        psyduck.setLevel(25);
        blastoise.setLevel(25);
        venonat.setLevel(25);
        charmeleon.setLevel(25);
        
        Pokemon[] mistyPokemon = {ninetales, golbat, psyduck, blastoise, venonat, charmeleon};
        
        return new GymLeader("Misty", mistyPokemon);
    }
    
    //vermilion city
    public static GymLeader leaderSurge() {
        Pokemon raichu = PokemonFactory.createPokemon("Raichu");
        Pokemon mankey = PokemonFactory.createPokemon("Mankey");
        Pokemon arcanine = PokemonFactory.createPokemon("Arcanine");
        Pokemon pikachu = PokemonFactory.createPokemon("Pikachu");
        Pokemon gloom = PokemonFactory.createPokemon("Gloom");
        Pokemon sandslash = PokemonFactory.createPokemon("Sandslash");
        
        raichu.setLevel(35);
        mankey.setLevel(35);
        arcanine.setLevel(35);
        pikachu.setLevel(35);
        gloom.setLevel(35);
        sandslash.setLevel(35);
        
        Pokemon[] surgePokemon = {raichu, mankey, arcanine, pikachu, gloom, sandslash};
        
        return new GymLeader("Surge", surgePokemon);
    }
    
    //celadon city
    public static GymLeader leaderErika() {
        Pokemon gloom = PokemonFactory.createPokemon("Gloom");
        Pokemon primeape = PokemonFactory.createPokemon("Primeape");
        Pokemon jigglypuff = PokemonFactory.createPokemon("Jigglypuff");
        Pokemon vileplume = PokemonFactory.createPokemon("Vileplume");
        Pokemon kakuna = PokemonFactory.createPokemon("Kakuna");
        Pokemon clefairy = PokemonFactory.createPokemon("Clefairy");
        
        gloom.setLevel(45);
        primeape.setLevel(45);
        jigglypuff.setLevel(45);
        vileplume.setLevel(45);
        kakuna.setLevel(45);
        clefairy.setLevel(45);
        
        Pokemon[] erikaPokemon = {gloom, primeape, jigglypuff, vileplume, kakuna, clefairy};
        
        return new GymLeader("Erika", erikaPokemon);
    }
    
    //fuchsia city
    public static GymLeader leaderKoga() {
        Pokemon venomoth = PokemonFactory.createPokemon("Venomoth");
        Pokemon parasect = PokemonFactory.createPokemon("Parasect");
        Pokemon primeape = PokemonFactory.createPokemon("Primeape");
        Pokemon venonat = PokemonFactory.createPokemon("Venonat");
        Pokemon nidorina = PokemonFactory.createPokemon("Nidorina");
        Pokemon nidorino = PokemonFactory.createPokemon("Nidorina");
        
        venomoth.setLevel(50);
        parasect.setLevel(50);
        primeape.setLevel(50);
        venonat.setLevel(50);
        nidorina.setLevel(50);
        nidorino.setLevel(50);
        
        Pokemon[] kogaPokemon = {venomoth, parasect, primeape, venonat, nidorina, nidorino};
        
        return new GymLeader("Koga", kogaPokemon);
    }
    
    //saffron city
    public static GymLeader leaderSabrina() {
        Pokemon zubat = PokemonFactory.createPokemon("Zubat");//
        Pokemon pidgeotto = PokemonFactory.createPokemon("Pidgeotto");//
        Pokemon clefable = PokemonFactory.createPokemon("Clefable");//
        Pokemon sandshrew = PokemonFactory.createPokemon("Sandshrew");//
        Pokemon charizard = PokemonFactory.createPokemon("Charizard");//
        Pokemon ivysaur = PokemonFactory.createPokemon("Ivysaur");//
        
        zubat.setLevel(60);
        pidgeotto.setLevel(60);
        clefable.setLevel(60);
        sandshrew.setLevel(60);
        charizard.setLevel(60);
        ivysaur.setLevel(60);
        
        Pokemon[] sabrinaPokemon = {zubat, pidgeotto, clefable, sandshrew, charizard, ivysaur};
        
        return new GymLeader("Sabrina", sabrinaPokemon);
    }
    
    //cinnabar island
    public static GymLeader leaderBlaine() {
        Pokemon charizard = PokemonFactory.createPokemon("Charizard");
        Pokemon arcanine = PokemonFactory.createPokemon("Arcanine");
        Pokemon golduck = PokemonFactory.createPokemon("Golduck");
        Pokemon oddish = PokemonFactory.createPokemon("Oddish");
        Pokemon clefable = PokemonFactory.createPokemon("Clefable");
        Pokemon wartorle = PokemonFactory.createPokemon("Wartortle");
        
        charizard.setLevel(70);
        arcanine.setLevel(70);
        golduck.setLevel(70);
        oddish.setLevel(70);
        clefable.setLevel(70);
        wartorle.setLevel(70);
        
        Pokemon[] blainePokemon = {charizard, arcanine, golduck, oddish, clefable, wartorle};
        
        return new GymLeader("Blaine", blainePokemon);
    }
    
    //viridian city
    public static GymLeader leaderGiovani() {
        Pokemon persian = PokemonFactory.createPokemon("Persian");
        Pokemon dugtrio = PokemonFactory.createPokemon("Dugtrio");
        Pokemon nidoqueen = PokemonFactory.createPokemon("Nidoqueen");
        Pokemon nidoking = PokemonFactory.createPokemon("Nidoking");
        Pokemon fearow = PokemonFactory.createPokemon("Fearow");
        Pokemon butterfree = PokemonFactory.createPokemon("Butterfree");
        
        persian.setLevel(80);
        dugtrio.setLevel(80);
        nidoqueen.setLevel(80);
        nidoking.setLevel(80);
        fearow.setLevel(80);
        butterfree.setLevel(80);
        
        Pokemon[] giovaniPokemon = {persian, dugtrio, nidoqueen, nidoking, fearow, butterfree};
        
        return new GymLeader("Giovani", giovaniPokemon);
    }
}
