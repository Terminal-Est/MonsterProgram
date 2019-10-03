import java.util.Random;
import java.util.Scanner;

public class MonsterFighter {

	private static Scanner sc;
	private static int count;
	private static Monster[] monsters;
	private static Player p = new Player(100,30,30);

	public static void main(String[] args) {
		monsters = new Monster[20];
		sc = new Scanner(System.in);
		count = 0;
		String select;
		print("\nEnter your selection!" + "\n1 - Create a Monster" + "\n2 - Fill Monsters" + "\n3 - Fight Random Monster" + "\n4 - View a specific Monster"
				+ "\n5 - View all Monsters" + "\n6 - Exit\nWhat do you choose?: ");
		select = sc.next();
		while (select != "6") {
			switch (select) {
			case "1":
				createMonster();
				break;
			case "2":
				fillMonsters(); // Temporary choice merely to fill all possible elements in the array.
				print("Monsters Filled!\n");
				break;
			case "3":
				fightMonster();
				break;
			case "4":
				viewSingleMonster();
				break;
			case "5":
				viewAllMonsters();
				break;
			default:
				print("\nIncorrect option\n");
				break;
			}
			print("\nEnter your selection!" + "\n1 - Create a Monster" + "\n2 - Fill Monsters" + "\n3 - Fight Random Monster" + "\n4 - View a specific Monster"
					+ "\n5 - View all Monsters" + "\n6 - Exit\nWhat do you choose?: ");
			select = sc.next();
		}
		print("Exiting the game...");
	}

	private static void createMonster() {
		String name = "";
		String select = "";
		int str = 0;
		int intel = 0;
		int dex = 0;
		int hp = 100;
		int mp = 100;
		int lvl = 1;
		if (count == monsters.length) {
			print("Monster roster full!\n");
		} else {
			print("\nEnter Monster name: ");
			name = sc.next();
			print("\nRoll for STRENGTH!");
			str = 1 + (int)(Math.random() * ((20 - 1) + 1)); // (MAX-MIN) made min 1 so zero was not obtainable.
			print("\nStrength is: " + str);
			print("\nRoll for INTELLIGENCE!");
			intel = 1 + (int)(Math.random() * ((20 - 1) + 1)); // (MAX-MIN) made min 1 so zero was not obtainable.
			print("\nIntelligence is: " + intel);
			print("\nRoll for DEXTERITY!");
			dex = 1 + (int)(Math.random() * ((20 - 1) + 1)); // (MAX-MIN) made min 1 so zero was not obtainable.
			print("\nDexterity is: " + dex);
			print("\nMonster HP is: " + hp);
			print("\nMonster MP is: " + mp);
			print("\nMonster Level is: " + lvl);
			monsters[count] = new Monster(name, str, intel, dex, hp, mp, lvl);
			print("\n\nSelect Monster type!" + "\n1 - Fire Monster, combines STRENGTH and DEXTERITY!"
				+ "\n2 - Water Monster, combines DEXTERITY and INTELLIGENCE!"
				+ "\n3 - Thunder Monster, combines INTELLIGENCE and STRENGTH!" + "\nEnter selection: ");
			select = sc.next();
			if (!select.isEmpty()) {
				switch (select) {
				case "1":
					print("\nFire Monster selected!");
					monsters[count] = new FireMonster(name, str, intel, dex, hp, mp, lvl);
					count++;
					break;
				case "2":
					print("\nWater Monster selected!");
					monsters[count] = new WaterMonster(name, str, intel, dex, hp, mp, lvl);
					count++;
					break;
				case "3":
					print("\nThunder Monster selected!");
					monsters[count] = new ThunderMonster(name, str, intel, dex, hp, mp, lvl);
					count++;
					break;
				default:
					print("\nIncorrect option\n");
				}
			}
		}
	}
	
	public static void fillMonsters() {
		String name = "";
		int str = 0;
		int intel = 0;
		int dex = 0;
		int hp = 100;
		int mp = 100;
		int lvl = 1;
		int type = 0;
		if (count < monsters.length) {
			while (count < monsters.length) {
				name = "Monster " + (count + 1);
				str = 1 + (int)(Math.random() * ((20 - 1) + 1)); // (MAX-MIN) made min 1 so zero was not obtainable.
				intel = 1 + (int)(Math.random() * ((20 - 1) + 1)); //(MAX-MIN) made min 1 so zero was not obtainable.
				dex = 1 + (int)(Math.random() * ((20 - 1) + 1)); //(MAX-MIN) made min 1 so zero was not obtainable.
				type = 1 + (int)(Math.random() * ((3 - 1) + 1));
				switch (type) {
					case 1:
						monsters[count] = new FireMonster(name, str, intel, dex, hp, mp, lvl);
						break;
					case 2:
						monsters[count] = new WaterMonster(name, str, intel, dex, hp, mp, lvl);
						break;
					case 3:
						monsters[count] = new ThunderMonster(name, str, intel, dex, hp, mp, lvl);
						break;
				}
				count++;
			}
		} else {
			print("Monster roster full!\n");
		}
			
	}
	
	public static void fightMonster() {
			int randomMonster = 0 + (int)(Math.random() * ((19 - 0) + 0));
			String output = "\nYOU ARE FIGHTING:\n";
			output += "Monster Name: " + monsters[randomMonster].getName() + "\n";
			output += "Monster Level: " + monsters[randomMonster].getLVL() + "\n";
			output += "Monster Attack: " + monsters[randomMonster].getAttack() + "\n";
			output += "Monster Defense: " + monsters[randomMonster].getDefense() + "\n";
			output += "Monster Health: " + monsters[randomMonster].getHP() + "\n";
			output += "Monster Mana: " + monsters[randomMonster].getMP() + "\n";
			output += "\n";
			print(output);

		do {
			int choice = Prompt();
			switch (choice) {
			case 1:
				fight(randomMonster);
				break;
			case 2:
				heal(randomMonster);
				break;
			case 3:
				defend(randomMonster);
				break;
			}
			print("Monster Health Remaining: " + monsters[randomMonster].getHP() + "\n");
			print("Player Health Remaining: " + p.getHP() + "\n");
		} while (!(p.getHP() <= 0) && !(monsters[randomMonster].getHP() <= 0));
		if(p.getHP()<=0)
			print("You have been defeated!\n");
		else if (monsters[randomMonster].getHP()<=0)
			print("You have defeated the monster!\n"); 
		else
			print("As your blows land, you both crumple on the ground. Its a draw!\n");
		resetHP(randomMonster); // Resets player and monster HP after battle
	}
	
	private static void defend(int randomMonster) {
		int choice = getChoice();
		int defenseRoll;
		int monDamage;
		switch (choice) {
		case 1:
			monDamage = getMonsterRoll(1, randomMonster);
			defenseRoll = getPlayerRoll(2);
			int totalDamage = monDamage - defenseRoll;
			print("You decide to " + p.getGuard() + ".\n");
			if (totalDamage <= 0) {
				print(monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + ".\n");
				print("Your " + p.getGuard() + " negates the monsters attack completely.\n");
			} else {
				print(monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + ".\n");
				print("The monsters attack is too much causing you " + (totalDamage) + " damage.\n");
				p.takeDMG(totalDamage);
			}
			break;
		case 2:
			print("The monster uses " + monsters[randomMonster].getGuard() + ".\n");
			print("The monster defends against your attack which never comes.\n");
			break;

			// Removed the monsters ability to heal, can create a healing skill.
			
		/*
		 * case 3:
		 * print("As you prepare to defend against an attack, the monster heals.\n");
		 * getMonsterRoll(3, randomMonster); break;
		 */
		}
	}

	private static void heal(int randomMonster) {
		int choice = getChoice();
		int healRoll;
		int monDamage;
		switch (choice) {
		case 1:
			monDamage = getMonsterRoll(1, randomMonster);
			p.takeDMG(monDamage);
			if (p.getHP() <= 0)
				break;
			else {
				healRoll = getPlayerRoll(3);
				print(monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + " for "+ monDamage + " points of damage.\n");
				print("You survive and " + p.getHeal() + " for " + healRoll + " health.\n");
				p.healHP(healRoll);
				break;
			}
		case 2:
			print("The monster uses " + monsters[randomMonster].getGuard() + ".\n");
			print("The monster defends against your attack which never comes.\n");
			healRoll = getPlayerRoll(3);
			p.healHP(healRoll);
			print("You take the opportunity to " + p.getHeal() + " and regain " + healRoll + " health.\n");
			break;

			// Removed the monsters ability to heal, can create a healing skill.
			
		/*
		 * case 3: healRoll = getPlayerRoll(3);
		 * print("The monster decides to heal as well!\n"); print("You heal for " +
		 * healRoll + "\n"); monsters[randomMonster].healHP(getMonsterRoll(3,
		 * randomMonster)); break;
		 */
		}

	}

	private static void fight(int randomMonster) {
		int choice = getChoice();
		int damageRoll;
		int monDamage;
		switch (choice) {
		case 1:
			monDamage = getMonsterRoll(1, randomMonster);
			p.takeDMG(monDamage);
			damageRoll = getPlayerRoll(1);
			monsters[randomMonster].takeDMG(damageRoll);
			print("You both attack each other at the same time!\n");
			print("You decide to " + p.getAttackName() + " for " + damageRoll + " points of damage.\n");
			print(monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + " for "+ monDamage + " points of damage.\n");
			break;

		case 2:
			print("As you attack the monster uses " + monsters[randomMonster].getGuard() + ".\n");
			damageRoll = getPlayerRoll(1);
			int monDefense = getMonsterRoll(2, randomMonster);
			int totaldamage = damageRoll - monDefense;
			if (totaldamage > 0) {
				print("You managed to defeat the monsters " + monsters[randomMonster].getGuard() + " and deal " + totaldamage + " damage.\n");
				monsters[randomMonster].takeDMG(totaldamage);
			} else
				print("The monsters " + monsters[randomMonster].getGuard() + " was impenetrable!\n");
			System.out.println();
			break;
			
			// Removed the monsters ability to heal, can create a healing skill.
			
		/*
		 * case 3: damageRoll = getPlayerRoll(1);
		 * print("As you attack the monster heals!\n"); print("You hit for " +
		 * damageRoll + "\n"); if (monsters[randomMonster].getHP() <= 0) break; else
		 * getMonsterRoll(3, randomMonster); break;
		 */
		}
	}

	public static int getChoice() {
		int choice;
		Random rand = new Random();
		choice = (rand.nextInt(2)) + 1;
		return choice;
	}
	
	public static int getMonsterRoll(int Option, int randomMonster) {
		Random rand = new Random();
		int roll = 0;
		switch (Option) {
		case 1:
			roll = (rand.nextInt(monsters[randomMonster].getAttack())) + 1;
			return roll;
		case 2:
			roll = (rand.nextInt(monsters[randomMonster].getDefense())) + 1;
			return roll;
		case 3:
			roll = (rand.nextInt((monsters[randomMonster].getMAXHP()) / 2)) + 1;
			return roll;
		default:
			return roll;
		}
	}
	
	private static int getPlayerRoll(int Option) {
		Random rand = new Random();
		int roll = 0;
		switch (Option) {
		case 1:
			roll = (rand.nextInt(p.getStrength())) + 1;
			return roll;
		case 2:
			roll = (rand.nextInt(p.getDefense())) + 1;
			return roll;
		case 3:
			roll = (rand.nextInt((p.getMAXHP()) / 2)) + 1;
			return roll;
		default:
			return roll;
		}

	}

	private static int Prompt() {
		String output = "";
		output += "What do you choose to do?\n";
		output += "1 - FIGHT\n";
		output += "2 - HEAL\n";
		output += "3 - DEFEND\n";
		output += "Make your choice:\n";
		print(output);
		int choice = sc.nextInt();
		return choice;
	}
	
	public static void resetHP(int randomMonster) {
		p.setHP();
		monsters[randomMonster].setHP();
	}

	public static void viewSingleMonster() {
		int monsterNum;
		print("Which monster would you like to view? (Enter array location):");
		monsterNum = sc.nextInt();
		monsters[monsterNum].viewSingleMonster();
	}
	
	public static void viewAllMonsters() {
		String output = "\n";
		output += String.format("%-15s %-10s %-12s %-15s %-13s %-10s %-10s %-10s%-10s %-10s%n", "Name:", "Type:", "Strength:", "Intelligence:", "Dexterity:", "Attack:", "Defense:", "Health:", "Mana:", "Level:");
		print(output);
		for (int i = 0; i < count; i++) {
			monsters[i].viewAllMonsters();
		}
	}
	
	private static String print(String input) {
		System.out.print(input);
		return input;
	}
}
