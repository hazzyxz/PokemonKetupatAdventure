package backend;

import java.io.Serializable;

public class Moves implements Serializable {

	
	//pokemon moves name and damage
	
	private String MovesName;
	private int Damage;
	
	
	//----------------constructor--------------------------//
	
	public Moves(String movesname, int damage) {
		this.setMovesName(movesname);
		this.Damage = damage;
	}
	
	//----------------constructor--------------------------//
	
	
	//setter and getter, to update for leveling up
	public void setDamage(int damage) {
		Damage = damage;
	}
	public int getDamage() {
		return Damage;
	}
	public String getMovesName() {
		return MovesName;
	}

	public void setMovesName(String movesName) {
		MovesName = movesName;
	}
	
	
	
	
	
}
