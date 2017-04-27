package liza;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	public static final String gameName = "Play with Lisa";
	public static final int menu = 0;
	public static final int ins = 1;
	public static final int story = 2;
	public static final int levelone = 3;
	public static final int leveltwo  = 4;
	public static final int levelthree = 5;
	public static final int levelfour = 6;
	public static final int levelfive = 7;
	public static final int custom = 8;
	
	public Game(String gameName){
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Instructions(ins));
		this.addState(new Story(story));
		this.addState(new LevelOne(levelone));
		this.addState(new LevelTwo(leveltwo));
		this.addState(new LevelThree(levelthree));
		this.addState(new LevelFour(levelfour));
		this.addState(new LevelFive(levelfive));
		this.addState(new Custom(custom));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu).init(gc, this);
		this.enterState(menu);
		this.getState(ins).init(gc, this);
		this.getState(story).init(gc, this);
		this.getState(levelone).init(gc, this);
		this.getState(leveltwo).init(gc, this);
		this.getState(levelthree).init(gc, this);
		this.getState(levelfour).init(gc, this);
		this.getState(levelfive).init(gc, this);
		this.getState(custom).init(gc, this);
		this.enterState(menu);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Game(gameName));
			//int maxFPS = 7;
		    //appgc.setTargetFrameRate(maxFPS);
			appgc.setDisplayMode(864, 648, false);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}

	}

}
