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
public class Board2 {
 private final int NUM_OF_MOVES = 8;
 private final int[][] MOVES ={{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,1},{-2,-1}};
 private final int[][] QUADRANT ={
     {1,2,3,4},
     {3,4,1,2},
     {2,1,4,3},
     {1,3,2,1}
 };
 
 private int boardLength;
 private int boardWidth;
 private int moveNumber;
 private int[][] daBoard;//ciclo no tabuleiro
 private int[][] daMoves;//lista de movimentos
 
 public Board2(int BOARD_SIZE){
     this.boardLength = BOARD_SIZE;
     this.boardWidth = BOARD_SIZE;
     this.moveNumber=0;
     this.daBoard = new int[BOARD_SIZE][BOARD_SIZE];
     this.daMoves = new int[BOARD_SIZE*BOARD_SIZE][2];
 }
 
 //Retorna o numero de casas no tabuleiro
 public int getSize(){
     return boardLength*boardWidth;
 }
 
 //Rertorna true se a posicao dada for a de uma casa vazia no tabuleiro
 private boolean inBoardAndEmpty(int x, int y){
     return ( x < boardLength  && x >= 0 && y < boardWidth   && y >=0  && daBoard[x][y] == 0 );
 }
 
 //Retorna o numero de casas alcancaveis a partir de dada posicao
 private int getAccessibility(int x, int y){
     int accessibility = 0;
     for(int i=0; i < NUM_OF_MOVES ; i++){
         if(inBoardAndEmpty(x + MOVES[i][0], y + MOVES[i][1])){
             accessibility++;
         }
     }
     return accessibility;
 }
 
 //Determina o proximo movimento e povoa casas no tabuleiro
 public int[] nextMove(int[] square){
 int xSquare = square[0];
 int ySquare = square[1];
 int accessibility = NUM_OF_MOVES;
 
 for (int i=0 ; i< NUM_OF_MOVES ; i++){
 int newX = xSquare + MOVES[i][0];
 int newY = ySquare + MOVES[i][1];
 int newAccessibility = getAccessibility(newX, newY);
 
 if( inBoardAndEmpty(newX, newY) && newAccessibility < accessibility ){
 square[0] = newX;
 square[1] = newY;
 accessibility = newAccessibility;
 }
 }
 daBoard[ square[0] ][ square[1] ] = ++moveNumber;
 return square;
 }
 
 //Povoa o tabuleiro
 //'x' e 'y' sao a posicao de partida do algoritmo
 public void findBoard(int x, int y){
     int[] square = new int[2];
     square[0] = x;
     square[1] = y;
     daBoard[ square[0] ][ square[1] ] = ++moveNumber;
     for (int i=1; i< this.getSize() ; i++){
         square = this.nextMove(square);
     }
 }
 
 //Cria a lista de movimentos
 public void findMoves(){
     for (int i=0; i < boardLength ; i++){
         for (int j=0; j < boardWidth ; j++){
             if(daBoard[i][j]-daBoard[0][0]<0){
                 daMoves[(64+daBoard[i][j]-daBoard[0][0])][0]=j;
                 daMoves[(64+daBoard[i][j]-daBoard[0][0])][1]=i;
             }
             else{
                 daMoves[(daBoard[i][j]-daBoard[0][0])][0]=j;
                 daMoves[(daBoard[i][j]-daBoard[0][0])][1]=i;
             }
         }
     }
 }
 
 //Checa lista de movimentos
 public boolean checkMoves(){
     int count=1, aux=1;
     boolean flag=true;
     for (int i=1; i < this.getSize() ; i++){
         for(int j=0; j < NUM_OF_MOVES ; j++){
             if(daMoves[i][0]-daMoves[i-1][0]==MOVES[j][0] && daMoves[i][1]-daMoves[i-1][1]==MOVES[j][1]){
                 count++;
             }
         }
         aux++;
         if(aux!=count){
             //Mostra em que movimento ocorre o erro
             //System.out.print(i+1 + "\t");
             //System.out.print(daMoves[i][0]-daMoves[i-1][0] + "\t");
             //System.out.println(daMoves[i][1]-daMoves[i-1][1]);
             count++;
             flag=false;
         }
     }
     return flag;
 }
 
 //Checa o movimento que fecha o ciclo
 public boolean finalMove(){
     int count;
     if(daMoves[1][0]==1 && daMoves[1][1]==2 && daMoves[63][0]==2 && daMoves[63][1]==1){
          return true;
     }
     else if(daMoves[1][0]==2 && daMoves[1][1]==1 && daMoves[63][0]==1 && daMoves[63][1]==2){
          return true;
     }
     else{
         return false;
     }
 }
 
 //Mostra o tabuleiro na tela
 public void printBoard(){
     System.out.println("   00 01 02 03 04 05 06 07 ");
     for (int i=0; i < boardLength ; i++){
         System.out.print(String.format("%02d",i)+"|");
         for (int j=0; j < boardWidth ; j++){
             if(daBoard[i][j]-daBoard[0][0]<0){
                 System.out.print(String.format("%02d",65+daBoard[i][j]-daBoard[0][0]) + "|");
             }
             else{
                 System.out.print(String.format("%02d",1+daBoard[i][j]-daBoard[0][0]) + "|");
             }
         }
         System.out.println();
     }
 }
 
 //Mostra a lista de movimentos na tela
 public void printMoves(){
     System.out.println("\t"+"X"+ "\t"+"Y");
     for (int i=0; i < this.getSize() ; i++){
         System.out.print(i+1 + "\t");
         System.out.print(daMoves[i][0] + "\t");
         System.out.println(daMoves[i][1]);
     }
 }
 
 //Retorna a lista de movimentos
 public int[][] getMoves(){
     return this.daMoves;
 }
}