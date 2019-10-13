import java.util.Random;

public class Player {
	private String[] attacks = { "Groin Punch", "Throw Rock", "Shin Kick", "Backstab", "Roundhouse", "Jump Kick",
			"Throat Punch", "Five-Finger Death Punch", "Superman Punch", "Kamehameha" };
	private String guard = "Brace";
	private String heal = "Pray";
	private String attackName;
	private int playerHP;
	private int playerMAXHP;
	private int playerStr;
	private int playerDef;
	private int playerDex;
	private int playerSpd;
	private int playerEva;
	private int playerAcc;
	private int playerLck;
	private int playerWis;
	private int playerInt;
	private int playerCon;

	public Player(int playerStrength, int playerDefense, int playerDexterity, int playerSpeed, int playerEvasion, int playerLuck, int playerAccuracy, int playerWisdom, int playerConstitution, int playerIntelligence) {
		this.playerCon = playerConstitution;
		this.playerMAXHP = playerCon * 10;
		this.playerHP = playerMAXHP;
		this.playerStr = playerStrength;
		this.playerDef = playerDefense;
		this.playerDex = playerDexterity;
		this.playerSpd = playerSpeed;
		this.playerLck = playerLuck;
		this.playerWis = playerWisdom;
		this.playerInt = playerIntelligence;
		this.playerEva = playerEvasion;
		this.playerAcc = playerAccuracy;
		
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

	public int rollAttackName() {
		Random rand = new Random();
		int randomAttack = rand.nextInt(10);
		return randomAttack;
	}
	
	public String getAttackName(int i) {
		return attacks[i];
	}

	public int getStrength() {
		return this.playerStr;
	}

	public int getDefense() {
		return this.playerDef;
	}
	
	public int getDexterity() {
		return this.playerDex;
	}
	
	public int getEvasion() {
		return this.playerEva;
	}

	public int getLuck() {
		return this.playerLck;
	}
	
	public int getSpeed() {
		return this.playerSpd;
	}

	public int getIntel() {
		return this.playerInt;
	}
	
	public int getCon() {
		return this.playerCon;
	}

	public int getWisdom() {
		return this.playerWis;
	}
	
	public int getAccuracy() {
		return this.playerAcc;
	}
	

}
