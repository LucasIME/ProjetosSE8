/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientechatjava;

import java.io.IOException;

/**
 *
 * @author Lucas
 */
public class ClienteChatJava {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException Trata exceção
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Cliente("127.0.0.1", 1339).executa();
    }

}
