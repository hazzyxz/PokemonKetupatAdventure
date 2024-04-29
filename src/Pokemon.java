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
	private double FullHealth;
	private double Exp;
	private Moves[] Move = new Moves[2];
	private double CurrentHealth;
	private boolean downed = false;
	
	
	
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
	public double getFullHealth() {
		return FullHealth;
	}
	public void setCurrentHealth(double health) {
		CurrentHealth = health;
	}
	public double getCurrentHealth() {
		return CurrentHealth;
	}
	public double getExp() {
		return Exp;
	}
	public void setExp(double exp) {
		Exp = exp;
	}
	public Moves[] getMove() {
		return Move;
	}
	
	public ArrayList<String> getType() {
		return type;
	}
	public ArrayList<String> getWeakness() {
		return Weakness;
	}
	public ArrayList<String> getStrength() {
		return Strength;
	}
	
	//constructor for creature
	public Pokemon(String name, double health, String[] type, int level, String[] strength, String[] weakness, Moves move1, Moves move2) {
		
		this.Name = name;
		this.FullHealth = health;
		this.CurrentHealth = health;
	
		for(int i = 0; i< type.length; i++)
			this.type.add(type[i]);
		
		for(int i = 0; i< weakness.length; i++)
			this.Weakness.add(weakness[i]);
		

		for(int i = 0; i< strength.length; i++)
			this.Strength.add(strength[i]);
		
		this.Move[0] = move1;
		this.Move[1] = move2;
		
		this.level = level;
		
	}
	
	public void evolve () {
		
		//TO-DO is to put evolve properties, 
		//increase stat
		
	}
	
	public void increaseLevel() {
		this.level +=1;
		this.Move[0].setDamage(Move[0].getDamage() + 2);
		this.Move[1].setDamage(Move[1].getDamage() + 2);
		
	}
	
	public boolean isDown() {	
		return (this.CurrentHealth <= 0);
	}
	
	
	
	
}
