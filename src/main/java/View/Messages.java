package View;

import java.util.Scanner;

public class Messages {
	
	public Messages() {}
	
	
	public void startGame() {
		
		System.out.println("Welcome to Swingy Console mode!!");
		System.out.println("Press 1 to start a new console game, 2 to continue | 3 to exit the console");
	}
	
	public void startConsole() {
		System.out.println("Press 1 to create a new Player | 2 to continue\n");
		
	}
	
	public void createPlayer() {
		System.out.println("creating a new player");
	}
	
	public int movePlayer() {
		System.out.println("Press 1 to move up | 2 to move down | 3 to move left | 4 to move right");
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.next()); 
		return input;
		
	}
	public String encounter() {
		
		System.out.println("You looose!!");
		System.out.println("You have encountered an enemy");
		System.out.println("Press f to fight or r to run");
		Scanner scan = new Scanner(System.in);
		String input = scan.next(); 
		return input;
		
	}
	

}
