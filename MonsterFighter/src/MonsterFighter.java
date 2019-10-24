import java.util.Scanner;

public class MonsterFighter {

	private static Scanner sc;
	private static Monster[] monsters;
	private static int monCount;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		monsters = new Monster[100];
		monCount = 0;
		String select;
		String monSelect;
		boolean exit = false;

		do {
			System.out.printf("%n%s%n", "-----------------------------");
			System.out.printf("%s%n", "--- Monster fighter game! ---");
			System.out.printf("%s%n%n", "-----------------------------");
			System.out.printf("%s%n", "Make your selection!");
			System.out.printf("%s%n", "A: Create a Monster");
			System.out.printf("%s%n", "B: View your Monsters");
			System.out.printf("%s%n", "C: Fight Monsters");
			System.out.print("\nEnter selection: ");
			select = sc.nextLine();
			switch (select.toUpperCase()) {
			case "A":
				if (monCount == 100) {
					System.out.printf("%n%s%n", "Monster roster full!");
				} else {
					String name;
					System.out.printf("%n%s", "Enter your Monster name: ");
					name = sc.nextLine();
					System.out.printf("%n%s%n", "What type of Monster would you like to create?");
					System.out.printf("%s%n", "F: Fire Monster. Strong attack, weak defence");
					System.out.printf("%s%n", "W: Water Monster. Strong dodge, well balanced");
					System.out.printf("%s%n", "E: Earth Monster. Strong defence, weak attack");
					System.out.print("\nEnter selection: ");
					monSelect = sc.nextLine();
					addMonster(monSelect, name);
				}
				break;
			case "B":
				monsters[0].showMonster();
				break;
			case "C":
				break;
			case "X":
				exit = true;
				break;
			default:
				System.out.printf("%n%s%n", "Invalid selection");
			}
		} while (exit == false);
		System.exit(0);
	}

	private static void addMonster(String selection, String name) {

		switch (selection.toUpperCase()) {
		case "F":
			monsters[monCount] = new Fire(name, 30, 25, 10);
			monsters[monCount].setStats();
			System.out.printf("%n%s%n", monsters[monCount].getClass() + " Monster created!");
			monCount++;
			break;
		case "W":
			monsters[monCount] = new Water(name, 20, 20, 30);
			monsters[monCount].setStats();
			System.out.printf("%n%s%n", monsters[monCount].getClass() + " Monster created!");
			monCount++;
			break;
		case "E":
			monsters[monCount] = new Earth(name, 10, 20, 35);
			monsters[monCount].setStats();
			System.out.printf("%n%s%n", monsters[monCount].getClass() + " Monster created!");
			monCount++;
			break;
		default:
			System.out.printf("%n%s%n", "Invalid selection");
		}
	}
}
