package dao;

import Classes.PodCast;
import conexao.Conexao;
import Classes.Usuario;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PodCastDAO {

    //Atributos de conexão
    private Conexao conexao;
    private Connection conn;

    //Construtor da classe DAO
    public PodCastDAO() {
        this.conexao = new Conexao(); //Cria um objeto de conexão
        this.conn = this.conexao.getConexao(); //Construtor da classe DAO
    }

    public int inserir(PodCast cast) {
        int status;
        try {
            String sql = "INSERT INTO podcast (produtor,nomeEpisodio,numeroEpisodio,duracao,urlRepositorio) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cast.getProdutor());
            stmt.setString(2, cast.getNomeEpisodio());
            stmt.setInt(3, cast.getNumeroEpisodio());
            stmt.setString(4, cast.getDuracao());
            stmt.setString(5, cast.getUrlRepositorio());
            status = stmt.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro no INSERT: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public boolean excluir(int id) {
        boolean resultado;
        try {
            String sql = "DELETE FROM podcast WHERE id = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            resultado = stmt.executeUpdate() > 0;
            stmt.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Erro no DELETE: " + ex.getMessage());
            return false;
        }
    }

    //Pega o PodCast pelo Nome do Episodio
    public List<PodCast> PegarPodCastNome(String nomeEpisodio) {
        try {
            String sql = "SELECT * FROM podcast WHERE NomeEpisodio LIKE ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            stmt.setString(1, "%" + nomeEpisodio + "%");
            ResultSet rs = stmt.executeQuery();
            List<PodCast> lista = new ArrayList();

            while (rs.next()) {
                PodCast p = new PodCast();
                p.setId(rs.getInt("id"));
                p.setProdutor(rs.getString("produtor"));
                p.setNomeEpisodio(rs.getString("nomeEpisodio"));
                p.setNumeroEpisodio(rs.getInt("numeroEpisodio"));
                p.setDuracao(rs.getString("duracao"));
                p.setUrlRepositorio(rs.getString("urlRepositorio"));
                lista.add(p);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao pegar dados de Listagem pelo Nome: " + e.getMessage());
            return null;
        }
    }

    //Lista podcast somente nome e id
    public List<PodCast> ListaNomeeID() {
        try {
            String sql = "SELECT id,nomeEpisodio FROM podcast";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<PodCast> lista = new ArrayList<>();

            while (rs.next()) {
                PodCast cast = new PodCast();
                cast.setId(rs.getInt("id"));
                cast.setNomeEpisodio(rs.getString("nomeEpisodio"));
                lista.add(cast);
            }
            return lista;
        } catch (Exception ex) {
            System.out.println("Erro ao pegar dados do banco: " + ex.getMessage());
            return null;
        }
    }
}
