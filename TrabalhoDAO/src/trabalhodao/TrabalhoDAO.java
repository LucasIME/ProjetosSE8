/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhodao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class TrabalhoDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        aluno joao = new aluno(12415, "Joao");
        aluno marcelo = new aluno (12426, "Marcelo");
        AlunoDAO manipulador = new AlunoDAO();
        ArrayList<aluno> lista = new ArrayList<>(manipulador.listar());
        for( aluno a : lista){
            System.out.println(a.getNome() +" "+  a.getCodigo());
        }
        manipulador.inserir(joao);
        manipulador.deletar(marcelo);
        manipulador.atualizar(joao, 12410);

    }
    
}
