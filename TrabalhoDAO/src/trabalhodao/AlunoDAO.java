/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodao;

/**
 *
 * @author Pedro
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public ArrayList<aluno> listar() throws
            ClassNotFoundException, SQLException {
        ArrayList<aluno> lista = new ArrayList<aluno>() {
        };
        FabricaConexoes fabrica = new FabricaConexoes();
        Statement stmt  = (Statement) fabrica.conexao().createStatement();
        ResultSet rs = stmt.executeQuery("select * from aluno;");

        while (rs.next()) {
            lista.add(new aluno( rs.getInt("codigo"), rs.getString("pessoa")));
        }
        return lista;
    }
    
    boolean inserir(aluno a) throws SQLException, ClassNotFoundException{
        FabricaConexoes fabrica = new FabricaConexoes();
        Statement stmt  = fabrica.conexao().createStatement();
        return stmt.execute("insert into aluno values ('" + a.getNome()+ "', " + a.getCodigo() +"); ");
    }
    
    boolean deletar(aluno a) throws ClassNotFoundException, SQLException{
        FabricaConexoes fabrica = new FabricaConexoes();
        Statement stmt  = fabrica.conexao().createStatement();
        return stmt.execute("delete from aluno where pessoa = '" + a.getNome()+ "' and codigo = " + a.getCodigo() + "; ");
    }
    
    boolean atualizar(aluno a, int novocodigo) throws ClassNotFoundException, SQLException{
        FabricaConexoes fabrica = new FabricaConexoes();
        Statement stmt  = fabrica.conexao().createStatement();
        return stmt.execute("update aluno  set codigo = " + novocodigo + " where pessoa = '" + a.getNome()+ "'; ");
    }
    
    
}
