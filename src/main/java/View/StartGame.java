package View;

import java.util.ArrayList;

import Controller.HeroMaker;
import Model.Coordinates;
import Model.PcCoordinates;


public class StartGame {
	
	HeroMaker heromaker = HeroMaker.getHero();
	PcCoordinates pc = new PcCoordinates();
	Messages input = new Messages();
	//Map map = new Map();
	
	private int pcLevel;
	private int mapSize;
	public int cox = 0;
	public int coy = 0;
	
	
	
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
			
			map.showBoard();
			//place enemies
			map.placeEnemies();
			map.board[cox][coy] = " H ";
			map.showBoard();
			int option =  input.movePlayer();
			map.move(option,cox,coy);
			
			map.showBoard();
		
			System.exit(1);
			
			
		}
		
		
		
	}

}
