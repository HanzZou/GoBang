import java.util.Scanner;

/**
 * 计算最高
 */
public class Updowm {

//    ChessBoard chessBoard=new ChessBoard();
//    int[][] chess=null;
    //存储分数
    int[][] score=null;

    /**
     * 传入落子的二维数组，返回评分的二维数组
     * @param chess
     * @return
     */
    public int[][] recive(int[][] chess){
       score= new int[15][15];
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                //该位置没有落子，计算分数
                if(chess[i][j]==0){
                    score[i][j]=Judge.scoreBySlash(chess,i,j,1)+Score.scoreByVertical(chess,i,j,1);
                }
            }
        }
        return score;
    }

    //判断最高分，返回数组下标
    public int[] heightScore(int[][] score){

        int[] index=new int[2];
        int max=score[0][0];
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                if(max<=score[i][j]){
                    max=score[i][j];
                    index[0]=i;
                    index[1]=j;
                }
            }
        }
        return index;
    }

    public int[][] getScore() {
        return score;
    }

    public void setScore(int[][] score) {
        this.score = score;
    }


}
