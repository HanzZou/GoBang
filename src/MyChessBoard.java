/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */


import java.util.Scanner;

/**
 * @author wangyu4
 * @date 2018/7/24 13:24
 */
public class MyChessBoard {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        int[][] chess1=chessBoard.getChessBoard();
        Scanner scanner = new Scanner(System.in);
        Updowm updowm=new Updowm();
        chessBoard.printChessBoard();
        System.out.println("先手请输入1，后手请输入2：");

        int order=scanner.nextInt();
        if (order==1){
            chess1[7][7]=1;
            chessBoard.setChessBoard(chess1);
            System.out.println("我方下棋位置为： 7,7");
        }
        for(int i = 0; i < 120; i++){
            System.out.println("请先输入一个坐标：");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            //根据对手输入的相应值，改变棋盘中相应位置,对手落子得到棋盘
            int[][] chess=chessBoard.printIndex(x,y);
            int[][] sc=updowm.recive(chess);
            int[] a=updowm.heightScore(sc);
            chessBoard.outputIndex(a);
        }
    }
}

