/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoxadrez;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class TrabalhoXadrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         int[][] list = new int[64][2];
     
        for (int i=0; i < 8 ; i++){
         for (int j=0; j < 8 ; j++){
             //Tabuleiro
             Board2 stroll = new Board2(8);
             int[] moves = new int[stroll.getSize()];
 
             //Teste do algoritmo para diferentes pontos de partida
             //Feito para garantir um percurso ciclico
             stroll.findBoard(i,j);
             stroll.findMoves();
 
             if(stroll.checkMoves() && stroll.finalMove()){//Checa resposta
                 //Prints
                 System.out.println("X0="+i+"\tY0="+j);//Ponto de partida do algoritmo
                 stroll.printBoard();//Tabuleiro
                 stroll.printMoves();//Lista de Movimentos
                 System.out.println();
                 list= stroll.getMoves();//Captura a lista de movimentos
             }
         }
    }
      
        XadrezDAO manipulador = new XadrezDAO();
        Xadrez vetormov[] = new Xadrez[64];
        
        
        for (int i = 0; i < 64; i++) {
            vetormov[i] = new Xadrez(i, list[i][1], list[i][0]);
        }
        
        for (int i = 0; i < 64; i++) {
            System.out.println("Movimento " + vetormov[i].getNum() + ": " + vetormov[i].getY() + "," + vetormov[i].getX());
        }
        
        
        manipulador.criarTabela();
        for (int i = 0; i < 64; i++) {
        manipulador.inserir(vetormov[i]);
        }
        
        ArrayList<Xadrez> TabeladoBD = manipulador.listar();
        System.out.println("Movimentos no BD:");
        for(int i=0; i<TabeladoBD.size(); i++){
            System.out.println("Movimento " + TabeladoBD.get(i).getNum() + ": " + TabeladoBD.get(i).getY() + "," + TabeladoBD.get(i).getX());
        }
        
        /*
        //Tabuleiro
        Board stroll = new Board(8);
        int[] position = stroll.FirstSquare();

        //A.I.
        for (int i = 1; i < stroll.getSize(); i++) {
            position = stroll.nextMove(position);
        }

        //Print
        stroll.printBoard();

        XadrezDAO manipulador = new XadrezDAO();
        Xadrez vetormov[] = new Xadrez[64];
       
        for (int i = 0; i < 64; i++) {
            vetormov[i] = new Xadrez(i, stroll.retornaYnum(i+1), stroll.retornaXnum(i+1));
        }
        
        for (int i = 0; i < 64; i++) {
            System.out.println("Movimento " + vetormov[i].getNum() + ": " + vetormov[i].getY() + "," + vetormov[i].getX());
        }
        
        manipulador.criarTabela();
        for (int i = 0; i < 64; i++) {
        manipulador.inserir(vetormov[i]);
        }
        
        ArrayList<Xadrez> TabeladoBD = manipulador.listar();
        System.out.println("Movimentos no BD:");
        for(int i=0; i<TabeladoBD.size(); i++){
            System.out.println("Movimento " + TabeladoBD.get(i).getNum() + ": " + TabeladoBD.get(i).getY() + "," + TabeladoBD.get(i).getX());
        }
                 */         
    }
}
