package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public String url = "jdbc:mysql://localhost:3306/cenaflix_podcast";
    public String user = "root";
    public String password = "taticodobem@357";

    private Connection conn; // conexao armazenada aqui

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão com o Banco funcionado...");
            return conn;
        } catch (Exception e) {
            System.out.println("Erro de conexão com o Banco");
            return null;
        }
    }

    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {}}

}
