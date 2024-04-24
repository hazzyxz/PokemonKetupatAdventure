

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
	private String type;
	private int level = 5;
	private String Strength;
	private String Weakness;
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
	public Pokemon(String name, double health, String type, String strength, String weakness, Moves move1, Moves move2) {
		
		this.Name = name;
		this.Health = health;
		this.type = type;
		this.Strength = strength;
		this.Weakness = weakness;
		this.Move1 = move1;
		this.Move2 = move2;
		
	}
	
	public void evolve () {
		
		//TO-DO is to put evolve properties, 
		//increase stat
		
	}
	
	
	
	
	
}
