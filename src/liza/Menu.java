package liza;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {

	Image title;
	String message = "";
	
	public Menu(int menu){
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		title = new Image("res/PlayWithLiza2.jpg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		title.draw(0,0);
		g.drawString(message, 400, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		message = "X: " + xpos + ", Y: " + ypos;

		if((xpos>=250 && xpos<=620)&&(ypos<=590 && ypos>=390)){
			title = new Image("res/PlayWithLiza2.1.jpg");
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
		
		else{
			title = new Image("res/PlayWithLiza2.jpg");
		}
		
		if((xpos>=3 && xpos<=196)&&(ypos<=185 && ypos>=85)){
			title = new Image("res/customGame.jpg");
			if(Mouse.isButtonDown(0)){
				sbg.enterState(8);
			}
		}
		
		else{
			title = new Image("res/PlayWithLiza2.jpg");
		}
		
	}

	@Override
	public int getID() {
		return 0;
	}
	
}
