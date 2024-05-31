package data;

import main.GamePanel;
import main.KeyHandler;
import screens.PalletTown;

import java.io.*;

public class SaveLoad {

    GamePanel gp;;
    KeyHandler keyH;

    public SaveLoad(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void save(String pathName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(pathName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            DataStorage ds = new DataStorage();
            ds.player = gp.player;
            ds.currentScreen = gp.currentScreen.getCityName();

            out.writeObject(ds);
            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String pathName) {
        try {
            FileInputStream fileIn = new FileInputStream(pathName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            DataStorage ds = (DataStorage) in.readObject();
            gp.player = ds.player;

            // LOAD SCREEN BASED ON cityName
            switch (ds.currentScreen) {
                case "Pallet Town": gp.currentScreen = new PalletTown(gp, keyH); break;
            }


            in.close();


        } catch (FileNotFoundException e) {
            System.out.println("Load File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Load Class Not Found!");
        }
    }
}
