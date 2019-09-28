import java.util.Scanner;

public class MonsterFighter {

	private static Scanner sc;
	private static int count;
	private static Monster[] monsters;

	public static void main(String[] args) {
		monsters = new Monster[100];
		sc = new Scanner(System.in);
		count = 0;
		String select;
		boolean exit = false;
		while (exit == false) {
			print("\nEnter your selection!" + "\n1 - Create a Monster" + "\n2 - Fight Monsters" + "\n3 - View a Monster"
					+ "\n4 - Exit\nWhat do you choose?: ");
			select = sc.next();
			switch (select) {
			case "1":
				createMonster();
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				exit = true;
				break;
			default:
				print("\nIncorrect option\n");
				break;
			}
		}
	}

	private static void createMonster() {
		String name = "";
		String select = "";
		boolean menu = false;
		double str = 0;
		double intel = 0;
		double dex = 0;
		int hp = 100;
		int mp = 100;
		int lvl = 1;
		if (count == 100) {
			print("Monster roster full!");
		} else {
			print("\nEnter Monster name: ");
			name = sc.next();
			print("\nRoll for STRENGTH!");
			str = (Math.rint(Math.random() * 20));
			print("\nStrength is: " + str);
			print("\nRoll for INTELLIGENCE!");
			intel = (Math.rint(Math.random() * 20));
			print("\nIntelligence is: " + intel);
			print("\nRoll for DEXTERITY!");
			dex = (Math.rint(Math.random() * 20));
			print("\nDexterity is: " + dex);
			print("\nMonster HP is: " + hp);
			print("\nMonster MP is: " + mp);
			print("\nMonster Level is: " + lvl);
			monsters[count] = new Monster(name, str, intel, dex, hp, mp, lvl);
		}
		print("\n\nSelect Monster type!" + "\n1 - Fire Monster, combines STRENGTH and DEXTERITY!"
				+ "\n2 - Water Monster, combines DEXTERITY and INTELLIGENCE!"
				+ "\n3 - Thunder Monster, combines INTELLIGENCE and STRENGTH!" + "\nEnter selection: ");
		select = sc.next();
		while (menu != true) {
			switch (select) {
			case "1":
				print("\nFire Monster selected!");
				monsters[count] = new FireMonster(name, str, intel, dex, hp, mp, lvl);
				menu = true;
				break;
			default:
				print("\nIncorrect option\n");
			}
		}
	}

	private static String print(String input) {
		System.out.print(input);
		return input;
	}
}
