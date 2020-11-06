package Model;

import Controller.HeroMaker;

public class PcCoordinates {
	private HeroMaker hero = HeroMaker.getHero();
	private int cox;
	private int coy;
	private int mapSize;
	
	public PcCoordinates() {}
	
	public void setX(int x) {
		this.cox = x;
	}
	public int getX() {
		return this.cox;
	}
	public void setY(int y) {
		this.coy = y;
	}
	public int getY() {
		return this.coy;
	}
	public void setXP(int level) {
		hero.setHeroXp(level);
	}
	public void setMapSize(int level) {
		this.mapSize = (level - 1) * 5 + 10 - (level % 2);
	}
	public int getMapSize() {
		return this.mapSize;
	}
	public void nextLevel() {
		hero.setHeroLevel(hero.getHeroLevel() + 1);
		hero.setHeroAttack(hero.getHeroAttack() + 10);
		hero.setHeroDefense(hero.getHeroDefense() + 10);
		setXP(hero.getHeroLevel());
		setMapSize(hero.getHeroLevel());
		setX(this.mapSize/2);
		setY(this.mapSize/2);
		//place enemies from Map
		System.out.println("place enemies from Map");
	}
	

}
