package repository;

import banco.DbConfiguration;
import entities.Jogador;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import oracle.jdbc.OracleBfile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogadorRepository implements Repositorio<Integer, Jogador> {
    Connection con = null;

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Jogador adicionar(Jogador object) throws BancoDeDadosException {
        try {
            con = DbConfiguration.getConnection();

            String sql = "INSERT INTO JOGADOR\n" +
                    "(ID_JOGADOR, NOME_JOGADOR, SENHA)\n" +
                    "VALUES(SEQ_JOGADOR.nextval, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, object.getNomeJogador());
            stmt.setString(2, object.getSenha());


            stmt.executeUpdate();
            System.out.println("Jogador adicionado com sucesso");
            object.setId(this.retornarId(object.getNomeJogador()));

            return object;
        } catch (SQLException e) {
            throw new BancoDeDadosException();
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
    public boolean remover(Integer id) throws BancoDeDadosException {
        try {
            con = DbConfiguration.getConnection();

            String sql = "DELETE FROM JOGADOR WHERE ID_JOGADOR = "+id;

            PreparedStatement stmt = con.prepareStatement(sql);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("Jogador removido com sucesso");

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException();
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
    public boolean editar(Integer id, Jogador jogador) throws BancoDeDadosException {
        try {
            con = DbConfiguration.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE JOGADOR SET ");
            sql.append(" NOME_JOGADOR = ?,");
            sql.append(" SENHA = ?");
            sql.append(" WHERE ID_JOGADOR = ?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, jogador.getNomeJogador());
            stmt.setString(2, jogador.getSenha());
            stmt.setInt(3, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
            System.out.println("Jogador editado com sucesso" + res);

            return res > 0;
        } catch (SQLException e) {
            throw new BancoDeDadosException();
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
    public List<Jogador> listar() throws BancoDeDadosException {
        List<Jogador> jogadorList = new ArrayList<>();
        try {
            con = DbConfiguration.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM JOGADOR";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Jogador jogador = new Jogador();
                jogador.setNomeJogador(res.getString("NOME_JOGADOR"));
                jogador.setSenha(res.getString("SENHA"));
                jogadorList.add(jogador);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return jogadorList;
    }

    public Integer retornarId(String nome) throws BancoDeDadosException {
        int result;
        try {
            con = DbConfiguration.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM JOGADOR WHERE NOME_JOGADOR = '"+nome+"'";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                result = res.getInt("id_jogador");
                return result;
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    return  null;
    }
}
