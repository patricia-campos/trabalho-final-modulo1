package repository;

import entities.Boss;
import exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BossRepository implements Repositorio<Integer,Boss>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_BOSS.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);


        return null;
    }

    @Override
    public Boss adicionar(Boss object) throws BancoDeDadosException {


        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {

        return false;
    }

    @Override
    public boolean editar(Integer id, Boss boss) throws BancoDeDadosException {

        return false;
    }

    @Override
    public List<Boss> listar() throws BancoDeDadosException {
        return null;
    }
}
