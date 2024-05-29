package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Maze {

    public static void main(String[] args) {
        MazeMap maze = new MazeMap();
    }
}

class MapFrame extends JFrame {

    int[][] map;
    MapPanel mapPanel;
    JButton hint;
    Photo goldCoin;

    MapFrame(int[][] map) {
        goldCoin = new Photo();
        hint = new JButton("Hint (Pay 100 gold)");
        hint.setBounds(260, 370, 150, 30);
        hint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to pay 100  Gold  to show the path?",
                        "Hint for 100 GOLD?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        goldCoin.getCoin());
                if (response == JOptionPane.YES_OPTION) {
                    remove(hint);
                    mapPanel.unlockHint = true;
                    //mapPanel.remove(hint);
                    repaint();
                }
            }

        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        mapPanel.playerMove(-1, 0); // Move the ball up
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        mapPanel.playerMove(1, 0); // Move the ball down
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        mapPanel.playerMove(0, -1); // Move the ball left
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        mapPanel.playerMove(0, 1); // Move the ball right
                        repaint();
                        break;
                }
            }
        });
        mapPanel = new MapPanel(map,this);
        this.setLayout(null);
        this.setTitle("PokeMaze");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(mapPanel);
        this.add(hint);
        mapPanel.setLayout(null);
        //mapPanel.add(hint);
    }

}

class Photo extends ImageIcon {

    private ImageIcon goldCoin;
    private Image ghastly;
    private Image wall;
    private Image flag;
    private Image floor;
    private Image player;

    public Photo() {
        goldCoin = new ImageIcon("Images/goldIcon.jpg");
        Image gc = goldCoin.getImage();
        Image resizedCoin = gc.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        goldCoin = new ImageIcon(resizedCoin); // Assign to the instance variable
        ImageIcon ghastlytemp = new ImageIcon("Images/ghastly.png");
        Image g = ghastlytemp.getImage();
        ghastly = g.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon walltemp = new ImageIcon("Images/wall.jpg");
        Image w = walltemp.getImage();
        wall = w.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon flagtemp = new ImageIcon("Images/flag.png");
        Image f = flagtemp.getImage();
        flag = f.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon floortemp = new ImageIcon("Images/floor.jpg");
        Image flr = floortemp.getImage();
        floor = flr.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon playertemp = new ImageIcon("Images/player.png");
        Image p = playertemp.getImage();
        player = p.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

    }

    public ImageIcon getCoin() {
        return goldCoin;
    }

    public Image getGhastly() {
        return ghastly;
    }
    public Image getWall() {
        return wall;
    }
    public Image getFlag() {
        return flag;
    }
    
    public Image getFloor(){
        return floor;
    }
    
    public Image getPlayer(){
        return player;
    }

}

class MapPanel extends JPanel {

    int[][] map;
    boolean unlockHint = false;
    int playerX, playerY;
    boolean gameEnded = false;
    Photo image;
    MapFrame mapFrame;

    ArrayList<MapPosition> path;

    MapPanel(int map[][],MapFrame mapFrame) {
        this.map = map;
        this.setBounds(0, 0, 500, 500);
        this.mapFrame=mapFrame;
        image = new Photo();
    }

    public void playerMove(int dx, int dy) {
        if (!gameEnded) { // If game hasn't ended
            int newX = playerX + dx;
            int newY = playerY + dy;

            // Check if the new position is valid
            if (isValidMove(newX, newY)) {
                playerX = newX;
                playerY = newY;

                // Check for collisions
                checkCollisions();
            }

            // Repaint the panel
        }
    }

    private void checkCollisions() {
        if (map[playerX][playerY] == 3) { // If the player touches a pink cell
            JOptionPane.showMessageDialog(null, "Warning: You've being haunted by Ghastly. One of your pokemon is brutally killed. Game Over!");
            gameEnded = true;
            mapFrame.dispose();
        } else if (map[playerX][playerY] == 9) { // If the player reaches the red cell
            JOptionPane.showMessageDialog(null, "Congratulations! You reached the end! You win!");
            gameEnded = true;
            mapFrame.dispose();
        }
    }

    // Check if the move is valid
    private boolean isValidMove(int x, int y) {
        return y >= 0 && x < map[0].length && x >= 0 && x < map.length && map[x][y] != 1;
    }

    public void setPath(ArrayList<MapPosition> g) {
        this.path = g;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int x = (30 * j) + 50;
                int y = (30 * i) + 60;
                Color color;
                switch (map[i][j]) {
                    case 1:
                        g.drawImage(image.getWall(), x, y, this);
                        break;
                    case 9:
                        g.drawImage(image.getFlag(), x+5, y, this);
                        break;
                    case 3:
                        g.drawImage(image.getGhastly(), x, y, this);
                        break;
                    default:
                        g.drawImage(image.getFloor(), x, y, this);
                        break;
                }
//                g.setColor(color);
//                g.fillRect((30 * j) + 50, (30 * i) + 60, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect((30 * j) + 50, (30 * i) + 60, 30, 30);
            }
        }
        if (unlockHint) {
            for (int i = 0; i < path.size(); i++) {
                int pathX = path.get(i).x;
                int pathY = path.get(i).y;
                g.setColor(Color.GREEN);
                g.fillRect((30 * pathY) + 50, (30 * pathX) + 60, 30, 30);
                if(i==path.size()-1){
                    g.drawImage(image.getFlag(), (30 * pathY) + 55, (30 * pathX) + 60, this);
                }
            }
        }

//        g.setColor(Color.RED);
        g.drawImage(image.getPlayer(), (30 * playerY) + 50, (30 * playerX) + 60, this);
//        g.fillOval((30 * playerY) + 50, (30 * playerX) + 60, 30, 30);

    }
}

class MazeMap {

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

    MazeMap() {
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

class MapPosition {

    int x, y;
    MapPosition prev;

    MapPosition(int x, int y, MapPosition prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
