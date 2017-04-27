package liza;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Player {
	
	static int[] array = new int[2];
	static int canPass;
	static int[][] heuristic;
	

	public static int[] move(int posPlayer, int in, int[][] upDownRmae, int[][] leftRightRmae,Animation man, Animation manDown, Animation manUp, Animation manLeft, Animation manRight){
		
		if(in == Input.KEY_DOWN){
			if(posPlayer!=31 && posPlayer!=32 && posPlayer!=33 && posPlayer!=34 && posPlayer!=35 && posPlayer!=36){
				if(Walls.checkWalls(posPlayer, Input.KEY_DOWN, upDownRmae, leftRightRmae)){
					canPass = 1;
					posPlayer+=6;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			}
			else{
				canPass = 0;
			}
			
		}
		else if(in == Input.KEY_UP){
			if(posPlayer!=1 && posPlayer!=2 && posPlayer!=3 && posPlayer!=4 && posPlayer!=5 && posPlayer!=6){
				if(Walls.checkWalls(posPlayer, Input.KEY_UP, upDownRmae, leftRightRmae)){
					canPass = 1;
					posPlayer-=6;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			
			}
			else{
				canPass = 0;
			}
	}
		else if(in == Input.KEY_RIGHT){
			if(posPlayer!=6 && posPlayer!=12 && posPlayer!=18 && posPlayer!=24 && posPlayer!=30 && posPlayer!=36){
				if(Walls.checkWalls(posPlayer, Input.KEY_RIGHT, upDownRmae, leftRightRmae)){
					canPass = 1;
					posPlayer++;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			}
			else{
				canPass = 0;
			}
			
	}
		
		else if(in == Input.KEY_LEFT){
			if(posPlayer!=1 && posPlayer!=7 && posPlayer!=13 && posPlayer!=19 && posPlayer!=25 && posPlayer!=31){
				if(Walls.checkWalls(posPlayer, Input.KEY_LEFT, upDownRmae, leftRightRmae)){
					canPass = 1;
					posPlayer--;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			}
			else{
				canPass = 0;
			}
			
	}	
		
		array[0] = posPlayer;
		array[1] = canPass;
		return array;
	}
	
	public static int[] moveCustom(int posPlayer, int input, boolean[] horiBool, boolean[] veriBool){
		
		if(input == Input.KEY_DOWN){
			if(posPlayer!=31 && posPlayer!=32 && posPlayer!=33 && posPlayer!=34 && posPlayer!=35 && posPlayer!=36){
				if(Walls.checkWalls(horiBool, veriBool, posPlayer, Input.KEY_DOWN)){
					canPass = 1;
					posPlayer+=6;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			}
			else{
				canPass = 0;
			}
			
		}
		else if(input == Input.KEY_UP){
			if(posPlayer!=1 && posPlayer!=2 && posPlayer!=3 && posPlayer!=4 && posPlayer!=5 && posPlayer!=6){
				if(Walls.checkWalls(horiBool, veriBool, posPlayer, Input.KEY_UP)){
					canPass = 1;
					posPlayer-=6;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			
			}
			else{
				canPass = 0;
			}
	}
		else if(input == Input.KEY_RIGHT){
			if(posPlayer!=6 && posPlayer!=12 && posPlayer!=18 && posPlayer!=24 && posPlayer!=30 && posPlayer!=36){
				if(Walls.checkWalls(horiBool, veriBool, posPlayer, Input.KEY_RIGHT)){
					canPass = 1;
					posPlayer++;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			}
			else{
				canPass = 0;
			}
			
	}
		
		else if(input == Input.KEY_LEFT){
			if(posPlayer!=1 && posPlayer!=7 && posPlayer!=13 && posPlayer!=19 && posPlayer!=25 && posPlayer!=31){
				if(Walls.checkWalls(horiBool, veriBool, posPlayer, Input.KEY_UP)){
					canPass = 1;
					posPlayer--;
					heuristic = functions.computeHeuristic(posPlayer, heuristic);
				
				}
				else{
					canPass = 0;
				}
			}
			else{
				canPass = 0;
			}
			
	}	
		
		array[0] = posPlayer;
		array[1] = canPass;
		return array;
		
	}
	
	public static int[][] getHeuristic(){
		
		return heuristic;
	}
}
	
