package Controller;
import View.Map;
import View.StartGame;
import Controller.HeroMaker;

public class Movement {
	
	HeroMaker hero = new HeroMaker();
	
	
	
	Map map = new Map(hero.getHeroLevel());
	
	public int x;
	public int y;
	private int size;
	boolean Move = true;
	

	
	
	public void move(int direction,int cox, int coy) {
		
		size = map.board.length;
		this.x = cox;
		this.y = coy;

		
		if(direction == 1) {
			y--;
			

		}
		else if(direction == 2) {
			y++;

		}
		else if(direction == 3) {
			x--;

		}
		else if(direction == 4) {
			x++;

		}
		if((y < 0 |  y >= (size)) | (x < 0 | x >= (size))) {
			System.out.println("Move on to the next level");
		}
	}
	

}
