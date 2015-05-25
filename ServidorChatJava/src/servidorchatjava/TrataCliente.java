/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchatjava;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Classe que trata um determinado cliente, capturando suas mensagens e as redistribuindo
 *
 * @author Lucas
 */
class TrataCliente implements Runnable {

    private InputStream cliente;
    private Servidor servidor;

    public TrataCliente(InputStream cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
        Scanner s = new Scanner(this.cliente);
        while (s.hasNextLine()) {
            System.out.println("Mensagem Recebida!");
            try {
                servidor.distribuiMensagem(s.nextLine(), this.cliente);
            } catch (IOException ex) {
                Logger.getLogger(TrataCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        s.close();
    }
}
