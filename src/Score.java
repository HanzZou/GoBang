
public class Score {

	
	
/*    // tuple is empty  
    Blank,  
    // tuple contains a black chess  
    B,  
    // tuple contains two black chesses  
    BB,  
    // tuple contains three black chesses  
    BBB,  
    // tuple contains four black chesses  
    BBBB,  
    // tuple contains a white chess  
    W,  
    // tuple contains two white chesses  
    WW,  
    // tuple contains three white chesses  
    WWW,  
    // tuple contains four white chesses  
    WWWW,  
    // tuple does not exist  
    Virtual,  
    // tuple contains at least one black and at least one white  
    Polluted*/  
	private static int[] tupleScoreTable=new int[12];
	static {
		tupleScoreTable[0] = 7;  //B
	    tupleScoreTable[1] = 35;  
	    tupleScoreTable[2] = 800;  
	    tupleScoreTable[3] = 15000;  
	    tupleScoreTable[4] = 800000;  
	    tupleScoreTable[5] = 15; //W  
	    tupleScoreTable[6] = 400;  
	    tupleScoreTable[7] = 1800;  
	    tupleScoreTable[8] = 100000;  
	    tupleScoreTable[9] = 0;  
	    tupleScoreTable[10] = 0; 
	}
     
	
	/**
     * 计算指定点的分数
     * @param board 棋盘
     * @param x 横坐标
     * @param y 纵坐标
     * @param player 选手(1为系统，-1为对手，0为初始)
     * @return 该点分数
     */
	
	public static int scoreByVertical(int[][] board,int n,int m,int player){
		int y=n;
		int x=m;
		int sum=0;
		for(int i=y;i<y+5;i++){
			int playersame=0;
			int notplayersame=0;
			if((i-4)<0||i>14){
				continue;
			}
			for(int j=0;j<5;j++){
				if(board[i-j][x]==player){
					playersame++;
				}else if(board[i-j][x]==-player){
					notplayersame++;
				}
				
			}
			
			if(playersame!=0&&notplayersame!=0){	
				continue;
			}
			if(playersame==0&&notplayersame==0){
				sum=sum+tupleScoreTable[playersame];
			}
			if(playersame!=0&&notplayersame==0){
				sum=sum+tupleScoreTable[playersame];
			}
			if(playersame==0&&notplayersame!=0){	
			 sum=sum+tupleScoreTable[notplayersame+4];	
				
			}
			
			
			
		}
		
		for(int i=x;i<x+5;i++){
			int playersame=0;
			int notplayersame=0;
			if((i-4)<0||i>14){
				continue;
			}
			for(int j=0;j<5;j++){
				if(board[y][i-j]==player){
					playersame++;
				}else if(board[y][i-j]==-player){
					notplayersame++;
				}
				
			}
			
			if(playersame!=0&&notplayersame!=0){	
				continue;
			}
			if(playersame==0&&notplayersame==0){
				sum=sum+tupleScoreTable[playersame];
			}
			if(playersame!=0&&notplayersame==0){
				sum=sum+tupleScoreTable[playersame];
			}
			if(playersame==0&&notplayersame!=0){	
			 sum=sum+tupleScoreTable[notplayersame+4];	
				
			}
		}
		
		return sum;
		
	}
	

	

}
