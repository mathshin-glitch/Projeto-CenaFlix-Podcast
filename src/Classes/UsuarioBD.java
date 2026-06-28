package Classes;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioBD {

    private Conexao conexao;
    private Connection conn;

    public UsuarioBD() {
        this.conexao = new Conexao();
        this.conn = conexao.getConexao();
    }

    public Usuario validarUsuarioSeguro(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE LOWER(login)=LOWER(?) AND senha=?";
        Usuario usuarioEncontrado = null;

        Connection conn = new Conexao().getConexao();
        if (conn == null) {
            System.out.println("Erro: conexão nula!");
            return null;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha()); // senha exata

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId(rs.getInt("id"));
                    usuarioEncontrado.setLogin(rs.getString("login"));
                    usuarioEncontrado.setSenha(rs.getString("senha"));
                    usuarioEncontrado.setTipo(rs.getString("tipo"));
                }
            }

        } catch (Exception ex) {
            System.out.println("Erro ao validar usuário: " + ex.getMessage());
            ex.printStackTrace();
        }

        return usuarioEncontrado;
    }
}
