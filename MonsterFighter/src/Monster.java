import java.util.Random;

public class Monster {

	private String[] lastName = { "Cyclops", "Hawk", "Soul Devourer", "Tiger", "Peluda", "Platypus", "Mammoth",
			"Draugr", "Leopard", "Ogre", "Sprite", "Goblin", "Destroyer", "Witch", "Phoenix", "Rat", "Giant Kangaroo",
			"Dodo", "Ghost", "Keresh", "Balayang", "Tjinimin", "Callisto", "Vetalu", "Bennu", "Nightmare", "Nymph",
			"Guardian", "Griffin", "Devil", "Tengu", "Penguin", "Lion", "Chimera", "Minotaur", "Revenant",
			"Sabre-Tooth Tiger", "Unknown Creature", "Hellhound", "Amarok", "Ancient", "Cerberus", "Fenrir", "Wraith",
			"Monkey King", "Werewolf", "Hippogriff", "Sleipnir", "Pegasus", "Scylla", "Centaur", "Unicorn",
			"Cursed Remains", "Soul Eater", "Manticore", "Spirit", "Drop Bear", "Bunyip", "Behemoth", "Boar", "Yeti",
			"Yowie", "Dragon", "Shade", "Harpy", "Undead", "Rainbow Serpent", "Serpent", "Moon Rabbit", "Bigfoot",
			"Jackalope", "Rat King", "Sobek", "Basilisk", "Cockatrice", "Death Worm", "Death Eater", "Funnel-Web",
			"Fiend", "Wyvern", "Hydra", "Ouroboros", "Giant Echidna", "Golem", "Homunculus", "Chupacabra", "Gorgon",
			"Dullahan", "Skin-Walker", "Vampire", "Ratatoskr", "Banshee", "Dwarf", "Siren", "Nightmare", "Gremlin",
			"Demon", "Valkyrie", "Elemental", "Troll", "Mountain Giant", "Leviathan", "Werejaguar", "Vermilion Bird",
			"Mandrake", "Ghoul", "Poltergeist", "Gargoyle", "Charybdis", "Demon Lord", "Arachnid", "Pest",
			"Floating Glyph", "Wyrm" };
	private String createdName;
	private int str;
	private int intel;
	private int dex;
	private int luck;
	private int spd;
	private int eva;
	private int acc;
	private int wis;
	private int con;
	private int hp;
	private int maxHP;
	private int maxMP;
	private int mp;
	private int lvl;

	public Monster() {
		int randomLVLgen = (int) (Math.random() * ((20 - 1)) + 1);
		if (randomLVLgen <= 8) {
			this.lvl = 1;
		} else if (randomLVLgen > 8 && randomLVLgen < 14) {
			this.lvl = 2;
		} else if (randomLVLgen >= 14 && randomLVLgen <= 18) {
			this.lvl = 3;
		} else if (randomLVLgen == 19) {
			this.lvl = 4;
		} else if (randomLVLgen == 20) {
			this.lvl = 5;
		}
		this.str = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.intel = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.dex = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.eva = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.spd = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.wis = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.con = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.acc = (int) (Math.random() * (20 - 17) + 17) * lvl;
		this.luck = (int) (Math.random() * (10 - 8) + 8) * lvl;
		this.maxHP = (int) (Math.random() * (150 - 125) + 125 + con) * lvl;
		this.maxMP = (int) (Math.random() * (150 - 125) + 125 + wis) * lvl;
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
	
	public String getHealName() {
		return "";
	}
	
	public int getHealing() {
		return 0;
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

	public int getLuck() {
		return this.luck;
	}
	
	public int getEva() {
		return this.eva;
	}
	
	public int getSpd() {
		return this.spd;
	}
	
	public int getWis() {
		return this.wis;
	}
	
	public int getCon() {
		return this.con;
	}
	
	public int getAcc() {
		return this.acc;
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

	public int rollAttack() {
		return 0;
	}
	
	public String getAttackName(int i) {
		return "";
	}
	
	public int getAttackBaseDMG(String attack) {
		return 0;
	}

	public int getAttackMPCost(String attack) {
		return 0;
	}

	public String getGuard() {
		return "";
	}

}
