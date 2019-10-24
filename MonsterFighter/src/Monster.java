import java.util.Random;

public abstract class Monster {

	// Main monster class, all monsters start with 100 HP, 100 MP and at lvl 1.
	// These values are created at compilation and are final..
	protected static final double HP = 100;
	protected static final double MP = 100;
	protected static final int LVL = 1;
	protected static Random rand;

	public Monster(String name, double str, double intel, double dex) {
		rand = new Random();

	}
	
	public abstract void showMonster();
	
	public abstract String getName();
	
	public abstract void setStats();
	
}
