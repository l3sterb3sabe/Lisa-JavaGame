package liza;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import java.awt.Point;
import java.io.InputStream;
import java.awt.Font;

public class LevelFive extends BasicGameState{

	Image map;
	Image character;
	Image lisaTemp;
	Image orbPic;
	Sound bgSound;
	String message = "";
	Input input;
	Animation man, manUp, manDown, manLeft, manRight;
	
	float positionX, positionY;
	int[] duration = {200, 200};
	double moveAmount = 1.5;
	float playerX, playerY;
	float lisaX, lisaY;
	int posPlayer = 24;
	int posLisa = 2;
	int goal = 12;
	int orb = 1;
	int origposPlayer = posPlayer, origposLisa = posLisa, origOrb = orb;
	String command = "";
	int calcPoints = 100;
	String initPoints;
	boolean finish;
	
	TrueTypeFont font;
	TrueTypeFont font2;
	
	int playerMoves, lisaMoves;
	
	int playerLocation;
	
	Point[][] points = 
		{
			{new Point(235,10), new Point(345,10),new Point(445,10),new Point(565,10),new Point(670,10),new Point(790,10)},
			{new Point(235,115),new Point(345,115),new Point(445,115),new Point(565,115),new Point(670,115),new Point(790,115)},
			{new Point(235,225),new Point(345,225),new Point(445,225),new Point(565,225),new Point(670,225),new Point(790,225)},
			{new Point(235,330),new Point(345,330),new Point(445,330),new Point(565,330),new Point(670,330),new Point(790,330)},
			{new Point(235,440),new Point(345,440),new Point(445,440),new Point(565,440),new Point(670,440),new Point(790,440)},
			{new Point(235,550),new Point(345,550),new Point(445,550),new Point(565,550),new Point(670,550),new Point(790,550)}
		};
	
	int[][] tileNames = {
			{ 1,  2,  3,  4,   5,  6},
			{ 7,  8,  9, 10 , 11, 12},
			{13, 14, 15, 16 , 17, 18},
			{19, 20, 21, 22,  23, 24},
			{25, 26, 27, 28,  29, 30},
			{31, 32, 33, 34,  35, 36}
	};
	
	public static int[][] heuristic;
	
	int[][] leftRightWall = {
								{7, 8},
								{11, 12},
								{14, 15},
								{16, 17},
								{20, 21},
								{22, 23},
								{25, 26},
								{28, 29},
								{32, 33},
								{34, 35}
							};
	int[][] upDownWall = {
							{5, 11},
							{8, 14},
							{9, 15},
							{12, 18},
							{21, 27},
							{23, 29},
							{28, 34}
						};
	
	
	public LevelFive(int levelfive){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		System.out.println("Level Five Ready!");
		map = new Image("res/LevelFive.jpg");
		bgSound = new Sound("res/Bent_and_Broken.ogg");
		bgSound.loop();
		orbPic = new Image("res/orb2.png");
		lisaTemp = new Image("res/LisaFinal.png");
		
		//Animation For Character/ Player
		Image[] charUp = {new Image("res/jakeUp.png"), new Image("res/jakeUp.png")};
		Image[] charDown = {new Image("res/jakeDown.png"), new Image("res/jakeDown.png")};
		Image[] charLeft = {new Image("res/jakeLeft.png"), new Image("res/jakeLeft.png")};
		Image[] charRight = {new Image("res/jakeRight.png"), new Image("res/jakeRight.png")};
		
		//Assign Animation
		manUp = new Animation(charUp, duration, false);
		manDown = new Animation(charDown, duration, false);
		manLeft = new Animation(charLeft, duration, false);
		manRight = new Animation(charRight, duration, false);
		man = manDown;
		
		Font awtFont = new Font("Times New Roman", Font.BOLD, 60);
		font = new TrueTypeFont(awtFont, false);
		
		//Load TTF File for font
		try{
				InputStream inputstream = ResourceLoader.getResourceAsStream("res/About Dead.ttf");
				
				Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputstream);
				awtFont2 = awtFont2.deriveFont(24f);
				font2 = new TrueTypeFont(awtFont2, false);
				
		}catch(Exception e){e.printStackTrace();}
		
		playerMoves = 1;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		initPoints = Integer.toString(calcPoints);
		map.draw(0,0);
		orbPic.draw(functions.getX(orb, tileNames, points), functions.getY(orb, tileNames, points));
		playerY = functions.getY(posPlayer, tileNames, points);
		playerX = functions.getX(posPlayer, tileNames, points);
		lisaY = functions.getY(posLisa, tileNames, points);
		lisaX = functions.getX(posLisa, tileNames, points);
		
		man.draw(playerX,playerY);
		lisaTemp.draw(lisaX, lisaY);
		
		g.drawString(message, 200, 0);
		//g.drawString(initPoints, 30, 30);
		font.drawString(60, 40, initPoints);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		int[] array = new int[2];
		
		//Reset Button
				if((xpos>=13 && xpos<=200)&&(ypos<=403 && ypos>=337)){
					if(Mouse.isButtonDown(0)){
						calcPoints = 100;
						posLisa = origposLisa;
						posPlayer = origposPlayer;
						orb = origOrb;
						playerMoves=1;
					}
				}
		//Menu Button
				if((xpos>=13 && xpos<=200)&&(ypos<=292 && ypos>=226)){
					if(Mouse.isButtonDown(0)){
						sbg.enterState(0);
					}
				}
				message = "X: " + xpos + ", Y: " + ypos + " Position : " + posPlayer + "Moves : " + playerMoves;
				
				input  = gc.getInput();
						//down
				
				if(playerMoves>0){
						Player.heuristic = heuristic;
						
						if(calcPoints>0){
							if(input.isKeyPressed(Input.KEY_DOWN)){
								array = Player.move(posPlayer, Input.KEY_DOWN, upDownWall, leftRightWall, man, manDown, manUp, manLeft, manRight);
								if(array[1] == 1){
									posPlayer = array[0];
									man = manDown;
									calcPoints -= 3;
									initPoints = Integer.toString(calcPoints);
									playerMoves--;
									heuristic = Player.getHeuristic();
									if(playerMoves==0){
										lisaMoves = 2;
									}
								}
							}
						}
						
						//up
						if(calcPoints>0){
							if(input.isKeyPressed(Input.KEY_UP)){
								array = Player.move(posPlayer, Input.KEY_UP, upDownWall, leftRightWall, man, manDown, manUp, manLeft, manRight);
								if(array[1] == 1){
									posPlayer = array[0];
									man = manUp;
									calcPoints -= 3;
									initPoints = Integer.toString(calcPoints);
									playerMoves--;
									heuristic = Player.getHeuristic();
									if(playerMoves == 0){
										lisaMoves = 2;
									}
								}
							}
						}
						
						//right
						if(calcPoints>0){
							if(input.isKeyPressed(Input.KEY_RIGHT)){
								array = Player.move(posPlayer, Input.KEY_RIGHT, upDownWall, leftRightWall, man, manDown, manUp, manLeft, manRight);
								if(array[1] == 1){
									posPlayer = array[0];
									man = manRight;
									calcPoints -= 3;
									initPoints = Integer.toString(calcPoints);
									playerMoves--;
									heuristic = Player.getHeuristic();
									if(playerMoves == 0){
										lisaMoves = 2;
									}
								}
							}
						}
						
						//left
						if(calcPoints>0){
							if(input.isKeyPressed(Input.KEY_LEFT)){
								array = Player.move(posPlayer, Input.KEY_LEFT, upDownWall, leftRightWall, man, manDown, manUp, manLeft, manRight);
								if(array[1] == 1){
									posPlayer = array[0];
									man = manLeft;
									calcPoints -= 3;
									initPoints = Integer.toString(calcPoints);
									playerMoves--;
									heuristic = Player.getHeuristic();
									if(playerMoves == 0){
										lisaMoves = 2;
									}
								}
							}
						}
				}
				if(lisaMoves>0){
					if(!(posLisa==posPlayer)){
						posLisa = Lisa.move( heuristic, posLisa, tileNames, upDownWall, leftRightWall);
						lisaMoves--;
						if(lisaMoves == 0){
							playerMoves = 1;
						}
					}//if(!(posLisa==posPlayer)){
				}
					
					if(posPlayer == goal){
						message = "You Win!";
						lisaMoves= 0;
						playerMoves = 0;
					}
					
					if(posPlayer == orb){
						calcPoints+=15;
						initPoints = Integer.toString(calcPoints);
						orb = -1;
					}
					
					if(posPlayer == posLisa){
						message = "You Lose";
						playerMoves = 0;
					}
					if(calcPoints<=0){
						message = "You Lose";
					}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 7;
	}

}
