package liza;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Keyboard;
import java.awt.Point;

public class Levels extends BasicGameState{
	
	Image map;
	Image character;
	Sound bgSound;
	String message = "";
	Input input;
	Animation man, manUp, manDown, manLeft, manRight;
	float positionX, positionY;
	int[] duration = {200, 200};
	double moveAmount = 1.5;
	int startX = 0, startY = 0;
	String command = "";
	
	int playerLocation;
	
	Point[][] points = {
			{new Point(25,10), new Point(130,10),new Point(235,10),new Point(345,10),new Point(455,10),new Point(565,10)},
			{new Point(25,115),new Point(130,115),new Point(235,115),new Point(345,115),new Point(455,115),new Point(565,115)},
			{new Point(25,225),new Point(130,225),new Point(235,225),new Point(345,225),new Point(455,225),new Point(565,225)},
			{new Point(25,330),new Point(130,330),new Point(235,330),new Point(345,330),new Point(455,330),new Point(565,330)},
			{new Point(25,440),new Point(130,440),new Point(235,440),new Point(345,440),new Point(455,440),new Point(565,440)},
			{new Point(25,550),new Point(130,550),new Point(235,550),new Point(345,550),new Point(455,550),new Point(565,550)}
		};
	
	int[][] tileNumber = {
			{1, 2, 3, 4 ,5, 6},
			{7, 8, 9, 10 ,11, 12},
			{13, 14, 15, 16 , 17, 18},
			{19, 20, 21, 22, 23, 24,},
			{25, 26, 27, 28, 29, 30},
			{31, 32, 33, 34, 35, 36}
	};
	
	
	int[][] heuristic = {
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}
		};
	
	
	Point testPoint = new Point(25, 550);
	
	
	public Levels(int levels){
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		map = new Image("res/PrototypeMap.jpg");
		character = new Image("res/jakeDown.png");
		bgSound = new Sound("res/Bent_and_Broken.ogg");
		bgSound.loop();
		positionX = 560;
		positionY = 25;
		Image[] moveUp = {new Image("res/jakeUp.png"), new Image("res/jakeUp.png")};
		Image[] moveDown = {new Image("res/jakeDown.png"), new Image("res/jakeDown.png")};
		Image[] moveLeft = {new Image("res/jakeLeft.png"), new Image("res/jakeLeft.png")};
		Image[] moveRight = {new Image("res/jakeRight.png"), new Image("res/jakeRight.png")};
		
		manUp = new Animation(moveUp, duration, false);
		manDown = new Animation(moveDown, duration, false);
		manLeft = new Animation(moveLeft, duration, false);
		manRight = new Animation(moveRight, duration, false);
		man = manDown;

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		map.draw(0,0);
		man.draw(points[startX][startY].x,points[startX][startY].y);
		g.drawString(message, 400, 0);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		message = "X: " + xpos + ", Y: " + ypos;
		
		input  = gc.getInput();
		
			//down
			if(input.isKeyPressed(Input.KEY_DOWN)){
				if(startX<5){
					startX++;
					man = manDown;
				}
			}
			//up
			else if(input.isKeyPressed(Input.KEY_UP)){
				if(startX>0){
					startX--;
					man = manUp;
				}	
			}
			//right
			else if(input.isKeyPressed(Input.KEY_RIGHT)){
				if(startY<5){
					startY++;
					man = manRight;
				}
			}
			//left
			else if(input.isKeyPressed(Input.KEY_LEFT)){
				if(startY>0){
					startY--;
					man = manLeft;
				}
			}
	
	}
	@Override
	public int getID() {
		
		return 1;
	}
	
	

}
