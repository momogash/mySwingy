package View;

import java.util.ArrayList;

import Controller.HeroMaker;
import Model.Coordinates;
import Model.PcCoordinates;


public class StartGame {
	
	HeroMaker heromaker = HeroMaker.getHero();
	PcCoordinates pc = new PcCoordinates();
	Map map = new Map();
	
	private int pcLevel;
	private int mapSize;
	private int cox = 0;
	private int coy = 0;
	private ArrayList<Coordinates> c;
	
	
	public StartGame() {
		pcLevel = heromaker.getHeroLevel();
		Map map = new Map(pcLevel);
		map.mapSize(pcLevel);
		mapSize = map.board.length;
		
		//set players coordinates according to mapsize determined by level
		pc.setX(this.mapSize/2);
		pc.setY(this.mapSize/2);
		cox = pc.getX();
		coy = pc.getY();
		
		map.board[cox][coy] = " H ";
		
		
		System.out.println("Mapsize is:"+this.mapSize);
		System.out.println("Player X coordinate is:"+cox);
		System.out.println("Player Y coordinate is:"+coy);
		
		while(true) {
			//
			map.showBoard();
			//place enemies
			map.placeEnemies();
			map.showBoard();
		
			
			System.exit(1);
			
			
		}
		
		
		
	}

}
