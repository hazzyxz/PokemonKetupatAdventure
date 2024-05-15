
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Maze {

    public static void main(String[] args) {
        MazeMap maze = new MazeMap();
        maze.playGame();
        ArrayList<MapPosition> path = maze.dfsSearch();
        if (path != null) {
            System.out.println("Path found to the end point!");
            for (MapPosition pos : path) {
                System.out.println("Move to: (" + pos.x + ", " + pos.y + ")");
            }
        } else {
            System.out.println("No path found to the end point.");
        }
    }
}

class MazeMap {

    int[][] map1 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 5, 0, 0, 1, 0, 1, 0, 0, 0, 0, 9, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    int[][] map2 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
        {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1},
        {1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    int[][] map3 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 9, 1},
        {1, 5, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    int[][] map4 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 1, 1, 0, 1, 9, 0, 0, 0, 0, 1},
        {1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1},
        {1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 5, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    int map[][] = map1;

    Random g;
    Stack<MapPosition> stack;
    boolean[][] visited;
    int playerX, playerY;

    MazeMap() {
        stack = new Stack<>();
        g = new Random();
        int mapNumber = g.nextInt(4);
        initializePlayer();
        switch (mapNumber) {
            case 0:
                map = map1;
                break;
            case 1:
                map = map2;
                break;
            case 2:
                map = map3;
                break;
            case 3:
                map = map4;
                break;
        }
        visited = new boolean[map.length][map[0].length];
    }
    
    
    void initializePlayer() {
        // Find the starting position
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 5) {
                    playerX = i;
                    playerY = j;
                    map[i][j] = 0; // Mark the starting position as an empty cell for gameplay
                    return;
                }
            }
        }
    }

    void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMaze();
            System.out.println("Enter move (WASD): ");
            char move = scanner.nextLine().toUpperCase().charAt(0);
            if (movePlayer(move)) {
                System.out.println("You reached the endpoint!");
                break;
            }
        }
        scanner.close();
    }

    boolean movePlayer(char move) {
        int newX = playerX;
        int newY = playerY;
        switch (move) {
            case 'W': newX--; break; // Move up
            case 'S': newX++; break; // Move down
            case 'A': newY--; break; // Move left
            case 'D': newY++; break; // Move right
            default: System.out.println("Invalid move! Use W (up), A (left), S (down), D (right)"); return false;
        }
        if (isValidMove(newX, newY)) {
            playerX = newX;
            playerY = newY;
            return map[playerX][playerY] == 9; // Check if endpoint is reached
        } else {
            System.out.println("Invalid move! Hit a wall or out of bounds.");
            return false;
        }
    }

    void printMaze() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("P ");
                } else if (map[i][j] == 1) {
                    System.out.print("# ");
                } else if (map[i][j] == 9) {
                    System.out.print("E ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public ArrayList<MapPosition> dfsSearch() {
        // Find the starting position
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 5) {
                    stack.push(new MapPosition(i, j, null));
                    visited[i][j] = true;
                    break;
                }
            }
        }

        // Perform DFS
        while (!stack.isEmpty()) {
            MapPosition current = stack.pop();
            int x = current.x;
            int y = current.y;

            // Check if we reached the end point
            if (map[x][y] == 9) {
                // Extract the path
                return extractPath(current);
            }

            // Explore the neighbors
            exploreNeighbors(current);
        }

        return null; // No path found
    }

    private void exploreNeighbors(MapPosition current) {
        int x = current.x;
        int y = current.y;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValidMove(newX, newY)) {
                stack.push(new MapPosition(newX, newY, current));
                visited[newX][newY] = true;
            }
        }
    }
    

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && !visited[x][y] && (map[x][y] == 0 || map[x][y] == 9);
    }

    private ArrayList<MapPosition> extractPath(MapPosition end) {
        ArrayList<MapPosition> path = new ArrayList<>();
        MapPosition current = end;
        while (current != null) {
            path.add(0, current);
            current = current.prev;
        }
        return path;
    }
}

class MapPosition {

    int x, y;
    MapPosition prev;

    MapPosition(int x, int y, MapPosition prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }
}
