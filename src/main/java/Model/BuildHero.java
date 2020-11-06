package Model;

public class BuildHero {
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

    public BuildHero(String HeroName, String HeroType, int HeroHitPoints, int HeroXp, int HeroAttack, int HeroLevel, int HeroDefense){
        this.HeroName = HeroName;
        this.HeroType = HeroType;
        this.HeroHitPoints = HeroHitPoints;
        this.HeroXp = HeroXp;
        this.HeroLevel = HeroLevel;
        this.HeroAttack = HeroAttack; 
        this.HeroDefense = HeroDefense;
//        this.x = x;
//        this.y = y;
//        this.experience = experience;
        
    }

}
