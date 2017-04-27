package liza;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Story extends BasicGameState{
	
	Image line;
	String message = "";
	
	public Story(int story){
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		line = new Image("res/instruction.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		line.draw(110, 0);
		g.drawString(message, 100, 50);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		message = "X: " + xpos + " Y: " + ypos;
		
		if((xpos>=408 && xpos<=753)&&(ypos<=70 && ypos>=8)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(3);
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
