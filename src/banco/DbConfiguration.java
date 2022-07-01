package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiguration {


    public void abrirConexao(){
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "BATALHA";
        String password = "oracle";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection= DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Conectado com Sucesso");
        }catch (ClassNotFoundException cx){
            System.out.println("Driver nao localizado");
            cx.printStackTrace();
        }catch (SQLException sx){
            System.out.println("Erro ao abrir conexão com o banco de dados");
            sx.printStackTrace();
        }
    }
}
