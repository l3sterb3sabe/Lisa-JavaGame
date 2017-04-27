package liza;

import org.newdawn.slick.Input;

public class Walls {

	
public static boolean checkWalls(int position, int input, int[][] upDownRmae, int[][] leftRightRmae){
		
		
		if(input == Input.KEY_DOWN){
			for(int i = 0; i < upDownRmae.length; i ++){
				if(upDownRmae[i][0] == position){
					return false;
				}
			}
		}
		
		if(input == Input.KEY_UP){
			for(int i = 0; i < upDownRmae.length; i ++){
				if(upDownRmae[i][1] == position){
					return false;
				}
			}	
		}
	
		if(input == Input.KEY_LEFT){
			for(int i = 0; i < leftRightRmae.length; i ++){
				if(leftRightRmae[i][1] == position){
					return false;
				}
			}
		}
		
		if(input == Input.KEY_RIGHT){
			for(int i = 0; i < leftRightRmae.length; i ++){
				if(leftRightRmae[i][0] == position){
					return false;
				}
			}
		}
		
		return true;
	}//public static boolean checkWalls(int position, int input, int[][] upDownRmae, int[][] leftRightRmae){

	public static boolean checkWalls(boolean[] horiBool, boolean[] veriBool, int tileNumber, int input){ 
		
		if(input == Input.KEY_DOWN){
			
			if(horiBool[tileNumber-1]){
				return false;
			}
		}
		
		if(input == Input.KEY_LEFT){
			
			if(tileNumber>=1 && tileNumber<=6){
				if(veriBool[tileNumber-2]){
					return false;
				}
			}
			if(tileNumber>=7 && tileNumber<=12){
				if(veriBool[tileNumber-3]){
					return false;
				}
			}
			if(tileNumber>=13 && tileNumber<=18){
				if(veriBool[tileNumber-4]){
					return false;
				}
			}
			if(tileNumber>=19 && tileNumber<=24){
				if(veriBool[tileNumber-5]){
					return false;
				}
			}
			if(tileNumber>=25 && tileNumber<=30){
				if(veriBool[tileNumber-6]){
					return false;
				}
			}
			if(tileNumber>=31 && tileNumber<=36){
				if(veriBool[tileNumber-7]){
					return false;
				}
			}
		}
		
		if(input == Input.KEY_UP){
			
			if(horiBool[tileNumber-7]){
				return false;
			}
		}
		
		if(input == Input.KEY_RIGHT){
			
			if(tileNumber>=1 && tileNumber<=6){
				if(veriBool[tileNumber-1]){
					return false;
				}
			}
			if(tileNumber>=7 && tileNumber<=12){
				if(veriBool[tileNumber-2]){
					return false;
				}
			}
			if(tileNumber>=13 && tileNumber<=18){
				if(veriBool[tileNumber-3]){
					return false;
				}
			}
			if(tileNumber>=19 && tileNumber<=24){
				if(veriBool[tileNumber-4]){
					return false;
				}
			}
			if(tileNumber>=25 && tileNumber<=30){
				if(veriBool[tileNumber-5]){
					return false;
				}
			}
			if(tileNumber>=31 && tileNumber<=36){
				if(veriBool[tileNumber-6]){
					return false;
				}
			}
			
		}
		
		return true;
		
	}


}//public class Walls {
