import java.util.Random;

public class ThunderMonster extends Monster {

	private String[] firstName = { "Charged", "Thunderous", "Yellow", "Lightning", "Electric", "Wired", "Arcing",
			"Magnetic", "Energised", "Overcharged", "Rewired", "Shock", "Shocking", "Surging", "Negatively Charged",
			"Positively Charged", "Electrical", "Watt Absorbing", "Power Hungry", "Static", "Bright", "Luminescent"};
	private String fullName;
	private String[] attacks = { "Spark", "Lightning Punch", "Electric Kick", "Zap", "Discharge", "Thunderstorm",
			"Maul" };
	private int[] attackMPCost = { 10, 5, 5, 20, 30, 40, 0 };
	private String guard = "Charged Armor";
	private int attack;
	private int defense;

	public ThunderMonster() {
		super();
		String name = buildFirstName() + " " + super.buildLastName();
		this.fullName = name;
		this.attack = (super.getStr() + super.getDex());
		this.defense = (super.getInt() + super.getStr() + super.getDex());
	}

	@Override
	public void setCreatedMonsterName(String name) {
		this.fullName = name;
	}
	
	public String buildFirstName() {
		int randomInt;
		randomInt = 0 + (int) (Math.random() * ((firstName.length - 0) + 0));
		String randomName = firstName[randomInt];
		return randomName;
	}

	@Override
	public String getName() {
		super.getName();
		return this.fullName;
	}

	@Override
	public int getAttack() {
		super.getAttack();
		return this.attack;
	}

	@Override
	public int getAttackMPCost(String attack) {
		super.getAttackMPCost(attack);
		int i = 0;
		while (!attack.equals(attacks[i])) {
			if (!attack.equals(attacks[i]))
				i++;
		}
		return attackMPCost[i];
	}

	@Override
	public int getDefense() {
		super.getDefense();
		return this.defense;
	}

	@Override
	public String getGuard() {
		return this.guard;
	}

	@Override
	public String getAttackName() {
		super.getAttackName();
		Random rand = new Random();
		int randomAttack = (rand.nextInt(7));
		while (super.getMP() < attackMPCost[randomAttack]) {
			randomAttack = (rand.nextInt(7));
		}

		return this.attacks[randomAttack];
	}

	@Override
	public void viewSingleMonster() {
		super.viewSingleMonster();
		System.out.printf("%-30s %-10s %-12s %-15s %-13s %-10s %-10s %-10s %-10s %-10s%n", "Name:", "Type:",
				"Strength:", "Intelligence:", "Dexterity:", "Attack:", "Defense:", "Health:", "Mana:", "Level:");
		System.out.printf("%-30s %-10s %-12s %-15s %-13s %-10s %-10s %-10s %-10s %-10s%n", fullName,
				getClass().getName().substring(0, 7), super.getStr(), super.getInt(), super.getDex(), attack, defense,
				super.getHP(), super.getMP(), super.getLVL());
	}

	@Override
	public void viewAllMonsters() {
		super.viewAllMonsters();
		System.out.printf("%-30s %-10s %-12s %-15s %-13s %-10s %-10s %-10s %-10s %-10s%n", fullName,
				getClass().getName().substring(0, 7), super.getStr(), super.getInt(), super.getDex(), attack, defense,
				super.getHP(), super.getMP(), super.getLVL());
	}
}
