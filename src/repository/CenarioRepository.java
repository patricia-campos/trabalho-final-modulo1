package repository;

import banco.DbConfiguration;
import entities.cenario.Cenario;
import exceptions.BancoDeDadosException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CenarioRepository implements Repositorio<Integer, Cenario> {


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
    public Cenario adicionar(Cenario cenario) throws BancoDeDadosException {
       Connection con = null;
        try {

            con = DbConfiguration.getConnection();

            Integer proximoId = this.getProximoId(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, Cenario cenario) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<Cenario> listar() throws BancoDeDadosException {
        return null;
    }
}
