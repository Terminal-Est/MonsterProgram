import java.util.Random;

public class Player {
	private String[] attacks = { "Groin Punch", "Throw Rock", "Shin Kick", "Backstab", "Roundhouse", "Jump Kick",
			"Throat Punch", "Five-Finger Death Punch", "Superman Punch", "Kamehameha" };
	private String guard = "Brace";
	private String heal = "Pray";
	private int playerHP;
	private int playerMAXHP;
	private int playerStrength;
	private int playerDefense;

	public Player(int playerHP, int playerStrength, int playerDefense) {
		this.playerHP = playerHP;
		this.playerMAXHP = playerHP;
		this.playerStrength = playerStrength;
		this.playerDefense = playerDefense;
	}

	public int getHP() {
		if (playerHP < 0)
			playerHP = 0;
		return this.playerHP;
	}

	public void setHP() {
		this.playerHP = playerMAXHP;
	}

	public int getMAXHP() {
		return this.playerMAXHP;
	}

	public void takeDMG(int totalDamage) {
		playerHP -= totalDamage;
	}

	public void healHP(int heal) {
		playerHP += heal;
		if (playerHP > playerMAXHP)
			playerHP = playerMAXHP;
	}

	public String getGuard() {
		return this.guard;
	}

	public String getHeal() {
		return this.heal;
	}

	public String getAttackName() {
		Random rand = new Random();
		int randomAttack = rand.nextInt(10);
		return attacks[randomAttack];
	}

	public int getStrength() {
		return this.playerStrength;
	}

	public int getDefense() {
		return this.playerDefense;
	}
}
