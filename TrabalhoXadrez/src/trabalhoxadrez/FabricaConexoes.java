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
        this.setServer("186.202.152.241");
        this.setTcpport("3306");
        this.setBase("websimulado15");
        this.setUser("websimulado15");
        this.setPassword("a46db46d36d98e");
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
