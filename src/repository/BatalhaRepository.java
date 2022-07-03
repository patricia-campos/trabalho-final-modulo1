package repository;

import banco.DbConfiguration;
import entities.Batalha;
import exceptions.BancoDeDadosException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatalhaRepository implements Repositorio<Integer, Batalha> {

    Connection con = null;

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "Select SEQ_BATALHA.nextval mysequence FROM DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()){
            return res.getInt("mysequence");
        }
        return null;
    }

    //Adicionando uma batalha - CREATE
    @Override
    public Batalha adicionar (Batalha object) throws BancoDeDadosException {

        Connection con = null;

        try {
            con = DbConfiguration.getConnection();
            Integer proximoId = this.getProximoId(con);

            String sql = """
                         INSERT INTO BATALHA
                         (ID_BATALHA, ID_CENARIO, ID_JOGADOR, ID_BOSS, ROUND_BATALHA, STATUS)
                         VALUES(SEQ_BATALHA.nextval, ?, ?, ?, ?, ?)
                        """;

            // TODO: 02/07/2022 CHECAR COMO SERÁ O ROUND - LINHA 50

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, proximoId);
            stmt.setInt(2, object.getIdCenario());
            stmt.setInt(3, object.getIdJogador());
            stmt.setInt(4, object.getIdBoss());
            stmt.setInt(5, object.getRoundBatalha());
            stmt.setString(6, object.getStatus());


            stmt.executeUpdate();
            System.out.println("A batalha começou!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO 02/07/2022 O REMOVE SERÁ O ENCERRAR BATALHA? TERÁ REMOVE?

    //Removendo a batalha - DELETE
    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        try {
            con = DbConfiguration.getConnection();

            String sql = "DELETE FROM BATALHA WHERE ID_BATALHA = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("Batalha excluída com sucesso!");

            return res > 0;

        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Editando a batalha - UPDATE
    @Override
    public boolean editar(Integer id, Batalha batalha) throws BancoDeDadosException {

        try {
            con = DbConfiguration.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE BATALHA SET ");
            sql.append(" ID_BATALHA = ?,");
            sql.append(" ID_CENARIO = ?,");
            sql.append(" ID_JOGADOR = ? ");
            sql.append(" ID_BOSS = ? ");
            sql.append(" ID_ROUND BATALHA = ? ");
            sql.append(" STATUS = ? ");
            sql.append(" WHERE ID_BATALHA = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setInt(1, batalha.getIdBatalha());
            stmt.setInt(2, batalha.getIdCenario());
            stmt.setInt(3, batalha.getIdJogador());
            stmt.setInt(4, batalha.getIdJogador());
            stmt.setInt(5, batalha.getRoundBatalha());
            stmt.setString(6, batalha.getStatus());
            stmt.setInt(7, id);

            //TODO CHECAR A IMPRESSÃO DO UPDATE NO TESTE

            // Executa consulta
            int res = stmt.executeUpdate();
            System.out.println("Batalha alterada");

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Batalha> listar() throws BancoDeDadosException {
        List<Batalha> batalhas = new ArrayList<>();

        try {
            con = DbConfiguration.getConnection();
            Statement  stmt = con.createStatement();

            String sql = "SELECT * FROM BATALHA";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Batalha batalha = new Batalha();
                batalha.setIdBatalha(res.getInt("ID_BATALHA"));
                batalha.setIdCenario(res.getInt("ID_CENARIO"));
                batalha.setIdJogador(res.getInt("ID_JOGADOR"));
                batalha.setIdBoss(res.getInt("ID_BOSS"));
                batalha.setRoundBatalha(res.getInt("ROUND_BATALHA"));
                batalha.setStatus(res.getString("STATUS"));
            }

        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return batalhas;
    }

}






