import java.util.Random;

public class WaterMonster extends Monster {

	private String[] firstName = { "Frozen", "Drowned", "Salt Water", "Fresh Water", "Ice", "White", "Black Ice",
			"Freezing", "Cold", "Frost", "Sea", "Blue", "Frostback", "Icelandic", "Flooded", "Mist Covered", "Submerged", "Ice Veined",
			"Arctic", "Oceanic", "Icy", "Ice Covered", "Antarctic", "Aquarian", "Spitting", "Frosty" };
	private String fullName;
	private String[] attacks = { "Water Blast", "Freeze", "Ice Kick", "Whirlpool", "Whiteout", "Tsunami", "Assault" };
	private int[] attackMPCost = { 10, 5, 5, 20, 30, 40, 0 };
	private int[] attackBaseDMG = { 20, 10, 10, 40, 60, 80, 5 };
	private String guard = "Frozen Armor";
	private String[] buff = {"Blizzard"}; // Not being used at the moment
	private String heal = "Purification";
	private int healMPCost = 60;
	private int attack;
	private int defense;
	private int healing;

	public WaterMonster() {
		super();
		String name = buildFirstName() + " " + super.buildLastName();
		this.fullName = name;
		this.attack = (super.getInt() + super.getWis());
		this.defense = (super.getCon() + ((super.getStr() + super.getDex() + super.getInt()) / 3));
		this.healing = (super.getWis() + super.getCon());
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
	public int getHealing() {
		super.getHealing();
		return this.healing;
	}
	
	@Override
	public String getHealName() {
		return this.heal;
	}
	
	@Override
	public int getAttackBaseDMG(String attack) {
		super.getAttackBaseDMG(attack);
		int i = 0;
		while (!attack.equals(attacks[i])) {
			if (!attack.equals(attacks[i]))
				i++;
		}
		return attackBaseDMG[i];
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
	public String getAttackName(int i) {
		return attacks[i];
	}
	
	@Override
	public int rollAttack() {
		super.rollAttack();
		Random rand = new Random();
		int randomAttack = (rand.nextInt(7));
		while (super.getMP() < attackMPCost[randomAttack]) {
			randomAttack = (rand.nextInt(7));
		}
		return randomAttack;
	}

	@Override
	public void viewSingleMonster() {
		super.viewSingleMonster();
		System.out.printf(
				"%-30s %-10s %-12s %-15s %-13s %-11s %-11s %-11s %-11s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
				"Name:", "Type:", "Strength:", "Intelligence:", "Dexterity:", "Wisdom:", "Speed:", "Accuracy:",
				"Evasion:", "Constitution:", "Luck:", "Attack:", "Defense:", "Healing:", "Health:", "Mana:", "Level:");
		System.out.printf(
				"%-30s %-10s %-12s %-15s %-13s %-11s %-11s %-11s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
				fullName, getClass().getName().substring(0, 5), super.getStr(), super.getInt(), super.getDex(),
				super.getLuck(), attack, defense, super.getHP(), super.getMP(), super.getLVL());
	}

	@Override
	public void viewAllMonsters() {
		super.viewAllMonsters();
		System.out.printf(
				"%-30s %-10s %-12s %-15s %-13s %-11s %-11s %-11s %-11s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
				fullName, getClass().getName().substring(0, 5), super.getStr(), super.getInt(), super.getDex(),
				super.getWis(), super.getSpd(), super.getAcc(), super.getEva(), super.getCon(), super.getLuck(), attack,
				defense, healing, super.getHP(), super.getMP(), super.getLVL());
	}
}