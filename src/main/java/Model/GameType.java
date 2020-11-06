package Model;
import View.Messages;
import Controller.Game_Default;

public class GameType {
	
	Messages message = new Messages();
	Game_Default exit = new Game_Default();
	
	public GameType(){}
	
	public void game(int input) {
		
		if (input == 1) {
			
			message.startConsole();
			
//			NewConsoleGame console = new NewConsoleGame();
//			console.startConstole();
//			
		}
			
		
		else if (input == 2)
		{
			System.out.println("Start GUI");
			
		}
		else if (input == 3) {
			exit.Exitgame();
			
		} 
		
	}
	
	public void playContinue (int option) {
		
		if (option == 1) 
			message.createPlayer();
			
		
		
		
	}

}
