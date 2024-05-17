import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Node implements Comparable<Node> {

    private final String name;
    private Integer distance = Integer.MAX_VALUE;
    private List<Node> shortestPath = new LinkedList<>();
    private final Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addAdjacentNode(Node node, int weight) {
        adjacentNodes.put(node, weight);
        node.adjacentNodes.put(this, weight); // Add the reverse edge for undirected graph
    }

    public int getDistance() {
        return this.distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance, node.getDistance());
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
