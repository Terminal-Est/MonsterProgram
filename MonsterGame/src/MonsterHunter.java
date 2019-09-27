import java.util.Random;
import java.util.Scanner;

public class MonsterHunter {
	public static Monster[] monsterParty;
	public static int playerHealth;
	public static int playerStrength;
	public static int playerDefense;
	public static int MAXHEALTH;
	public static Scanner input;

	public static void main(String[] args) {
		Random rand = new Random();
		playerStrength = (rand.nextInt(20) + 1);
		playerDefense = (rand.nextInt(20) + 1);
		playerHealth = playerDefense * 2;
		MAXHEALTH = playerHealth;
		monsterParty = new Monster[1];

		for (int i = 0; i < monsterParty.length; i++) {
			monsterParty[i] = new Monster();
			System.out.printf("%25s%n%n", "YOU ARE FIGHTING");
			System.out.printf("Monster Name:%22s%n%n", monsterParty[i].getName());
			System.out.printf("Monster Defense:%19s%n", monsterParty[i].getDefense());
			System.out.printf("Monster Strength:%18s%n", monsterParty[i].getStrength());
			System.out.printf("Monster Health:%20s%n", monsterParty[i].getHealth());
			System.out.println();
		}
		do {
			int choice = Prompt();
			switch (choice) {
			case 1:
				fight();
				break;
			case 2:
				heal();
				break;
			case 3:
				defend();
				break;
			}
			System.out.printf("Monster Health Remaining:%20s%n", monsterParty[0].getHealth());
			System.out.printf("Player Health Remaining:%21s%n", playerHealth);
		} while (!(playerHealth <= 0) && !(monsterParty[0].getHealth() <= 0));
 if(playerHealth<=0) 
	 System.out.println("You have been defeated!");
	 else if (monsterParty[0].getHealth()<=0) {
		 System.out.println("You have defeated the monster!"); 
	 }
	 else
		 System.out.println("As your blows land, you both crumple on the ground. Its a draw!");
 }
	

	private static void defend() {
		int choice = monsterParty[0].getChoice();
		int defenseRoll;
		int monDamage;
		switch (choice) {
		case 1:
			monDamage = monsterParty[0].getRoll(1);
			defenseRoll = getPlayerRoll(2);
			int totalDamage = monDamage - defenseRoll;
			if (totalDamage <= 0)
				System.out.println("Your defense negates the monsters attack completely");
			else {
				System.out.println("The monsters attack is too much causing you " + (totalDamage) + " damage");
				playerHealth -= totalDamage;
			}
			break;
		case 2:
			System.out.println("The monster defends against your attack which never comes");
			break;
		case 3:
			System.out.println("As you prepare to defend against an attack, the monster heals");
			monsterParty[0].getRoll(3);
			break;
		}
	}

	private static void heal() {
		int choice = monsterParty[0].getChoice();
		int healRoll;
		int monDamage;
		switch (choice) {
		case 1:
			monDamage = monsterParty[0].getRoll(1);
			playerHealth -= monDamage;
			if (playerHealth <= 0)
				break;
			else {
				healRoll = getPlayerRoll(3);
				System.out.println("The monster takes a slash at you, dealing " + monDamage + " damage.");
				System.out.println("You survive and heal for " + healRoll + "health.");
				break;
			}
		case 2:
			System.out.println("The monster defends against your attack which never comes");
			healRoll = getPlayerRoll(3);
			playerHealth += healRoll;
			System.out.println("You take the opportunity to heal for " + healRoll);
			break;
		case 3:
			healRoll = getPlayerRoll(3);
			System.out.println("The monster decides to heal as well!");
			System.out.println("You heal for " + healRoll);
			monsterParty[0].getRoll(3);
			break;
		}

	}

	private static void fight() {
		int choice = monsterParty[0].getChoice();
		int damageRoll;
		int monDamage;
		switch (choice) {
		case 1:
			monDamage = monsterParty[0].getRoll(1);
			playerHealth -= monDamage;
			damageRoll = getPlayerRoll(1);
			monsterParty[0].setHealth(damageRoll);
			System.out.println("You both attack each other at the same time!");
			System.out.println("You deal " + damageRoll + " points of damage");
			System.out.println("You are struck for " + monDamage + " points of damage");
			break;

		case 2:
			System.out.println("As you attack the monster guards");
			damageRoll = getPlayerRoll(1);
			int monDefense = monsterParty[0].getRoll(2);
			int totaldamage = damageRoll - monDefense;
			if (totaldamage > 0) {
				System.out.println("You managed to defeat the monsters defenses and dealt " + totaldamage + " damage");
				monsterParty[0].setHealth(totaldamage);
			} else
				System.out.println("The monsters defenses were impenetrable!");
			System.out.println();
			break;
		case 3:
			damageRoll = getPlayerRoll(1);
			System.out.println("As you attack the monster heals!");
			System.out.println("You hit for " + damageRoll);
			if (monsterParty[0].getHealth() <= 0)
				break;
			else
				monsterParty[0].getRoll(3);
			break;
		}
	}

	private static int getPlayerRoll(int Option) {
		Random rand = new Random();
		int roll = 0;
		switch (Option) {
		case 1:
			roll = (rand.nextInt(playerStrength)) + 1;
			return roll;
		case 2:
			roll = (rand.nextInt(playerDefense)) + 1;
			return roll;
		case 3:
			roll = (rand.nextInt((MAXHEALTH) / 2)) + 1;
			playerHealth += roll;
			if (playerHealth > MAXHEALTH)
				playerHealth = MAXHEALTH;
			return roll;
		default:
			return roll;
		}

	}

	private static int Prompt() {
		input = new Scanner(System.in);
		System.out.printf("%30s%n%n", "What do you choose to do?");
		System.out.printf("%20s%n", "1 - FIGHT");
		System.out.printf("%19s%n", "2 - HEAL");
		System.out.printf("%21s%n", "3 - DEFEND");
		System.out.printf("%21s%n%n", "Make your choice:");
		int choice = input.nextInt();

		return choice;
	}

}
