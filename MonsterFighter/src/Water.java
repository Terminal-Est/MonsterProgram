
public class Water extends Monster {

	private String name;
	private double str;
	private double intel;
	private double dex;
	private double hp;
	private double mp;
	private int lvl;
	
	public Water(String name, double str, double intel, double dex) {
		super(name, str, intel, dex);
		this.name = name;
		this.str = str;
		this.intel = intel;
		this.dex = dex;
		this.hp = Monster.HP;
		this.mp = Monster.MP;
		this.lvl = Monster.LVL;

	}

	@Override
	public void showMonster() {
		System.out.println(this.name);
		System.out.printf("%.0f%n", this.str);
		System.out.printf("%.0f%n", this.intel);
		System.out.printf("%.0f%n", this.dex);
		System.out.println(this.hp);
		System.out.println(this.mp);
		System.out.println(this.lvl);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setStats() {
		this.str = 20 + (this.str - 20) * rand.nextDouble();
		this.intel = 15 + (this.intel - 15) * rand.nextDouble();
		this.dex = 15 + (this.dex - 15) * rand.nextDouble();
	}

}
