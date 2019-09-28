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
			print("\n\nEnter your selection!\n1 - Create a Monster\n2 - Fight Monsters\n3 - View a Monster\n4 - Exit\nWhat do you choose?: ");
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
			}
		}
	}

	private static void createMonster() {
		String name = "";
		double str = 0;
		double intel = 0;
		double dex = 0;
		double hp = 0;
		if (count == 100) {
			print("Monster roster full!");
		} else {
			print("Enter Monster name: ");
			name = sc.next();
			print("\nRoll for STRENGTH!");
			str = (Math.rint(Math.random() * ((20 - 1) + 1)) + 1);
			print("\nStrength is: " + str);
			print("\nRoll for INTELLIGENCE!");
			intel = (Math.rint(Math.random() * ((20 - 1) + 1)) + 1);
			print("\nIntelligence is: " + intel);
			print("\nRoll for DEXTERITY!");
			dex = (Math.rint(Math.random() * ((20 - 1) + 1)) + 1);
			print("\nDexterity is: " + dex);
			hp = 100;
			print("\nMonster HP is: " + hp);
		}

	}

	private static String print(String input) {
		System.out.print(input);
		return input;
	}
}
