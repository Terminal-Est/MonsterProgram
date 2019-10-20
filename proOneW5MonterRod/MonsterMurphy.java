package proOneW5MonterRod;

import java.util.Random;

public class MonsterMurphy extends Monster {
	
	private String[] firstName = {"Taty", "Rod"};
	private String[] attacks = {"bark", "chase"};
	private int[] attackCost = {10, 20};
	private int[] attackDamage = {20, 10};
	private String fullName;
	private int attack;
	
	public MonsterMurphy() {
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
