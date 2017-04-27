package liza;

@SuppressWarnings("static-access")
public class Heuristics {
	
	 static Main square = new Main();
	 static int player;
	 static int x;
	 static int[] r1c1 = square.r1c1;
	 static int[] r1c2 = square.r1c2;
	 static int[] r1c3 = square.r1c3;
	 static int[] r1c4 = square.r1c4;
	 static int[] r1c5 = square.r1c5;
	 static int[] r1c6 = square.r1c6;
	 static int[] r2c1 = square.r2c1;
	 static int[] r2c2 = square.r2c2;
	 static int[] r2c3 = square.r2c3;
	 static int[] r2c4 = square.r2c4;
	 static int[] r2c5 = square.r2c5;
	 static int[] r2c6 = square.r2c6;
	 static int[] r3c1 = square.r3c1;
	 static int[] r3c2 = square.r3c2;
	 static int[] r3c3 = square.r3c3;
	 static int[] r3c4 = square.r3c4;
	 static int[] r3c5 = square.r3c5;
	 static int[] r3c6 = square.r3c6;
	 static int[] r4c1 = square.r4c1;
	 static int[] r4c2 = square.r4c2;
	 static int[] r4c3 = square.r4c3;
	 static int[] r4c4 = square.r4c4;
	 static int[] r4c5 = square.r4c5;
	 static int[] r4c6 = square.r4c6;
	 static int[] r5c1 = square.r5c1;
	 static int[] r5c2 = square.r5c2;
	 static int[] r5c3 = square.r5c3;
	 static int[] r5c4 = square.r5c4;
	 static int[] r5c5 = square.r5c5;
	 static int[] r5c6 = square.r5c6;
	 static int[] r6c1 = square.r6c1;
	 static int[] r6c2 = square.r6c2;
	 static int[] r6c3 = square.r6c3;
	 static int[] r6c4 = square.r6c4;
	 static int[] r6c5 = square.r6c5;
	 static int[] r6c6 = square.r6c6;

	static int target, target2;
	static int h;
	static int tempH;

	public static int[][] computeVertically(){
		
		 
		 if(r1c1[2]==1){
			 player = 1;
		 }
		 else if (r1c2[2]==1){
			 player = 2;
		 }
		 else if (r1c3[2]==1){
			 player = 3;
		 }
		 else if (r1c4[2]==1){
			 player = 4;
		 }
		 else if (r1c5[2]==1){
			 player = 5;
		 }
		 else if (r1c6[2]==1){
			 player = 6;
		 }
		 else if (r2c1[2]==1){
			 player = 7;
		 }
		 else if (r2c2[2]==1){
			 player = 8;
		 }
		 else if (r2c3[2]==1){
			 player = 9;
		 }
		 else if (r2c4[2]==1){
			 player = 10;
		 }
		 else if (r2c5[2]==1){
			 player = 11;
		 }
		 else if (r2c6[2]==1){
			 player = 12;
		 }
		 else if (r3c1[2]==1){
			 player = 13;
		 }
		 else if (r3c2[2]==1){
			 player = 14;
		 }
		 else if (r3c3[2]==1){
			 player = 15;
		 }
		 else if (r3c4[2]==1){
			 player = 16;
		 }
		 else if (r3c5[2]==1){
			 player = 17;
		 }
		 else if (r3c6[2]==1){
			 player = 18;
		 }
		 else if (r4c1[2]==1){
			 player = 19;
		 }
		 else if (r4c2[2]==1){
			 player = 20;
		 }
		 else if (r4c3[2]==1){
			 player = 21;
		 }
		 else if (r4c4[2]==1){
			 player = 22;
		 }
		 else if (r4c5[2]==1){
			 player = 23;
		 }
		 else if (r4c6[2]==1){
			 player = 24;
		 }
		 else if (r5c1[2]==1){
			 player = 25;
		 }
		 else if (r5c2[2]==1){
			 player = 26;
		 }
		 else if (r5c3[2]==1){
			 player = 27;
		 }
		 else if (r5c4[2]==1){
			 player = 28;
		 }
		 else if (r5c5[2]==1){
			 player = 29;
		 }
		 else if (r5c6[2]==1){
			 player = 30;
		 }
		 else if (r6c1[2]==1){
			 player = 31;
		 }
		 else if (r6c2[2]==1){
			 player = 32;
		 }
		 else if (r6c3[2]==1){
			 player = 33;
		 }
		 else if (r6c4[2]==1){
			 player = 34;
		 }
		 else if (r6c5[2]==1){
			 player = 35;
		 }
		 else if (r6c6[2]==1){
			 player = 36;
		 }
		 
		//check vertically, up
		 target = player;
		 x=6;
		 h=0;
		 tempH=0;
		 while(target>=1){
			 h=tempH;
			 Heuristics2.assignH();
			 computeHorizontally();
			 target = player-x;
			 x+=6;
			 tempH++;
		 }//check vertically, up
		 
		//check vertically, down
		 target = player;
		 x=6;
		 h=0;
		 tempH=0;
		 while(target<=36){ 
			 h=tempH;
			 Heuristics2.assignH();
			 computeHorizontally();
			 target = player+x;
			 x+=6;
			 tempH++;
		 }//check vertically, down
		 int heuristic[][] = {
				 {r1c1[0],r1c2[0],r1c3[0],r1c4[0],r1c5[0],r1c6[0]},
				 {r2c1[0],r2c2[0],r2c3[0],r2c4[0],r2c5[0],r2c6[0]},
				 {r3c1[0],r3c2[0],r3c3[0],r3c4[0],r3c5[0],r3c6[0]},
				 {r4c1[0],r4c2[0],r4c3[0],r4c4[0],r4c5[0],r4c6[0]},
				 {r5c1[0],r5c2[0],r5c3[0],r5c4[0],r5c5[0],r5c6[0]},
				 {r6c1[0],r6c2[0],r6c3[0],r6c4[0],r6c5[0],r6c6[0]}
		 };
		 
		 return heuristic;
	}//public static void computeVertically(){
	
	public static void computeHorizontally(){
		int tempTarget = target;
		if(target>=1&&target<=6){
			//check horizontally, left
			int y=1;
			switch(target){
				case 1: h=r1c1[0];
					break;
				case 2: h=r1c2[0];
					break;
				case 3: h=r1c3[0];
					break;
				case 4: h=r1c4[0];
					break;
				case 5: h=r1c5[0];
					break;
				case 6: h=r1c6[0];
					break;
			}//switch(target){
			h++;
			while(target>1&&target<=6){
				target=target-y;
				Heuristics2.assignH();
				h++;
			}//while(target>1&&target<=6){
			//check horizontally, left
			
			//check horizontally, right
			target = tempTarget;
			int z=1;
			switch(target){
				case 1: h=r1c1[0];
					break;
				case 2: h=r1c2[0];
					break;
				case 3: h=r1c3[0];
					break;
				case 4: h=r1c4[0];
					break;
				case 5: h=r1c5[0];
					break;
				case 6: h=r1c6[0];
					break;
			}//switch(target){
			h++;
			while(target>=1&&target<6){
				target=target+z;
				Heuristics2.assignH();
				h++;
			}//while(target>=1&&target<6){
			//check horizontally, right
			
		}//if(target>=1&&target<=6){
		
		else if(target>=7&&target<=12){
			//check horizontally, left
			int y=1;
			switch(target){
				case 7: h=r2c1[0];
					break;
				case 8: h=r2c2[0];
					break;
				case 9: h=r2c3[0];
					break;
				case 10: h=r2c4[0];
					break;
				case 11: h=r2c5[0];
					break;
				case 12: h=r2c6[0];
					break;
			
			}//switch(target){
			h++;
			while(target>7&&target<=12){
				target=target-y;
				Heuristics2.assignH();
				h++;
			}//while(target>7&&target<=12){
			//check horizontally, left
			
			//check horizontally, right
			target = tempTarget;
			int z=1;
			switch(target){
				case 7: h=r2c1[0];
					break;
				case 8: h=r2c2[0];
					break;
				case 9: h=r2c3[0];
					break;
				case 10: h=r2c4[0];
					break;
				case 11: h=r2c5[0];
					break;
				case 12: h=r2c6[0];
					break;
			}//switch(target){
			h++;
			while(target>=7&&target<12){
				target=target+z;
				Heuristics2.assignH();
				h++;
			}//while(target>=7&&target<12){
			//check horizontally, right
			
		}//else if(target>=7&&target<=12){
		
		else if(target>=13&&target<=18){
			//check horizontally, left
			int y=1;
			switch(target){
				case 13: h=r3c1[0];
					break;
				case 14: h=r3c2[0];
					break;
				case 15: h=r3c3[0];
					break;
				case 16: h=r3c4[0];
					break;
				case 17: h=r3c5[0];
					break;
				case 18: h=r3c6[0];
					break;
			
			}//switch(target){
			h++;
			while(target>13&&target<=18){
				target=target-y;
				Heuristics2.assignH();
				h++;
			}//while(target>13&&target<=18){
			//check horizontally, left
			
			//check horizontally, right
			target = tempTarget;
			int z=1;
			switch(target){
				case 13: h=r3c1[0];
					break;
				case 14: h=r3c2[0];
					break;
				case 15: h=r3c3[0];
					break;
				case 16: h=r3c4[0];
					break;
				case 17: h=r3c5[0];
					break;
				case 18: h=r3c6[0];
					break;
			}//switch(target){
			h++;
			while(target>=13&&target<18){
				target=target+z;
				Heuristics2.assignH();
				h++;
			}//while(target>=13&&target<18){
			//check horizontally, right
			
		}//else if(target>=13&&target<=18){
		
		else if(target>=19&&target<=24){
			//check horizontally, left
			int y=1;
			switch(target){
				case 19: h=r4c1[0];
					break;
				case 20: h=r4c2[0];
					break;
				case 21: h=r4c3[0];
					break;
				case 22: h=r4c4[0];
					break;
				case 23: h=r4c5[0];
					break;
				case 24: h=r4c6[0];
					break;
			
			}//switch(target){
			h++;
			while(target>19&&target<=24){
				target=target-y;
				Heuristics2.assignH();
				h++;
			}//while(target>19&&target<=24){
			//check horizontally, left
			
			//check horizontally, right
			target = tempTarget;
			int z=1;
			switch(target){
				case 19: h=r4c1[0];
					break;
				case 20: h=r4c2[0];
					break;
				case 21: h=r4c3[0];
					break;
				case 22: h=r4c4[0];
					break;
				case 23: h=r4c5[0];
					break;
				case 24: h=r4c6[0];
					break;
			}//switch(target){
			h++;
			while(target>=19&&target<24){
				target=target+z;
				Heuristics2.assignH();
				h++;
			}//while(target>=19&&target<24){
			//check horizontally, right
			
		}//else if(target>=19&&target<=24){
		
		else if(target>=25&&target<=30){
			//check horizontally, left
			int y=1;
			switch(target){
				case 25: h=r5c1[0];
					break;
				case 26: h=r5c2[0];
					break;
				case 27: h=r5c3[0];
					break;
				case 28: h=r5c4[0];
					break;
				case 29: h=r5c5[0];
					break;
				case 30: h=r5c6[0];
					break;
			
			}//switch(target){
			h++;
			while(target>25&&target<=30){
				target=target-y;
				Heuristics2.assignH();
				h++;
			}//while(target>25&&target<=30){
			//check horizontally, left
			
			//check horizontally, right
			target = tempTarget;
			int z=1;
			switch(target){
				case 25: h=r5c1[0];
					break;
				case 26: h=r5c2[0];
					break;
				case 27: h=r5c3[0];
					break;
				case 28: h=r5c4[0];
					break;
				case 29: h=r5c5[0];
					break;
				case 30: h=r5c6[0];
					break;
			}//switch(target){
			h++;
			while(target>=25&&target<30){
				target=target+z;
				Heuristics2.assignH();
				h++;
			}//while(target>=25&&target<30){
			//check horizontally, right
			
		}//else if(target>=25&&target<=30){
		
		else if(target>=31&&target<=36){
			//check horizontally, left
			int y=1;
			switch(target){
				case 31: h=r6c1[0];
					break;
				case 32: h=r6c2[0];
					break;
				case 33: h=r6c3[0];
					break;
				case 34: h=r6c4[0];
					break;
				case 35: h=r6c5[0];
					break;
				case 36: h=r6c6[0];
					break;
			
			}//switch(target){
			h++;
			while(target>31&&target<=36){
				target=target-y;
				Heuristics2.assignH();
				h++;
			}//while(target>31&&target<=36){
			//check horizontally, left
			
			//check horizontally, right
			target = tempTarget;
			int z=1;
			switch(target){
				case 31: h=r6c1[0];
					break;
				case 32: h=r6c2[0];
					break;
				case 33: h=r6c3[0];
					break;
				case 34: h=r6c4[0];
					break;
				case 35: h=r6c5[0];
					break;
				case 36: h=r6c6[0];
					break;
			}//switch(target){
			h++;
			while(target>=31&&target<36){
				target=target+z;
				Heuristics2.assignH();
				h++;
			}//while(target>=31&&target<36){
			//check horizontally, right
			
		}//else if(target>=31&&target<=36){
		
		
	}//public static void computeHorizontally(){
	
}//public class Heuristics {
