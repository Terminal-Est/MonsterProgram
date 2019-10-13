import java.util.Random;
import java.util.Scanner;

public class MonsterFighter {

	private static Scanner sc;
	private static int count;
	private static Monster[] monsters;
	private static Player p = new Player(50, 50, 50, 50, 50, 25, 50, 50, 50, 50);

	public static void main(String[] args) {
		monsters = new Monster[20];
		sc = new Scanner(System.in);
		count = 0;
		String select;
		print("\nEnter your selection!" + "\n1 - Create a Monster" + "\n2 - Fill Monsters"
				+ "\n3 - Fight Random Monster" + "\n4 - View a specific Monster" + "\n5 - View all Monsters"
				+ "\n6 - Exit\nWhat do you choose?: ");
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
				print("\nEnter your selection!" + "\n1 - Create a Monster" + "\n2 - Fill Monsters"
						+ "\n3 - Fight Random Monster" + "\n4 - View a specific Monster" + "\n5 - View all Monsters"
						+ "\n6 - Exit\nWhat do you choose?: ");
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
				type = 1 + (int) (Math.random() * ((3 - 1) + 1));
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
		int randomMonster = 0 + (int) (Math.random() * ((19 - 0) + 0));
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
		if (p.getHP() <= 0)
			print("You have been defeated!\n");
		else if (monsters[randomMonster].getHP() <= 0)
			print("You have defeated the " + monsters[randomMonster].getName() + "!\n");
		else
			print("As your blows land, you both crumple on the ground. Its a draw!\n");
		resetHP(randomMonster); // Resets player and monster HP after battle
	}

	private static void defend(int randomMonster) {
		int choice = getChoice();
		int playerSpeedRoll, playerEvasionRoll, playerDefenseRoll;
		int monDamageRoll, monAccuracyRoll, monSpeedRoll, monHealRoll;
		int monAttackLocation = 0;
		if (choice > 4) {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and " + p.getGuard() + " before the " + monsters[randomMonster].getName() + " attacks you!\n");
				monAttackLocation = monsters[randomMonster].rollAttack();
				print("You attempt to " + p.getGuard() + " the " + monsters[randomMonster].getName() + "'s " + monsters[randomMonster].getAttackName(monAttackLocation) + "\n");
				monDamageRoll = getMonsterRoll(1, randomMonster, monAttackLocation);
				playerDefenseRoll = getPlayerRoll(2);
				if (playerDefenseRoll >= monDamageRoll) {
					print("Your defensive " + p.getGuard() + " is too strong for the " + monsters[randomMonster].getName() + "'s " + monsters[randomMonster].getAttackName(monAttackLocation) + "\n");
				} else {
					print("The " + monsters[randomMonster].getName() + " is too strong and overwhelms your defenses!\n");
					p.takeDMG(monDamageRoll - playerDefenseRoll);
					print("The " + monsters[randomMonster].getName() + " uses "
						+ monsters[randomMonster].getAttackName(monAttackLocation) + " and hits you for " + (monDamageRoll - playerDefenseRoll)
						+ " points of damage.\n");
					monsters[randomMonster].useMP(monsters[randomMonster].getAttackMPCost(monsters[randomMonster].getAttackName(monAttackLocation)));
				}
			} else {
				print("The " + monsters[randomMonster].getName() + " is too quick and gets the upper hand and attacks first!\n");
				monAccuracyRoll = getMonsterRoll(5, randomMonster, monAttackLocation);
				playerEvasionRoll = getPlayerRoll(6);
				if (monAccuracyRoll >= playerEvasionRoll) {
					print("You attempt to evade the " + monsters[randomMonster].getName() + "'s attack but it is too accurate!\n");
					monAttackLocation = monsters[randomMonster].rollAttack();
					monDamageRoll = getMonsterRoll(1, randomMonster, monAttackLocation);
					p.takeDMG(monDamageRoll);
					print("The " + monsters[randomMonster].getName() + " uses "
							+ monsters[randomMonster].getAttackName(monAttackLocation) + " and hits you for " + monDamageRoll
							+ " points of damage.\n");
					monsters[randomMonster].useMP(monsters[randomMonster].getAttackMPCost(monsters[randomMonster].getAttackName(monAttackLocation)));
				} else {
					print("You successfully evade the " + monsters[randomMonster].getName() + "'s attack.\n");
				}
				if (p.getHP() > 0) {
					print("You decide to " + p.getGuard() + ".\n");
					print("You defend against the " + monsters[randomMonster].getName() + "'s attack but it is too late.\n");
				
				}
			}
		} else if (choice >= 2 && choice <= 4) {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and " + p.getGuard() + " before the " + monsters[randomMonster].getName() + " can do anything!\n");
				print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getGuard() + ".\n");
				print("The " + monsters[randomMonster].getName() + " defends against your attack which never comes.\n");
			} else {
				print("The " + monsters[randomMonster].getName() + " is too quick and guards!\n");
				print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getGuard() + ".\n");
				print("You decide to " + p.getGuard() + ".\n");
				print("You defend against the " + monsters[randomMonster].getName() + "'s attack which never comes.\n");
			}
		} else {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and " + p.getGuard() + " before the " + monsters[randomMonster].getName() + " can do anything!\n");
				print("You defend against the " + monsters[randomMonster].getName() + "'s attack which never comes.\n");
				print("The monster decides to heal!\n");
				monHealRoll = getMonsterRoll(3, randomMonster, monAttackLocation);
				print("The " +  monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getHealName() + ".\n");
				print("The " + monsters[randomMonster].getName() +  "heals for " + monHealRoll + "\n");
				monsters[randomMonster].healHP(monHealRoll);
			} else {
				print("The " + monsters[randomMonster].getName() + " is too quick and uses " +  monsters[randomMonster].getHealName() + " before you can do anything.\n");
				monHealRoll = getMonsterRoll(3, randomMonster, monAttackLocation);
				print("The " + monsters[randomMonster].getName() +  " heals for " + monHealRoll + "\n");
				monsters[randomMonster].healHP(monHealRoll);
				print("You decide to " + p.getGuard() + ".\n");
				print("You defend against the " + monsters[randomMonster].getName() + "'s attack which never comes.\n");
			}			 
		}
	}

	private static void heal(int randomMonster) {
		int choice = getChoice();
		int playerhealRoll, playerSpeedRoll, playerEvasionRoll;
		int monDamageRoll, monAccuracyRoll, monSpeedRoll, monHealRoll;
		int monAttackLocation = 0;
		if (choice > 4) {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and heal before the " + monsters[randomMonster].getName() + " attacks you!\n");
				playerhealRoll = getPlayerRoll(3);
				print("You heal for " + playerhealRoll + " health.\n");
				playerEvasionRoll = getPlayerRoll(6);
				monAccuracyRoll = getMonsterRoll(5, randomMonster, monAttackLocation);
				print("The " + monsters[randomMonster].getName() + " tries to attack!\n");
				if (monAccuracyRoll >= playerEvasionRoll) {
					print("You attempt to evade the " + monsters[randomMonster].getName() + "'s attack but its accuracy is too great!\n");
					monAttackLocation = monsters[randomMonster].rollAttack();
					monDamageRoll = getMonsterRoll(1, randomMonster, monAttackLocation);
					p.takeDMG(monDamageRoll);
					print("The " + monsters[randomMonster].getName() + " uses "
							+ monsters[randomMonster].getAttackName(monAttackLocation) + " and hits you for " + monDamageRoll
							+ " points of damage.\n");
					monsters[randomMonster].useMP(monsters[randomMonster].getAttackMPCost(monsters[randomMonster].getAttackName(monAttackLocation)));
				} else {
					print("You successfully evade the " + monsters[randomMonster].getName() + "'s attack.\n");
				}
			} else {
				print("The " + monsters[randomMonster].getName() + " is too quick and attacks you before you can heal!\n");
				playerEvasionRoll = getPlayerRoll(6);
				monAccuracyRoll = getMonsterRoll(5, randomMonster, monAttackLocation);
				print("The " + monsters[randomMonster].getName() + " tries to attack!\n");
				if (monAccuracyRoll >= playerEvasionRoll) {
					print("You attempt to evade the " + monsters[randomMonster].getName() + "'s attack but its accuracy is too great!\n");
					monAttackLocation = monsters[randomMonster].rollAttack();
					monDamageRoll = getMonsterRoll(1, randomMonster, monAttackLocation);
					p.takeDMG(monDamageRoll);
					print("The " + monsters[randomMonster].getName() + " uses "
							+ monsters[randomMonster].getAttackName(monAttackLocation) + " and hits you for " + monDamageRoll
							+ " points of damage.\n");
					monsters[randomMonster].useMP(monsters[randomMonster].getAttackMPCost(monsters[randomMonster].getAttackName(monAttackLocation)));
					if (!(p.getHP() <= 0)) {
						playerhealRoll = getPlayerRoll(3);
						print("You survive and " + p.getHeal() + " for " + playerhealRoll + " health.\n");
						p.healHP(playerhealRoll);
					}
				} else {
					print("You successfully evade the " + monsters[randomMonster].getName() + "'s attack.\n");
					playerhealRoll = getPlayerRoll(3);
					print("You successfully evade the " + monsters[randomMonster].getName() + "'s attack and " + p.getHeal() + " for " + playerhealRoll + " health.\n");
					p.healHP(playerhealRoll);
				}
			}
		} else if (choice >= 2 && choice <= 4) {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and heal before the " + monsters[randomMonster].getName() + " can do anything!\n");
				playerhealRoll = getPlayerRoll(3);
				p.healHP(playerhealRoll);
				print("You heal for " + playerhealRoll + " health.\n");
				print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getGuard() + ".\n");
				print("The " + monsters[randomMonster].getName() + " defends against your attack which never comes.\n");
			} else {
				print("The " + monsters[randomMonster].getName() + " is too quick and guards!\n");
				print("The " + monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getGuard() + ".\n");
				print("The " + monsters[randomMonster].getName() + " defends against your attack which never comes.\n");
				playerhealRoll = getPlayerRoll(3);
				print("You take the opportunity to heal and regain " + playerhealRoll + " health.\n");
				p.healHP(playerhealRoll);
			}
		} else {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and heal before the " + monsters[randomMonster].getName() + " can do anything.\n");
				playerhealRoll = getPlayerRoll(3);
				print("You heal for " + playerhealRoll + " health.\n");
				p.healHP(playerhealRoll);
				print("The monster decides to heal as well!\n");
				monHealRoll = getMonsterRoll(3, randomMonster, monAttackLocation);
				print("The " +  monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getHealName() + ".\n");
				print("The " + monsters[randomMonster].getName() +  "heals for " + monHealRoll + "\n");
				monsters[randomMonster].healHP(monHealRoll);
			} else {
				monHealRoll = getMonsterRoll(3, randomMonster, monAttackLocation);
				print("The " + monsters[randomMonster].getName() + " is too quick and uses " +  monsters[randomMonster].getHealName() + " before you.\n");
				print("The " + monsters[randomMonster].getName() +  " heals for " + monHealRoll + "\n");
				monsters[randomMonster].healHP(monHealRoll);
				playerhealRoll = getPlayerRoll(3);
				print("You then heal for " + playerhealRoll + " health.\n");
				p.healHP(playerhealRoll);
			}			 
		}

	}

	private static void fight(int randomMonster) {
		int choice = getChoice();
		int playerDamageRoll, playerSpeedRoll, playerAccuracyRoll, playerEvasionRoll;
		int monDamageRoll, monAccuracyRoll, monEvasionRoll, monSpeedRoll, monHealRoll;
		int monAttackLocation = 0, playerAttackLocation = 0;
		if (choice > 4) {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and attack first!\n");
				playerAccuracyRoll = getPlayerRoll(5);
				monEvasionRoll = getMonsterRoll(6, randomMonster, monAttackLocation);
				if (playerAccuracyRoll >= monEvasionRoll) {
					playerAttackLocation = p.rollAttackName();
					print("The " + monsters[randomMonster].getName() + " attempts to evade your attack but you are too accurate!\n");
					playerDamageRoll = getPlayerRoll(1);
					monsters[randomMonster].takeDMG(playerDamageRoll);
					print("You execute a " + p.getAttackName(playerAttackLocation) + " for " + playerDamageRoll + " points of damage.\n");
				} else {
					print("The " + monsters[randomMonster].getName() + " successfully evades the " + p.getAttackName(playerAttackLocation) + ".\n");
				}
				if (!(monsters[randomMonster].getHP() <= 0)) {
					print("The " + monsters[randomMonster].getName() + " tries to attack!\n");
					monAccuracyRoll = getMonsterRoll(5, randomMonster, monAttackLocation);
					playerEvasionRoll = getPlayerRoll(6);
					if (monAccuracyRoll >= playerEvasionRoll) {
						print("You attempt to evade the " + monsters[randomMonster].getName() + "'s attack but its accuracy is too great!\n");
						monAttackLocation = monsters[randomMonster].rollAttack();
						monDamageRoll = getMonsterRoll(1, randomMonster, monAttackLocation);
						p.takeDMG(monDamageRoll);
						print("The " + monsters[randomMonster].getName() + " uses "
							+ monsters[randomMonster].getAttackName(monAttackLocation) + " and hits you for " + monDamageRoll
							+ " points of damage.\n");
						monsters[randomMonster].useMP(monsters[randomMonster].getAttackMPCost(monsters[randomMonster].getAttackName(monAttackLocation)));
					} else {
						print("You successfully evade the " + monsters[randomMonster].getName() + "'s attack.\n");
					}
				}
			}else {
				print("The " + monsters[randomMonster].getName() + " is too quick and gets the upper hand and attacks first!\n");
				monAccuracyRoll = getMonsterRoll(5, randomMonster, monAttackLocation);
				playerEvasionRoll = getPlayerRoll(6);
				if (monAccuracyRoll >= playerEvasionRoll) {
					print("You attempt to evade the " + monsters[randomMonster].getName() + "'s attack but it is too accurate!\n");
					monAttackLocation = monsters[randomMonster].rollAttack();
					monDamageRoll = getMonsterRoll(1, randomMonster, monAttackLocation);
					p.takeDMG(monDamageRoll);
					print("The " + monsters[randomMonster].getName() + " uses "
							+ monsters[randomMonster].getAttackName(monAttackLocation) + " and hits you for " + monDamageRoll
							+ " points of damage.\n");
					monsters[randomMonster].useMP(monsters[randomMonster].getAttackMPCost(monsters[randomMonster].getAttackName(monAttackLocation)));
				} else {
					print("You successfully evade the " + monsters[randomMonster].getName() + "'s attack.\n");
				}
				if (p.getHP() > 0) {
					print("You decide to strike.");
					playerAccuracyRoll = getPlayerRoll(5);
					monEvasionRoll = getMonsterRoll(6, randomMonster, monAttackLocation);
					if (playerAccuracyRoll >= monEvasionRoll) {
						playerAttackLocation = p.rollAttackName();
						print("The " + monsters[randomMonster].getName() + " attempts to evade your attack but your accuracy is too great!\n");
						playerDamageRoll = getPlayerRoll(1);
						monsters[randomMonster].takeDMG(playerDamageRoll);
						print("You execute a " + p.getAttackName(playerAttackLocation) + " for " + playerDamageRoll + " points of damage.\n");
					} else {
						print("The " + monsters[randomMonster].getName() + " successfully evades the " + p.getAttackName(playerAttackLocation) + ".\n");
					}
				}
			}
		} else if (choice >= 2 && choice <= 4) {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and attack first!\n");
				playerAccuracyRoll = getPlayerRoll(5);
				monEvasionRoll = getMonsterRoll(6, randomMonster, monAttackLocation);
				if (playerAccuracyRoll >= monEvasionRoll) {
					playerAttackLocation = p.rollAttackName();
					print("The " + monsters[randomMonster].getName() + " attempts to evade your attack but you are too accurate!\n");
					playerDamageRoll = getPlayerRoll(1);
					monsters[randomMonster].takeDMG(playerDamageRoll);
					print("You execute a " + p.getAttackName(playerAttackLocation) + " for " + playerDamageRoll + " points of damage.\n");
				} else {
					print("The " + monsters[randomMonster].getName() + " successfully evades the " + p.getAttackName(playerAttackLocation) + ".\n");
				}
				if (!(monsters[randomMonster].getHP() <= 0)) {
					print("The " +  monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getGuard() + ".\n");
					print("The " + monsters[randomMonster].getName() + " improves its defences for no reason.\n");
				}
			} else {
				print("The " + monsters[randomMonster].getName() + " is too quick and uses " + monsters[randomMonster].getGuard() + ".\n");
				print("You decide to strike.");
				playerAccuracyRoll = getPlayerRoll(5);
				monEvasionRoll = getMonsterRoll(6, randomMonster, monAttackLocation);
				if (playerAccuracyRoll >= monEvasionRoll) {
					playerAttackLocation = p.rollAttackName();
					print("The " + monsters[randomMonster].getName() + " attempts to evade your attack but you are too accurate!\n");
					playerDamageRoll = getPlayerRoll(1);
					int monDefense = getMonsterRoll(2, randomMonster, monAttackLocation);
					int totaldamage = playerDamageRoll - monDefense;
					if (totaldamage > 0) {
						print("You managed to defeat the " + monsters[randomMonster].getName() + "'s "
								+ monsters[randomMonster].getGuard() + " and deal " + totaldamage + " damage.\n");
						monsters[randomMonster].takeDMG(totaldamage);
					} else
						print("You execute a " + p.getAttackName(playerAttackLocation) + " but the " + monsters[randomMonster].getName() + "'s " + monsters[randomMonster].getGuard()
								+ " was impenetrable!\n");
					System.out.println();
				} else {
					print("The " + monsters[randomMonster].getName() + " successfully evades the " + p.getAttackName(playerAttackLocation) + ".\n");
				}
			}	
		} else {
			monSpeedRoll = getMonsterRoll(4, randomMonster, monAttackLocation);
			playerSpeedRoll = getPlayerRoll(4);
			if (playerSpeedRoll >= monSpeedRoll) {
				print("You are too quick and manage to get the upper hand and attack first!\n");
				playerAccuracyRoll = getPlayerRoll(5);
				monEvasionRoll = getMonsterRoll(6, randomMonster, monAttackLocation);
				if (playerAccuracyRoll >= monEvasionRoll) {
					playerAttackLocation = p.rollAttackName();
					print("The " + monsters[randomMonster].getName() + " attempts to evade your attack but you are too accurate!\n");
					playerDamageRoll = getPlayerRoll(1);
					monsters[randomMonster].takeDMG(playerDamageRoll);
					print("You execute a " + p.getAttackName(playerAttackLocation) + " for " + playerDamageRoll + " points of damage.\n");
				} else {
					print("The " + monsters[randomMonster].getName() + " successfully evades the " + p.getAttackName(playerAttackLocation) + ".\n");
				}
				if (monsters[randomMonster].getHP() > 0) {
					print("The " +  monsters[randomMonster].getName() + " uses " + monsters[randomMonster].getHealName() + ".\n");
					monHealRoll = getMonsterRoll(3, randomMonster, monAttackLocation);
					print("The " + monsters[randomMonster].getName() +  " heals for " + monHealRoll + "\n");
					monsters[randomMonster].healHP(monHealRoll);
				}
			} else {
				print("The " + monsters[randomMonster].getName() + " is too quick and uses " +  monsters[randomMonster].getHealName() + ".\n");
				monHealRoll = getMonsterRoll(3, randomMonster, monAttackLocation);
				print("The " + monsters[randomMonster].getName() +  "heals for " + monHealRoll + "\n");
				monsters[randomMonster].healHP(monHealRoll);
				print("You decide to strike.");
				playerAccuracyRoll = getPlayerRoll(5);
				monEvasionRoll = getMonsterRoll(6, randomMonster, monAttackLocation);
				if (playerAccuracyRoll >= monEvasionRoll) {
					playerAttackLocation = p.rollAttackName();
					print("The " + monsters[randomMonster].getName() + " attempts to evade your attack but you are too accurate!\n");
					playerDamageRoll = getPlayerRoll(1);
					monsters[randomMonster].takeDMG(playerDamageRoll);
					print("You execute a " + p.getAttackName(playerAttackLocation) + " for " + playerDamageRoll + " points of damage.\n");
				} else {
					print("The " + monsters[randomMonster].getName() + " successfully evades the " + p.getAttackName(playerAttackLocation) + ".\n");
				}
			}
		}
	}

	public static int getChoice() {
		int choice;
		choice = (int) (Math.random() * (10 - 1) + 1);
		return choice;
	}

	public static int getMonsterRoll(int Option, int randomMonster, int attackLocation) {
		int roll = 0, critCheck = 0;
		int min = 0, max = 0;
		switch (Option) {
		case 1:
			min = monsters[randomMonster].getAttackBaseDMG(monsters[randomMonster].getAttackName(attackLocation))
					+ monsters[randomMonster].getAttack()/2;
			max = monsters[randomMonster].getAttackBaseDMG(monsters[randomMonster].getAttackName(attackLocation))
					+ monsters[randomMonster].getAttack() + monsters[randomMonster].getLuck()/2;
			roll = (int) (Math.random() * (max - min) + min);
			min = monsters[randomMonster].getDex() + monsters[randomMonster].getLuck()/4;
			max = 50 * monsters[randomMonster].getLVL();
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck > ((int) (0.9 * max))) {
				print("Critical Hit!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 2:
			min = (monsters[randomMonster].getDefense());
			max = (monsters[randomMonster].getDefense() + monsters[randomMonster].getLuck() / 2);
			roll = (int) (Math.random() * (max - min) + min);
			min = monsters[randomMonster].getDex() + monsters[randomMonster].getLuck()/4;
			max = 50 * monsters[randomMonster].getLVL();
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck > ((int) (0.9 * max))) {
				print("The " + monsters[randomMonster].getName() + " gets a lucky defensive increase!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 3:
			min = (monsters[randomMonster].getHealing());
			max = (monsters[randomMonster].getHealing() + monsters[randomMonster].getLuck()/2);
			roll = (int) (Math.random() * (max - min) + min);
			min = monsters[randomMonster].getDex() + monsters[randomMonster].getLuck()/4;
			max = 50 * monsters[randomMonster].getLVL();
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck > ((int) (0.9 * max))) {
				print("Critical Heal!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 4:
			min = (monsters[randomMonster].getSpd());
			max = (monsters[randomMonster].getSpd() + monsters[randomMonster].getLuck()/2);
			roll = (int) (Math.random() * (max - min) + min);
			min = monsters[randomMonster].getDex() + monsters[randomMonster].getLuck()/4;
			max = 50 * monsters[randomMonster].getLVL();
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck > ((int) (0.9 * max))) {
				print("The " + monsters[randomMonster].getName() + " gets a lucky speed increase!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 5:
			min = (monsters[randomMonster].getAcc());
			max = (monsters[randomMonster].getAcc() + monsters[randomMonster].getLuck()/2);
			roll = (int) (Math.random() * (max - min) + min);
			min = monsters[randomMonster].getDex() + monsters[randomMonster].getLuck()/4;
			max = 50 * monsters[randomMonster].getLVL();
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck > ((int) (0.9 * max))) {
				print("The " + monsters[randomMonster].getName() + " gets a lucky accuracy increase!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 6:
			min = (monsters[randomMonster].getEva());
			max = (monsters[randomMonster].getEva() + monsters[randomMonster].getLuck()/2);
			roll = (int) (Math.random() * (max - min) + min);
			min = monsters[randomMonster].getDex() + monsters[randomMonster].getLuck()/4;
			max = 50 * monsters[randomMonster].getLVL();
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck > ((int) (0.9 * max))) {
				print("The " + monsters[randomMonster].getName() + " gets a lucky evasive increase!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		default:
			return roll;
		}
	}

	private static int getPlayerRoll(int Option) {
		int roll = 0, critCheck = 0;
		int min = 0, max = 0;
		switch (Option) {
		case 1:
			min = (p.getStrength());
			max = (p.getStrength() + p.getLuck());
			roll = (int) (Math.random() * (max - min) + min);
			min = p.getDexterity() + p.getLuck()/8;
			max = 100;
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck >= 90) {
				print("Critical Hit!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 2:
			min = (p.getDefense());
			max = (p.getDefense() + p.getCon() / 2 + p.getLuck());
			roll = (int) (Math.random() * (max - min) + min);
			min = p.getDexterity() + p.getLuck()/8;
			max = 100;
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck >= 90) {
				print("You get a lucky defensive increase!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 3:
			min = (p.getWisdom());
			max = (p.getWisdom() + p.getLuck());
			roll = (int) (Math.random() * (max - min) + min);
			min = p.getDexterity() + p.getLuck()/8;
			max = 100;
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck >= 90) {
				print("Critical Heal!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 4:
			min = (p.getSpeed());
			max = ((p.getSpeed()) + p.getLuck());
			roll = (int) (Math.random() * (max - min) + min);
			min = p.getDexterity() + p.getLuck()/8;
			max = 100;
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck >= 90) {
				print("You get a lucky speed increase!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 5:
			min = ((p.getAccuracy()));
			max = ((p.getAccuracy()) + p.getLuck());
			roll = (int) (Math.random() * (max - min) + min);
			min = p.getDexterity() + p.getLuck()/8;
			max = 100;
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck >= 90) {
				print("You get a lucky accuracy increase!\n");
				roll = (int) (roll * 1.3);
			}
			return roll;
		case 6:
			min = ((p.getEvasion()));
			max = ((p.getEvasion()) + p.getLuck());
			roll = (int) (Math.random() * (max - min) + min);
			min = p.getDexterity() + p.getLuck()/8;
			max = 100;
			critCheck = (int) (Math.random() * (max - min) + min);
			if (critCheck >= 90) {
				print("You get a lucky evasive increase!\n");
				roll = (int) (roll * 1.3);
			}
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
		print("\n");
		print((String.format(
				"%-30s %-10s %-12s %-15s %-13s %-11s %-11s %-11s %-11s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
				"Name:", "Type:", "Strength:", "Intelligence:", "Dexterity:", "Wisdom:", "Speed:", "Accuracy:",
				"Evasion:", "Constitution:", "Luck:", "Attack:", "Defense:", "Healing:", "Health:", "Mana:",
				"Level:")));
		for (int i = 0; i < count; i++) {
			monsters[i].viewAllMonsters();
		}
	}

	private static String print(String input) {
		System.out.print(input);
		return input;
	}
}
