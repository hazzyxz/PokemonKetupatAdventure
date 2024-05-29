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
            sprites.put("Charmander", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Charmander.png"))));
            sprites.put("Squirtle", ImageIO.read(Objects.requireNonNull(PokemonSprite.class.getResourceAsStream("/Sprites/Squirtle.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
