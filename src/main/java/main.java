import java.util.Scanner;

import Model.GameType;
import Model.NewHero;
import View.Messages;
import View.StartGame;

public class main {

	public static void main(String[] args) {
		
		Messages game = new Messages();
		GameType console = new GameType();
		NewHero hero = new NewHero();
		
		
		//choose game mode
		
		String GameType = args[0];
		try {
			
				if (GameType.equals("console")) {
					game.startGame();
					
					//game type input(gui/console)
					Scanner scan = new Scanner(System.in);
					int input = Integer.parseInt(scan.nextLine());
					console.game(input);
					
					//Player creation input or continue from previous game
					Scanner scann = new Scanner(System.in);
					int option = Integer.parseInt(scann.nextLine());
					console.playContinue(option);
					
					//hero creation
					hero.createHero();
					//start game/play
					StartGame start = new StartGame();
					//create map
					
					//place hero
					//place enemies
					
					
	
			}
//			else if(GameType.equals("GUI"))
//				StartGui Gui = new StartGui();
			
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Pass a valid argument:console/GUI");
				e.printStackTrace();
	
			}
		// TODO Auto-generated method stub

	}

}
