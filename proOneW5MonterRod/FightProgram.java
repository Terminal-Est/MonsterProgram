package proOneW5MonterRod;

import java.util.Random;
import java.util.Scanner;
//New
public class FightProgram {

	private static Scanner console;
	private static int count;
	private static Monster[] monsters;
	private static Player player = new Player(20, 30);

	public static void main (String[] args) {
		monsters = new Monster[2];
		console = new Scanner(System.in);
		count = 0;
		String choose;
		print("\nPick one!" + " \n1 - Create a monster" + "\n2 - Fill monsters");
		choose = console.nextLine();
		while (!choose.isEmpty() && Integer.parseInt(choose)!=6) {
			switch (choose) {
			
			case "1":
				createMonster();
				break;
				
			case "2":
				fillMonsters();
				break;
			
			case "3":
				fightMonster();
				break;			

			default: 
				print("\nIncorrect option chosen!");
				break;			
			}
			if(Integer.parseInt(choose) !=6) {
				print("\n Enter your selection! " + "\n 1 - Create a monster" + "\n 2 - Fill MOnsters"
						+ "\n 3 - Fight Random Monster" + "\n 4 - View specific monster" + "\n 5 - View all monsters"
						+ "\n 6 - Exit program"
						);
				choose = console.next();
			}
		}
		print ("Exiting the game");
	}

	private static void createMonster() {
		String name = "";
		String select = "";
		if (count == monsters.length) {
			print("Monster roster full!\n");
		} else {
			print("\nEnter Monster name: ");
			name = console.nextLine();
			monsters[count] = new Monster();
			print("\n\nSelect Monster type!" + "\n1 - Murphy combines annoyance with caramadie!"
					+ "\n2 - Nankin combines lazyness with hunting poweress!");
			select = console.nextLine();
			if (!select.isEmpty()) {
				switch (select) {
				case "1":
					print("\nMurphy the Monster selected!");
					monsters[count] = new MonsterMurphy();
					break;
				case "2":
					print("\nNankin the Monster selected!");
					monsters[count] = new MonsterNankin();
					break;
				default:
					print("\nIncorrect option\n");
				}
				monsters[count].setGeneratedMonsterName(name);
				print("\nMonster Name is: " + monsters[count].getSurname());
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
				print("\nMonster Strength is: " + monsters[count].getLevel());

				count++;
			}
		}

	}

	public static void fillMonsters() {
		int type = 0;
		if (count < monsters.length) {
			while (count < monsters.length) {
				type = 1 + (int) (Math.random() * ((2 - 1) + 1));
				switch (type) {
				case 1:
					monsters[count] = new MonsterMurphy();
					break;
				case 2:
					monsters[count] = new MonsterNankin();
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
		output += "Monster Name: " + monsters[randomMonster].getSurname() + "\n";
		output += "Monster Level: " + monsters[randomMonster].getLevel() + "\n";
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
			monsters[randomMonster].getLevel();
			print(monsters[randomMonster].getSurname() + " Health Remaining: " + monsters[randomMonster].getLevel() + "\n");
			print("Player Health Remaining: " + player.getStrength() + "\n\n");
		} while (!(player.getStrength() <= 0) && !(monsters[randomMonster].getLevel() <= 0));
		if (player.getStrength() <= 0)
			print("You have been defeated!\n");
		else if (monsters[randomMonster].getLevel() <= 0)
			print("You have defeated the " + monsters[randomMonster].getSurname() + "!\n");
		else
			print("As your blows land, you both crumple on the ground. Its a draw!\n");
		resetLevel(randomMonster); // Resets player and monster HP after battle
	}

	private static void defend(int randomMonster) {
		// TODO Auto-generated method stub
		
	}

	private static void heal(int randomMonster) {
		// TODO Auto-generated method stub
		
	}

	private static void resetLevel(int randomMonster) {
		
		
	}

	private static void fight(int randomMonster) {
		
		
	}



	private static void print(String string) {
		

	}
	

	
	private static int Prompt() {
		String output = "";
		output += "What do you choose to do?\n";
		output += "1 - FIGHT\n";
		output += "2 - HEAL\n";
		output += "3 - DEFEND\n";
		output += "Make your choice:\n";
		print(output);
		int choice = console.nextInt();
		console.nextLine();
		return choice;
	}

}
