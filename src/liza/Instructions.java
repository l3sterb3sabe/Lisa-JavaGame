package liza;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Instructions extends BasicGameState{
	
	Sound bgMusic;
	Image controls;
	String message = "";
	
	public Instructions(int ins){
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		controls = new Image("res/instructions2.png");
		bgMusic = new Sound("res/ClickPlay.ogg");
		bgMusic.play();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		controls.draw(110, 0);
		g.drawString(message, 200, 100);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		message = "X: " + xpos + " Y: " + ypos;
		
		if((xpos>=307 && xpos<=555)&&(ypos<=100 && ypos>=20)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(2);
			}
		}
		
		
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
