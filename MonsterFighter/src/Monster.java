
public class Monster {

	private String name;
	private double str;
	private double intel;
	private double dex;
	private int hp;
	private int mp;
	private int lvl;

	public Monster(String name, double str, double intel, double dex, int hp, int mp, int lvl) {
		this.name = name;
		this.str = str;
		this.intel = intel;
		this.dex = dex;
		this.hp = hp;
		this.mp = mp;
		this.lvl = lvl;
	}

	public String setName(String name) {
		this.name = name;
		return name;
	}

	public double setStr(double strength) {
		this.str = strength;
		return strength;
	}

	public double setInt(double intelligence) {
		this.intel = intelligence;
		return intelligence;
	}

	public double setDex(double dexterity) {
		this.dex = dexterity;
		return dexterity;
	}

	public int setHp(int health) {
		this.hp = health;
		return health;
	}
	
	public int setMp(int mp) {
		this.mp = mp;
		return mp;
	}

	public int setLvl(int level) {
		this.lvl = level;
		return level;
	}

}
