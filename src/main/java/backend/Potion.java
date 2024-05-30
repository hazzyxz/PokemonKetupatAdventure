package backend;


import java.io.Serializable;

public class Potion implements Serializable {

    private String name;
    private boolean small=false;
    private boolean medium=false;
    private boolean large=false;

    public Potion(int i){
        switch(i){
            case 0: small=true;break;
            case 1: medium=true;break;
            case 2: large=true;break;
            default: break;
        }
    }

    public void setSmall(){
        name="Small Potion";
        small=true;
        medium=false;
        large=false;
    }

    public boolean getSmall(){
        return small;
    }

    public void setMedium(){
        name="Medium Potion";
        medium=true;
        small=false;
        large=false;
    }

    public boolean getMedium(){
        return medium;
    }

    public void setLarge(){
        name="Large Potion";
        large=true;
        small=false;
        medium=false;
    }

    public String getName(){
        return name;
    }

    public boolean getLarge(){
        return large;
    }

    public int heal(){
        if(small){
            return 30;//adjust accordingly
        }

        if(medium){
            return 100;//adjust accordingly
        }

        if(large){
            return 200;//adjust accordingly
        }

        return 0;
    }
}