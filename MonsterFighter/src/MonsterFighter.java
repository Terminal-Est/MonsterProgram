import java.util.Random;
import java.util.Scanner;

public class MonsterFighter {

	private static Scanner sc;
	private static int count;
	private static Monster[] monsters;
	private static Player p = new Player(200,50,50);

	public static void main(String[] args) {
		monsters = new Monster[20];
		sc = new Scanner(System.in);
		count = 0;
		String select;
		print("\nEnter your selection!" + "\n1 - Create a Monster" + "\n2 - Fill Monsters" + "\n3 - Fight Random Monster" + "\n4 - View a specific Monster"
				+ "\n5 - View all Monsters" + "\n6 - Exit\nWhat do you choose?: ");
		select = sc.nextLine();
		while (!select.isEmpty() && Integer.parseInt(select) != 6) {
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
			if (Integer.parseInt(select) != 6) {
				print("\nEnter your selection!" + "\n1 - Create a Monster" + "\n2 - Fill Monsters" + "\n3 - Fight Random Monster" + "\n4 - View a specific Monster"
					+ "\n5 - View all Monsters" + "\n6 - Exit\nWhat do you choose?: ");
				select = sc.next();
			}
		}
		print("Exiting the game...");
	}

	private static void createMonster() {
		String name = "";
		String select = "";
		if (count == monsters.length) {
			print("Monster roster full!\n");
		} else {
			print("\nEnter Monster name: ");
			name = sc.nextLine();
			monsters[count] = new Monster();
			print("\n\nSelect Monster type!" + "\n1 - Fire Monster, combines STRENGTH and DEXTERITY!"
				+ "\n2 - Water Monster, combines DEXTERITY and INTELLIGENCE!"
				+ "\n3 - Thunder Monster, combines INTELLIGENCE and STRENGTH!" + "\nEnter selection: ");
			select = sc.nextLine();
			if (!select.isEmpty()) {
				switch (select) {
				case "1":
					print("\nFire Monster selected!");
					monsters[count] = new FireMonster();
					break;
				case "2":
					print("\nWater Monster selected!");
					monsters[count] = new WaterMonster();
					break;
				case "3":
					print("\nThunder Monster selected!");
					monsters[count] = new ThunderMonster();
					break;
				default:
					print("\nIncorrect option\n");
				}
				monsters[count].setCreatedMonsterName(name);
				print("\nMonster Name is: " + monsters[count].getName());
				print("\nMonster Type is: ");
				switch (monsters[count].getClass().getName().substring(0, 1)) {
					case "F":
						print("Fire");
						break;
					case "W":
						print("Water");
						break;
					case "T":
						print("Thunder");
						break;
					default:
						print("No Type");
				}
				print("\nMonster Strength is: " + monsters[count].getStr());
				print("\nMonster Intelligence is: " + monsters[count].getInt());
				print("\nMonster Dexterity is: " + monsters[count].getDex());
				print("\nMonster Attack is: " + monsters[count].getAttack());
				print("\nMonster Defense is: " + monsters[count].getDefense());
				print("\nMonster HP is: " + monsters[count].getMAXHP());
				print("\nMonster MP is: " + monsters[count].getMAXMP());
				print("\nMonster Level is: " + monsters[count].getLVL());
				count++;
			}
		}
	}
	
	public static void fillMonsters() {
		int type = 0;
		if (count < monsters.length) {
			while (count < monsters.length) {
				type = 1 + (int)(Math.random() * ((3 - 1) + 1));
				switch (type) {
					case 1:
						monsters[count] = new FireMonster();
						break;
					case 2:
						monsters[count] = new WaterMonster();
						break;
					case 3:
						monsters[count] = new ThunderMonster();
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
			monsters[randomMonster].regenMP();
			print(monsters[randomMonster].getName() + " Health Remaining: " + monsters[randomMonster].getHP() + "\n");
			print("Player Health Remaining: " + p.getHP() + "\n\n");
		} while (!(p.getHP() <= 0) && !(monsters[randomMonster].getHP() <= 0));
		if(p.getHP()<=0)
			print("You have been defeated!\n");
		else if (monsters[randomMonster].getHP()<=0)
			print("You have defeated the " + monsters[randomMonster].getName() + "!\n"); 
		else
			print("As your blows land, you both crumple on the ground. Its a draw!\n");
		resetHP(randomMonster); // Resets player and monster HP after battle
	}
	
	private static void defend(int randomMonster) {
		int choice = getChoice();
		int defenseRoll;
		int monDamage;
		if (choice > 2) {
			monDamage = getMonsterRoll(1, randomMonster);
			defenseRoll = getPlayerRoll(2);
			int totalDamage = monDamage - defenseRoll;
			print("You decide to " + p.getGuard() + ".\n");
			if (totalDamage <= 0) {
				print("The "+ monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + ".\n");
				monsters[randomMonster].useMP(monsters[randomMonster].getAttackMPCost(monsters[randomMonster].getAttackName()));
				print("Your " + p.getGuard() + " negates the monsters attack completely.\n");
			} else {
				print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + ".\n");
				print("The " + monsters[randomMonster].getName() + "'s " + monsters[randomMonster].getAttackName() + " is too much causing you " + (totalDamage) + " damage.\n");
				p.takeDMG(totalDamage);
			}
		}else {
			print("The monster uses " + monsters[randomMonster].getGuard() + ".\n");
			print("The monster defends against your attack which never comes.\n");

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
		if (choice > 2) {
			monDamage = getMonsterRoll(1, randomMonster);
			p.takeDMG(monDamage);
			if (!(p.getHP() <= 0)) {
				healRoll = getPlayerRoll(3);
				print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + " for "+ monDamage + " points of damage.\n");
				print("You survive and " + p.getHeal() + " for " + healRoll + " health.\n");
				p.healHP(healRoll);
			}
			else {
				print("The " + monsters[randomMonster].getName() + " attacks before you can heal.\n");
				print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + " for "+ monDamage + " points of damage.\n");
			}
		}else {
			print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getGuard() + ".\n");
			print("The " + monsters[randomMonster].getName() + " defends against your attack which never comes.\n");
			healRoll = getPlayerRoll(3);
			p.healHP(healRoll);
			print("You take the opportunity to " + p.getHeal() + " and regain " + healRoll + " health.\n");

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
		if (choice > 2) {
			monDamage = getMonsterRoll(1, randomMonster);
			p.takeDMG(monDamage);
			damageRoll = getPlayerRoll(1);
			monsters[randomMonster].takeDMG(damageRoll);
			print("You both attack each other at the same time!\n");
			print("You decide to execute a " + p.getAttackName() + " for " + damageRoll + " points of damage.\n");
			print("The "+ monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getAttackName() + " for "+ monDamage + " points of damage.\n");
		} else {
			print("As you attack the monster uses " + monsters[randomMonster].getGuard() + ".\n");
			damageRoll = getPlayerRoll(1);
			int monDefense = getMonsterRoll(2, randomMonster);
			int totaldamage = damageRoll - monDefense;
			if (totaldamage > 0) {
				print("You managed to defeat the " + monsters[randomMonster].getName() + "'s " + monsters[randomMonster].getGuard() + " and deal " + totaldamage + " damage.\n");
				monsters[randomMonster].takeDMG(totaldamage);
			} else
				print("The " + monsters[randomMonster].getName() + "'s " + monsters[randomMonster].getGuard() + " was impenetrable!\n");
			System.out.println();
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
		choice = (rand.nextInt(10)) + 1;
		return choice;
	}
	
	public static int getMonsterRoll(int Option, int randomMonster) {
		Random rand = new Random();
		int roll = 0;
		int min = 0, max = 0;
		switch (Option) {
		case 1:
			min = (monsters[randomMonster].getAttack() - 10);
			max = (monsters[randomMonster].getAttack() + 10);
			roll = (int) (Math.random() * (max - min) + min);
			return roll;
		case 2:
			min = (monsters[randomMonster].getDefense() - 10);
			max = (monsters[randomMonster].getDefense() + 10);
			roll = (int) (Math.random() * (max - min) + min);
			return roll;
		case 3:
			min = (monsters[randomMonster].getInt() - 10);
			max = (monsters[randomMonster].getInt() + 10);
			roll = (int) (Math.random() * (max - min) + min);
			return roll;
		default:
			return roll;
		}
	}
	
	private static int getPlayerRoll(int Option) {
		Random rand = new Random();
		int roll = 0;
		int min = 0, max = 0;
		switch (Option) {
		case 1:
			min = (p.getStrength() - 10);
			max = (p.getStrength() + 10);
			roll = (int) (Math.random() * (max - min) + min);
			return roll;
		case 2:
			min = (p.getDefense() - 10);
			max = (p.getDefense() + 10);
			roll = (int) (Math.random() * (max - min) + min);
			return roll;
		case 3:
			min = ((p.getMAXHP() / 2) - 10);
			max = ((p.getMAXHP() / 2) + 10);
			roll = (int) (Math.random() * (max - min) + min);
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
		sc.nextLine();
		return choice;
	}
	
	public static void resetHP(int randomMonster) {
		p.setHP();
		monsters[randomMonster].resetHP();
		monsters[randomMonster].resetMP();
	}

	public static void viewSingleMonster() {
		int monsterNum;
		print("Which monster would you like to view? (Enter array location):");
		monsterNum = sc.nextInt();
		monsters[monsterNum].viewSingleMonster();
	}
	
	public static void viewAllMonsters() {
		String output = "\n";
		output += String.format("%-30s %-10s %-12s %-15s %-13s %-10s %-10s %-10s%-10s %-10s%n", "Name:", "Type:", "Strength:", "Intelligence:", "Dexterity:", "Attack:", "Defense:", "Health:", "Mana:", "Level:");
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
