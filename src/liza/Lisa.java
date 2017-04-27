package liza;

import org.newdawn.slick.Input;

public class Lisa {

	public static int move( int[][] heuristic, int posLisa, int[][] tileNames, int[][] upDownRmae, int[][] leftRightRmae){
		
		int decisionMove = checkLowestH(heuristic, posLisa, tileNames, upDownRmae, leftRightRmae);
		
		if(decisionMove == 1){
			if(posLisa!=1 && posLisa!=7 && posLisa!=13 && posLisa!=19 && posLisa!=25 && posLisa!=31){
				if(Walls.checkWalls(posLisa, Input.KEY_LEFT, upDownRmae, leftRightRmae)){
					posLisa--;
				}
			}
			return posLisa;
		}	
		
		else if(decisionMove == 2){
			if(posLisa!=1 && posLisa!=2 && posLisa!=3 && posLisa!=4 && posLisa!=5 && posLisa!=6){
				if(Walls.checkWalls(posLisa, Input.KEY_UP, upDownRmae, leftRightRmae)){
					posLisa-=6;
				}
			}
			return posLisa;
		}
		
		else if(decisionMove == 3){
			if(posLisa!=6 && posLisa!=12 && posLisa!=18 && posLisa!=24 && posLisa!=30 && posLisa!=36){
				if(Walls.checkWalls(posLisa, Input.KEY_RIGHT, upDownRmae, leftRightRmae)){
					posLisa++;
				}
			}
			return posLisa;
		}
		
		else if(decisionMove == 4){
			if(posLisa!=31 && posLisa!=32 && posLisa!=33 && posLisa!=34 && posLisa!=35 && posLisa!=36){
				if(Walls.checkWalls(posLisa, Input.KEY_DOWN, upDownRmae, leftRightRmae)){
					posLisa+=6;
				}
			}
			return posLisa;
		}
		
		return posLisa;
	}
	
	public static int checkLowestH(int[][] heuristic, int posLisa, int[][] tileNames, int[][] upDownRmae, int[][] leftRightRmae){
		
		int[] pos = new int[2];
		int left=99, right=99, up=99, down=99;
		pos = findPosition(posLisa, tileNames);
		
		//System.out.println(pos[0] + " "+ pos[1]);
		
		//get left heuristic
		try{
			
			left = heuristic[pos[0]][pos[1]-1];
			
		}catch(ArrayIndexOutOfBoundsException e){ left = 99; }
		
		//get right heuristic
		try{
			
			right = heuristic[pos[0]][pos[1]+1];
			
		}catch(ArrayIndexOutOfBoundsException e){ right = 99;}
		
		//get top heuristic
		try{
			
			up = heuristic[pos[0]-1][pos[1]];
			
		}catch(ArrayIndexOutOfBoundsException e){ up = 99; }
		
		//get bottom heuristic
		try{
			
			down = heuristic[pos[0]+1][pos[1]];
			
		}catch(ArrayIndexOutOfBoundsException e){ down = 99; }
		
		System.out.println(left + ", " + right + ", " + up + ", " + down);
		System.out.println("----------------------");
		
		if(left<right){
			if(up<down){
				if(left<up){
					System.out.println(left + "left");
					return 1;
					
				}
				else if(left>up){
					System.out.println(up + "up");
					return 2;
				}
				else{
					if(Walls.checkWalls(posLisa, Input.KEY_LEFT, upDownRmae, leftRightRmae)){
						System.out.println(left + "left");
						return 1;
					}
					else{
						System.out.println(up + "up");
						return 2;
					}
				}
			}//if(up<down){
			else{
				if(left<down){
					System.out.println(left + "left");
					return 1;
				}
				else if(left>down){
					System.out.println(down + "down");
					return 4;
				}
				else{
					if(Walls.checkWalls(posLisa, Input.KEY_LEFT, upDownRmae, leftRightRmae)){
						System.out.println(left + "left");
						return 1;
					}
					else{
						System.out.println(down + "down");
						return 4;
					}
				}
			}
		}//if(left<right){
		else{//right>left
			if(up<down){
				if(right<up){
					System.out.println(right + "right");
					return 3;
				}
				else if(right>up){
					System.out.println(up + "up");
					return 2;
				}
				else{
					if(Walls.checkWalls(posLisa, Input.KEY_RIGHT, upDownRmae, leftRightRmae)){
						System.out.println(right + "right");
						return 3;
					}
					else{
						System.out.println(up + "up");
						return 2;
					}
				}
			}
			else{
				if(right<down){
					System.out.println(right + "right");
					return 3;
				}
				else if(right>down){
					System.out.println(down + "down");
					return 4;
				}
				else{
					if(Walls.checkWalls(posLisa, Input.KEY_RIGHT, upDownRmae, leftRightRmae)){
						System.out.println(right + "right");
						return 3;
					}
					else{
						System.out.println(down + "down");
						return 4;
					}
				}
			}
		}//else{
	}
	
public static int moveCustom( int[][] heuristic, int posLisa, int[][] tileNames, boolean[] horiBool, boolean[] veriBool){
		
		int decisionMove = checkLowestH(heuristic, posLisa, tileNames, horiBool, veriBool);
		
		if(decisionMove == 1){
			if(posLisa!=1 && posLisa!=7 && posLisa!=13 && posLisa!=19 && posLisa!=25 && posLisa!=31){
				if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_LEFT)){
					posLisa--;
				}
			}
			return posLisa;
		}	
		
		else if(decisionMove == 2){
			if(posLisa!=1 && posLisa!=2 && posLisa!=3 && posLisa!=4 && posLisa!=5 && posLisa!=6){
				if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_UP)){
					posLisa-=6;
				}
			}
			return posLisa;
		}
		
		else if(decisionMove == 3){
			if(posLisa!=6 && posLisa!=12 && posLisa!=18 && posLisa!=24 && posLisa!=30 && posLisa!=36){
				if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_RIGHT)){
					posLisa++;
				}
			}
			return posLisa;
		}
		
		else if(decisionMove == 4){
			if(posLisa!=31 && posLisa!=32 && posLisa!=33 && posLisa!=34 && posLisa!=35 && posLisa!=36){
				if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_DOWN)){
					posLisa+=6;
				}
			}
			return posLisa;
		}
		
		return posLisa;
	}
	


	private static int checkLowestH(int[][] heuristic, int posLisa, int[][] tileNames, boolean[] horiBool, boolean[] veriBool) {
		
		int[] pos = new int[2];
		int left=99, right=99, up=99, down=99;
		pos = findPosition(posLisa, tileNames);
		
		//System.out.println(pos[0] + " "+ pos[1]);
		
		//get left heuristic
		try{
			
			left = heuristic[pos[0]][pos[1]-1];
			
		}catch(ArrayIndexOutOfBoundsException e){ left = 99; }
		
		//get right heuristic
		try{
			
			right = heuristic[pos[0]][pos[1]+1];
			
		}catch(ArrayIndexOutOfBoundsException e){ right = 99;}
		
		//get top heuristic
		try{
			
			up = heuristic[pos[0]-1][pos[1]];
			
		}catch(ArrayIndexOutOfBoundsException e){ up = 99; }
		
		//get bottom heuristic
		try{
			
			down = heuristic[pos[0]+1][pos[1]];
			
		}catch(ArrayIndexOutOfBoundsException e){ down = 99; }
		
		System.out.println(left + ", " + right + ", " + up + ", " + down);
		System.out.println("----------------------");
		
		if(left<right){
			if(up<down){
				if(left<up){
					System.out.println(left + "left");
					return 1;
					
				}
				else if(left>up){
					System.out.println(up + "up");
					return 2;
				}
				else{
					if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_LEFT)){
						System.out.println(left + "left");
						return 1;
					}
					else{
						System.out.println(up + "up");
						return 2;
					}
				}
			}//if(up<down){
			else{
				if(left<down){
					System.out.println(left + "left");
					return 1;
				}
				else if(left>down){
					System.out.println(down + "down");
					return 4;
				}
				else{
					if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_LEFT)){
						System.out.println(left + "left");
						return 1;
					}
					else{
						System.out.println(down + "down");
						return 4;
					}
				}
			}
		}//if(left<right){
		else{//right>left
			if(up<down){
				if(right<up){
					System.out.println(right + "right");
					return 3;
				}
				else if(right>up){
					System.out.println(up + "up");
					return 2;
				}
				else{
					if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_RIGHT)){
						System.out.println(right + "right");
						return 3;
					}
					else{
						System.out.println(up + "up");
						return 2;
					}
				}
			}
			else{
				if(right<down){
					System.out.println(right + "right");
					return 3;
				}
				else if(right>down){
					System.out.println(down + "down");
					return 4;
				}
				else{
					if(Walls.checkWalls(horiBool, veriBool, posLisa, Input.KEY_RIGHT)){
						System.out.println(right + "right");
						return 3;
					}
					else{
						System.out.println(down + "down");
						return 4;
					}
				}
			}
		}//else{
}

	public static int[] findPosition(int posLisa, int[][] tileNames){

		int[] temp = new int[2];
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j <6; j++){
				if(tileNames[i][j] == posLisa){
					temp[0] = i;
					temp[1] = j;
				}
			}
		}
		return temp;
	}
}
