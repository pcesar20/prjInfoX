package br.com.infox.dal;

import java.sql.*;

public class ModuloConexao {

    public static Connection conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        // seta caminho do banco de dados, nesse projeto chamado 'dbinfox'.
        String url = "jdbc:mysql://localhost:3306/dbinfox?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
