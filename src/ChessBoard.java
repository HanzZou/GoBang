/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

import javax.swing.*;

/**
 * @author wangyu4
 * @date 2018/7/24 13:23
 */
public class ChessBoard {


    int chessBoard[][] = new int[15][15];


    public int[][] getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(int[][] chessBoard) {
        this.chessBoard = chessBoard;
    }


    /**
     *   对方从控制台输入的值是坐标，对应数组全部存为-1，
     */
    public int[][] printIndex(int x,int y){
        chessBoard[14-y][x]=-1;
        return chessBoard;
    }


    /**
     *   落子下标，转化为坐标，对应数组全部存为1，
     */
    public int[][] outputIndex(int[] index){
        chessBoard[index[0]][index[1]]=1;
        printChessBoard();
        System.out.println("我们所下的位置坐标是:"+index[1]+","+(14-index[0]));
        return chessBoard;
    }


    /**
     * 输出我的棋盘
     */
    public void printChessBoard(){
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                switch (chessBoard[i][j]){
                    case 0:
                        System.out.print(0+"\t");
                        break;
                    case 1:
                        System.out.print("*\t");
                        break;
                    case -1:
                        System.out.print("#\t");
                        break;
                }

            }
            System.out.println("");
        }
    }



}

