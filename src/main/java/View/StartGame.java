package View;

import java.util.ArrayList;

import Controller.HeroMaker;
import Model.Coordinates;
import Model.PcCoordinates;
import Controller.Movement;


public class StartGame {
	
	HeroMaker heromaker = HeroMaker.getHero();
	PcCoordinates pc = new PcCoordinates();
	Messages input = new Messages();
	//Map map = new Map();
	Movement move = new Movement();
	
	private int pcLevel;
	public int mapSize;
	public int cox = 0;
	public int coy = 0;
	private int position;
	boolean run;
	
	
	
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
		
		
		
		
		System.out.println("Mapsize is:"+this.mapSize);
		System.out.println("Player X coordinate is:"+cox);
		System.out.println("Player Y coordinate is:"+coy);
		
		run = true;
		
		while(true) {
			
		
			map.board[cox][coy] = " H ";
			map.placeEnemies();
			map.showBoard();
			int option =  input.movePlayer();
			move.move(option, cox, coy);
			
			

			
			map.board[cox][coy] = " * ";
			map.board[move.y][move.x] = " H ";
			
			map.showBoard();
			System.out.println("printing board after in start game");
//			map.showBoard();
//			
		
			System.exit(1);
			
			
		}
		
		
		
	}

}
