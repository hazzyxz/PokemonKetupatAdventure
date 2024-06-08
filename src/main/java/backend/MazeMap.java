package backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMap {

    private int[][] map1 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 5, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 3, 0, 0, 1, 3, 1, 1, 1, 3, 1},
        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 3, 1, 0, 0, 3, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private int[][] map2 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1},
        {1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 3, 1},
        {1, 0, 1, 0, 1, 0, 1, 3, 1, 0, 0, 0, 1},
        {1, 5, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 3, 0, 0, 0, 0, 1, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private int[][] map3 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 1, 9, 0, 0, 0, 1, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 3, 0, 1},
        {1, 1, 1, 3, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 3, 0, 0, 5, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private int[][] map4 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 3, 1, 5, 1, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
        {1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
        {1, 0, 1, 3, 1, 1, 1, 0, 1, 9, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 3, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    int map[][] = map1;

    Random g;
    Stack<MapPosition> stack;
    boolean[][] visited;
    int playerX, playerY;

    public MazeMap() {
        stack = new Stack<>();
        g = new Random();
        int mapNumber = g.nextInt(4);
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
        initializePlayer();
        visited = new boolean[map.length][map[0].length];
        MapFrame mapFrame = new MapFrame(map);
        mapFrame.mapPanel.setPath(dfsSearch());
        mapFrame.mapPanel.playerX = playerX;
        mapFrame.mapPanel.playerY = playerY;
        mapFrame.requestFocusInWindow();

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

    public ArrayList<MapPosition> dfsSearch() {
        stack.push(new MapPosition(playerX, playerY, null));
        visited[playerX][playerY] = true;

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

    private boolean isValidMovePlayer(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && (map[x][y] == 0 || map[x][y] == 9 || map[x][y] == 3);
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
