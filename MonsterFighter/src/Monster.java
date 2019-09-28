
public class Monster {

	private int str;
	private int intel;
	private int dex;
	private int hp;

	public Monster(int str, int intel, int dex, int hp) {
		this.str = str;
		this.intel = intel;
		this.dex = dex;
		this.hp = hp;
	}
	
	public int setStr(int strength) {
		this.str = strength;
		return strength;
	}
	
	public int setInt(int intelligence) {
		this.intel = intelligence;
		return intelligence;
	}
	
	public int setDex(int dexterity) {
		this.dex = dexterity;
		return dexterity;
	}
	
	public int setHp(int health) {
		this.hp = health;
		return health;
	}

}
