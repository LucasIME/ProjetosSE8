/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoxadrez;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Calculos {
    
    int t[][] = new int[8][8];
        int a[] = new int[8];
        int b[] = new int[8];
        int cont;
        
    public Calculos(){
        a[0] = 2; 
        a[1] = 1;
        a[2] = -1;
        a[3] = -2;
        b[0] = 1;
        b[1] = 2;
        b[2] = 2;
        b[3] = 1;

        a[4] = -2;
        a[5] = -1;
        a[6] = 1;
        a[7] = 2;
        b[4] = -1;
        b[5] = -2;
        b[6] = -2;
        b[7] = -1;
        cont = 1;
        t[0][0] = 1;
        cavalo(2, 0, 0);
    }
        
    public void imprime() {
        int i, j;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                System.out.printf("%3d", this.t[i][j]);
                if(j==7) System.out.println("");
            }
        }
        System.out.println();
    }

    int cavalo(int i, int x, int y) {
        int u, v, k, q;
        if (i == 65) {
            imprime();
            return 1;
        }
        //executa movimentos
        for (k = 0; k < 8; k++) {
       //for (k=7;k>=0;k--){
            u = x + a[k];
            v = y + b[k];
            //testa limites do tabuleiro
            if ((u >= 0 && u <= 7) && (v >= 0 && v <= 7)) {
                if (this.t[u][v] == 0) { //posicao livre
                    this.t[u][v] = i; //registre o movimento
                    q = cavalo(i + 1, u, v);
                    if (q == 0 || ( (q==1) && !atingivel( retornaXnum(1), retornaYnum(1), retornaXnum(64), retornaYnum(64) )) ) {
                        this.t[u][v] = 0; //se não alcançou todos, desfaça 
                    } else{
                        return 1; // se alcançou todos, retorne 1
                    }
                }
            }
        }
        return 0;
    }
        
    public int retornaXnum (int num){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if (this.t[i][j] == num) return i;
            }
        }
        return -1;
    }
    
    public int retornaYnum(int num){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if (this.t[i][j] == num) return j;
            }
        }
        return -1;
    }
    
    boolean atingivel( int x1, int y1, int x2, int y2){
        if( (abs(x1-x2)==1 && abs(y1-y2)==2) || ( abs(x2-x1)==2 && abs(y2-y1)==1  )  ) return true;
        else return false;
    } 
   
}
