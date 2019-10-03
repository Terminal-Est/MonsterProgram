import java.util.Random;

public class Monster {

	private String name;
	private int str;
	private int intel;
	private int dex;
	private int hp;
	private int maxHP;
	private int mp;
	private int lvl;

	public Monster(String name, int str, int intel, int dex, int hp, int mp, int lvl) {
		this.name = name;
		this.str = str;
		this.intel = intel;
		this.dex = dex;
		this.hp = hp;
		this.maxHP = hp;
		this.mp = mp;
		this.lvl = lvl;
	}
	
	public void takeDMG(int totalDamage) {
		hp -= totalDamage;
		if (hp < 0)
			hp = 0;
	}
	
	public void healHP(int heal) {
		hp += heal;
		if (hp > maxHP)
			hp = maxHP;
	}
	
	public void viewSingleMonster() {
	}
	
	public void viewAllMonsters() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getStr() {
		return this.str;
	}
	
	public int getDex() {
		return this.dex;
	}
	
	public int getInt() {
		return this.intel;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public int getMAXHP() {
		return this.maxHP;
	}
	
	public void setHP() {
		this.hp = maxHP;
	}
	
	public int getMP() {
		return this.mp;
	}
	
	public int getLVL() {
		return this.lvl;
	}
	
	public int getAttack() {
		int attack = 0;
		return attack;
	}
	
	public int getDefense() {
		int defense = 0;
		return defense;
	}
	
	public String getAttackName() {
		return "";
	}
	
	public String getGuard() {
		return "";
	}
	
}
