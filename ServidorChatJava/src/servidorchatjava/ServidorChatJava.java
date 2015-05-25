/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchatjava;

import java.io.IOException;

/**
 *
 * @author Lucas
 */
public class ServidorChatJava {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException Trata exceção
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Servidor(1339).executa();

    }

}
