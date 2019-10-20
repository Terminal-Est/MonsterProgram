package proOneW5MonterRod;

public class Monster {

	private String[] surname = { "Nankin", "Murphy" };
	private int level;
	private String generatedName;

	public String surnameGenerator() {
		int randomNumber;
		randomNumber = 0 + (int) Math.random() * ((surname.length - 0) + 0);
		String surnameGenerator = surname[randomNumber];
		return surnameGenerator;
	}
	
	public void setGeneratedMonsterName(String name) {
		
	}
	
	public String generateSurname()	{
		int randomInt;
		randomInt = 0 + (int) (Math.random() * ((surname.length - 0) + 0));
		String randomName = surname[randomInt];
		return randomName;
	}
	public Monster() {

		int randomLevelGenerator = (int) (Math.random() * 20 + 1);

		if (randomLevelGenerator <= 8) {
			this.level = 1;
		} else if (randomLevelGenerator > 8) {
			this.level = 2;
		}

	}

	public int getLevel() {
		return this.level;
	}
	
	public String getSurname() {
		return "";
	}

	public void setMonsterName(String[] fullName) {
		
		
	}

	public void viewSingleMonster() {
		
		
	}

}