package Controller;

import Model.BuildHero;
import Model.HeroCreator;

public class HeroMaker {
	
	private String HeroName;
	private String HeroType;
	private int HeroHitPoints;
	private int HeroXp;
	private int HeroAttack;
	private int HeroLevel;
	private int HeroDefense;
//	private int x;
//	private int y;
	//private int experience;
	private int Heroid;
	private static BuildHero heromaker;
	private static HeroMaker instance = null;
	
	public HeroMaker() {}
	
	
	//check if it hasnt been created already
	public static HeroMaker getHero() {
		if (instance == null) {
			instance = new HeroMaker();
			return instance;
		}
		else 
			return instance;
		
	}
	
	public void buildHero() {
		HeroCreator build = new HeroCreator();
		build.setHeroName(HeroName).setHeroType(this.HeroType).setHeroHitPoints(this.HeroHitPoints).setHeroXp(this.HeroXp).setHeroAttack(this.HeroAttack).setHeroLevel(this.HeroLevel).setHeroDefense(this.HeroDefense);
		this.heromaker = build.Builder();
	}

	
	public void setHeroName(String name) {
		this.HeroName = name;
		//System.out.println(this.HeroName);
	}
	
	public String getHeroName() {
		return this.HeroName;
	}
	
	
	public void setHeroType(String type) {
		this.HeroType = type;
	}
	
	public String getHeroType() {
		return this.HeroType;
	}
	
	public void setHeroHitPoints(Integer hitpoints) {
		this.HeroHitPoints = hitpoints;
	}
	
	public Integer getHeroHitPoints() {
		return this.HeroHitPoints;
	}
	
	public void setHeroXp(Integer level1) {
		this.HeroXp = level1 * 1000 + ((level1-1)* (level1 - 1)* 450);
		this.HeroXp = HeroXp;
	}
	
	public Integer getHeroXp() {
		return this.HeroXp;
	}
	
	public void setHeroAttack(Integer attack) {
		this.HeroAttack = attack;
	}
	
	public Integer getHeroAttack() {
		return this.HeroAttack;
	}
	
	public void setHeroLevel(Integer level1) {
		this.HeroLevel = level1;
	
	}
	
	public Integer getHeroLevel() {
		return this.HeroLevel;
	}
      
	public void setHeroDefense(Integer defense) {
		this.HeroDefense = defense;
		return;
	}
	
	public Integer getHeroDefense() {
		return this.HeroDefense;
	}
	
//	public void setx(Integer co_x) {
//		this.x = co_x;
//		return;
//	}
//	
//	public Integer getx() {
//		return this.x;
//	}
//	public void sety(Integer co_y) {
//		this.y = co_y;
//		return;
//	}
//	
//	public Integer gety() {
//		return this.y;
//	}
	
//	public void setexperience(Integer experience1) {
//		this.experience = experience1;
//		return;
//	}
//	
//	public Integer getexperience() {
//		return this.experience;
//	}
	
	
//	public int getHeroid() {
//		return this.Heroid;
//	}
//
//
//	public void setHeroid(int heroid) {
//		this.Heroid = heroid;
//		return;
//	}


	public BuildHero build() {
		return heromaker;
		
	}

}
