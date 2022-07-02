package repository;

import banco.DbConfiguration;
import entities.Cenario;
import exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CenarioRepository implements Repositorio<Integer, Cenario> {
        Connection con = null;

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "Select SEQ_CENARIO.nextval mysequence FROM DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()){
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public Cenario adicionar(Cenario object) throws BancoDeDadosException {
        try {
            con = DbConfiguration.getConnection();

            String sql = "INSERT INTO CENARIO (ID_CENARIO, NOME_CENARIO, HORARIO, TIPO_REINO)\n" +
                    "\tVALUES (SEQ_CENARIO.nextval, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, object.getNomeCenario());
            stmt.setDate(2, (Date) object.getHorario());
//            stmt.set(3, object.getTipoCenario());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        try {
            con = DbConfiguration.getConnection();

            String sql = "DELETE FROM CENARIO WHERE ID_CENARIO = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int res = stmt.executeUpdate();
            System.out.println("Cenario removido");

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
    public boolean editar(Integer id, Cenario cenario) throws BancoDeDadosException {
        try {
            con = DbConfiguration.getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CENARIO SET ");
            sql.append(" NOME_CENARIO = ?,");
            sql.append(" HORARIO = ?,");
            sql.append(" TIPO_REINO = ?");
            sql.append("WHERE ID_CENARIO = ? ");

            PreparedStatement stmt = con.prepareStatement(sql.toString());

            stmt.setString(1, cenario.getNomeCenario());
            stmt.setDate(2, (Date) cenario.getHorario());
//            stmt.set(3, object.getTipoCenario());

            int res = stmt.executeUpdate();
            System.out.println("Cenario editado com sucesso" + res);

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
    public List<Cenario> listar() throws BancoDeDadosException {
        List<Cenario> cenarios = new ArrayList<>();
        try {
            con = DbConfiguration.getConnection();
            Statement  stmt = con.createStatement();

            String sql = "SELECT * FROM CENARIO";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Cenario cenario = new Cenario();
                cenario.setNomeCenario(res.getString("NOME_CENARIO"));
                cenario.setHorario(res.getDate("HORARIO"));
//                cenario.setTipoCenario(res.g);
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
        return cenarios;
    }
}