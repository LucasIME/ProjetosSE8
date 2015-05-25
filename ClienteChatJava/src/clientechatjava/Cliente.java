/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientechatjava;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**Classe que define o Cliente do Chat
 *
 * @author Lucas
 */
public class Cliente {

    private String host;
    private int porta;
    private String nome;

    /**Construtor - Define os parâmetros do cliente: nome, IP do Servidor e Número da porta a qual irá se conectar
     *
     * @param host IP do Servidor
     * @param i Número da porta a qual irá se conectar
     */
    public Cliente(String host, int i) {
        System.out.println("Digite o seu Nome:");
        Scanner nomescanner = new Scanner(System.in);
        this.nome = nomescanner.nextLine();
        this.host = host;
        this.porta = i;
    }

    /**Método que inicializa a execução do cliente
     *
     * @throws UnknownHostException Trata exceção
     * @throws IOException Trata exceção
     */
    public void executa() throws UnknownHostException, IOException {
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente se conectou ao servidor!");

        Recebedor r = new Recebedor(cliente.getInputStream());
        new Thread(r).start();

        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(this.nome + " diz: " + teclado.nextLine());
        }
    }
}
