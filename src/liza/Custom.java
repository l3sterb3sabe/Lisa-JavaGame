package liza;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;
import org.lwjgl.input.Keyboard;
import java.awt.Point;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.Font;

public class Custom extends BasicGameState{

//	int[][] horiPoints = {
//			
//			{1, 7},{2, 8},{3, 9},{4, 10},{5, 11}, {6, 11},
//			{7, 13}, {8, 14}, {9, 15}, 
//			
//	};

	
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
	
	int[] array;
	
	Image map;
	Image horizontal1, horizontal2, horizontal3, horizontal4, horizontal5, horizontal6, 
		  horizontal7, horizontal8, horizontal9, horizontal10, horizontal11, horizontal12,
		  horizontal13, horizontal14, horizontal15, horizontal16, horizontal17, horizontal18,
		  horizontal19, horizontal20, horizontal21, horizontal22, horizontal23, horizontal24, 
		  horizontal25, horizontal26, horizontal27, horizontal28, horizontal29, horizontal30;

	Image vertical1, vertical2, vertical3, vertical4, vertical5, vertical6,
		  vertical7, vertical8, vertical9, vertical10, vertical11, vertical12,
		  vertical13, vertical14, vertical15, vertical16, vertical17, vertical18,
		  vertical19, vertical20, vertical21, vertical22, vertical23, vertical24,
		  vertical25, vertical26, vertical27, vertical28, vertical29, vertical30;
	
	Image horizontalLine;
	Image horizontalPoint;
	Image verticalLine;
	Image verticalPoint;
	
	Image[] sub = new Image[30];
	Image[] temp = new Image[30];
		
	boolean[] horiBool = new boolean[30];
	boolean[] veriBool = new boolean[30];
	ArrayList<ArrayList<Integer>> walls = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> holder = new ArrayList<Integer>();
	
	Animation man, manUp, manDown, manLeft, manRight;
	int[] duration = {200, 200};
	
	Image stairs;
	Image player;
	Image lisa;
	Image orbPic;
	Image blank;
	Animation tempPlayer;
	String message = "";
	
	int posLisa, goal, orb;
	int posPlayer;
	
	int playerMoves = 1;
	int lisaMoves;
	
	boolean flagPlayer = true;
	boolean flagGoal = true;
	boolean flagOrb = true;
	boolean flagLisa = true;
	boolean notExistPlayer = true;
	boolean notExistGoal = true;
	boolean notExistOrb = true;
	boolean notExistLisa = true;
	
	float playerX, playerY, goalX, goalY, lisaX, lisaY, orbX, orbY;
	
	public Custom(int custom){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		map = new Image("res/CustomMap.jpg");
		horizontalLine = new Image("res/horizontalLine.jpg");
		horizontalPoint = new Image("res/horizontalPoint.png");
		verticalLine = new Image("res/verticalLine.jpg");
		verticalPoint = new Image("res/verticalPoint.png");
		blank = new Image("res/horizontalEmpty.png");
		stairs = new Image("res/customStairs.jpg");
		lisa = new Image("res/LisaFinal.png");
		orbPic = new Image("res/orb2.png");
		
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
		tempPlayer = manDown;
		
		sub[0] = horizontalPoint;
		sub[1] = horizontalPoint;
		sub[2] = horizontalPoint;
		sub[3] = horizontalPoint;
		sub[4] = horizontalPoint;
		sub[5] = horizontalPoint;
		sub[6] = horizontalPoint;
		sub[7] = horizontalPoint;
		sub[8] = horizontalPoint;
		sub[9] = horizontalPoint;
		sub[10] = horizontalPoint;
		sub[11] = horizontalPoint;
		sub[12] = horizontalPoint;
		sub[13] = horizontalPoint;
		sub[14] = horizontalPoint;
		sub[15] = horizontalPoint;
		sub[16] = horizontalPoint;
		sub[17] = horizontalPoint;
		sub[18] = horizontalPoint;
		sub[19] = horizontalPoint;
		sub[20] = horizontalPoint;
		sub[21] = horizontalPoint;
		sub[22] = horizontalPoint;
		sub[23] = horizontalPoint;
		sub[24] = horizontalPoint;
		sub[25] = horizontalPoint;
		sub[26] = horizontalPoint;
		sub[27] = horizontalPoint;
		sub[28] = horizontalPoint;
		sub[29] = horizontalPoint;
		
		temp[0] = verticalPoint;
		temp[1] = verticalPoint;
		temp[2] = verticalPoint;
		temp[3] = verticalPoint;
		temp[4] = verticalPoint;
		temp[5] = verticalPoint;
		temp[6] = verticalPoint;
		temp[7] = verticalPoint;
		temp[8] = verticalPoint;
		temp[9] = verticalPoint;
		temp[10] = verticalPoint;
		temp[11] = verticalPoint;
		temp[12] = verticalPoint;
		temp[13] = verticalPoint;
		temp[14] = verticalPoint;
		temp[15] = verticalPoint;
		temp[16] = verticalPoint;
		temp[17] = verticalPoint;
		temp[18] = verticalPoint;
		temp[19] = verticalPoint;
		temp[20] = verticalPoint;
		temp[21] = verticalPoint;
		temp[22] = verticalPoint;
		temp[23] = verticalPoint;
		temp[24] = verticalPoint;
		temp[25] = verticalPoint;
		temp[26] = verticalPoint;
		temp[27] = verticalPoint;
		temp[28] = verticalPoint;
		temp[29] = verticalPoint;

		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map.draw(0,0);
		horizontal1 = sub[0];
		horizontal1.draw(220, 100);
		horizontal2 = sub[1];
		horizontal2.draw(325, 100);
		horizontal3 =sub[2];
		horizontal3.draw(433, 100);
		horizontal4 =sub[3];
		horizontal4.draw(540, 100);
		horizontal5 =sub[4];
		horizontal5.draw(650, 100);
		horizontal6 =sub[5];
		horizontal6.draw(760, 100);
		horizontal7 =sub[6];
		horizontal7.draw(220, 207);
		horizontal8 =sub[7];
		horizontal8.draw(325, 207);
		horizontal9 =sub[8];
		horizontal9.draw(433, 207);
		horizontal10 =sub[9];
		horizontal10.draw(540, 207);
		horizontal11 =sub[10];
		horizontal11.draw(650, 207);
		horizontal12 =sub[11];
		horizontal12.draw(760, 207);
		horizontal13 =sub[12];
		horizontal13.draw(220, 314);
		horizontal14 =sub[13];
		horizontal14.draw(325, 314);
		horizontal15 =sub[14];
		horizontal15.draw(433, 314);
		horizontal16 =sub[15];
		horizontal16.draw(540, 314);
		horizontal17 =sub[16];
		horizontal17.draw(650, 314);
		horizontal18 =sub[17];
		horizontal18.draw(760, 314);
		horizontal19 =sub[18];
		horizontal19.draw(220, 421);
		horizontal20 =sub[19];
		horizontal20.draw(325, 421);
		horizontal21 =sub[20];
		horizontal21.draw(433, 421);
		horizontal22 =sub[21];
		horizontal22.draw(540, 421);
		horizontal23 =sub[22];
		horizontal23.draw(650, 421);
		horizontal24 =sub[23];
		horizontal24.draw(760, 421);
		horizontal25 =sub[24];
		horizontal25.draw(220, 528);
		horizontal26 =sub[25];
		horizontal26.draw(325, 528);
		horizontal27 =sub[26];
		horizontal27.draw(433, 528);
		horizontal28 =sub[27];
		horizontal28.draw(540, 528);
		horizontal29 =sub[28];
		horizontal29.draw(650, 528);
		horizontal30 =sub[29];
		horizontal30.draw(760, 528);
		
		vertical1 = temp[0];
		vertical1.draw(315, 0);
		vertical2 = temp[1];
		vertical2.draw(420, 0);
		vertical3 = temp[2];
		vertical3.draw(530, 0);
		vertical4 = temp[3];
		vertical4.draw(638, 0);
		vertical5 = temp[4];
		vertical5.draw(748, 0);
		vertical6 = temp[5];
		vertical6.draw(315, 110);
		vertical7 = temp[6];
		vertical7.draw(420, 110);
		vertical8 = temp[7];
		vertical8.draw(530, 110);
		vertical9 = temp[8];
		vertical9.draw(638, 110);
		vertical10 = temp[9];
		vertical10.draw(748, 110);
		vertical11 = temp[10];
		vertical11.draw(315, 220);
		vertical12 = temp[11];
		vertical12.draw(420, 220);
		vertical13 = temp[12];
		vertical13.draw(530, 220);
		vertical14 = temp[13];
		vertical14.draw(638, 220);
		vertical15 = temp[14];
		vertical15.draw(748, 220);
		vertical16 = temp[15];
		vertical16.draw(315, 325);
		vertical17 = temp[16];
		vertical17.draw(420, 325);
		vertical18 = temp[17];
		vertical18.draw(530, 325);
		vertical19 = temp[18];
		vertical19.draw(638, 325);
		vertical20 = temp[19];
		vertical20.draw(748, 325);
		vertical21 = temp[20];
		vertical21.draw(315, 435);
		vertical22 = temp[21];
		vertical22.draw(420, 435);
		vertical23 = temp[22];
		vertical23.draw(530,  435);
		vertical24 = temp[23];
		vertical24.draw(638, 435);
		vertical25 = temp[24];
		vertical25.draw(748, 435);
		vertical26 = temp[25];
		vertical26.draw(315, 545);
		vertical27 = temp[26];
		vertical27.draw(420, 545);
		vertical28 = temp[27];
		vertical28.draw(530, 545);
		vertical29 = temp[28];
		vertical29.draw(638, 545);
		vertical30 = temp[29];
		vertical30.draw(748, 545);
		if(!flagPlayer){
			playerX = functions.getX(posPlayer, tileNames, points);
			playerY = functions.getY(posPlayer, tileNames, points);
			man = tempPlayer;
			man.draw(playerX, playerY);
		}
		if(!flagGoal){
			goalX = functions.getX(goal, tileNames, points) - 20;
			goalY = functions.getY(goal, tileNames, points) - 5;
			stairs.draw(goalX, goalY);
		}
		if(!flagLisa){
			lisaX = functions.getX(posLisa, tileNames, points);
			lisaY = functions.getY(posLisa, tileNames, points);
			lisa.draw(lisaX, lisaY);
		}
		if(!flagOrb){
			orbX = functions.getX(orb, tileNames, points) + 15;
			orbY = functions.getY(orb, tileNames, points) + 20;
			orbPic.draw(orbX, orbY);
		}
		
		g.drawString(message, 500, 10);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		Input input;
		
		input = gc.getInput();
		message = "X : " + xpos + " Y : "+ ypos;
		
		//Play Button
		if((xpos>=11 && xpos<=200)&&(ypos<=217 && ypos>=151)){
			if(Mouse.isButtonDown(0)){
				for(int i = 0; i< horiBool.length; i++){
					if(!horiBool[i]){
						sub[i] = blank;
					}
					if(!veriBool[i]){
						temp[i] = blank;
					}
				}
				
			}
		}
		
		//Reset Button
		if((xpos>=11 && xpos<=200)&&(ypos<=142 && ypos>=77)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(8);
					}
				}
		
	//Menu Button
		if((xpos>=11 && xpos<=200)&&(ypos<=67 && ypos>=0)){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(0);
					}
				}
		
		if(playerMoves>0){
			Player.heuristic = heuristic;
			if(input.isKeyPressed(Input.KEY_DOWN)){
				array = Player.moveCustom(posPlayer, Input.KEY_DOWN, horiBool, veriBool);
					if(array[1] == 1){
						posPlayer = array[0];
						tempPlayer = manDown;
						heuristic = Player.getHeuristic();
						playerMoves--;
						if(playerMoves == 0){
							lisaMoves = 2;
						}
					}
			}
			if(input.isKeyPressed(Input.KEY_LEFT)){
				array = Player.moveCustom(posPlayer, Input.KEY_LEFT, horiBool, veriBool);
					if(array[1] == 1){
						posPlayer = array[0];
						tempPlayer = manLeft;
						heuristic = Player.getHeuristic();
						playerMoves--;
						if(playerMoves == 0){
							lisaMoves = 2;
						}
					}
			}
			
			if(input.isKeyPressed(Input.KEY_RIGHT)){
				array = Player.moveCustom(posPlayer, Input.KEY_RIGHT, horiBool, veriBool);
					if(array[1] == 1){
						posPlayer = array[0];
						tempPlayer = manRight;
						playerMoves--;
						heuristic = Player.getHeuristic();
						if(playerMoves == 0){
							lisaMoves = 2;
						}
					}
			}
			
			if(input.isKeyPressed(Input.KEY_UP)){
				array = Player.moveCustom(posPlayer, Input.KEY_UP, horiBool, veriBool);
					if(array[1] == 1){	
						posPlayer = array[0];
						tempPlayer = manUp;
						heuristic = Player.getHeuristic();
						playerMoves--;
						if(playerMoves == 0){
							lisaMoves = 2;
						}
					}
			}
		}
		
		if(lisaMoves>0){
			if(!(posLisa==posPlayer)){
				posLisa = Lisa.moveCustom(heuristic, posLisa, tileNames, horiBool, veriBool);
				lisaMoves--;
				playerMoves = 0;
				if(lisaMoves == 0){
					playerMoves = 1;
				}
			}//if(!(posLisa==posPlayer)){
		}
		
		if(posPlayer == goal){
			//message = "YouWin";
		}
		
		//hpoint1
		if((xpos>=264 && xpos<=278)&&(ypos<=544 && ypos>=533)){
			if(Mouse.isButtonDown(0)){
				sub[0] = horizontalLine;
				horiBool[0] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[0] = horizontalPoint;
				horiBool[0] = false;
			}
		}//hpoint1
		
		//hpoint2
		if((xpos>=368 && xpos<=384)&&(ypos<=544 && ypos>=533)){
			if(Mouse.isButtonDown(0)){
				sub[1] = horizontalLine;
				horiBool[1] = true;
			
			}
			else if(Mouse.isButtonDown(1)){
				sub[1] = horizontalPoint;
				horiBool[1] = false;
			}
		}//hpoint2
		
		//hpoint3
		if((xpos>=476 && xpos<=491)&&(ypos<=544 && ypos>=533)){
			if(Mouse.isButtonDown(0)){
				sub[2] = horizontalLine;
				horiBool[2] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[2] = horizontalPoint;
				horiBool[2] = false;
			}
		}//hpoint3
		
		//hpoint4
		if((xpos>=583 && xpos<=598)&&(ypos<=544 && ypos>=533)){
			if(Mouse.isButtonDown(0)){
				sub[3] = horizontalLine;
				horiBool[3] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[3] = horizontalPoint;
				horiBool[3] = false;
			}
		}//hpoint4
		
		//hpoint5
		if((xpos>=693 && xpos<=709)&&(ypos<=544 && ypos>=533)){
			if(Mouse.isButtonDown(0)){
				sub[4] = horizontalLine;
				horiBool[4] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[4] = horizontalPoint;
				horiBool[4] = false;
			}
		}//hpoint5
		
		//hpoint6
		if((xpos>=804 && xpos<=818)&&(ypos<=544 && ypos>=533)){
			if(Mouse.isButtonDown(0)){
				sub[5] = horizontalLine;
				horiBool[5] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[5] = horizontalPoint;
				horiBool[5] = false;
			}
		}//hpoint6
		
		//hpoint7
		if((xpos>=264 && xpos<=278)&&(ypos<=437 && ypos>=425)){
			if(Mouse.isButtonDown(0)){
				sub[6] = horizontalLine;
				horiBool[6] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[6] = horizontalPoint;
				horiBool[6] = false;
			}
		}//hpoint7
	
		//hpoint8
		if((xpos>=368 && xpos<=384)&&(ypos<=437 && ypos>=425)){
			if(Mouse.isButtonDown(0)){
				sub[7] = horizontalLine;
				horiBool[7] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[7] = horizontalPoint;
				horiBool[7] = false;
			}
		}//hpoint8
		
		//hpoint9
		if((xpos>=476 && xpos<=491)&&(ypos<=437 && ypos>=425)){
			if(Mouse.isButtonDown(0)){
				sub[8] = horizontalLine;
				horiBool[8] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[8] = horizontalPoint;
				horiBool[8] = false;
			}
		}//hpoint9
		
		//hpoint10
		if((xpos>=583 && xpos<=598)&&(ypos<=437 && ypos>=425)){
			if(Mouse.isButtonDown(0)){
				sub[9] = horizontalLine;
				horiBool[9] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[9] = horizontalPoint;
				horiBool[9] = false;
			}
		}//hpoint10
		
		//hpoint11
		if((xpos>=693 && xpos<=709)&&(ypos<=437 && ypos>=425)){
			if(Mouse.isButtonDown(0)){
				sub[10] = horizontalLine;
				horiBool[10] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[10] = horizontalPoint;
				horiBool[10] = false;
			}
		}//hpoint11
		
		//hpoint12
		if((xpos>=804 && xpos<=818)&&(ypos<=437 && ypos>=425)){
			if(Mouse.isButtonDown(0)){
				sub[11] = horizontalLine;
				horiBool[11] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[11] = horizontalPoint;
				horiBool[11] = false;
			}
		}//hpoint12
		
		//hpoint13
		if((xpos>=264 && xpos<=278)&&(ypos<=331 && ypos>=318)){
			if(Mouse.isButtonDown(0)){
				sub[12] = horizontalLine;
				horiBool[12] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[12] = horizontalPoint;
				horiBool[12] = false;
			}
		}//hpoint13
		
		//hpoint14
		if((xpos>=368 && xpos<=384)&&(ypos<=331 && ypos>=318)){
			if(Mouse.isButtonDown(0)){
				sub[13] = horizontalLine;
				horiBool[13] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[13] = horizontalPoint;
				horiBool[13] = false;
			}
		}//hpoint14
		
		//hpoint15
		if((xpos>=476 && xpos<=491)&&(ypos<=331 && ypos>=318)){
			if(Mouse.isButtonDown(0)){
				sub[14] = horizontalLine;
				horiBool[14] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[14] = horizontalPoint;
				horiBool[14] = false;
			}
		}//hpoint15
		
		//hpoint16
		if((xpos>=583 && xpos<=598)&&(ypos<=331 && ypos>=318)){
			if(Mouse.isButtonDown(0)){
				sub[15] = horizontalLine;
				horiBool[15] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[15] = horizontalPoint;
				horiBool[15] = false;
			}
		}//hpoint16
		
		//hpoint17
		if((xpos>=693 && xpos<=709)&&(ypos<=331 && ypos>=318)){
			if(Mouse.isButtonDown(0)){
				sub[16] = horizontalLine;
				horiBool[16] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[16] = horizontalPoint;
				horiBool[16] = false;
			}
		}//hpoint17
		
		//hpoint18
		if((xpos>=804 && xpos<=818)&&(ypos<=331 && ypos>=318)){
			if(Mouse.isButtonDown(0)){
				sub[17] = horizontalLine;
				horiBool[17] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[17] = horizontalPoint;
				horiBool[17] = false;
			}
		}//hpoint18
		
		//hpoint19
		if((xpos>=264 && xpos<=278)&&(ypos<=224 && ypos>=211)){
			if(Mouse.isButtonDown(0)){
				sub[18] = horizontalLine;
				horiBool[18] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[18] = horizontalPoint;
				horiBool[18] = false;
			}
		}//hpoint19
		
		//hpoint20
		if((xpos>=368 && xpos<=384)&&(ypos<=224 && ypos>=211)){
			if(Mouse.isButtonDown(0)){
				sub[19] = horizontalLine;
				horiBool[19] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[19] = horizontalPoint;
				horiBool[19] = false;
			}
		}//hpoint20
		
		//hpoint21
		if((xpos>=476 && xpos<=491)&&(ypos<=224 && ypos>=211)){
			if(Mouse.isButtonDown(0)){
				sub[20] = horizontalLine;
				horiBool[20] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[20] = horizontalPoint;
				horiBool[20] = false;
			}
		}//hpoint21
		
		//hpoint22
		if((xpos>=583 && xpos<=598)&&(ypos<=224 && ypos>=211)){
			if(Mouse.isButtonDown(0)){
				sub[21] = horizontalLine;
				horiBool[21] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[21] = horizontalPoint;
				horiBool[21] = false;
			}
		}//hpoint22
		
		//hpoint23
		if((xpos>=693 && xpos<=709)&&(ypos<=224 && ypos>=211)){
			if(Mouse.isButtonDown(0)){
				sub[22] = horizontalLine;
				horiBool[22] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[22] = horizontalPoint;
				horiBool[22] = false;
			}
		}//hpoint23
		
		//hpoint24
		if((xpos>=804 && xpos<=818)&&(ypos<=224 && ypos>=211)){
			if(Mouse.isButtonDown(0)){
				sub[23] = horizontalLine;
				horiBool[23] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[23] = horizontalPoint;
				horiBool[23] = false;
			}
		}//hpoint24
		
		//hpoint25
		if((xpos>=264 && xpos<=278)&&(ypos<=117 && ypos>=104)){
			if(Mouse.isButtonDown(0)){
				sub[24] = horizontalLine;
				horiBool[24] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[24] = horizontalPoint;
				horiBool[24] = false;
			}
		}//hpoint25
		
		//hpoint26
		if((xpos>=368 && xpos<=384)&&(ypos<=117 && ypos>=104)){
			if(Mouse.isButtonDown(0)){
				sub[25] = horizontalLine;
				horiBool[25] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[25] = horizontalPoint;
				horiBool[25] = false;
			}
		}//hpoint26
		
		//hpoint27
		if((xpos>=476 && xpos<=491)&&(ypos<=117 && ypos>=104)){
			if(Mouse.isButtonDown(0)){
				sub[26] = horizontalLine;
				horiBool[26] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[26] = horizontalPoint;
				horiBool[26] = false;
			}
		}//hpoint27
		
		//hpoint28
		if((xpos>=583 && xpos<=598)&&(ypos<=117 && ypos>=104)){
			if(Mouse.isButtonDown(0)){
				sub[27] = horizontalLine;
				horiBool[27] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[27] = horizontalPoint;
				horiBool[27] = false;
			}
		}//hpoint28
		
		//hpoint29
		if((xpos>=693 && xpos<=709)&&(ypos<=117 && ypos>=104)){
			if(Mouse.isButtonDown(0)){
				sub[28] = horizontalLine;
				horiBool[28] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[28] = horizontalPoint;
				horiBool[28] = false;
			}
		}//hpoint29
		
		//hpoint30
		if((xpos>=804 && xpos<=818)&&(ypos<=117 && ypos>=104)){
			if(Mouse.isButtonDown(0)){
				sub[29] = horizontalLine;
				horiBool[29] = true;
			}
			else if(Mouse.isButtonDown(1)){
				sub[29] = horizontalPoint;
				horiBool[29] = false;
			}
		}//hpoint30
		
		//vpoint1
		if((xpos>=316 && xpos<=331)&&(ypos<=600 && ypos>=558)){
			if(Mouse.isButtonDown(0)){
				temp[0] = verticalLine;
				veriBool[0] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[0] = verticalPoint;
				veriBool[0] = false;
			}
		}//vpoint1
		
		//vpoint2
		if((xpos>=420 && xpos<=437)&&(ypos<=600 && ypos>=558)){
			if(Mouse.isButtonDown(0)){
				temp[1] = verticalLine;
				veriBool[1] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[1] = verticalPoint;
				veriBool[1] = false;
			}
		}//vpoint2
		
		//vpoint3
		if((xpos>=532 && xpos<=547)&&(ypos<=600 && ypos>=558)){
			if(Mouse.isButtonDown(0)){
				temp[2] = verticalLine;
				veriBool[2] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[2] = verticalPoint;
				veriBool[2] = false;
			}
		}//vpoint3
		
		//vpoint4
		if((xpos>=639 && xpos<=654)&&(ypos<=600 && ypos>=558)){
			if(Mouse.isButtonDown(0)){
				temp[3] = verticalLine;
				veriBool[3] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[3] = verticalPoint;
				veriBool[3] = false;
			}
		}//vpoint4
		
		//vpoint5
		if((xpos>=749 && xpos<=764)&&(ypos<=600 && ypos>=558)){
			if(Mouse.isButtonDown(0)){
				temp[4] = verticalLine;
				veriBool[4] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[4] = verticalPoint;
				veriBool[4] = false;
			}
		}//vpoint5
	
		//vpoint6
		if((xpos>=316 && xpos<=331)&&(ypos<=492 && ypos>=479)){
			if(Mouse.isButtonDown(0)){
				temp[5] = verticalLine;
				veriBool[5] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[5] = verticalPoint;
				veriBool[5] = false;
			}
		}//vpoint6
		
		//vpoint7
		if((xpos>=420 && xpos<=437)&&(ypos<=492 && ypos>=479)){
			if(Mouse.isButtonDown(0)){
				temp[6] = verticalLine;
				veriBool[6] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[6] = verticalPoint;
				veriBool[6] = false;
			}
		}//vpoint7
		
		//vpoint8
		if((xpos>=532 && xpos<=547)&&(ypos<=492 && ypos>=479)){
			if(Mouse.isButtonDown(0)){
				temp[7] = verticalLine;
				veriBool[7] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[7] = verticalPoint;
				veriBool[7] = false;
			}
		}//vpoint8
		
		//vpoint9
		if((xpos>=639 && xpos<=654)&&(ypos<=492 && ypos>=479)){
			if(Mouse.isButtonDown(0)){
				temp[8] = verticalLine;
				veriBool[8] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[8] = verticalPoint;
				veriBool[8] = false;
			}
		}//vpoint9
		
		//vpoint10
		if((xpos>=749 && xpos<=764)&&(ypos<=492 && ypos>=479)){
			if(Mouse.isButtonDown(0)){
				temp[9] = verticalLine;
				veriBool[9] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[9] = verticalPoint;
				veriBool[9] = false;
			}
		}//vpoint10
		
		//vpoint11
		if((xpos>=316 && xpos<=331)&&(ypos<=476 && ypos>=368)){
			if(Mouse.isButtonDown(0)){
				temp[10] = verticalLine;
				veriBool[10] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[10] = verticalPoint;
				veriBool[10] = false;
			}
		}//vpoint11
		
		//vpoint12
		if((xpos>=420 && xpos<=437)&&(ypos<=476 && ypos>=368)){
			if(Mouse.isButtonDown(0)){
				temp[11] = verticalLine;
				veriBool[11] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[11] = verticalPoint;
				veriBool[11] = false;
			}
		}//vpoint12
		
		//vpoint13
		if((xpos>=532 && xpos<=547)&&(ypos<=476 && ypos>=368)){
			if(Mouse.isButtonDown(0)){
				temp[12] = verticalLine;
				veriBool[12] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[12] = verticalPoint;
				veriBool[12] = false;
			}
		}//vpoint13
		
		//vpoint14
		if((xpos>=639 && xpos<=654)&&(ypos<=476 && ypos>=368)){
			if(Mouse.isButtonDown(0)){
				temp[13] = verticalLine;
				veriBool[13] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[13] = verticalPoint;
				veriBool[13] = false;
			}
		}//vpoint14
		
		//vpoint15
		if((xpos>=749 && xpos<=764)&&(ypos<=476 && ypos>=368)){
			if(Mouse.isButtonDown(0)){
				temp[14] = verticalLine;
				veriBool[14] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[14] = verticalPoint;
				veriBool[14] = false;
			}
		}//vpoint15
		
		//vpoint16
		if((xpos>=316 && xpos<=331)&&(ypos<=276 && ypos>=263)){
			if(Mouse.isButtonDown(0)){
				temp[15] = verticalLine;
				veriBool[15] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[15] = verticalPoint;
				veriBool[15] = false;
			}
		}//vpoint16
		
		//vpoint17
		if((xpos>=420 && xpos<=437)&&(ypos<=276 && ypos>=263)){
			if(Mouse.isButtonDown(0)){
				temp[16] = verticalLine;
				veriBool[16] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[16] = verticalPoint;
				veriBool[16] = false;
			}
		}//vpoint17
		
		//vpoint18
		if((xpos>=532 && xpos<=547)&&(ypos<=276 && ypos>=263)){
			if(Mouse.isButtonDown(0)){
				temp[17] = verticalLine;
				veriBool[17] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[17] = verticalPoint;
				veriBool[17] = false;
			}
		}//vpoint18
		
		//vpoint19
		if((xpos>=639 && xpos<=654)&&(ypos<=276 && ypos>=263)){
			if(Mouse.isButtonDown(0)){
				temp[18] = verticalLine;
				veriBool[18] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[18] = verticalPoint;
				veriBool[18] = false;
			}
		}//vpoint19
		
		//vpoint20
		if((xpos>=749 && xpos<=764)&&(ypos<=273 && ypos>=263)){
			if(Mouse.isButtonDown(0)){
				temp[19] = verticalLine;
				veriBool[19] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[19] = verticalPoint;
				veriBool[19] = false;
			}
		}//vpoint20
		
		//vpoint21
		if((xpos>=316 && xpos<=331)&&(ypos<=166 && ypos>=154)){
			if(Mouse.isButtonDown(0)){
				temp[20] = verticalLine;
				veriBool[20] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[20] = verticalPoint;
				veriBool[20] = false;
			}
		}//vpoint21
		
		//vpoint22
		if((xpos>=420 && xpos<=437)&&(ypos<=166 && ypos>=154)){
			if(Mouse.isButtonDown(0)){
				temp[21] = verticalLine;
				veriBool[21] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[21] = verticalPoint;
				veriBool[21] = false;
			}
		}//vpoint22
		
		//vpoint23
		if((xpos>=532 && xpos<=547)&&(ypos<=166 && ypos>=154)){
			if(Mouse.isButtonDown(0)){
				temp[22] = verticalLine;
				veriBool[22] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[22] = verticalPoint;
				veriBool[22] = false;
			}
		}//vpoint23
		
		//vpoint24
		if((xpos>=639 && xpos<=654)&&(ypos<=166 && ypos>=154)){
			if(Mouse.isButtonDown(0)){
				temp[23] = verticalLine;
				veriBool[23] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[23] = verticalPoint;
				veriBool[23] = false;
			}
		}//vpoint24
		
		//vpoint25
		if((xpos>=749 && xpos<=764)&&(ypos<=166 && ypos>=154)){
			if(Mouse.isButtonDown(0)){
				temp[24] = verticalLine;
				veriBool[24] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[24] = verticalPoint;
				veriBool[24] = false;
			}
		}//vpoint25
		
		//vpoint26
		if((xpos>=316 && xpos<=331)&&(ypos<=57 && ypos>=43)){
			if(Mouse.isButtonDown(0)){
				temp[25] = verticalLine;
				veriBool[25] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[25] = verticalPoint;
				veriBool[25] = false;
			}
		}//vpoint26
		
		//vpoint27
		if((xpos>=420 && xpos<=437)&&(ypos<=57 && ypos>=43)){
			if(Mouse.isButtonDown(0)){
				temp[26] = verticalLine;
				veriBool[26] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[26] = verticalPoint;
				veriBool[26] = false;
			}
		}//vpoint27
		
		//vpoint28
		if((xpos>=532 && xpos<=547)&&(ypos<=57 && ypos>=43)){
			if(Mouse.isButtonDown(0)){
				temp[27] = verticalLine;
				veriBool[27] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[27] = verticalPoint;
				veriBool[27] = false;
			}
		}//vpoint28
		
		//vpoint29
		if((xpos>=639 && xpos<=654)&&(ypos<=57 && ypos>=43)){
			if(Mouse.isButtonDown(0)){
				temp[28] = verticalLine;
				veriBool[28] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[28] = verticalPoint;
				veriBool[28] = false;
			}
		}//vpoint29
		
		//vpoint30
		if((xpos>=749 && xpos<=764)&&(ypos<=57 && ypos>=43)){
			if(Mouse.isButtonDown(0)){
				temp[29] = verticalLine;
				veriBool[29] = true;
			}
			else if(Mouse.isButtonDown(1)){
				temp[29] = verticalPoint;
				veriBool[29] = false;
			}
		}//vpoint30
		
		//Tile1
		if((xpos>=216 && xpos<=309)&&(ypos<=648 && ypos>=548)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 1;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer =  1;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 1;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal =  1;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 1;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  1;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 1;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  1;
					notExistLisa = false;
				}
			}
		}//Tile1
		
		//Tile2
		if((xpos>=334 && xpos<=419)&&(ypos<=648 && ypos>=548)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 2;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 2;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 2;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 2;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 2;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  2;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 2;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  2;
					notExistLisa = false;
				}
			}
		}//Tile2
		
		//Tile3
		if((xpos>=439 && xpos<=538)&&(ypos<=648 && ypos>=548)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 3;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 3;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 3;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 3;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 3;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  3;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 3;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  3;
					notExistLisa = false;
				}
			}
		}//Tile3
		
		//Tile4
		if((xpos>=548 && xpos<=636)&&(ypos<=648 && ypos>=548)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 4;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 4;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 4;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 4;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 4;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  4;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 4;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  4;
					notExistLisa = false;
				}
			}
		}//Tile4
		
		//Tile5
		if((xpos>=657 && xpos<=747)&&(ypos<=648 && ypos>=548)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 5;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 5;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 5;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 5;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 5;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  5;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 5;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  5;
					notExistLisa = false;
				}
			}
		}//Tile5
		
		//Tile6
		if((xpos>=765 && xpos<=862)&&(ypos<=648 && ypos>=548)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 6;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 6;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 6;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 6;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 6;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  6;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 6;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  6;
					notExistLisa = false;
				}
			}
		}//Tile6
		
		//Tile7
		if((xpos>=216 && xpos<=309)&&(ypos<=531 && ypos>=442)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 7;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer =  7;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 7;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 7;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 7;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  7;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 7;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  7;
					notExistLisa = false;
				}
			}
		}//Tile7
		
		//Tile8
		if((xpos>=334 && xpos<=419)&&(ypos<=531 && ypos>=442)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 8;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 8;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 8;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 8;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 8;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  8;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 8;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  8;
					notExistLisa = false;
				}
			}
		}//Tile8
		
		//Tile9
		if((xpos>=439 && xpos<=538)&&(ypos<=531 && ypos>=442)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 9;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 9;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 9;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 9;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 9;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  9;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 9;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  9;
					notExistLisa = false;
				}
			}
		}//Tile9
		
		//Tile10
		if((xpos>=548 && xpos<=636)&&(ypos<=531 && ypos>=442)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 10;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 10;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 10;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 10;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 10;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  10;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 10;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  10;
					notExistLisa = false;
				}
			}
		}//Tile10
		
		//Tile11
		if((xpos>=657 && xpos<=747)&&(ypos<=531 && ypos>=442)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 11;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 11;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 11;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 11;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 11;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  11;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 11;
						flagLisa = false;
						notExistLisa = false;
					}
					
				}
				else{
					posLisa =  11;
					notExistLisa = false;
				}
			}
		}//Tile11
		
		//Tile12
		if((xpos>=765 && xpos<=862)&&(ypos<=531 && ypos>=442)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 12;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 12;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 12;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 12;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 12;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  12;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 12;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  12;
					notExistLisa = false;
				}
			}
		}//Tile12
		
		//Tile13
		if((xpos>=216 && xpos<=309)&&(ypos<=425 && ypos>=334)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 13;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer =  13;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 13;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 13;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 13;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  13;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 13;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  13;
					notExistLisa = false;
				}
			}
		}//Tile13
		
		//Tile14
		if((xpos>=334 && xpos<=419)&&(ypos<=425 && ypos>=334)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 14;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 14;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 14;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 14;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 14;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  14;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 14;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  14;
					notExistLisa = false;
				}
			}
		}//Tile14
		
		//Tile15
		if((xpos>=439 && xpos<=538)&&(ypos<=425 && ypos>=334)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 15;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 15;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 15;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 15;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 15;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  15;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 15;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  15;
					notExistLisa = false;
				}
			}
		}//Tile15
		
		//Tile16
		if((xpos>=548 && xpos<=636)&&(ypos<=425 && ypos>=334)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 16;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 16;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 16;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 16;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 16;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  16;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 16;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  16;
					notExistLisa = false;
				}
			}
		}//Tile16
		
		//Tile17
		if((xpos>=657 && xpos<=747)&&(ypos<=425 && ypos>=334)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 17;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 17;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 17;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 17;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 17;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  17;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 17;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  17;
					notExistLisa = false;
				}
			}
		}//Tile17
		
		//Tile18
		if((xpos>=765 && xpos<=862)&&(ypos<=425 && ypos>=334)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 18;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 18;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 18;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 18;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 18;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  18;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 18;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  18;
					notExistLisa = false;
				}
			}
		}//Tile18
		
		//Tile19
		if((xpos>=216 && xpos<=309)&&(ypos<=317 && ypos>=225)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 19;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer =  19;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 19;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 19;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 19;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  19;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 19;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  19;
					notExistLisa = false;
				}
			}
		}//Tile19
		
		//Tile20
		if((xpos>=334 && xpos<=419)&&(ypos<=317 && ypos>=225)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 20;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 20;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 20;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 20;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 20;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  20;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 20;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  20;
					notExistLisa = false;
				}
			}
		}//Tile20
		
		//Tile21
		if((xpos>=439 && xpos<=538)&&(ypos<=317 && ypos>=225)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 21;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 21;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 21;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 21;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 21;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  21;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 21;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  21;
					notExistLisa = false;
				}
			}
		}//Tile21
		
		//Tile22
		if((xpos>=548 && xpos<=636)&&(ypos<=317 && ypos>=225)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 22;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 22;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 22;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 22;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 22;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  22;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 22;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  22;
					notExistLisa = false;
				}
			}
		}//Tile22
		
		//Tile23
		if((xpos>=657 && xpos<=747)&&(ypos<=317 && ypos>=225)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 23;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 23;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 23;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 23;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 23;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  23;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 23;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  23;
					notExistLisa = false;
				}
			}
		}//Tile23
		
		//Tile24
		if((xpos>=765 && xpos<=862)&&(ypos<=317 && ypos>=225)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 24;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 24;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 24;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 24;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 24;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  24;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 24;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  24;
					notExistLisa = false;
				}
			}
		}//Tile24
		
		//Tile25
		if((xpos>=216 && xpos<=309)&&(ypos<=210 && ypos>=120)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 25;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 25;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 25;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 25;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 25;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  25;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 25;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  25;
					notExistLisa = false;
				}
			}
		}//Tile25
		
		//Tile26
		if((xpos>=334 && xpos<=419)&&(ypos<=210 && ypos>=120)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 26;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 26;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 26;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 26;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 26;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  26;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 26;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  26;
					notExistLisa = false;
				}
			}
		}//Tile26
		
		//Tile27
		if((xpos>=439 && xpos<=538)&&(ypos<=210 && ypos>=120)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 27;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 27;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 27;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 27;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 27;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  27;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 27;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  27;
					notExistLisa = false;
				}
			}
		}//Tile27
		
		//Tile28
		if((xpos>=548 && xpos<=636)&&(ypos<=210 && ypos>=120)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 28;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 28;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 28;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 28;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 28;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  28;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 28;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  28;
					notExistLisa = false;
				}
			}
		}//Tile28
		
		//Tile29
		if((xpos>=657 && xpos<=747)&&(ypos<=210 && ypos>=120)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 29;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 29;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 29;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 29;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 29;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  29;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 29;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  29;
					notExistLisa = false;
				}
			}
		}//Tile29
		
		//Tile30
		if((xpos>=765 && xpos<=862)&&(ypos<=210 && ypos>=120)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 30;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 30;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 30;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 30;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 30;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  30;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 30;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  30;
					notExistLisa = false;
				}
			}
		}//Tile30
		
		//Tile31
		if((xpos>=216 && xpos<=309)&&(ypos<=103 && ypos>=0)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 31;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 31;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 31;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 31;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 31;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  31;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 31;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  31;
					notExistLisa = false;
				}
			}
		}//Tile31
		
		//Tile32
		if((xpos>=334 && xpos<=419)&&(ypos<=103 && ypos>=0)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 32;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 32;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 32;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 32;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 32;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  32;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 32;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  32;
					notExistLisa = false;
				}
			}
		}//Tile32
		
		//Tile33
		if((xpos>=439 && xpos<=538)&&(ypos<=103 && ypos>=0)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 33;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 33;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 33;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 33;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 33;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  33;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 33;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  33;
					notExistLisa = false;
				}
			}
		}//Tile33
		
		//Tile34
		if((xpos>=548 && xpos<=636)&&(ypos<=103 && ypos>=0)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 34;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 34;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 34;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 34;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 34;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  34;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 34;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  34;
					notExistLisa = false;
				}
			}
		}//Tile34
		
		//Tile35
		if((xpos>=657 && xpos<=747)&&(ypos<=103 && ypos>=0)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 35;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 35;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 35;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 35;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 35;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  35;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 35;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  35;
					notExistLisa = false;
				}
			}
		}//Tile35
		
		//Tile36
		if((xpos>=765 && xpos<=862)&&(ypos<=103 && ypos>=0)){
			if(input.isKeyPressed(Input.KEY_P)){
				if(notExistPlayer){
					if(flagPlayer){
						posPlayer = 36;
						flagPlayer = false;
						notExistPlayer = false;
					}
				}
				else{
					posPlayer = 36;
					notExistPlayer = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_E)){
				if(notExistGoal){
					if(flagGoal){
						goal = 36;
						flagGoal = false;
						notExistGoal = false;
					}
				}
				else{
					goal = 36;
					notExistGoal = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_O)){
				if(notExistOrb){
					if(flagOrb){
						orb = 36;
						flagOrb = false;
						notExistOrb = false;
					}
				}
				else{
					orb =  36;
					notExistOrb = false;
				}
			}
			else if(input.isKeyPressed(Input.KEY_L)){
				if(notExistLisa){
					if(flagLisa){
						posLisa = 36;
						flagLisa = false;
						notExistLisa = false;
					}
				}
				else{
					posLisa =  36;
					notExistLisa = false;
				}
			}
		}//Tile36
	}
	
	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 8;
	}

}
