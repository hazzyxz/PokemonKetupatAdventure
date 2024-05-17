import java.util.Arrays;
import java.util.List;

public class RivalsRace {

    public static void play() {

        Node SaffronCity = new Node("Saffron City");
        Node CeladonCity = new Node("Celadon City");
        Node CeruleanCity = new Node("CeruleanCity");
        Node VermillionCity = new Node("Vermillion City");
        Node LavenderTown = new Node("LavenderTown");
        Node FuschiaCity = new Node("Fuschia City");
        Node PewterCity = new Node("Pewter City");
        Node ViridianCity = new Node("Viridian City");
        Node PalletTown = new Node("Pallet Town");
        Node CinnabarIsland = new Node("Cinnabar Island");

        SaffronCity.addAdjacentNode(CeladonCity, 4);
        SaffronCity.addAdjacentNode(CeruleanCity, 6);
        SaffronCity.addAdjacentNode(VermillionCity, 3);
        SaffronCity.addAdjacentNode(LavenderTown, 3);

        CeladonCity.addAdjacentNode(FuschiaCity, 10);

        CeruleanCity.addAdjacentNode(LavenderTown, 9);
        CeruleanCity.addAdjacentNode(PewterCity, 12);

        VermillionCity.addAdjacentNode(LavenderTown, 5);
        VermillionCity.addAdjacentNode(FuschiaCity, 7);

        LavenderTown.addAdjacentNode(FuschiaCity, 11);

        FuschiaCity.addAdjacentNode(CinnabarIsland, 5);

        CinnabarIsland.addAdjacentNode(PalletTown, 7);

        PalletTown.addAdjacentNode(ViridianCity, 5);

        ViridianCity.addAdjacentNode(PewterCity, 8);

        List<Node> allNodes = Arrays.asList(SaffronCity, CeladonCity, CeruleanCity, VermillionCity, LavenderTown, FuschiaCity, PewterCity, ViridianCity, PalletTown, CinnabarIsland);

        // Calculate shortest path from Saffron City
        Node.calculateShortestPath(SaffronCity);

        Node randomDestination = Node.getRandomNonAdjacentNode(SaffronCity, allNodes);
        System.out.println("Random destination: " + randomDestination.getName());

        //Print the shortest path
        Node.printPathToDestination(randomDestination);

    }

}
