/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoxadrez;

/**
 *
 * @author Pedro
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class XadrezDAO {

   
    public ArrayList<Xadrez> listar() throws
            ClassNotFoundException, SQLException {
        ArrayList<Xadrez> lista = new ArrayList<Xadrez>();
        FabricaConexoes fabrica = new FabricaConexoes();
        Statement stmt  = (Statement) fabrica.conexao().createStatement();
        ResultSet rs = stmt.executeQuery("select * from movimentos order by nummov;");
        int i=0;
        while (rs.next()) {
            lista.add(new Xadrez( rs.getInt("nummov"), rs.getInt("y"), rs.getInt("x")));
        }
        return lista;
    }
    
    boolean criarTabela() throws ClassNotFoundException, SQLException{
        FabricaConexoes fabrica = new FabricaConexoes();
        Statement stmt  = fabrica.conexao().createStatement();
        stmt.execute("DROP TABLE movimentos;");
        return stmt.execute("CREATE TABLE IF NOT EXISTS `movimentos` (\n" +
                "  `nummov` int(11) NOT NULL,\n" +
                    "  `x` int(11) NOT NULL,\n" +
        "  `y` int(11) NOT NULL,\n" +
    "  PRIMARY KEY (`x`,`y`)\n" +
        ") ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci; ");
    }
  
  
    boolean inserir(Xadrez a) throws SQLException, ClassNotFoundException{
        FabricaConexoes fabrica = new FabricaConexoes();
        Statement stmt  = fabrica.conexao().createStatement();
        return stmt.execute("insert into movimentos values ( " +a.getNum()+", " + a.getX()+ ", " + a.getY() +"); ");
    }
    /*
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
    */
    
}
