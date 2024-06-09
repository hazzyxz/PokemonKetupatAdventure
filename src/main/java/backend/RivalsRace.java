package backend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;

import static main.ApplicationMain.userInput;
import static screens.SaffronCity.answerRivalsRace;

public class RivalsRace {

    public static void main(String[] args) {
        play();
    }

    public static void play() {

        JFrame frame = new JFrame();
        RacePanel panel = new RacePanel();
        panel.setBounds(0, 0, 600, 600);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setTitle("Rival Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.add(panel, BorderLayout.CENTER);

        JTextField inputField = new JTextField();

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput = inputField.getText();
                inputField.setText("");
            }
        };
        
        Font pokemon_classic20 = null;

        try {
            InputStream is = RivalsRace.class.getResourceAsStream("/Font/Pokemon Classic.ttf");
            pokemon_classic20 = Font.createFont(Font.TRUETYPE_FONT, is);
            pokemon_classic20 = pokemon_classic20.deriveFont(Font.PLAIN, 20);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        inputField.setFont(pokemon_classic20);
        inputField.setFocusable(true);
        inputField.addActionListener(action);
        frame.add(inputField, BorderLayout.SOUTH);

        frame.setVisible(true);
        panel.setVisible(true);

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

        //Saffron City Adjacent Node
        SaffronCity.addAdjacentNode(CeladonCity, 4);
        SaffronCity.addAdjacentNode(CeruleanCity, 6);
        SaffronCity.addAdjacentNode(VermillionCity, 3);
        SaffronCity.addAdjacentNode(LavenderTown, 3);

        //Celadon City Adjacent Node
        CeladonCity.addAdjacentNode(FuschiaCity, 10);

        //Cerulean City Adjacent Node
        CeruleanCity.addAdjacentNode(LavenderTown, 9);
        CeruleanCity.addAdjacentNode(PewterCity, 12);

        //Vermillion City Adjacent Node
        VermillionCity.addAdjacentNode(LavenderTown, 5);
        VermillionCity.addAdjacentNode(FuschiaCity, 7);

        //Lavender Town Adjacent Node
        LavenderTown.addAdjacentNode(FuschiaCity, 11);

        //Fuschia City Adjacent Node
        FuschiaCity.addAdjacentNode(CinnabarIsland, 5);

        //Cinnabar Island Adjacent Node
        CinnabarIsland.addAdjacentNode(PalletTown, 7);

        //Pallet Town Adjacent Node
        PalletTown.addAdjacentNode(ViridianCity, 5);

        //Viridian City Adjacent Node
        ViridianCity.addAdjacentNode(PewterCity, 8);

        List<Node> allNodes = Arrays.asList(SaffronCity, CeladonCity, CeruleanCity, VermillionCity, LavenderTown, FuschiaCity, PewterCity, ViridianCity, PalletTown, CinnabarIsland);

        // Calculate shortest path from Saffron City
        calculateShortestPath(SaffronCity);

        Node randomDestination = getRandomNonAdjacentNode(SaffronCity, allNodes);
        System.out.println("Random destination: " + randomDestination.getName());
        switch(randomDestination.getName()){
            case "Cinnabar Island":
                panel.cinnabar=true;
                frame.repaint();
                break;
            case "Fuschia City":
                panel.fuschia=true;
                frame.repaint();
                break;
            case "Pallet Town":
                panel.pallet=true;
                frame.repaint();
                break;
            case "Viridian City":
                panel.virdian=true;
                frame.repaint();
                break;
            case "Pewter City":
                panel.pewter=true;
                frame.repaint();
                break;
        }

        //Print the shortest path
        //printPathToDestination(randomDestination);
        // Prompt the user for their answer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the shortest path to the destination (format: City1 -> City2 -> ... -> Destination): ");
        do {
            answerRivalsRace = userInput;
        } while (answerRivalsRace.isEmpty());

        // Compare user's answer with the correct path
        String correctPath = randomDestination.getShortestPath().stream()
                .map(Node::getName)
                .collect(Collectors.joining(" -> ")) + " -> " + randomDestination.getName();

        if (answerRivalsRace.trim().equalsIgnoreCase(correctPath.trim())) {
            int response = JOptionPane.showConfirmDialog(null,
                    "Congrats! You win absolutely nothing! Continue your journey.",
                    "You Win!",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (response == -1) {
                frame.dispose();
            }
        } else {
            int response = JOptionPane.showConfirmDialog(null,
                    "Bruh, wrong answer. Skill issue lol, go learn basic maths",
                    "bruh momemnt",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (response == -1) {
                frame.dispose();
            }
        }
        frame.dispose();

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

class RacePanel extends JPanel {

    PhotoRace photo;
    boolean fuschia;
    boolean pewter;
    boolean virdian;
    boolean pallet;
    boolean cinnabar;
    boolean win;
    boolean lose;

    RacePanel() {
        photo = new PhotoRace();
        fuschia=false; 
        pewter=false;
        virdian =false;
        pallet=false;
        cinnabar=false;
        win = false;
        lose = false;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 700, 700);
        g2d.drawImage(photo.getMWW(), 50, 20, this);
        
        // Set the font
        Font font = new Font("Serif", Font.BOLD, 15);
        g2d.setFont(font);

        // Set the color
        g2d.setColor(Color.BLACK);
        if(fuschia){
            String text = "Your rival, Gary challenges you for a race to FUSCHIA CITY";
            g2d.drawString(text, 50, 340);
            String text2="Find the shortest path to beat him in the race.";
            g2d.drawString(text2, 50, 360);
            g2d.drawImage(photo.getAF(),38 ,365, this);
        }
        if(pewter){
            String text = "Your rival, Gary challenges you for a race to PEWTER CITY";
            g2d.drawString(text, 50, 340);
            String text2="Find the shortest path to beat him in the race.";
            g2d.drawString(text2, 50, 360);
            g2d.drawImage(photo.getAF(),38 ,365, this);
        }
        if(virdian){
            String text = "Your rival, Gary challenges you for a race to VIRIDIAN CITY";
            g2d.drawString(text, 50, 340);
            String text2="Find the shortest path to beat him in the race.";
            g2d.drawString(text2, 50, 360);
            g2d.drawImage(photo.getAF(),38 ,365, this);
        }
        if(pallet){
            String text = "Your rival, Gary challenges you for a race to PALLET TOWN";
            g2d.drawString(text, 50, 340);
            String text2="Find the shortest path to beat him in the race.";
            g2d.drawString(text2, 50, 360);
            g2d.drawImage(photo.getAF(),38 ,365, this);
        }
        if(cinnabar){
            String text = "Your rival, Gary challenges you for a race to CINNABAR ISLAND";
            g2d.drawString(text, 50, 340);
            String text2="Find the shortest path to beat him in the race.";
            g2d.drawString(text2, 50, 360);
            g2d.drawImage(photo.getAF(),38 ,365, this);
        }

        if (win) {

        }
        if (lose) {

        }
    }
}

class PhotoRace extends ImageIcon {

    private Image mapWithWeight;
    private Image answerFormat;

    public PhotoRace() {
        ImageIcon mwwtemp = new ImageIcon("Images/MapWithWeight.jpg");
        Image mww = mwwtemp.getImage();
        mapWithWeight = mww.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon aftemp = new ImageIcon("Images/AnswerFormat.png");
        Image af = aftemp.getImage();
        answerFormat = af.getScaledInstance(200, 60, Image.SCALE_SMOOTH);

    }

    public Image getMWW() {
        return mapWithWeight;
    }
    
    public Image getAF(){
        return answerFormat;
    }
}
