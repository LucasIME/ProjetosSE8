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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

    private String base;
    private String user;
    private String password;
    private String server;
    private String tcpport;

    public FabricaConexoes() {
        this.setServer("localhost");
        this.setTcpport("3306");
        this.setBase("trabalhodao");
        this.setUser("desenvolvedor");
        this.setPassword("");
    }

    public Connection conexao() throws
            ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection("jdbc:mysql://" + getServer()
                + ":" + getTcpport() + "/" + getBase(), getUser(),
                getPassword());
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getTcpport() {
        return tcpport;
    
}

    private void setTcpport(String string) {
        this.tcpport = string;
    }
}
