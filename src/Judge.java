/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

/**
 * @author zouhanzhen
 * @date 2018/7/24 14:41
 */
public class Judge {

    private static int[] tupleScoreTable = new int[9];

    static {
        tupleScoreTable[0] = 7;
        tupleScoreTable[1] = 35;
        tupleScoreTable[2] = 800;
        tupleScoreTable[3] = 15000;
        tupleScoreTable[4] = 800000;
        tupleScoreTable[5] = 15;
        tupleScoreTable[6] = 400;
        tupleScoreTable[7] = 1800;
        tupleScoreTable[8] = 100000;
    }

    /**
     * 计算指定点的分数
     * @param board 棋盘
     * @param x 横坐标
     * @param y 纵坐标
     * @param player 选手(1为系统，-1为对手，0为初始)
     * @return 该点分数
     */
    public static int scoreBySlash(int[][] board, int x, int y, int player) {
        int score = 0;
        //左上开始的斜线
        for (int i = 0; i < 5; i++) {
            if (x - i < 0 || y - i < 0 || x + 4 - i > 14 || y + 4 - i > 14) {
                continue;
            }
            int selfNum = 0;
            int enemyNum = 0;
            for (int j = 0; j < 5; j++) {

                if (board[x-i+j][y-i+j]==player) {
                    selfNum++;
                } else if (board[x-i+j][y-i+j]==-player) {
                    enemyNum++;
                }
            }
            if (selfNum != 0 && enemyNum != 0) {
                continue;
            } else if (selfNum == 0 && enemyNum == 0) {
                score+=7;
            } else if (selfNum == 0) {
                score+=tupleScoreTable[4+enemyNum];
            } else {
                score+=tupleScoreTable[0+selfNum];
            }
        }
        //左下开始的斜线
        for (int i = 0; i < 5; i++) {
            if (x - i < 0 || y + i > 14 || x + 4 - i > 14 || y - 4 + i < 0) {
                continue;
            }
            int selfNum = 0;
            int enemyNum = 0;
            for (int j = 0; j < 5; j++) {

                if (board[x-i+j][y+i-j]==player) {
                    selfNum++;
                } else if (board[x-i+j][y+i-j]==-player) {
                    enemyNum++;
                }
            }
            if (selfNum != 0 && enemyNum != 0) {
                continue;
            } else if (selfNum == 0 && enemyNum == 0) {
                score+=7;
            } else if (selfNum == 0) {
                score+=tupleScoreTable[4+enemyNum];
            } else {
                score+=tupleScoreTable[0+selfNum];
            }
        }
        return score;
    }
}