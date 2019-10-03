import java.util.Random;

public class Player {
	private String attack1 = "Groin Punch";
	private String attack2 = "Throw Rock";
	private String attack3 = "Shin Kick";
	private String guard = "Brace";
	private String heal = "Pray";
	private int playerHealth;
	private int playerMAXHealth;
	private int playerStrength;
	private int playerDefense;
	
	public Player(int playerHealth, int playerStrength, int playerDefense) {
		this.playerHealth = playerHealth;
		this.playerMAXHealth = playerHealth;
		this.playerStrength = playerStrength;
		this.playerDefense = playerDefense;
	}
	
	public int getHP() {
		return this.playerHealth;
	}
	
	public void setHP() {
		this.playerHealth = playerMAXHealth;
	}
	
	public int getMAXHP() {
		return this.playerMAXHealth;
	}
	
	public void takeDMG(int totalDamage) {
		playerHealth -= totalDamage;
	}
	
	public void healHP(int heal) {
		playerHealth += heal;
		if (playerHealth > playerMAXHealth)
			playerHealth = playerMAXHealth;
	}
	
	public String getGuard() {
		return this.guard;
	}
	
	public String getHeal() {
		return this.heal;
	}
	
	public String getAttackName() {
		Random rand = new Random();
		int randomAttack = (rand.nextInt(3)) + 1;
		switch (randomAttack) {
		case 2:
			return this.attack2;
		case 3:
			return this.attack3;
		default:
			return this.attack1;
		}
	}
	
	public int getStrength() {
		return this.playerStrength;
	}
	
	public int getDefense() {
		return this.playerDefense;
	}
}
