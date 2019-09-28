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
			print("Enter your selection!\n1 - Create Monster\n2 - Fight Monster\n3 - View a mnonster\n4 - Exit\nWhat do you choose?: ");
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
		
	}

	private static String print(String input) {
		System.out.println(input);
		return input;
	}
}
