import java.util.Random;

public class FireMonster extends Monster {

	private String[] firstName = { "Fiery", "Blazing", "Volcanic", "Charred", "Cindered", "Flaming", "Molten", "Red",
			"Barbecued", "Crackling", "Hot", "Amber", "Igniting", "Roasted", "Smoking", "Ashed", "White-Hot", "Cooked",
			"Conflagrating", "Fire", "Sun", "Solar", "Raging", "Steaming", "Steamy", "Rabid", "Thermal" };
	private String fullName;
	private String[] attacks = {"Flame Jet", "Fire Punch", "Fire Kick", "Flaming Slash", "Fire Breath", "Ignite", "Maul"};
	private int[] attackMPCost = {10,5,5,20,30,40,0};
	private String guard = "Molten Armor";
	private int attack;
	private int defense;

	public FireMonster() {
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
		randomInt = 0 + (int)(Math.random() * ((firstName.length - 0) + 0));
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
				getClass().getName().substring(0, 4), super.getStr(), super.getInt(), super.getDex(), attack, defense,
				super.getHP(), super.getMP(), super.getLVL());
	}

	@Override
	public void viewAllMonsters() {
		super.viewAllMonsters();
		System.out.printf("%-30s %-10s %-12s %-15s %-13s %-10s %-10s %-10s %-10s %-10s%n", fullName,
				getClass().getName().substring(0, 4), super.getStr(), super.getInt(), super.getDex(), attack, defense,
				super.getHP(), super.getMP(), super.getLVL());
	}
}
