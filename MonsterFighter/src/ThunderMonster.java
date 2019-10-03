import java.util.Random;

public class ThunderMonster extends Monster {
	
	private String attack1 = "Spark";
	private String attack2 = "Lightning Punch";
	private String guard = "Charged Armor";
	private int attack;
	private int defense;

	public ThunderMonster(String name, int str, int intel, int dex, int hp, int mp, int lvl) {
		super(name, str, intel, dex, hp, mp, lvl);
		this.attack = intel + str;
		this.defense = intel + str + dex;
	}

	@Override
	public int getAttack() {
		super.getAttack();
		return attack;
	}
	
	@Override
	public int getDefense() {
		super.getDefense();
		return defense;
	}
	
	@Override
	public String getGuard() {
		return this.guard;
	}
	
	@Override
	public String getAttackName() {
		Random rand = new Random();
		int randomAttack = (rand.nextInt(2)) + 1;
		if (randomAttack == 2)
			return this.attack2;
		else
			return this.attack1;
	}
	
	@Override
	public void viewSingleMonster() {
		super.viewSingleMonster();
		System.out.printf("%-15s %-10s %-12s %-15s %-13s %-10s %-10s %-10s %-10s %-10s%n", "Name:", "Type:", "Strength:", "Intelligence:", "Dexterity:", "Attack:", "Defense:", "Health:", "Mana:", "Level:");
		System.out.printf("%-15s %-10s %-12s %-15s %-13s %-10s %-10s %-10s %-10s %-10s%n", super.getName(), getClass().getName().substring(0, 7), super.getStr(), super.getInt(), super.getDex(), attack, defense, super.getHP(), super.getMP(), super.getLVL());
	}

	@Override
	public void viewAllMonsters() {
		super.viewAllMonsters();
		System.out.printf("%-15s %-10s %-12s %-15s %-13s %-10s %-10s %-10s %-10s %-10s%n", super.getName(), getClass().getName().substring(0, 7), super.getStr(), super.getInt(), super.getDex(), attack, defense, super.getHP(), super.getMP(), super.getLVL());
	}
	
}