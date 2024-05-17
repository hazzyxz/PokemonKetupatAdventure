import java.util.*;

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

}
