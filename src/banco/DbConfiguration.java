package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiguration {


    public static Connection getConnection(){
        Connection connection = null;
        String dbUrl = "jdbc:oracle:thin:@10.0.20.80:1521:xe";
        String username = "VEMSER_PATRICIA";
        String password = "KcELgWKcJB";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(dbUrl,username,password);
        }catch (ClassNotFoundException cx){
            System.out.println("Driver nao localizado");
            cx.printStackTrace();
        }catch (SQLException sx){
            System.out.println("Erro ao abrir conexão com o banco de dados");
            sx.printStackTrace();
        }
        return connection;
    }
}
