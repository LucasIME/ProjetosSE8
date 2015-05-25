/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientechatjava;

import java.io.InputStream;
import java.util.Scanner;

/**Classe que recebe as mensagens do servidor destinadas a um determinado cliente
 *
 * @author Lucas
 */
public class Recebedor implements Runnable {

    private InputStream msgdoservidor;

    /**Construtor - Define a InputStream do cliente que irá receber mensagen
     *
     * @param msgdoservidor InputStream do cliente
     */
    public Recebedor(InputStream msgdoservidor) {
        this.msgdoservidor = msgdoservidor;
    }

    public void run() {
        Scanner s = new Scanner(this.msgdoservidor);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}
