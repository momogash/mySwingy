package View;

import java.util.ArrayList;
import java.util.Random;

import Model.Coordinates;

public class Map {

	private int size;
	public String [][] board;
	ArrayList<Coordinates> enemyCoordinate;
	
	//public Map() {}
	
	public Map(int level) {
		this.board = createBoard(mapSize(level));
		
	}
	
//	public void setSize(int level) {
//		this.size = (int) ((level -1) * 5 + 10 - (level*0.02));
//		
//	}
	
//	public int getSize() {
//		return this.size;
//	}
	
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
		System.out.println("You are here");
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
	public void move(int direction) {
		// prompt comes before here
		//1 North
		//2 South
		//3 East
		//4 West
		
		int x = 4;
		int y = 4; //should be received from hero class
		int mapsize = board.length;
		boolean Win = false;
		
		
		if(direction == 1)
		{//going up changes the y coordinates
			board[y][x] = " * ";
			if((y - 1 ) < 0 ){
				Win = true;
			}
			fight((y-1),x);
			
			board[y-1][x] = " E ";
			
			
		}
		
		else if(direction == 2)
		{
			board[y][x] = " * ";
			
			if((y + 1 ) == mapsize ) {
				
				Win = true;
			
			}
			fight((y+1),x);
			board[y+1][x] = " E ";	
		}
		
		else if(direction == 3)
		{
			board[y][x] = " * ";
			if((x-1) < 0) {
				Win = true;
			}
			fight((y),(x-1));
			board[y][x-1] = " E ";
			
		}
		else if(direction == 4)
		{
			board[y][x] = " * ";
			if((x + 1) == mapsize) {
				Win = true;
			}
			fight((y),(x+1));
			board[y][x+1] = " E ";
		}
		else 
		{
			System.out.println("incorrect value entered");
		}
		
		if(Win = true) {
			System.out.println("You have won!!!");
			System.exit(0);
		}
	}

	public void fight(int y, int x) {
		
		for(Coordinates c: enemyCoordinate) {
			if (c.getX() == x || c.getY() == y) {
				//fight algorithm
				System.out.println("You looose!!");
				System.exit(0);
				
			}
				
		}
		
	}
	
	
}
