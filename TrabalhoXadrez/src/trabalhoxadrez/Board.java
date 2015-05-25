/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoxadrez;

/**
 *
 * @author Lucas
 */
import java.util.Random;

public class Board {

    private final int NUM_OF_MOVES = 8;
    private final int[][] MOVES = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    private final int[][] QUADRANT
            = {
                {1, 2, 3, 4},
                {3, 4, 1, 2},
                {2, 1, 4, 3},
                {1, 3, 2, 1}
            };

    private int moveNumber;
    private int[][] daBoard;
    private int boardLength;
    private int boardWidth;

    public Board(int BOARD_SIZE) {
        this.boardLength = BOARD_SIZE;
        this.boardWidth = BOARD_SIZE;
        this.daBoard = new int[boardLength][boardWidth];
        this.moveNumber = 0;
    }

    public int[] FirstSquare() {
        Random chaosnum = new Random();
        int[] square = new int[2];
        square[0] = chaosnum.nextInt(boardLength);
        square[1] = chaosnum.nextInt(boardWidth);
        daBoard[square[0]][square[1]] = ++moveNumber;
        return square;
    }

    public int getSize() {
        return boardLength * boardWidth;
    }

    private int getAccessibility(int x, int y) {
        int accessibility = 0;
        for (int i = 0; i < NUM_OF_MOVES; i++) {
            if (inRangeAndEmpty(x + MOVES[i][0], y + MOVES[i][1])) {
                accessibility++;
            }
        }
        return accessibility;
    }

    public int[] nextMove(int[] square) {
        int xSquare = square[0];
        int ySquare = square[1];
        int accessibility = NUM_OF_MOVES;

        for (int i = 0; i < NUM_OF_MOVES; i++) {
            int newX = xSquare + MOVES[i][0];
            int newY = ySquare + MOVES[i][1];
            int newAccessibility = getAccessibility(newX, newY);

            if (inRangeAndEmpty(newX, newY) && newAccessibility < accessibility) {
                square[0] = newX;
                square[1] = newY;
                accessibility = newAccessibility;
            }
        }
        daBoard[square[0]][square[1]] = ++moveNumber;
        return square;
    }

    private boolean inRangeAndEmpty(int x, int y) {
        return (x < boardLength && x >= 0 && y < boardWidth && y >= 0
                && daBoard[x][y] == 0);
    }

    public void printBoard() {
        //interface=tela
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (daBoard[i][j] - daBoard[0][0] < 0) {
                    System.out.print((65 + daBoard[i][j] - daBoard[0][0]) + "\t");
                } else {
                    System.out.print((1 + daBoard[i][j] - daBoard[0][0]) + "\t");
                }
            }
            System.out.println();
        }
    }
    
    public int retornaYnum (int num){
         for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (daBoard[i][j] - daBoard[0][0] < 0) {
                    if((65 + daBoard[i][j] - daBoard[0][0]) == num) return i;
                } else {
                    if(((1 + daBoard[i][j] - daBoard[0][0])) == num) return i;
                }
            }
        }
        return -1;
    }
    
    public int retornaXnum(int num){
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (daBoard[i][j] - daBoard[0][0] < 0) {
                    if((65 + daBoard[i][j] - daBoard[0][0]) == num) return j;
                } else {
                    if(((1 + daBoard[i][j] - daBoard[0][0])) == num) return j;
                }
            }
        }
        return -1;
    }
    
}
