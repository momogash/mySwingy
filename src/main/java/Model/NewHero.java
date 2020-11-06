package Model;

import java.util.Scanner;

import Controller.HeroMaker;

public class NewHero {
	
	HeroMaker heromaker = HeroMaker.getHero();
	//Db_Connection conn = new Db_Connection();
//	Map map = new Map();
	
	public NewHero() {}
	
	public void printHeroStats() {
	System.out.println("You have successfully created a hero!!");
	System.out.println(HeroMaker.getHero().getHeroName() + " | " + HeroMaker.getHero().getHeroType() + " | " + "Current XP : " + HeroMaker.getHero().getHeroXp()

    + " | " + "Current Attack Amount : " + HeroMaker.getHero().getHeroAttack() + " | " + "Current hit points : "+ HeroMaker.getHero().getHeroHitPoints()
    + " | " + "Current Defense points : " + HeroMaker.getHero().getHeroDefense());
	
}
	
	public void createHero() {
		System.out.println("Enter player name");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println("Select hero type to create from below:"
				+ "Press 1 WonderWoman"+
				 "press 2 CaptainMarvel" +
				"Press 3 for Wakanda Warrior");
		
		Scanner scanner = new Scanner(System.in);
		int option = Integer.parseInt(scanner.nextLine());
		
	
		if (option == 1) {
			
			heromaker.setHeroName(name);
			heromaker.setHeroType("WonderWoman");
			heromaker.setHeroAttack(100);
			//heromaker.setexperience(20);
			heromaker.setHeroDefense(15);
			heromaker.setHeroHitPoints(10);
			heromaker.setHeroLevel(1);
			heromaker.setHeroXp(heromaker.getHeroLevel());
			printHeroStats();
			
			//System.out.println("You created a Wonderwoman now save into database\n");	
		//	System.out.println("start game\n");
			
		}
		else if (option == 2) {
			//String name = scan.nextLine();
			heromaker.setHeroName(name);
			heromaker.setHeroType("CaptainMarvel");
			heromaker.setHeroAttack(500);
		//	heromaker.setexperience(60);
			heromaker.setHeroDefense(100);
			heromaker.setHeroHitPoints(200);
			heromaker.setHeroLevel(1);
			heromaker.setHeroXp(heromaker.getHeroLevel());
			printHeroStats();
			
			//System.out.println("You created a Captain Marvel now save into database\n");	
			//System.out.println("start game\n");
			
		}
		else if (option == 3) {
		//1String name = scan.nextLine();
			heromaker.setHeroName(name);
			heromaker.setHeroType("Wankanda Warriors");
			heromaker.setHeroAttack(500);
		//	heromaker.setexperience(50);
			heromaker.setHeroDefense(200);
			heromaker.setHeroHitPoints(400);
			heromaker.setHeroLevel(1);
			heromaker.setHeroXp(heromaker.getHeroLevel());
			printHeroStats();
			
			//System.out.println("You created a Wakanda Warrior now save into database\n");	
			//System.out.println("start game\n");
			
		}
		
//    
        else{
        	System.out.println("Invalid Entry....");
            scan.nextLine();
            createHero();
        }
		
	
		
	}
	
//	public void Gameset() throws ClassNotFoundException, SQLException {
//		//set map size according to player level
//		
//		ResultSet lastInfo = conn.lastInsert();
//		System.out.println(lastInfo.getInt("level"));
//		map.setSize(lastInfo.getInt("level")); 
//		
//		//set hero's coordinates
//		//update db with x coordinates
//		heromaker.setx(map.getSize()/2);
//		System.out.println(heromaker.getx());
//		
//		
//	}

}
