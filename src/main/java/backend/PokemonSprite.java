package backend;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PokemonSprite {
    public static Map<String, BufferedImage> sprites = new HashMap<>();

    static {
        try {
            sprites.put("Bulbasaur", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Bulbasaur.png"))));
            sprites.put("Ivysaur", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Ivysaur.png"))));
            sprites.put("Venusaur", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Venusaur.png"))));

            sprites.put("Charmander", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Charmander.png"))));
            sprites.put("Charmeleon", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Charmeleon.png"))));


            sprites.put("Squirtle", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Squirtle.png"))));
            sprites.put("Wartortle", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Wartortle.png"))));
            sprites.put("Blastoise", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Blastoise.png"))));

            sprites.put("Caterpie", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Caterpie.png"))));

            sprites.put("Weedle", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Weedle.png"))));

            sprites.put("Pidgey", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Pidgey.png"))));

            sprites.put("Rattata", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Rattata.png"))));

            sprites.put("Spearow", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Spearow.png"))));

            sprites.put("Ekans", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Ekans.png"))));

            sprites.put("Pikachu", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Pikachu.png"))));

            sprites.put("Sandshrew", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Sandshrew.png"))));

            sprites.put("Clefairy", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Clefairy.png"))));

            sprites.put("Vulpix", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Vulpix.png"))));

            sprites.put("Jigglypuff", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Jigglypuff.png"))));

            sprites.put("Zubat", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Zubat.png"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
