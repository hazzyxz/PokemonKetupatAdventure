package backend;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RivalsRace {

    public static void play() {

        Node SaffronCity = new Node("Saffron backend.City");
        Node CeladonCity = new Node("Celadon backend.City");
        Node CeruleanCity = new Node("CeruleanCity");
        Node VermillionCity = new Node("Vermillion backend.City");
        Node LavenderTown = new Node("LavenderTown");
        Node FuschiaCity = new Node("Fuschia backend.City");
        Node PewterCity = new Node("Pewter backend.City");
        Node ViridianCity = new Node("Viridian backend.City");
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

        // Calculate shortest path from Saffron backend.City
        calculateShortestPath(SaffronCity);

        Node randomDestination = getRandomNonAdjacentNode(SaffronCity, allNodes);
        System.out.println("Random destination: " + randomDestination.getName());

        //Print the shortest path
        printPathToDestination(randomDestination);

    }

    public static void calculateShortestPath(Node source) {
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Queue<Node> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));
        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            currentNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }
    }

    private static void evaluateDistanceAndPath(Node adjacentNode, Integer edgeWeight, Node sourceNode) {
        int newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(
                    Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode)).toList()
            );
        }
    }

    public static Node getRandomNonAdjacentNode(Node source, List<Node> allNodes) {
        List<Node> nonAdjacentNodes = allNodes.stream()
                .filter(node -> node != source && !source.getAdjacentNodes().containsKey(node))
                .toList();
        if (nonAdjacentNodes.isEmpty()) {
            throw new IllegalStateException("No non-adjacent nodes available.");
        }
        Random random = new Random();
        return nonAdjacentNodes.get(random.nextInt(nonAdjacentNodes.size()));
    }

    public static void printPathToDestination(Node destination) {
        String path = destination.getShortestPath().stream()
                .map(Node::getName)
                .collect(Collectors.joining(" -> "));
        path = path.isBlank() ? destination.getName() : path + " -> " + destination.getName();
        System.out.printf("%s : %d%n", path, destination.getDistance());
    }

}
