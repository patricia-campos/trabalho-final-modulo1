package repository;

import banco.DbConfiguration;
import entities.Boss;
import exceptions.BancoDeDadosException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BossRepository implements Repositorio<Integer,Boss>{

    Connection con = null;

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public Boss adicionar(Boss object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer idBoss) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Boss boss) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Boss> listar() throws BancoDeDadosException {

        List<Boss> bossList = new ArrayList<>();

        Connection con = null;

        try {
            con = DbConfiguration.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM BOSS";

            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                Boss boss = new Boss();
                boss.setIdBoss(res.getInt("ID_BOSS"));
                boss.setNome(res.getString("NOME_BOSS"));
                boss.setVida(res.getInt("VIDA_BOSS"));
                boss.setDefesa(res.getInt("DEFESA_BOSS"));
                boss.setAtaque(res.getInt("ATAQUE_BOSS"));
                bossList.add(boss);
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
        return bossList;
    }
}
