import java.util.ArrayList;


class Pokemon{
	
	
	/*
	-name
	-type
	-lvl
	-move -> 2 moves
	-strength -> type
	-weakness -> type
	-hp
	-exp
	
	*/
	
	private String Name;
	private ArrayList<String> type;
	private int level = 5;
	private ArrayList<String> Strength;
	private ArrayList<String> Weakness;
	private double Health;
	private double Exp;
	private Moves Move1;
	private Moves Move2;
	
	
	// getter and setter
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getHealth() {
		return Health;
	}
	public void setHealth(double health) {
		Health = health;
	}
	public double getExp() {
		return Exp;
	}
	public void setExp(double exp) {
		Exp = exp;
	}
	public Moves getMove1() {
		return Move1;
	}
	public Moves getMove2() {
		return Move2;
	}
	
	//constructor for creature
	public Pokemon(String name, double health, String[] type, int level, String[] strength, String[] weakness, Moves move1, Moves move2) {
		
		this.Name = name;
		this.Health = health;
	
		for(int i = 0; i< type.length; i++)
			this.type.add(type[i]);
		
		for(int i = 0; i< weakness.length; i++)
			this.Weakness.add(weakness[i]);
		

		for(int i = 0; i< strength.length; i++)
			this.Strength.add(strength[i]);
		
		this.Move1 = move1;
		this.Move2 = move2;
		
		this.level = level;
		
	}
	
	public void evolve () {
		
		//TO-DO is to put evolve properties, 
		//increase stat
		
	}
	
	public void increaseLevel() {
		this.level +=1;
		this.Move1.setDamage(Move1.getDamage() + 2);
		this.Move2.setDamage(Move2.getDamage() + 2);
		
	}
	
	
	
	
	
}
