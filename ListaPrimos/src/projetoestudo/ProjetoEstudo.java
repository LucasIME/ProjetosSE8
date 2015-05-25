/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestudo;

import static java.lang.Math.sqrt;

/**
 *
 * @author Lucas
 */
class ListaPrimos {

    int[] p;

    ListaPrimos(int nprimos) {
        int k = 0, i = 2;
        p = new int[nprimos];
        while (k < nprimos) {
            if (eh_primo(i)) {
                p[k++] = i;
            }

            i++;

        }
    }

    private boolean eh_primo(int x) {
        for (int i = 2; i < sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < p.length; i++) {
            if (i == 0) {
                s += p[i];
            } else {
                s += (", " + p[i]);
            }
        }
        return s;
    }
}

public class ProjetoEstudo {

    public static void main(String args[]) {
        ListaPrimos obj = new ListaPrimos(2000);
        System.out.println(obj);
    }
}
