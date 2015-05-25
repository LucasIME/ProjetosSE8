/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorchatjava;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**Classe que implementa a criação do servidor do Chat
 *
 * @author Lucas
 */
public class Servidor {

    private int porta;
    private List<PrintStream> clientes;
    private List<Socket> sockets;

    /**Construtor - Define a porta que será utilizada para conexão com os clientes
     *
     * @param porta Porta que será aberta para conexão
     */
    public Servidor(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
        this.sockets = new ArrayList<>();
    }

    /**Método que inicializa a execução do servidor
     *
     * @throws IOException Trata exceção
     */
    public void executa() throws IOException {
        ServerSocket servidor = new ServerSocket(this.porta);
        System.out.println("Porta " + this.porta + " aberta!");

        while (true) {
            Socket cliente = servidor.accept();
            this.sockets.add(cliente);
            System.out.println("Nova coneção com o cliente de IP: " + cliente.getInetAddress().getHostAddress());

            PrintStream ps = new PrintStream(cliente.getOutputStream());
            this.clientes.add(ps);

            //this.sockets.add(cliente);
            TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
            new Thread(tc).start();
        }

    }

    /**Método que redistribui uma dada mensagem de um cliente para todos os outros clientes do chat
     *
     * @param msg Mensagem recebida do cliente que será redistribuida para todos os outros clientes
     * @param inputdocliente InputStream do cliente que enviou a mensagem que será redistribuida
     * @throws IOException Trata exceção
     */
    public void distribuiMensagem(String msg, InputStream inputdocliente) throws IOException {
        int n = 0;
        //for (PrintStream cliente : this.clientes) {
        for (Socket socket : this.sockets) {
            // cliente.println(msg);
            if ((socket.getInputStream().equals(inputdocliente))) {
                n = sockets.indexOf(socket);
            }
        }
        for (PrintStream cliente : this.clientes) {
            if (clientes.indexOf(cliente) != n) {
                cliente.println(msg);
            }
        }
        System.out.println("Mensagem redistribuida!");
    }
}
