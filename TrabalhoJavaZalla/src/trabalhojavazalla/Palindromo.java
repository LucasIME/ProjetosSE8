/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojavazalla;

/**
 * Asked by Maj Anderson
 *
 * @author Zalla Ricardo 2nd Homework for Comp_3.2
 */
//import.java.util.Iterator;
import java.util.Scanner;

public class Palindromo {

    private Scanner input = new Scanner(System.in);
    private String frase, s;
    private StringBuilder frase2;

    Palindromo() {
        System.out.println("Digite a frase para checar se é palindomo:");
        frase = input.nextLine();
        s = frase.replaceAll(" ", "");
        s = s.toLowerCase();
        frase2 = new StringBuilder(s);
    }

    //ITERATIVO
    public boolean iterativo() {
        String s1 = s;
        int i = 0, j = s1.length() - 1;
        for (; i < s1.length() / 2; i++, j--) {
            if (s1.charAt(i) != s1.charAt(j)) {
                System.out.println("nao é palindromo");
                return false;
            }
        }
        i++;
        j--;
        System.out.println(frase + " é palindromo (iterativo)");
        return true;
    }

    //RECURSIVO
    public boolean recursivo() {
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            System.out.println("não é palindromo (recursivo)");
            return false;
        }
        if(s.length()==1 || s.isEmpty()){
            System.out.println("é um palindromo(recursivo)");
            return true;
        }
        s = s.substring(1, s.length() - 1);
        recursivo();
        return true;
    }

    public void StringBuilder() {
        StringBuilder aux = new StringBuilder(frase2);
        frase2.reverse();
        if (aux.toString().equals(frase2.toString())) {
            System.out.println(" é um palindromo!(StringBuilder)");
        } else {
            System.out.println("não é um palindromo!(StringBuilder)");
        }

    }
}
