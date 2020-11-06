package Model;

public class HeroCreator {
	
	private String HeroName;
	private String HeroType;
	private int HeroHitPoints;
	private int HeroXp;
	private int HeroAttack;
	private int HeroLevel;
	private int HeroDefense;
//	private int Herox;
//	private int Heroy;
	//private int experience;
	
	public HeroCreator() {}
	
	public BuildHero Builder() {
		
		return new BuildHero (HeroName, HeroType, HeroHitPoints, HeroXp, HeroAttack, HeroLevel, HeroDefense);
				
	}
	
	public HeroCreator setHeroName(String name) {
		this.HeroName = name;
		return this;
	}
	
	public HeroCreator setHeroType(String type) {
		this.HeroType = type;
		return this;
	}
	public HeroCreator setHeroHitPoints(int HitPoints) {
		this.HeroHitPoints = HitPoints;
		return this;
	}
	public HeroCreator setHeroXp(int Xp) {
		this.HeroXp = Xp;
		return this;
	}
	public HeroCreator setHeroAttack(int Attack) {
		this.HeroAttack = Attack;
		return this;
	}
	public HeroCreator setHeroLevel(int Level) {
		this.HeroLevel = Level;
		return this;
	}
	public HeroCreator setHeroDefense(int Defense) {
		this.HeroDefense = Defense;
		return this;
	}
//	public HeroCreator setHerox(int x) {
//		this.Herox = x;
//		return this;
//	}
//	public HeroCreator setHeroy(int y) {
//		this.Heroy = y;
//		return this;
//	}


}
