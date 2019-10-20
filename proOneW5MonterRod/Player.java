package proOneW5MonterRod;

import java.util.Random;

public class Player {
	
	private String[] attacks = {"Punch","Kick","Run"};
	private String attackName;
	private int playerStrength;
	private int playerDefence;
	
	public Player(int playerStrength, int playerDefence) {
		this.playerStrength = playerStrength;
		this.playerDefence = playerDefence;
		
	}
	
	public String getAttackName(int i) {
		return attacks[i];
	}
	
	public int getStrength() {
		return this.playerStrength;
	}
	
	public int getDefence() {
		return this.playerDefence;
	}
	
	public int pickAttackName() {
		Random randomAttk = new Random();
		int randomAttack = randomAttk.nextInt();
		return randomAttack;
	}

}
