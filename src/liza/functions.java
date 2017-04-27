package liza;

import java.awt.Point;

public class functions{
	
public static float getY(int tileNumber, int[][] tileNames, Point[][] points){
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j <6; j++){
				if(tileNames[i][j] == tileNumber){
					return points[i][j].y;
				}
			}
		}
		return  -1;
	}
	
	public static float getX(int tileNumber, int[][] tileNames, Point[][] points){
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j <6; j++){
				if(tileNames[i][j] == tileNumber){
					return points[i][j].x;
				}
			}
		}
		return  -1;
	}
	
	
	
	public static int[][] computeHeuristic(int posPlayer, int[][] heuristic){
		
		Heuristics heur = new Heuristics();
		heur.player = posPlayer;
		heuristic = heur.computeVertically();
		for(int i = 0; i<heuristic.length; i++){
			for(int j = 0; j<heuristic.length; j++){
				System.out.print(heuristic[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------");
		return heuristic;
	}
}