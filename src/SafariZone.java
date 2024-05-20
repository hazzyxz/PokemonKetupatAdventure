import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SafariZone {

    public static void play() {

        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("Welcome to the Safari Zone! Today's challenge: Sort the Pokémon!");
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println();
        System.out.print("Enter the Pokémon in your party (seperated by a comma): ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] pokemonInputNames = input.split(",");
        List<String> pokemonList = new ArrayList<>();
        for (String name : pokemonInputNames) {
            pokemonList.add(name.trim());
        }
        System.out.println();
        System.out.print("You entered: ");
        System.out.println(String.join(", ", pokemonList));
        System.out.println();

        sortPokemon(pokemonList);

        System.out.println();
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("Your Pokémon are now sorted! Enjoy your adventure in the Safari Zone!");
        System.out.println("+----------------------------------------------------------------------+");

    }

    private static void sortPokemon(List<String> pokemonList) {

        placeEevee(pokemonList);

        placeSnorlax(pokemonList);

        placeBulbasaurFarFromCharmander(pokemonList);

        placePikachu(pokemonList);

        placeJigglypuff(pokemonList);

        placeMachop(pokemonList);

    }

    private static void placeEevee(List<String> pokemonList) {

        String eevee = findAndRemove(pokemonList, "Eevee");
        if (eevee != null) {
            pokemonList.add(0, eevee);
            System.out.print("Step 1: Eevee insists on being positioned either at the beginning of the\n" +
                    "lineup to showcase its adaptability.\n" +
                    "Sorted List: " + String.join(", ", pokemonList) + "\n");
        }
    }

    private static void placeSnorlax(List<String> pokemonList) {

        String snorlax = findAndRemove(pokemonList, "Snorlax");
        if (snorlax != null) {
            pokemonList.add(snorlax);
            System.out.println("\nStep 2: Snorlax insists on being positioned at the end of the lineup to\n" +
                    "ensure maximum relaxation.\n" +
                    "Partial Sort: " + String.join(", ", pokemonList));
        }

    }

    private static void placeBulbasaurFarFromCharmander(List<String> pokemonList) {

        boolean containsBulbasaurAndCharmander = false;
        boolean containsBulbasaur = false;
        int bulbasaurIndex = -1;
        boolean containsCharmander = false;
        int charmanderIndex = -1;
        boolean containsEevee = pokemonList.stream().anyMatch("Eevee"::equalsIgnoreCase);
        boolean containsSnorlax = pokemonList.stream().anyMatch("Snorlax"::equalsIgnoreCase);

        for (int i = 0; i < pokemonList.size(); i++) {
            if (pokemonList.get(i).equalsIgnoreCase("Bulbasaur")) {
                containsBulbasaur = true;
                bulbasaurIndex = i;
            }
            if (pokemonList.get(i).equalsIgnoreCase("Charmander")) {
                containsCharmander = true;
                charmanderIndex = i;
            }
            if (containsBulbasaur && containsCharmander) {
                containsBulbasaurAndCharmander = true;
                break;
            }
        }

        if (containsBulbasaurAndCharmander) {
//            if (Math.abs(bulbasaurIndex - charmanderIndex) == 1) {
//                String bulbasaur = pokemonList.remove(bulbasaurIndex);
//                pokemonList.add(charmanderIndex > bulbasaurIndex ? bulbasaurIndex - 1 : bulbasaurIndex + 1, bulbasaur);
//            }
            String bulbasaur = pokemonList.remove(bulbasaurIndex);

            if (containsEevee) {
                pokemonList.add(1, bulbasaur);
            } else {
                pokemonList.add(0, bulbasaur);
            }

            String charmander = pokemonList.remove(charmanderIndex);

            if (containsSnorlax) {
                pokemonList.add(pokemonList.size() - 1, charmander);
            } else {
                pokemonList.add(charmander);
            }

            System.out.println("\nStep 3: Bulbasaur refuses to be placed next to Charmander.\n" +
                    "Partial Sort: " + String.join(", ", pokemonList));

        }

    }

    private static void placePikachu(List<String> pokemonList) {

        String pikachu = findAndRemove(pokemonList, "Pikachu");
        if (pikachu != null) {
            int center = pokemonList.size() / 2;
            pokemonList.add(center, pikachu);
            System.out.println("\nStep 4: Pikachu demands to be placed at the center of the arrangement.\n" +
                    "Partial Sort: " + String.join(", ", pokemonList));
        }
    }

    private static void placeJigglypuff(List<String> pokemonList) {

        int pikachuIndex = -1;
        int jigglypuffIndex = -1;
        int newPikachuIndex = 0;

        boolean containsSearchStr = pokemonList.stream().anyMatch("Pikachu"::equalsIgnoreCase);

        if (containsSearchStr) {
            for (int i = 0; i < pokemonList.size(); i++) {
                if (pokemonList.get(i).equalsIgnoreCase("Pikachu")) {
                    pikachuIndex = i;
                }
                if (pokemonList.get(i).equalsIgnoreCase("Jigglypuff")) {
                    jigglypuffIndex = i;
                }
            }

            if (Math.abs(pikachuIndex - jigglypuffIndex) != 1) {

                String jigglypuff = findAndRemove(pokemonList, "Jigglypuff");

                for (int i = 0; i < pokemonList.size(); i++) {
                    if (pokemonList.get(i).equalsIgnoreCase("Pikachu")) {
                        newPikachuIndex = i;
                    }
                }

                if (jigglypuff != null) {

                    pokemonList.add(newPikachuIndex, jigglypuff);
                    System.out.println("\nStep 5: Jigglypuff prefers to be surrounded by other \"cute\" Pokémon for\n" +
                            "morale purposes.\n" +
                            "Partial Sort: " + String.join(", ", pokemonList));

                }
            } else {
                System.out.println("\nStep 5: Jigglypuff prefers to be surrounded by other \"cute\" Pokémon for\n" +
                        "morale purposes.\n" +
                        "Partial Sort: " + String.join(", ", pokemonList));
            }
        }
    }

    private static void placeMachop(List<String> pokemonList) {

        String machop = findAndRemove(pokemonList, "Machop");
        int snorlaxIndex = -1;

        for (int i = 0; i < pokemonList.size(); i++) {
            if (pokemonList.get(i).equalsIgnoreCase("Snorlax")) {
                snorlaxIndex = i;
                break;
            }
        }

        if (machop != null && snorlaxIndex != -1) {
            pokemonList.add(snorlaxIndex, machop);
            System.out.println("\nStep 6: Machop demands to be placed next to the heaviest Pokemon in the\n" +
                    "lineup to show off its strength.\n" +
                    "Final Sorted List: " + String.join(", ", pokemonList));
        }

    }

    private static String findAndRemove(List<String> pokemonList, String name) {

        for (String pokemon : pokemonList) {
            if (pokemon.equalsIgnoreCase(name)) {
                pokemonList.remove(pokemon);
                return pokemon;
            }
        }
        return null;
    }

}


