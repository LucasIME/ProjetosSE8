/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triangulopascal;
import java.util.Scanner;
import java.math.*;

/**
 *
 * @author Lucas
 */
public class triangulo {
    private int tamanho;	

public int function(int i,int j)	{
	if(i==j || j==0) return 1;
	else return function(i-1,j)+ function(i-1,j-1);
}

	public void triangle(){
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o tamanho do triangulo de Pascal:");
		tamanho = input.nextInt();
		for(int i=0;i< tamanho;i++){
			for(int j=0; j<=i;j++){
				System.out.print(function(i,j) + " ");
			}
		System.out.println();
		}
	}
}
