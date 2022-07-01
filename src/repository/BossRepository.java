package repository;

import entities.Boss;
import exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BossRepository implements Repositorio<Integer,Boss>{

    @Override
    public Integer getProximoId(Connection connection) throws SQLException {

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
