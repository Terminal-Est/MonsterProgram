import java.util.Random;

public class Monster {

	private String[] lastName = { "Cyclops", "Hawk", "Tiger", "Peluda", "Platypus", "Mammoth", "Mouse", "Leopard",
			"Ogre", "Sprite", "Goblin", "Destroyer", "Gorilla", "Phoenix", "Rat", "Kangaroo", "Dodo", "Ghost", "Keresh",
			"Balayang", "Tjinimin", "Callisto", "Vetalu", "Bennu", "Griffin", "Devil", "Tengu", "Penguin", "Lion",
			"Chimera", "Minotaur", "Hellhound", "Amarok", "Cerberus", "Fenrir", "Monkey", "Werewolf", "Hippogriff",
			"Sleipnir", "Pegasus", "Unicorn", "Manticore", "Spirit", "Drop Bear", "Bunyip", "Behemoth", "Boar", "Yeti",
			"Yowie", "Dragon", "Rainbow Serpent", "Serpent", "Moon Rabbit", "Bigfoot", "Jackalope", "Rat King", "Sobek",
			"Basilisk", "Cockatrice", "Death Worm", "Spider", "Funnel-Web", "Wyvern", "Hydra", "Ouroboros", "Echidna",
			"Golem", "Homunculus", "Chupacabra", "Gorgon", "Dullahan", "Skin-Walker", "Vampire", "Ratatoskr", "Banshee",
			"Dwarf", "Siren", "Nightmare", "Gremlin", "Demon", "Valkyrie", "Elemental", "Troll", "Mountain Giant",
			"Leviathan", "Werejaguar", "Vermilion Bird", "Mandrake", "Ghoul", "Poltergeist", "Salamander", "Lizard",
			"Popobawa", "Gargoyle", "Charybdis", "Demon Lord", "Arachnid", "Pest", "Floating Glyph" };
	private String createdName;
	private int str;
	private int intel;
	private int dex;
	private int hp;
	private int maxHP;
	private int maxMP;
	private int mp;
	private int lvl;

	public Monster() {
		int randomLVLgen = (int) (Math.random() * ((20 - 1)) + 1);
		if (randomLVLgen <= 8) {
			this.lvl = 1;
		}
		else if (randomLVLgen > 8 && randomLVLgen < 14) {
			this.lvl = 2;
		}
		else if (randomLVLgen >= 14 && randomLVLgen <= 18) {
			this.lvl = 3;
		}
		else if (randomLVLgen == 19) {
			this.lvl = 4;
		}
		else if (randomLVLgen == 20) {
			this.lvl = 5;
		}
		this.str = (int) (Math.random() * (20 - 15) + 15) * lvl;
		this.intel = (int) (Math.random() * (20 - 15) + 15) * lvl;
		this.dex = (int) (Math.random() * (20 - 15) + 15) * lvl;
		this.maxHP = (int) (Math.random() * (150 - 125) + 125) * lvl;
		this.maxMP = (int) (Math.random() * (150 - 125) + 125) * lvl;
		this.hp = maxHP;
		this.mp = maxMP;
	}

	public void setCreatedMonsterName(String name) {

	}
	
	public String buildLastName() {
		int randomInt;
		randomInt = 0 + (int) (Math.random() * ((lastName.length - 0) + 0));
		String randomName = lastName[randomInt];
		return randomName;
	}

	public void takeDMG(int totalDamage) {
		hp -= totalDamage;
		if (hp < 0)
			this.hp = 0;
	}

	public void healHP(int heal) {
		hp += heal;
		if (hp > maxHP)
			this.hp = maxHP;
	}

	public void viewSingleMonster() {
	}

	public void viewAllMonsters() {
	}

	public String getLastName() {
		return "";
	}

	public String getName() {
		return "";
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
	
	public int getMAXMP() {
		return this.maxMP;
	}

	public void resetHP() {
		this.hp = maxHP;
	}

	public int getMP() {
		return this.mp;
	}

	public void resetMP() {
		this.mp = maxMP;
	}

	public void regenMP() {
		if (mp != maxMP)
			this.mp++;
	}

	public void useMP(int mp) {
		this.mp -= mp;
	}

	public int getLVL() {
		return this.lvl;
	}

	public int getAttack() {
		return 0;
	}

	public int getDefense() {
		return 0;
	}

	public String getAttackName() {
		return "";
	}

	public int getAttackMPCost(String attack) {
		return 0;
	}

	public String getGuard() {
		return "";
	}

}
