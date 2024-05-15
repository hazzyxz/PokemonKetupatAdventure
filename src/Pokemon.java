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
	
	//----------------Attribute----------------------------//
	
	private String Name;
	private ArrayList<String> type = new ArrayList<String>();
	private int level = 5;
	private ArrayList<String> Strength = new ArrayList<String>();
	private ArrayList<String> Weakness = new ArrayList<String>();
	private double FullHealth;
	private double Exp;
	private Moves[] Move = new Moves[2];
	private double CurrentHealth;
	private boolean downed = false;
	
	//----------------Attribute----------------------------//
	
	//-------------------setter and getter-----------------------//
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getLevel() {
		return level;
	}
	public Pokemon setLevel(int level) {
		
		this.Move[0].setDamage(Move[0].getDamage() + (2*level));
		this.Move[1].setDamage(Move[1].getDamage() + (2*level));
		this.FullHealth += level*30;
		this.CurrentHealth = FullHealth;
		
		this.level = level;
		
		return this;
		
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
	public void setDowned(boolean downed) {
		this.downed = downed;
	}
	
	public void setFullHealth(double fullHealth) {
		FullHealth = fullHealth;
	}
	
	//-------------------setter and getter-----------------------//
	
	//----------------constructor--------------------------//
	
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
	
	//----------------constructor--------------------------//
	
	//---------------------public method------------------------//
	
	public void healFull() { //heal fully pokemon
		CurrentHealth = FullHealth;
	}
	
	public void heal(int hp) throws Exception { //heal partially, dont know what could be use for, but its here
		if ((CurrentHealth + hp) > FullHealth)
			throw new Exception("Exceed full health");
		CurrentHealth += hp;
	}
	
	public void revive() { //change the parameter, use easier naming, pretty much the same as setter for downed
		this.downed = false;
		
	}
	

	// Clone method
    public Pokemon clone() {
        return new Pokemon(this.Name, this.FullHealth, this.type.toArray(new String[this.type.size()]), this.level, this.Strength.toArray(new String[this.Strength.size()]), this.Weakness.toArray(new String[this.Weakness.size()]), this.Move[0], this.Move[1]);
    }
	
	
	public void evolve () {
		
		//TO-DO is to put evolve properties, 
		//increase stat
		
	}
	
	public void increaseEXP(int xp) {
		
	}
	
	public Pokemon increaseLevel() {
		
		this.level +=1;
		this.Move[0].setDamage(Move[0].getDamage() + 2);
		this.Move[1].setDamage(Move[1].getDamage() + 2);
		
		return this;
	}
	
	public Pokemon increaseLevel(int LeveledUp) {
		this.level += LeveledUp;
		
		this.Move[0].setDamage(Move[0].getDamage() + (2*LeveledUp));
		this.Move[1].setDamage(Move[1].getDamage() + (2*LeveledUp));
		
		return this;
	}
	
	public Pokemon increaseHP(int HP) {
		this.FullHealth += HP;
		
		return this;
	}
	
	public boolean isDown() {	
		return (this.CurrentHealth <= 0);
	}
	
	
	
	
}
