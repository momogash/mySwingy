package View;

import java.util.ArrayList;

import java.util.Random;

import Controller.HeroMaker;
import Model.Coordinates;
import Model.PcCoordinates;

public class Map {

	private int size;
	public String [][] board;
	ArrayList<Coordinates> enemyCoordinate;
	PcCoordinates pc = new PcCoordinates();
	Messages write = new Messages();
	private String input= "";
	
	//public Map() {}
	
	public Map(int level) {
		this.board = createBoard(mapSize(level));
		
	}
	
	public int mapSize(int level) {
		int mapsize =  (level - 1) * 5 + 10 - (level % 2);
		return mapsize;
	}
	
	public String[][] createBoard(int mapsize){
		
		String[][] board = new String[mapsize][mapsize];
		for(int y = 0; y < mapsize; y++) {
			for(int x = 0; x < mapsize; x++) {
				board[y][x] = " * ";
						
			}
		}
		return board;
	}
	
	public ArrayList<Coordinates> Enemies() {
		System.out.println("Enemy creation");
		int enemyCount = board.length/2; //number of enemies to create according to size of map
		System.out.println("Enemy count in relation to board length " + board  + "is: " + enemyCount);
		
		enemyCoordinate = new ArrayList<Coordinates>();
		Random random = new Random();
		boolean coordinateExist = false;
		
		
		while(enemyCoordinate.size() != enemyCount) {
			int x = random.nextInt(board.length);
			int y = random.nextInt(board.length);
//			System.out.println("here " + x+ " " + y);
			
			for(Coordinates c: enemyCoordinate) {
				if (c.getX() == x || c.getY() == y)
					coordinateExist = true;
			}
			if(!coordinateExist) {
				enemyCoordinate.add(new Coordinates(x,y));
			} else
				coordinateExist = false;
				
			
		}
		return enemyCoordinate;
	}
	
	public void placeEnemies() {
//		System.out.println("You are here");
		ArrayList<Coordinates> placements = Enemies();
		
		for(Coordinates c: placements) {
			board[c.x][c.y] = " E ";  
		}
		
		//showBoard();
		
	}
	
	public void showBoard(){
		
		
		for(int y = 0; y < board.length; y++) {
			for(int x = 0; x < board.length; x++) {
			System.out.print(board[y][x]);
						
			}
			System.out.println();
		}
		
	}
	
	//movement
	public void move(int direction,int cox, int coy) {
		// prompt comes before here
		//1 North
		//2 South
		//3 East
		//4 West
		
		
		int x = cox;
//		System.out.println("pc's x is:" + x);
		int y = coy; //should be received from hero class
//		System.out.println("pc's x is:" + y);
		int mapsize = board.length;
		boolean Move = false;
		
		
		if(direction == 1)
		{//going up changes the y coordinates
			board[y][x] = " * ";
			if((y - 1 ) < 0 ){
				Move = false;
			}
			board[y-1][x] = " H ";
			showBoard();
			if(y == 1)
				System.out.println("move to nexgt level");
			else {
				y = y -1;
				pc.setY(y);
				System.out.println("lets fight");
				Move = true;
				//fight((y-1),x);
				
			}
			
			
			
			
			
			
		}
		
		else if(direction == 2)
		{
			board[y][x] = " * ";
			
			if((y + 1 ) == mapsize ) {
				
				Move = true;
			
			}
			//fight((y+1),x);
			board[y+1][x] = " H ";	
			showBoard();
		}
		
		else if(direction == 3)
		{
			board[y][x] = " * ";
			if((x-1) < 0) {
				Move = true;
			}
			//fight((y),(x-1));
			board[y][x-1] = " H ";
			showBoard();
			
		}
		else if(direction == 4)
		{
			board[y][x] = " * ";
			if((x + 1) == mapsize) {
				Move = true;
			}
			//fight((y),(x+1));
			board[y][x+1] = " H ";
			showBoard();
		}
		else 
		{
			System.out.println("incorrect value entered");
		}
		
		if(Move = true)
		{
			//check if you have not encountered an enemey
			for(Coordinates c: enemyCoordinate) {
				System.out.println(c.getX());
				System.out.println(c.getY());
				System.out.println(x);
				System.out.println(y);
				if (c.getX() == x || c.getY() == y) {
					//fight algorithm
					input = write.encounter();
					if(input.equals("f"))
					{
						System.out.println(HeroMaker.getHero().getHeroAttack());
						if(HeroMaker.getHero().getHeroAttack() < 100) {
							System.out.println("My power is unsuparsed......You loose");
							System.exit(1);
							
						}
						else {
							System.out.println("You have won this fight.....i will return with might!!!!");
							//should gain artefact or experience after winning 
							//then move to next level
							
						}
						}
					}
					
				}
			
//			System.out.println("You have won!!!");
//			System.exit(0);
		}
	}

//	public void fight(int y, int x) {
//		
//		for(Coordinates c: enemyCoordinate) {
//			if (c.getX() == x || c.getY() == y) {
//				//fight algorithm
//				System.out.println("You looose!!");
//				System.exit(0);
//				
//			}
//				
//		}
//		
//	}
	
	
}
