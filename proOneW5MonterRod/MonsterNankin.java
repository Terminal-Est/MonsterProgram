package proOneW5MonterRod;

public class MonsterNankin extends Monster {

	private String[] firstName = {"Carol", "Enrique"};
	private String[] attacks = {"bite", "chase"};
	private int[] attackCost = {20, 10};
	private int[] attackDamage = {10, 20};
	private String fullName;
	private int attack;
	
	public MonsterNankin() {
		super();
		String name = firstNameGenerator() + " " + super.surnameGenerator();
		this.fullName = name;
		this.attack = (super.getLevel());
	}
	
	public String firstNameGenerator() {
		int randomInt;
		randomInt = 0 + (int) (Math.random() * ((firstName.length - 0) + 0));
		String randomFName = firstName[randomInt];
		return randomFName;
	}
	
	@Override
	public void setMonsterName(String[] fullName) {
		this.firstName = fullName;
	}
	
}
